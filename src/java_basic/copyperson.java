package java_basic;

import java.io.Serializable;

public class copyperson  implements Serializable {

    private static final long serialVersionUID = -826558421081574017L;
    private String name;
    private String age;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
