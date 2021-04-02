package Lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaUtils {
    // 提供一个 Function 入参泛型方法【适用于不同的数据类型】
    public static <T, R> R calculate(T t, Function<T, R> function) {
        return function.apply(t);
    }


    public static <T> T Supplier(Supplier<T> suply) {
        //供应者接口
        return suply.get();
    }

    public static <T> void generateX(Consumer<T> consumer) {
        consumer.accept((T) "hello consumer");
    }


}
