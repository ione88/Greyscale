package com.opensoft.testtask.greyscale.model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Image implements IImage {
    BufferedImage imageDate;

    public Image(BufferedImage imageDate){
        this.imageDate = imageDate;
    }

    @Override
    public IImage updateImageScale(int newW, int newH) throws Exception {
        try {
            int type = imageDate.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : imageDate.getType();
            BufferedImage resizedImage = new BufferedImage(newW, newH, type);
            Graphics2D g = resizedImage.createGraphics();
            g.drawImage(imageDate, 0, 0, newW, newH, null);
            g.dispose();
            imageDate = resizedImage;
            return this;
        } catch (Exception e) {
            throw new Exception("Resize Error. Wight and Height must > 0");
        }

    }

    @Override
    public IImage updateImageColorToGrey() {
        for (int i = 0; i < imageDate.getHeight(); i++) {
            for (int j = 0; j < imageDate.getWidth(); j++) {
                Color c = new Color(imageDate.getRGB(j, i));
                int red = (int) (c.getRed() * 0.299);
                int green = (int) (c.getGreen() * 0.587);
                int blue = (int) (c.getBlue() * 0.114);
                Color newColor = new Color(
                        red + green + blue,
                        red + green + blue,
                        red + green + blue);
                imageDate.setRGB(j, i, newColor.getRGB());
            }
        }
        return this;
    }

    @Override
    public void localSaveImage(File output, String formatName) throws Exception {
        try {
          ImageIO.write(imageDate, formatName, output);
        } catch (Exception e) {
            throw new Exception("Save Error. Some reason  ");
        }
    }

    @Override
    public int getWidth() {
        return imageDate.getWidth();
    }

    @Override
    public int getHeight() {
        return imageDate.getHeight();
    }
}
