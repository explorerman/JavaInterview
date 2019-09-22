package functionalExpression;

import java.util.Arrays;

public class functionalTest {

	public static void main(String[] args) {
		int[] arr = {1,2,4,5,6,7,9,3};
		Arrays.stream(arr).map((x) -> x = x+1).forEach(System.out::println);
		Arrays.stream(arr).map(x -> (x % 2 == 0 ? x : x + 1)).forEach(System.out::print);
		Arrays.stream(arr).forEach(System.out::print);
 	}

}
