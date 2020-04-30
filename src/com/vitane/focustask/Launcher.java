package com.vitane.focustask;

import com.vitane.focustask.io.reader.Reader;
import com.vitane.focustask.io.writer.Writer;
import com.vitane.focustask.service.Sorter;
import com.vitane.focustask.service.comparator.Comparator;

import java.util.ArrayList;
import java.util.List;

public class Launcher {

    static boolean isDescSorting = false;
    static boolean isStringSorting = false;
    static Writer writer;
    static List<Reader> readers = new ArrayList<>();

    public static void main(String[] args) {
        new CommandLineParser().parse(args);
        Sorter sorter = new Sorter.Builder()
                .writer(writer)
                .comparator(new Comparator(isDescSorting, isStringSorting))
                .addFlows(readers)
                .build();
        sorter.sort();

        String header = "=== Completed ===";
        System.out.println(header);
    }
}