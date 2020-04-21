package java_basic;

import java.io.Serializable;
import java.util.List;

public class person implements Serializable {
    private static final long serialVersionUID = 7959368734091712597L;
    private String name;
    private String age;
    private List<person> listPerson;

    public List<person> getListPerson() {
        return listPerson;
    }

    public void setListPerson(List<person> listPerson) {
        this.listPerson = listPerson;
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
