package generic;

import java.util.List;

public class DAOTest {
    public static void main(String[] args) {
        DAO<User> dao = new DAO<>();
        dao.save("1001", new User(1001, 21, "123"));
        dao.save("1002", new User(1002, 22, "1234"));
        dao.save("1003", new User(1003, 23, "1235"));
        final List<User> list = dao.list();
        list.forEach(System.out::println);
    }
}
