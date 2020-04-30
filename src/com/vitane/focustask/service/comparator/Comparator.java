package com.vitane.focustask.service.comparator;

import com.vitane.focustask.io.reader.Reader;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Comparator {
    private Function<Map<Reader, String>, Map.Entry<Reader, String>> sortOrderFunction;
    private Function<Reader, String> sortTypeFunction = Reader::pickCurrentItem;

    public Comparator(Boolean isDescSorting, Boolean isStringSorting) {
        if (isDescSorting) {
            if (isStringSorting) {
                sortOrderFunction = pool -> Collections.max(pool.entrySet(), Map.Entry.comparingByValue());
            } else {
                sortOrderFunction = pool -> {
                    Map.Entry<Reader, Integer> entry = Collections.max(getReaderIntegerMap(pool).entrySet(),
                            Map.Entry.comparingByValue());
                    return new AbstractMap.SimpleEntry<>(entry.getKey(), String.valueOf(entry.getValue()));
                };
            }
        } else {
            if (isStringSorting) {
                sortOrderFunction = pool -> Collections.min(pool.entrySet(), Map.Entry.comparingByValue());
            } else {
                sortOrderFunction = pool -> {
                    Map.Entry<Reader, Integer> entry = Collections.min(getReaderIntegerMap(pool).entrySet(),
                            Map.Entry.comparingByValue());
                    return new AbstractMap.SimpleEntry<>(entry.getKey(), String.valueOf(entry.getValue()));
                };
            }
        }
    }

    private Map<Reader, Integer> getReaderIntegerMap(Map<Reader, String> pool) {
        Map<Reader, Integer> integerMap;
        try {
            integerMap = pool.entrySet().stream().collect(Collectors.toMap(
                    Map.Entry::getKey,
                    entry -> Integer.parseInt(entry.getValue())));
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage() + " " + "(Не удается распознать элемент)");
            integerMap = getReaderIntegerMap(pool);
        }
        return integerMap;
    }

    public Map.Entry<Reader, String> getAimEntry(Map<Reader, String> pool) {
        return sortOrderFunction.apply(pool);
    }

    public String getValue(Reader flow) {
        String value;

        if (flow.isFlowOver()) {
            throw new IndexOutOfBoundsException();
        }
        do {
            try {
                value = sortTypeFunction.apply(flow);
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage() + " " + "(Не удается распознать элемент)");
            }
        } while (true);
        return value;
    }
}
