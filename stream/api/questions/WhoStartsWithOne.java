package io.dowlath.stream.api.questions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WhoStartsWithOne {
    public static void main(String[] args) {
        /** find element from arrya who starts with 1 **/
        int[] numbers = { 5,9,11,2,8,21,1};
        List<String> stringList = Arrays.stream(numbers).boxed()
                                 .map(s -> s + "")
                                 .filter((s-> s.startsWith("1")))
                                 .collect(Collectors.toList());

        System.out.println(stringList);
    }
}
