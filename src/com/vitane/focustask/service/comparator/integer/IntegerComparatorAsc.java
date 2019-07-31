package com.vitane.focustask.service.comparator.integer;

import com.vitane.focustask.io.reader.Reader;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

public class IntegerComparatorAsc implements IntegerComparator {
    @Override
    public Map.Entry<Reader, String> getAimEntry(Map<Reader, String> pool) {
        Map<Reader, Integer> integerMap =
                pool.entrySet().stream().collect(Collectors.toMap(
                        entry -> entry.getKey(),
                        entry -> Integer.parseInt(entry.getValue()))
                );
        Map.Entry<Reader, Integer> entry = Collections.min(integerMap.entrySet(), Map.Entry.comparingByValue());
        return new AbstractMap.SimpleEntry<>(entry.getKey(), String.valueOf(entry.getValue()));
    }
}