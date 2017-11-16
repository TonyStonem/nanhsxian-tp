package cn.xjw.tpweb.base;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by xjw on 2017/11/16 10:48
 * Email : 1521975316@qq.com
 */
public interface RowParser {

    Object parserRow(ResultSet set) throws SQLException;

}
