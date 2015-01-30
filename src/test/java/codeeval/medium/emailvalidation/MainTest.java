package codeeval.medium.emailvalidation;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

    @Test
    public void test() {
        Main main = new Main();
        Assert.assertTrue(main.validateEmail("foo@bar.com"));
        Assert.assertFalse(main.validateEmail("this is not an email id"));
        Assert.assertFalse(main.validateEmail("admin#codeeval.com"));
        Assert.assertTrue(main.validateEmail("good123@bad.com"));

        Assert.assertFalse(main.validateEmail("this\\ still\\\"not\\\\allowed@example.com"));
        Assert.assertFalse(main.validateEmail("Abc.example.com"));
        Assert.assertFalse(main.validateEmail("this is not true"));
        Assert.assertFalse(main.validateEmail("this is\"not\\allowed@example.com"));
        Assert.assertFalse(main.validateEmail("hfij#kjdfvkl"));
        Assert.assertFalse(main.validateEmail("asterisk_domain@foo.*"));
        Assert.assertFalse(main.validateEmail("a\"b(c)d,e:f;g<h>i[j\\k]l@example.com"));
        Assert.assertFalse(main.validateEmail("<invalid>@foo.com"));
        Assert.assertFalse(main.validateEmail("A@b@c@example.com"));
        Assert.assertFalse(main.validateEmail("just\"not\"right@example.com"));

        Assert.assertFalse(main.validateEmail("\"very.unusual.@.unusual.com\"@example.com"));
        Assert.assertTrue(main.validateEmail("very.common@example.com"));
        Assert.assertTrue(main.validateEmail("niceandsimple@example.com"));
        Assert.assertTrue(main.validateEmail("disposable.style.email.with+symbol@example.com"));
        Assert.assertTrue(main.validateEmail("a.little.lengthy.but.fine@dept.example.com"));
        Assert.assertTrue(main.validateEmail("b@domain.net"));
        Assert.assertTrue(main.validateEmail("b@d.net"));
        Assert.assertTrue(main.validateEmail("bob123@alice123.com"));
        Assert.assertTrue(main.validateEmail("disposable.style.email.with+156@example.com"));
        Assert.assertTrue(main.validateEmail("1@d.net"));

    }

}