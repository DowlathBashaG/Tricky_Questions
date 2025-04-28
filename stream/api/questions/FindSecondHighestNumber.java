package io.dowlath.stream.api.questions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FindSecondHighestNumber {
    public static void main(String[] args) {
        int[] numbers = { 5,9,11,2,8,21,1};
        List<Integer> ascendingOrderlist = Arrays.stream(numbers).boxed().sorted().collect(Collectors.toList());
        System.out.println(ascendingOrderlist);

        Integer findSecondLargestNumber = Arrays.stream(numbers).boxed()
                .sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println(findSecondLargestNumber);



    }
}
