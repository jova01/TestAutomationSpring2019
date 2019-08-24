package com.cybertek.tests.day8_testing_intro;

import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaTestNGdemo {


    @Test
    public void test1(){
        String a="A";
        String b="A";

        Assert.assertEquals(a,b);
    }

    @Test
    public void test2(){
        String str1="apple";
        String str2="applee";

        boolean c=false;

        Assert.assertEquals(str1,str2);
        Assert.assertTrue(c);

    }

    @Test
    public void test3(){
        String str1="ADAF";
        String str2="AAA";
        Assert.assertTrue(str1.contains(str2));
    }

    @Test
    public static void test4(){
        Assert.assertFalse(false);
    }

}
