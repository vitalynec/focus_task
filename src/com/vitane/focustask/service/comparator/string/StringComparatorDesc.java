package com.vitane.focustask.service.comparator.string;

import com.vitane.focustask.io.reader.Reader;

import java.util.Collections;
import java.util.Map;

public class StringComparatorDesc implements StringComparator {
    @Override
    public Map.Entry<Reader, ?> getAimEntry(Map<Reader, String> pool) {
        return Collections.max(pool.entrySet(), Map.Entry.comparingByValue());
    }
}
