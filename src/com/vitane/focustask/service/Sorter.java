package com.vitane.focustask.service;

import com.vitane.focustask.service.comparator.Comparator;
import com.vitane.focustask.io.reader.Reader;
import com.vitane.focustask.io.writer.Writer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sorter {

    private Writer result;
    private List<Reader> flows = new ArrayList<>();
    private Comparator comparator;
    private Map<Reader, String> pool = new HashMap<>();

    private Sorter(Builder builder) {
        if (builder != null) {
            result = builder.writer;
            comparator = builder.comparator;
            flows.addAll(builder.readers);
        }
    }

    public static class Builder {
        private Writer writer;
        private Comparator comparator;
        private List<Reader> readers = new ArrayList<>();

        public Sorter.Builder writer(Writer item) {
            writer = item;
            return this;
        }

        public Sorter.Builder comparator(Comparator comparator) {
            this.comparator = comparator;
            return this;
        }

        public Sorter.Builder addFlows(List<Reader> flows) {
            if (flows == null) {
                return this;
            }
            readers.addAll(flows);
            return this;
        }

        public Sorter build() {
            return new Sorter(this);
        }
    }

    public void sort() {

        for (Reader flow : flows) {
            if (!flow.isFlowOver()) {
                pool.put(flow, comparator.getValue(flow));
            }
        }

        while (!pool.isEmpty()) {
            Map.Entry<Reader, ?> item = comparator.getAimEntry(pool);
            result.write(item.getValue().toString());
            if (item.getKey().isFlowOver()) {
                pool.remove(item.getKey());
            } else {
                pool.put(item.getKey(), comparator.getValue(item.getKey()));
            }
        }
    }
}