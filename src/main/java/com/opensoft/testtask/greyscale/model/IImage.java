package com.opensoft.testtask.greyscale.model;

import java.io.File;

public interface IImage {;
    IImage updateImageColorToGrey();
    IImage updateImageScale(int newW, int newH) throws Exception;
    void localSaveImage(File output, String formatName) throws Exception;
    int getWidth();
    int getHeight();
}
