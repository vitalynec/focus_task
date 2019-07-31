package com.vitane.focustask.service.comparator.string;

import com.vitane.focustask.io.reader.Reader;

import java.util.Collections;
import java.util.Map;

public class StringComparatorAsc implements StringComparator {
    @Override
    public Map.Entry<Reader, String> getAimEntry(Map<Reader, String> pool) {
        return Collections.min(pool.entrySet(), Map.Entry.comparingByValue());
    }
}
