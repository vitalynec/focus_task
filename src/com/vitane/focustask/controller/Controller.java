package com.vitane.focustask.controller;

import com.vitane.focustask.io.reader.Reader;
import com.vitane.focustask.io.writer.Writer;
import com.vitane.focustask.service.Sorter;
import com.vitane.focustask.service.comparator.Comparator;
import com.vitane.focustask.service.comparator.integer.IntegerComparatorAsc;
import com.vitane.focustask.service.comparator.integer.IntegerComparatorDesc;
import com.vitane.focustask.service.comparator.string.StringComparatorAsc;
import com.vitane.focustask.service.comparator.string.StringComparatorDesc;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private Writer writer;
    private Comparator comparator;
    private List<Reader> readers = new ArrayList<>();

    public Controller(boolean isDescSorting, boolean isStringSorting,
                      Writer writer, List<Reader> listOfReaders) {
        this.comparator = selectComparator(isDescSorting, isStringSorting);
        this.writer = writer;
        this.readers.addAll(listOfReaders);
    }

    private Comparator selectComparator(boolean isDescSorting, boolean isStringSorting) {
        if (isDescSorting) {
            return (isStringSorting) ? new StringComparatorDesc() :
                    new IntegerComparatorDesc();
        } else {
            return (isStringSorting) ? new StringComparatorAsc() :
                    new IntegerComparatorAsc();
        }
    }

    public void execute() {
        Sorter sorter = new Sorter.Builder()
                .writer(writer)
                .comparator(comparator)
                .addFlows(readers)
                .build();
        sorter.sort();
        printComplete();
    }

    private void printComplete() {
        String header = "=== Completed ===";
        System.out.println(header);
    }
}
