package codeeval.medium.detectingcycles;

import org.junit.Test;

import org.junit.Assert;

public class MainTest {

    @Test
    public void test() {
        Main main = new Main();
        Assert.assertEquals("6 3 1", main.detectCycle("2 0 6 3 1 6 3 1 6 3 1"));
        Assert.assertEquals("49", main.detectCycle("3 4 8 0 11 9 7 2 5 6 10 1 49 49 49 49"));
        Assert.assertEquals("1 2 3", main.detectCycle("1 2 3 1 2 3 1 2 3"));
    }

}