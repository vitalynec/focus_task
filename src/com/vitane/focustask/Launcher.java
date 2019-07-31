package com.vitane.focustask;

import com.vitane.focustask.controller.Controller;
import com.vitane.focustask.io.reader.Reader;
import com.vitane.focustask.io.writer.Writer;

import java.util.ArrayList;
import java.util.List;

public class Launcher {

    protected static boolean isDescSorting = false;
    protected static boolean isStringSorting = false;
    protected static Writer writer;
    protected static List<Reader> readers = new ArrayList<>();

    public static void main(String[] args) {
        new CommandLineParser().parse(args);
        Controller controller = new Controller(
                isDescSorting,
                isStringSorting,
                writer,
                readers
        );
        controller.execute();
    }
}