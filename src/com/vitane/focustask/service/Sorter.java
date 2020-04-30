package com.vitane.focustask.service;

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

        public Builder writer(Writer item) {
            writer = item;
            return this;
        }

        public Builder comparator(Comparator comparator) {
            this.comparator = comparator;
            return this;
        }

        public Builder addFlows(List<Reader> flows) {
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
}