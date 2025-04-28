package io.dowlath.stream.api.questions;

import java.util.stream.IntStream;

public class SkipAndLimitPrintValues {
    public static void main(String[] args) {
        // 1 to 10
        // skip 1 and limit (2-9)
        IntStream.rangeClosed(1,10).skip(1).limit(8).forEach(System.out::println);
    }
}
