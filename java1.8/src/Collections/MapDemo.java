package Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;


public class MapDemo {
    public static void main(String[] args) {
        //相同key的情况下，丢弃重复的只保留一个
        ArrayList<String> arrs = new ArrayList<>();
        arrs.add("1@1");
        arrs.add("1@2");
        arrs.add("2@2");
        arrs.add("3@3");
        Map<String, String> map = arrs.stream().map(arr -> arr.split("@")).collect(toMap(
                arr -> arr[0],
                arr -> arr[1],
                (v1, v2) -> v2
        ));
        System.out.println(map);

        //相同key的情况下，把value变成list，形成Map(Object,List<Object>)的形式。
        ArrayList<String> arrss = new ArrayList<>();
        arrss.add("1@1");
        arrss.add("1@2");
        arrss.add("2@2");
        arrss.add("3@3");
        Map<String, List<String>> collect = arrss.stream().map(arr -> arr.split("@")).collect(toMap(
               key -> key[0],
                value -> new ArrayList<String>(Collections.singleton(value[1])),
                (List<String> oldList, List<String> newList) -> {
                   oldList.addAll(newList);
                   return oldList;
                }
        ));
        System.out.println(collect);
    }
}
