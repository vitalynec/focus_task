package com.vitane.focustask.io.writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class WriterToFile implements Writer {

    private File file;

    public WriterToFile(File file) {
        this.file = file;
    }

    @Override
    public void write(String item) {
        if (file == null) {
            System.out.println(LocalDateTime.now().toString() + " : " + "Файл не найден!");
            return;
        }

        if (item == null) {
            System.out.println(LocalDateTime.now().toString() + " : " + "Элемент для записи не найден!");
            return;
        }

        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(item + "\n");
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
