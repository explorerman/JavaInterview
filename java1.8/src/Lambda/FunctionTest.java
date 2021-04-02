package Lambda;

import java.util.*;
import java.util.function.Function;

public class FunctionTest<T,R> {

    // 提供一个 Function 入参泛型方法【适用于不同的数据类型】
    private static <T, R> R calculate(T t, Function<T, R> function) {
        return function.apply(t);
    }

    public static void main(String[] args) {
        Function<List<Integer>, Integer> sumFunc = list -> list.stream().reduce(0, Integer::sum);
        Integer sum = FunctionTest.calculate(Arrays.asList(1, 2, 3, 4, 5), sumFunc);

        Function<List<Integer>, Integer> maxFunc = list -> list.stream().max(Comparator.comparingInt(o -> o)).orElse(null);
        Integer max = FunctionTest.calculate(Arrays.asList(1, 2, 3, 4, 5), maxFunc);

        Function<List<Integer>, Integer> minFunc = list -> list.stream().min(Comparator.comparingInt(o -> o)).orElse(null);
        Integer min = FunctionTest.calculate(Arrays.asList(1, 2, 3, 4, 5), minFunc);

        System.out.println("sum = " + sum + ", min = " + min + ", max = " + max);

        Function<String, SkuInfo> sku = (str) -> new SkuInfo();
        final SkuInfo live = FunctionTest.calculate("live", sku);
        System.out.println(live);

        String type = "A";
        SkuInfo skuInfo = FunctionTest.calculate(type, (typee) -> new SkuInfo());

    }
    public void test(){
        Map<String,Function<T, R>> map = new HashMap<>();
        map.put("直播", new Function<T, R>() {
            @Override
            public R apply(T t) {
                return (R) new SkuInfo();
            }
        });
        map.put("好物", t -> (R) new SkuInfo());
    }
}
