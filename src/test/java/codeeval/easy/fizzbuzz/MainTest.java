package codeeval.easy.fizzbuzz;

import org.junit.Test;

import org.junit.Assert;

public class MainTest {

    @Test
    public void test() {
        Main main = new Main();
        Assert.assertEquals("1 2 F 4 B F 7 8 F B", main.convertToFizzbuzz("3 5 10"));
        Assert.assertEquals("1 F 3 F 5 F B F 9 F 11 F 13 FB 15", main.convertToFizzbuzz("2 7 15"));
    }

}