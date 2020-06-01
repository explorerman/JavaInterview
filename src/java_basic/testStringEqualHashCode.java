package java_basic;

import java.util.HashMap;

public class testStringEqualHashCode {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        String st1 = new String("fo");
        String st2 = new String("fo");
        map.put(st1, "fo1");
        map.put(st2, "fo2");
        System.out.println(map.size());
        System.out.println(map.get(st1));
        System.out.println(map.get(st2));

    }
}
