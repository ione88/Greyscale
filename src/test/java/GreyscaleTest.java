import com.opensoft.testtask.greyscale.Runner;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Paths;

public class GreyscaleTest {

    @Test
    public void greyscaleTest() {
        //#0 normal args
        String[] args = new String[]{"https://sun1-3.userapi.com/c847122/v847122938/1b55ae/We3mg9d8nZc.jpg", "100", "100"};
        Assert.assertEquals(Runner.getGreyscale(args), Paths.get("output.jpg").toAbsolutePath().normalize().toString());
    }

    @Test
    public void greyscaleTest1() {
        //#1 normal args
        String[] args = new String[]{"file:./input.png", "100", "100"};
        Assert.assertEquals(Runner.getGreyscale(args), Paths.get("output.png").toAbsolutePath().normalize().toString());
    }

    @Test
    public void greyscaleTest2() {
        //#2 normal args
        String[] args = new String[]{"file:./input.jpg", "100", "-100"};
        Assert.assertEquals(Runner.getGreyscale(args), Paths.get("output.jpg").toAbsolutePath().normalize().toString());
    }

    @Test
    public void greyscaleTest3() {
        //#3 an exception is expected getHeight() = 0
        String[] args = new String[]{"file:./input.jpg"};
        Assert.assertEquals(Runner.getGreyscale(args), Paths.get("output.jpg").toAbsolutePath().normalize().toString());
    }

    @Test
    public void greyscaleTest4() {
        //#4 an exception is expected sizes = 0
        String[] args = new String[]{"file:./README.md"};
        Assert.assertEquals(Runner.getGreyscale(args), "Source Error. Image format is not supported: please, use one of this:  PNG, JPG, JPEG, BMP, GIF");
    }

    @Test
    public void greyscaleTest5() {
        //#5 an exception zero args
        String[] args = new String[]{};
        Assert.assertEquals(Runner.getGreyscale(args), "Source Error. check first argument 'file:/pathToImage' or 'http://pathToImage' or 'https://pathToImage'");
    }

    @Test
    public void greyscaleTest6() {
        //#6 an exception args is null
        String[] args = null;
        Assert.assertEquals(Runner.getGreyscale(args), "Source Error. check first argument 'file:/pathToImage' or 'http://pathToImage' or 'https://pathToImage'");
    }

}
