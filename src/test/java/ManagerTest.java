import com.opensoft.testtask.greyscale.manager.Manager;
import org.junit.Assert;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.net.URL;
import java.io.IOException;
import java.nio.file.Paths;

public class ManagerTest {
    @Test
    public void applyArgsTest() {
        String[] args = new String[]{"https://sun1-3.userapi.com/c847122/v847122938/1b55ae/We3mg9d8nZc.jpg", "100", "100"};
        Manager  manager = new Manager();
        boolean  expt = false;
        try {
            manager.applyArgs(args);
        } catch (Exception e) {
            expt = true;
        }
        Assert.assertFalse(expt);
        expt = false;
        try {
            Assert.assertNotNull(manager.getImage());
        } catch (Exception e) {
            expt = true;
        }
        Assert.assertFalse(expt);
        Assert.assertEquals(manager.getLocalFile().toString(), Paths.get(".").toAbsolutePath().normalize().toString() + "/output.jpg");
        Assert.assertEquals(manager.getFormatName(), "jpg");
        Assert.assertEquals(manager.getWidth(), 100);
        Assert.assertEquals(manager.getHeight(), 100);
    }

    @Test
    public void applyArgsTest1() {
        String[] args = new String[]{"file:./input.png", "100", "100"};
        Manager  manager = new Manager();
        boolean  expt = false;
        try {
            manager.applyArgs(args);
        } catch (Exception e) {
            expt = true;
        }
        Assert.assertFalse(expt);
        expt = false;
        try {
            Assert.assertNotNull(manager.getImage());
        } catch (Exception e) {
            expt = true;
        }
        Assert.assertFalse(expt);
        Assert.assertEquals(manager.getLocalFile().toString(), Paths.get(".").toAbsolutePath().normalize().toString() + "/output.png");
        Assert.assertEquals(manager.getFormatName(), "png");
        Assert.assertEquals(manager.getWidth(), 100);
        Assert.assertEquals(manager.getHeight(), 100);
    }

    @Test
    public void applyArgsTest2() throws IOException {
        URL path =  new URL("file:./input.jpg");
        int oldHeight =  ImageIO.read(path).getHeight();
        String[] args = new String[]{path.toString(), "100", "-100"};
        Manager  manager = new Manager();
        boolean  expt = false;
        try {
            manager.applyArgs(args);
        } catch (Exception e) {
            expt = true;
        }
        Assert.assertFalse(expt);
        expt = false;
        try {
            Assert.assertNotNull(manager.getImage());
        } catch (Exception e) {
            expt = true;
        }
        Assert.assertFalse(expt);
        Assert.assertEquals(manager.getLocalFile().toString(), Paths.get(".").toAbsolutePath().normalize().toString() + "/output.jpg");
        Assert.assertEquals(manager.getFormatName(), "jpg");
        Assert.assertEquals(manager.getWidth(), 100);
        Assert.assertEquals(manager.getHeight(), oldHeight);
    }

    @Test
    public void applyArgsTest3() throws IOException {
        URL path =  new URL("file:./input.jpg");
        int oldHeight =  ImageIO.read(path).getHeight();
        String[] args = new String[]{path.toString(), "100"};
        Manager  manager = new Manager();
        try {
            manager.applyArgs(args);
        } catch (Exception e) {
            Assert.fail();
        }
        boolean expt = false;
        try {
            Assert.assertNotNull(manager.getImage());
        } catch (Exception e) {
            expt = true;
        }
        Assert.assertFalse(expt);
        Assert.assertEquals(manager.getLocalFile().toString(), Paths.get(".").toAbsolutePath().normalize().toString() + "/output.jpg");
        Assert.assertEquals(manager.getFormatName(), "jpg");
        Assert.assertEquals(manager.getWidth(), 100);
        Assert.assertEquals(manager.getHeight(), oldHeight);
    }

    @Test
    public void applyArgsTest4() throws IOException {
        URL path =  new URL("file:./input.jpg");
        int oldHeight =  ImageIO.read(path).getHeight();
        int oldWidth =  ImageIO.read(path).getWidth();
        String[] args = new String[]{path.toString()};
        Manager  manager = new Manager();

        try {
            manager.applyArgs(args);
        } catch (Exception e) {
            Assert.fail();
        }

        try {
            Assert.assertNotNull(manager.getImage());
        } catch (Exception e) {
            Assert.fail();
        }
        Assert.assertEquals(manager.getLocalFile().toString(), Paths.get(".").toAbsolutePath().normalize().toString() + "/output.jpg");
        Assert.assertEquals(manager.getFormatName(), "jpg");
        Assert.assertEquals(manager.getWidth(), oldWidth);
        Assert.assertEquals(manager.getHeight(), oldHeight);
    }

    @Test
    public void applyArgsTest5() {
        String[] args = new String[]{};
        Manager  manager = new Manager();
        boolean  expt = false;
        try {
            manager.applyArgs(args);
        } catch (Exception e) {
            expt = true;
        }
        Assert.assertTrue(expt);
        expt = false;
        try {
            Assert.assertNotNull(manager.getImage());
        } catch (Exception e) {
            expt = true;
        }
        Assert.assertTrue(expt);
        Assert.assertEquals(manager.getLocalFile().toString(), Paths.get(".").toAbsolutePath().normalize().toString() + "/output.jpg");
        Assert.assertEquals(manager.getFormatName(), "jpg");
        Assert.assertEquals(manager.getWidth(), 0);
        Assert.assertEquals(manager.getHeight(), 0);
    }

    @Test
    public void applyArgsTest6() {
        String[] args = null;
        Manager  manager = new Manager();
        boolean  expt = false;
        try {
            manager.applyArgs(args);
        } catch (Exception e) {
            expt = true;
        }
        Assert.assertTrue(expt);
        expt = false;
        try {
            Assert.assertNotNull(manager.getImage());
        } catch (Exception e) {
            expt = true;
        }
        Assert.assertTrue(expt);
        Assert.assertEquals(manager.getLocalFile().toString(), Paths.get(".").toAbsolutePath().normalize().toString() + "/output.jpg");
        Assert.assertEquals(manager.getFormatName(), "jpg");
        Assert.assertEquals(manager.getWidth(), 0);
        Assert.assertEquals(manager.getHeight(), 0);
    }

}
