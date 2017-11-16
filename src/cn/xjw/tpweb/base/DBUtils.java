package cn.xjw.tpweb.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * jdbc类 负责数据库连接
 */
public class DBUtils {

    private static final String jdbcUrl = "jdbc:mysql://localhost:3306/sevenkill_book";
    private static final String uName = "root";
    private static final String uPswd = "xjwroot";

    private static Map<Thread, Connection> connections = new HashMap<Thread, Connection>();

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("can not register driver");
        }
    }

    private static Connection getConnection() throws SQLException {
        Connection con = connections.get(Thread.currentThread());
        if (con == null) {
            con = DriverManager.getConnection(jdbcUrl, uName, uPswd);
            System.out.println("open connection:" + con.hashCode());
            con.setAutoCommit(false);
            connections.put(Thread.currentThread(), con);
        }
        return con;
    }

    private static void closeConnection() {
        Connection con = connections.get(Thread.currentThread());
        if (con != null) {
            try {
                System.out.println("close connection: " + con.hashCode());
                con.close();
                connections.remove(Thread.currentThread());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static PreparedStatement createPS(String sql, Object... params) throws SQLException {
        PreparedStatement statement = getConnection().prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            statement.setObject(i + 1, params[i]);
        }
        return statement;
    }

    public static Object read(String sql, RowParser parser, Object... params) {
        Object obj = null;
        try {
            PreparedStatement ps = createPS(sql, params);
            ResultSet set = ps.executeQuery();
            if (set.next()) {
                obj = parser.parserRow(set);
            }
            set.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("参数或占位符异常");
        }
        return obj;
    }

    public static boolean write(String sql, Object... params) {
        try {
            PreparedStatement ps = createPS(sql, params);
            int i = ps.executeUpdate();
            ps.close();
            return i > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
