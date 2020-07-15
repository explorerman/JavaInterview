package LeetCode_tencent;

import java.util.stream.Stream;

import static java.util.Comparator.comparing;

public class aaa {
    public int numWays(int n) {
        Stream<Integer> emptyStream = Stream.empty();
        Stream.iterate(new int[]{0, 1},
                t -> new int[]{t[1],t[0] + t[1]})
                .limit(n)
                .map(t -> t[0])
                .max(comparing(Integer::intValue));
    }
}
