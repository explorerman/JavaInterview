package java_basic;

import java.util.ArrayList;
import java.util.List;

// 复制对象，将一个对象的属性复制到另一个对象中。
public class testPerson {

    public static List<person> copy(List<copyperson> copypersonList) {
        List<person> res = new ArrayList<>();
        for (copyperson cur : copypersonList) {
            person p = new person();
            p.setName(cur.getName());
            p.setAge(cur.getAge());
            res.add(p);
        }
        return res;
    }

    public static void main(String[] args) {
        List<copyperson> cpList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            copyperson cp = new copyperson();
            cp.setName("lijie" + i);
            cp.setAge("12");
            cpList.add(cp);
        }
        copy(cpList);
    }
}
