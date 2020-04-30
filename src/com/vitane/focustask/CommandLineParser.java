package com.vitane.focustask;

import com.vitane.focustask.io.reader.ReaderFromFile;
import com.vitane.focustask.io.writer.WriterToConsole;
import com.vitane.focustask.io.writer.WriterToFile;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CommandLineParser {

    private static final boolean DEBUG = false;

    void parse(String[] args) {
        int argsCounter = 0;
        if (args.length >= 3) {

            for (int i = 0; i < 2; i++) {
                if ("-a".equalsIgnoreCase(args[argsCounter]) || "-d".equalsIgnoreCase(args[argsCounter])) {
                    if ("-d".equalsIgnoreCase(args[argsCounter])) {
                        Launcher.isDescSorting = true;
                    }
                    argsCounter++;
                }

                if ("-s".equalsIgnoreCase(args[argsCounter]) || "-i".equalsIgnoreCase(args[argsCounter])) {
                    if ("-s".equalsIgnoreCase(args[argsCounter])) {
                        Launcher.isStringSorting = true;
                    }
                    argsCounter++;
                }
            }

            if (DEBUG) {
                Launcher.writer = new WriterToConsole();
                argsCounter++;
            } else {
                Launcher.writer = new WriterToFile(new File(args[argsCounter++]));
            }

            List<String> inputFileNames = new ArrayList<>(Arrays.asList(args).subList(argsCounter, args.length));
            if (inputFileNames.size() < 1) {
                System.out.println("Не указаны файлы входных данных!");
            } else {
                for (String fileName : inputFileNames) {
                    Launcher.readers.add(new ReaderFromFile(new File(fileName)));
                }
            }
        } else {
            System.out.println("Некорректное количество параметров!");
        }
    }
}
