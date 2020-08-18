package java_basic;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//写一段JDBC连接的程序，并实现数据查询。

public class JDBCTest {
    public static void main(String[] args) throws Exception {

        // 1、加载驱动
        Class.forName("com.mysql.jdbc.Driver");

        // 2、创建数据库连接对象
        Connection conn = null;

        conn = DriverManager
                .getConnection(
                        "jdbc:mysql://localhost:3306/db?useUnicode=true&characterEncoding=UTF-8",
                        "root", "123456");

        // 3、创建数据库命令执行对象

        PreparedStatement psPreparedStatement = conn
                .prepareStatement("select * from t_user");
        // Statement stmtStatement=conn.createStatement();

        // 4、执行数据库命令
        ResultSet rSet = psPreparedStatement.executeQuery();
        //ResultSet rs=stmtStatement.executeQuery("select * from t_user");
        //5、处理执行结果
        while(rSet.next()){
            int id=rSet.getInt("id");
            String usernameString=rSet.getString("username");
            String passwordString=rSet.getString("password");
        }
        if(rSet!=null)
            rSet.close();
        if(psPreparedStatement!=null)
            psPreparedStatement.close();
        if(conn!=null)
            conn.close();
    }
}
