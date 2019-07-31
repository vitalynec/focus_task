package com.vitane.focustask.service.comparator;

import com.vitane.focustask.io.reader.Reader;

import java.util.Map;

public interface Comparator {
    Map.Entry<Reader, String> getAimEntry(Map<Reader, String> pool);
    String getValue(Reader flow);
}
