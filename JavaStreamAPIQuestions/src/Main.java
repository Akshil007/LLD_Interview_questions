import java.util.*;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Use Stream API to count the total number of distinct words (case-insensitive) in all the sentences
        List<String> sentences = Arrays.asList(
                "Java Stream API provides a fluent interface for processing sequences of elements.",
                "It supports functional-style operations on streams of elements, such as map-reduce transformations.",
                "In this exercise, you need to count the total number of words in all sentences sentences .",
                "In this exercise, you need to count the total number of words in all sentences sentences ."
        );

//        sentences.stream().map(s -> s.split(" "))

        long ans = sentences.stream().flatMap(list -> Arrays.asList(list).stream()).distinct().count();
        System.out.println(ans);



        // Use Stream API to find the concatenation of the first two words that have even lengths.
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");
        String s1 = words.stream().filter(s -> s.length() % 2 == 0 ).limit(2).collect(Collectors.joining());
        System.out.println(s1);


        // Use Stream API to find the sum of the squares of even numbers in the list.
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        long sum = numbers.stream().filter(i -> i % 2 == 0).map(x -> x*x).mapToInt(i->i).sum();
        System.out.println(sum);

        // Use Stream API to group words by their lengths and collect the result into a Map.
        List<String> words2 = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");
        Map<Integer, List<String>> map = words2.stream().collect(Collectors.groupingBy(s -> s.length()));
        System.out.println(map);

        String test = " tes t ";
        char[] arr = test.toCharArray();
        System.out.println(arr);
//        Scanner sc  = new Scanner(System.in);
//        String s = sc.nextLine();
//        System.out.println(s);
        System.out.println(test.trim());

        String s = "112";
        int num = Integer.parseInt(s);
        String q = String.valueOf(num);
        

    }
}
