package com.opensoft.testtask.greyscale;

import com.opensoft.testtask.greyscale.manager.IManager;
import com.opensoft.testtask.greyscale.manager.Manager;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.Timestamp;

public class Runner {

    public static void main(String[] args)  {
        String log = getGreyscale(args);
        System.out.println(log);

        // save result into log.txt
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("log.txt", true))) {
            bufferedWriter.write(String.format("[%s] %s", new Timestamp(System.currentTimeMillis()), log));
            bufferedWriter.newLine();
        } catch (Exception e) {
            log = "ERROR to save logfile";
            System.out.println(String.format("[%s] %s", new Timestamp(System.currentTimeMillis()), log));
        }
    }

    public static String getGreyscale(String args[]) {
        IManager manager = new Manager();
        try {
            manager.applyArgs(args)
                   .getImage()
                   .updateImageColorToGrey()
                   .updateImageScale(manager.getWidth(), manager.getHeight())
                   .localSaveImage(manager.getLocalFile(), manager.getFormatName());
        } catch (Exception e) {
            return e.getMessage();
        }
        return manager.getLocalFile().toString();
    }
}
