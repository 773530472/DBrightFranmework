package com.dbright.Test;

import java.util.Optional;
import java.util.stream.Stream;

public class testKJJ {
    public static void main(String[] args) {
        String[] str = new String[]{"1","asfsad2","12","asfsadf"};
        Optional<String> max = Stream.of(str).max((p1, p2) -> Integer.compare(p1.length(),p2.length()));
        System.out.println(max);
    }
}
