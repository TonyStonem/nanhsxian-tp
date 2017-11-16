package cn.xjw.tpweb.db.parser;

import cn.xjw.tpweb.base.RowParser;
import cn.xjw.tpweb.db.bean.UserBean;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by xjw on 2017/11/16 10:55
 * Email : 1521975316@qq.com
 */
public class UserParser implements RowParser {

    @Override
    public Object parserRow(ResultSet set) throws SQLException {
        return new UserBean(
                set.getInt("id"),
                set.getString("loginID"),
                set.getString("address"),
                set.getString("details"),
                set.getString("loginDate"),
                set.getString("phone"),
                set.getString("pswd")
        );
    }
}
