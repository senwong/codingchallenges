package codeeval.hard.uglynumbers;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

    @Test
    public void test() {
        Main classUnderTest = new Main();
        Assert.assertEquals(0, classUnderTest.countPossibleUglyNumbers("1"));
        Assert.assertEquals(1, classUnderTest.countPossibleUglyNumbers("9"));
        Assert.assertEquals(6, classUnderTest.countPossibleUglyNumbers("011"));
        Assert.assertEquals(64, classUnderTest.countPossibleUglyNumbers("12345"));
        Assert.assertEquals(417905, classUnderTest.countPossibleUglyNumbers("1234567890123"));
    }

    @Test
    public void testDirtyNumber() {
        Assert.assertFalse(Main.isUglyNumber(13));
        Assert.assertTrue(Main.isUglyNumber(14));
        Assert.assertTrue(Main.isUglyNumber(39));
        Assert.assertFalse(Main.isUglyNumber(121));
    }

}