import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by xly on 2018/5/1.
 */
public class Demo {

    static String sql = null;
    static DBHelper db1 = null;
    static ResultSet ret = null;

    public static void main(String[] args) {
        sql = "select * from user";//SQL语句
        db1 = new DBHelper(sql);//创建DBHelper对象

        try {
            ret = db1.pst.executeQuery();//执行语句，得到结果集
            while (ret.next()) {
                long id = ret.getLong(1);
                int userAge = ret.getInt(2);
                String userName = ret.getString(3);
                System.out.println(id + "\t" + userAge + "\t" + userName  );
            }//显示数据
            ret.close();
            db1.close();//关闭连接
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
