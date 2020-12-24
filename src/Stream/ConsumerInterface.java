package Stream;

import java.util.List;

//自定义函数接口  @FunctionalInterface是可选的，但加上该标注编译器会帮你检查接口是否符合函数接口规范。就像加入@Override标注会检查是否重载了函数一样。
@FunctionalInterface
public interface ConsumerInterface<T> {
    void accept(T t);
}

class MyStream<T>{
    private List<T> list;

    public void myForEach(ConsumerInterface<T> consumer){
        for(T t : list){
            consumer.accept(t);
        }
    }
}

class CustomStream{

    public static void main(String[] args) {
        MyStream<String> stream = new MyStream<>();
        stream.myForEach(str -> System.out.println(str));
    }


}


