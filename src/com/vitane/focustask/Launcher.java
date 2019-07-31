package com.vitane.focustask;

import com.vitane.focustask.controller.Controller;
import com.vitane.focustask.io.reader.Reader;
import com.vitane.focustask.io.writer.Writer;

import java.util.ArrayList;
import java.util.List;

public class Launcher {

    static boolean isDescSorting = false;
    static boolean isStringSorting = false;
    static Writer writer;
    static List<Reader> readers = new ArrayList<>();

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