package Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamApiExample {
    public static void main(String[] args) {
        //使用流来操作forEach
        Stream<String> stream = Stream.of("I", "love", "you", "too");
        stream.forEach(str -> System.out.println(str));

        //filter 输出为长度等于3的字符串
        stream.filter(str -> str.length() == 3).forEach(str -> System.out.println(str));

        //distinct()  返回一个去除重复元素之后的Stream
        stream.distinct().forEach(str -> System.out.println(str));

        //sorted()
        stream.sorted((str1, str2) -> str1.length() - str2.length()).forEach(str -> System.out.println(str));

        //map() 输出原字符串的大写形式
        stream.map(str -> str.toUpperCase()).forEach(str -> System.out.println(str));

        //flatMap()
        Stream<List<Integer>> stream1 = Stream.of(Arrays.asList(1,2), Arrays.asList(3,4,5));
        stream1.flatMap(list -> list.stream()).forEach(i -> System.out.println(i));
        //原来的stream中有两个元素，分别是两个List<Integer>，执行flatMap()之后，
        // 将每个List都“摊平”成了一个个的数字，所以会新产生一个由5个数字组成的Stream。所以最终将输出1~5这5个数字。

        //reduce()
        // 找出最长的单词
        Stream<String> stream2 = Stream.of("I", "love", "you", "too");
        Optional<String> longest = stream2.reduce((s1, s2) -> s1.length()>=s2.length() ? s1 : s2);
        //Optional<String> longest = stream.max((s1, s2) -> s1.length()-s2.length());
        System.out.println(longest.get());
    }
    public void test(){

    }
}
