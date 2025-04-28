package io.dowlath.stream.api.questions;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicate_And_FindUnquieElement {
    public static void main(String[] args) {
        // {a=3, b=1, s=1, t=1, d=1, e=1, v=1, w=1, h=2, i=1, l=2, o=2}
        String input = "ilovedowlathbasha";
        List<String> duplicateElement = Arrays.stream(input.split(""))
                                        .collect(Collectors.groupingBy(Function.identity(),
                                        Collectors.counting())).entrySet().stream().
                                        filter(x->x.getValue()>1).map(Map.Entry::getKey)
                                       .collect(Collectors.toList());
        System.out.println("Duplicate Element.... : "+duplicateElement);

        List<String> uniqueElement = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting())).entrySet().stream().
                filter(x->x.getValue() == 1).map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println("Unique Element.... : "+uniqueElement);
    }
}
