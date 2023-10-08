package com.robokosta;

import org.w3c.dom.ls.LSException;

import java.util.*;

public class App
{
    public static List<User> findDuplicates1(Collection<User> collA, Collection<User> collB) {
        List<User> dupl = new ArrayList<>();
        Set<User> set = new HashSet<>(collA);

        collB.forEach(n -> { if (!set.add(n)) dupl.add(n); });

        return dupl;
    }

    public static List<User> findDuplicates2(Collection<User> collA, Collection<User> collB) {
        List<User> dupl = new ArrayList<>();
        Set<User> set = new LinkedHashSet<>(collA);

        collB.forEach(n -> { if (!set.add(n)) dupl.add(n); });

        return dupl;
    }

    public static void main( String[] args ) {}
}
