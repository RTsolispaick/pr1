package com.robokosta;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class AppTest extends TestCase
{
    public void testFind() {
        Random a = new Random();

        Collection<User> collA = new ArrayList<>();
        Collection<User> collB = new ArrayList<>();

        List<User> dupl = new ArrayList<>();
        byte[] array = new byte[a.nextInt(100)];

        while (collA.size() < 100000)
        {
            a.nextBytes(array);

            User temp = new User(new String(array, StandardCharsets.UTF_8)
                        , new String(array, StandardCharsets.UTF_8)
                        , array);

            collA.add(temp);
            if (a.nextBoolean()) {
                collB.add(temp);
                dupl.add(temp);
            }
        }

        while (collB.size() < 100000)
        {
            a.nextBytes(array);

            User temp = new User(new String(array, StandardCharsets.UTF_8)
                    , new String(array, StandardCharsets.UTF_8)
                    , array);

            collB.add(temp);
            if (a.nextBoolean()) {
                collA.add(temp);
                dupl.add(temp);
            }
        }

        long startTime1 = System.nanoTime();
        List<User> a1 = App.findDuplicates1(collA,collB);
        long endTime1 = System.nanoTime();
        long duration1 = (endTime1 - startTime1);

        long startTime2 = System.nanoTime();
        List<User> a2 = App.findDuplicates2(collA,collB);
        long endTime2 = System.nanoTime();
        long duration2 = (endTime2 - startTime2);

        System.out.println((double) duration1 / 1000000000 + "sec " + (double) duration2 / 1000000000 + "sec");

        Assert.assertEquals(a1, dupl);
        Assert.assertEquals(a2, dupl);
     }
}
