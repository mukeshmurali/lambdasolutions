package com.lamba;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreams {
    public static void main(String[] args) throws IOException {
        int arr[]={1,3,4,5};
        //Print each number using for each
        Arrays.stream(arr).forEach(System.out::println);
        //Add a range intermediately
        IntStream
                .range(1,4)
                .forEach(System.out::println);
        //Add a skip
        IntStream
                .range(1,50)
                .skip(5)
                .forEach(System.out::print);
        //Perform sum within a range
        int sum = IntStream.range(1, 20).sum();
        System.out.println("Sum=" + sum);
        //Filter from  a list of names
        Stream.of("Sarri", "Lampard", "Tuchel")
                .filter(s->s.contains("rr"))
                .forEach(System.out::println);
        //Sort a list names
        Stream.of("Tuchel","Lampard","Sarri")
                .sorted()
                .forEach(System.out::println);
        //Reverse Sort a list names
        Stream.of("Tuchel","Lampard","Sarri")
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
        //Print first item in the list
        Stream.of("Maurizio", "Thomas", "Frank")
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);
        //Print average of squares of an int array
        IntStream
                .of(1,2,3,4,5)
                .map(x->x*x)
                .average()
                .ifPresent(System.out::println);
        //Filter from a list of names and print
        List<String> people=Arrays.asList("Azpi","Mitchy","Eden");
        people.stream()
                .map(String::toLowerCase)
                .filter(s->s.startsWith("e"))
                .findFirst()
                .ifPresent(System.out::println);
        //Read from text file, sort lines and print
        Stream<String> lines = Files.lines(Path.of("src/main/resources/sample.txt"));
        lines
                .map(String::toLowerCase)
                .sorted()
                .forEach(System.out::println);
        lines.close();
        //Read from text file, pick lines begining with it and store in a list
        Stream<String> lines1 = Files.lines(Path.of("src/main/resources/sample.txt"));
        List<String> its = lines1.sorted()
                .filter(s -> s.contains("it"))
                .collect(Collectors.toList());
        System.out.println(its.toString());
        //Stream rows from a csv files and count field values in each line and filter out the lines having incomplete data
        Stream<String> charsInFiles = Files.lines(Path.of("src/main/resources/sample.txt"));
        long count = charsInFiles
                .map(x -> x.split(","))
                .filter(x-> x.length == 3)
                .count();Å
        System.out.println("Count="+ count);
        charsInFiles.close();
        //Stream rows from a csv file and parse data and print the items in rows with 2nd field value >12
        Stream<String> lines2 = Files.lines(Path.of("src/main/resources/sample_csv1.txt"));
        lines2
                .map(x->x.split(","))
                .filter(x-> Integer.parseInt(x[1])>12)
                .forEach(x-> System.out.println(x[0] + " " + x[1] + " " + x[2]));
        lines2.close();


    }
}
