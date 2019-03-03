import com.opensoft.testtask.greyscale.model.IImage;
import com.opensoft.testtask.greyscale.model.Image;
import org.junit.Assert;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ImageTest {
    @Test
    public void getImageTest(){
        try {
            URL path = new URL("file:./input.jpg");
            Image image = new Image(ImageIO.read(path));
            Assert.assertNotNull(image);
        } catch(Exception e) {
            Assert.fail();
        }
    }

    @Test
    public void getImageTest1(){
        try {
            URL path = new URL("https://sun1-3.userapi.com/c847122/v847122938/1b55ae/We3mg9d8nZc.jpg");
            Image image = new Image(ImageIO.read(path));
            Assert.assertNotNull(image);
        } catch(Exception e) {
            Assert.fail();
        }
    }

    @Test
    public void imageScaleTest() throws IOException {
        int newW = 100;
        int newH = 100;
        URL path = new URL("file:./input.jpg");
        IImage image = new Image(ImageIO.read(path));

        try {
            image.updateImageScale(newW, newH);
            Assert.assertNotNull(image);
        } catch(Exception e) {
            Assert.fail();
            return;
        }
        Assert.assertEquals(image.getWidth(), newW);
        Assert.assertEquals(image.getHeight(), newH);
    }

    @Test
    public void imageScaleTest1() throws IOException {
        int newW = 100;
        int newH = -100;
        URL path = new URL("file:./input.jpg");
        IImage image = new Image(ImageIO.read(path));

        try {
            image.updateImageScale(newW, newH);
            Assert.assertNotNull(image);
        } catch(Exception e) {
            Assert.assertEquals(e.getMessage(), "Resize Error. Wight and Height must > 0");
            return;
        }
        Assert.fail();
    }

    @Test
    public void imageScaleTest2() throws IOException {
        int newW = 0;
        int newH = 0;
        URL path = new URL("file:./input.jpg");
        IImage image = new Image(ImageIO.read(path));

        try {
            image.updateImageScale(newW, newH);
            Assert.assertNotNull(image);
        } catch(Exception e) {
            Assert.assertEquals(e.getMessage(), "Resize Error. Wight and Height must > 0");
            return;
        }
        Assert.fail();
    }

    @Test
    public void localSaveTest() throws IOException {
        URL path = new URL("file:./input.jpg");
        IImage image = new Image(ImageIO.read(path));

        try {
            image.localSaveImage(new File("output.jpg" ).getAbsoluteFile(), "jpg");
            Assert.assertNotNull(image);
        } catch(Exception e) {
            Assert.fail();
            return;
        }
        Assert.assertTrue(new File("output.jpg" ).exists());
    }

    @Test
    public void localSaveTes1() throws IOException {
        URL path = new URL("file:./input.png");
        IImage image = new Image(ImageIO.read(path));

        try {
            image.localSaveImage(new File("output.png" ).getAbsoluteFile(), "jpg");
            Assert.assertNotNull(image);
        } catch(Exception e) {
            Assert.fail();
            return;
        }
        Assert.assertTrue(new File("output.jpg" ).exists());
    }

}
