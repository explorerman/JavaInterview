package 复习资料___设计题;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ComputeClass extends abstractClass{
    private static Map<Integer, String> map = new ConcurrentHashMap<>();
    @Override
    protected Map<Integer, String> getMap() {
        return map;
    }
}
