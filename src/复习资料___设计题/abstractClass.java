package 复习资料___设计题;

import java.util.Map;

public abstract class abstractClass {
    public void forCompute(){
        for (int i = 0; i < 10; i++) {
            build(i, getMap());
        }
    }

    protected abstract Map<Integer, String> getMap();

    public void build(int i, Map<Integer, String> map){
        map.put(i, "hello_" + i);
    }


}
