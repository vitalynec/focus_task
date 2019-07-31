package com.vitane.focustask.io.writer;

public class WriterToConsole implements Writer {

    @Override
    public void write(String item) {
        System.out.print(item + " ");
    }
}