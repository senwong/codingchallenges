package codeeval.easy.happynumbers;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

    @Test
    public void test() {
        Main main = new Main();
        Assert.assertTrue(main.isHappyNumber("1"));
        Assert.assertTrue(main.isHappyNumber("7"));
        Assert.assertFalse(main.isHappyNumber("22"));
    }
}