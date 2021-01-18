import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class CollectionStreamExample {
    public static void main(String[] args) {
        //forEach的使用
        //使用外部迭代
        ArrayList<String> list = new ArrayList<>(Arrays.asList("i", "have", "a", "dream"));
        for(String str : list){
            if(str.length() > 3){
                System.out.println(str);
            }
        }

        //使用匿名内部类
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                if(s.length() > 3){
                    System.out.println(s);
                }
            }
        });

        //使用lambda表达式
        list.forEach( str ->{
            if(str.length() > 3){
                System.out.println(str);
            }
        });

        //removeIf() 删除长度大于3的字符串
        ArrayList<String> list1 = new ArrayList<>(Arrays.asList("i", "have", "a", "dream"));
        final Iterator<String> iterator = list1.iterator();
        while (iterator.hasNext()){
            if(iterator.next().length() > 3){
                iterator.remove();
            }
        }

        //使用removeIf,结合匿名内部类
        list1.removeIf(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() > 3;
            }
        });

        //使用lambda
        list1.removeIf(str -> str.length() > 3);

        //list
        //replaceAll() 对所有元素指行某个operator操作
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
        for (int i = 0; i < list2.size(); i++) {
            String str = list2.get(i);
            if(str.length() > 3){
                list2.set(i, str.toUpperCase());
            }
        }
        
        //使用replaceAll()结合匿名内部类
        list2.replaceAll(new UnaryOperator<String>() {
            @Override
            public String apply(String s) {
                if(s.length() > 3){
                    return s.toUpperCase();
                }
                return s;
            }
        });

        //使用lambda表达式
        list2.replaceAll(str -> {
            if(str.length() > 3){
                return str.toUpperCase();
            }
            return str;
        });

        //sort方法
        ArrayList<String> list3 = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
        Collections.sort(list3, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        //使用lambda表达式
        list3.sort((str1, str2) -> str1.length() - str2.length());

        //spliterator()


        //map中的新方法
        // 使用forEach()结合Lambda表达式迭代Map
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.forEach((k, v) -> System.out.println(k + "=" + v));

        //getOrDefault()

        //putIfAbsent()

        //remove()

        //replace()

        // 使用replaceAll()结合Lambda表达式实现
        map.replaceAll((k, v) -> v.toUpperCase());

        //merge()

        //compute()

        //computeIfAbsent()

        //computeIfPresent()

    }
}
