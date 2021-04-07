package 复习资料___设计题;

import java.util.Map;

public class test {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Map<Integer, String> map = new ComputeClass().getMap();
            System.out.println(map);
        }
    }
}
