package util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        String s1="ab";
        String s2="ab";
        System.out.println(s1 == s2);
        Integer k=100;
        Integer l=100;
        System.out.println(k==l);
        Integer[] ss={1,4,3,7,6};
        Arrays.sort(ss);
        System.out.println(Arrays.toString(ss));
        List<Integer> integers = Arrays.asList(ss);
        Collections.reverse(integers);
        System.out.println(integers);
    }
}
