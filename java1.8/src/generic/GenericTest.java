package generic;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {
    public static void main(String[] args) {
        List<? extends Person> listMaxPerson = new ArrayList<>();
        List<? super Person> listMinPerson = new ArrayList<>();

        List<Person> listPerson = new ArrayList<>();
        List<Student> listStudent = new ArrayList<>();
        List<Object> listObject = new ArrayList<>();

        listMaxPerson = listPerson;
        listMaxPerson = listStudent;
        //listMaxPerson = listObject;  编译错误
        final Person person = listMaxPerson.get(0);
        //Student student = listMaxPerson.get(0);  只能获取到最大对象，因为不确定获取的值具体是小于person的哪个对象
        //listMaxPerson.add(new Person());   编译失败
        //listMaxPerson.add(new Student()); 编译失败


        listMinPerson = listPerson;
        //编译错误，因为listMinPerson最小是Person
        //listMinPerson = listStudent;
        listMinPerson = listObject;
        listMinPerson.add(new Person());
        listMinPerson.add(new Student());


    }
}
