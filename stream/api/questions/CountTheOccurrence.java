package io.dowlath.stream.api.questions;


// ilovedowlathbasha
// a = 3 , b = 1 , d = 1 , e = 1, f=1, h=1 ...

import java.sql.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountTheOccurrence {
    public static void main(String[] args) {
        String input = "ilovedowlathbasha";
        //String[]  results = input.split("");
        //System.out.println(Arrays.toString(results)); //[i, l, o, v, e, d, o, w, l, a, t, h, b, a, s, h]
        // covert into array as groupby
        /*Map<String, List<String>> map = Arrays.stream(input.split(""))
                                            .collect(Collectors.groupingBy(s -> s));*/
        //{a=[a, a], b=[b], s=[s], t=[t], d=[d], e=[e], v=[v], w=[w], h=[h, h], i=[i], l=[l, l], o=[o, o]}
        Map<String, Long> count = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        // result : {a=3, b=1, s=1, t=1, d=1, e=1, v=1, w=1, h=2, i=1, l=2, o=2}
        System.out.println(count);


    }
}
