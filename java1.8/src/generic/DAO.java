package generic;

import java.util.*;

public class DAO<T> {
    private Map<String, T> map = new HashMap<>();

    //保存T类型的对象到map成员变量中
    public void save(String id, T entity){
        map.put(id, entity);
    }

    //从map中获取id对应的对象
    public T get(String id){
        return map.get(id);
    }

    //替换map中key为id的内容，改为entity对象
    public void update(String id, T entity){
        if(map.containsKey(id)){
            map.put(id, entity);
        }
    }
    //返回map中存放的所有T对象
    //注意强制类型转换，必须是自己清楚确实可以转的，如创建的时候是个object，要强转成person对象，必然会报错
    public List<T> list(){
         Collection<T> values = map.values();
         List<T> list = new ArrayList<>();
         for (T t : values){
             list.add(t);
         }
         return list;
    }

    public void delete(String id){
        map.remove(id);
    }
}
