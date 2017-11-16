package cn.xjw.tpweb.db.dao;

import cn.xjw.tpweb.base.DBUtils;
import cn.xjw.tpweb.db.bean.UserBean;
import cn.xjw.tpweb.db.parser.UserParser;

/**
 * Created by xjw on 2017/11/16 10:43
 * Email : 1521975316@qq.com
 */
public class SignInDao {

    public static UserBean query4LoginID(String loginID) {
        String sql = "select * from users where loginID = ?";
        return (UserBean) DBUtils.read(sql, new UserParser(), loginID);
    }

}
