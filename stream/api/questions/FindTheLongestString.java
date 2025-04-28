package io.dowlath.stream.api.questions;

import java.util.Arrays;

public class FindTheLongestString {
    public static void main(String[] args) {

        String[] strArray = {"java","techie","springboot","microservices"};

        String longestString = Arrays.stream(strArray)
                               .reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2)
                               .get();
        System.out.println("The longest string ... : "+ longestString);
    }
}
