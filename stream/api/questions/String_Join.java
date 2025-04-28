package io.dowlath.stream.api.questions;

import java.util.Arrays;
import java.util.List;

public class String_Join {
    // 1-2-3-4
    public static void main(String[] args) {
        List<String> nos = Arrays.asList("1","2","3","4");
        String results = String.join("-",nos);
        System.out.println(results);
    }
}
