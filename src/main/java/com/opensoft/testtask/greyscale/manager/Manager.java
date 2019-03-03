package com.opensoft.testtask.greyscale.manager;

import com.opensoft.testtask.greyscale.model.IImage;
import com.opensoft.testtask.greyscale.model.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Arrays;

import java.net.URL;

public class Manager implements IManager {
    private URL path;
    private int width;
    private int height;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public File getLocalFile() {
        return new File("output." + getFormatName()).getAbsoluteFile();
    }
    public String getFormatName() {
        String name = (path == null) ? "" : path.getFile();
        int lastIndexOf = name.lastIndexOf(".") + 1;
        String formatName = name.substring(lastIndexOf);

        if (!(Arrays.asList(ImageIO.getWriterFormatNames()).contains(formatName))) {
            return "jpg";
        }
        return name.substring(lastIndexOf);
    }

    @Override
    public Manager applyArgs(String[] args) throws Exception {
        if ( (args == null) || (args.length == 0) )
            throw new Exception("Source Error. check first argument 'file:/pathToImage' or 'http://pathToImage' or 'https://pathToImage'");
        try {
            path = new URL(args[0]);
            width = Integer.valueOf(args[1]);
            height = Integer.valueOf(args[2]);
        } catch (MalformedURLException e) {
            throw new Exception("Source Error. check first argument 'file:/pathToImage' or 'http://pathToImage' or 'https://pathToImage'");
        } catch (Exception e) {/* bad size args ignored */}
        return this;
    }

    @Override
    public IImage getImage() throws IOException {
        BufferedImage image = ImageIO.read(path);
        if (image == null) {
            throw new IOException("Source Error. Image format is not supported: please, use one of this:  PNG, JPG, JPEG, BMP, GIF");
        }
        if (width < 1) {
            width = image.getWidth();
        }
        if (height < 1) {
            height = image.getHeight();
        }

        return new Image(image);
    }
}
