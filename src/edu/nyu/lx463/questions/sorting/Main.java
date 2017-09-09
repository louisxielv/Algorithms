package edu.nyu.lx463.questions.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
	// write your code here
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("12");
        list.add("22");

        list.stream().filter(a -> {
            return a.startsWith("1");
        }).forEach(System.out::println);
    }
}
