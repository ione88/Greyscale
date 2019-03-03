package com.opensoft.testtask.greyscale.manager;

import com.opensoft.testtask.greyscale.model.IImage;

import java.io.File;
import java.io.IOException;

public interface IManager {
    File getLocalFile();
    String getFormatName();
    int getWidth();
    int getHeight();

    IManager applyArgs(String[] args) throws Exception;
    IImage getImage() throws IOException;

}
