package cn.xjw.tpweb.db.dao;

import cn.xjw.tpweb.base.DBUtils;
import cn.xjw.tpweb.db.bean.UserBean;

/**
 * Created by xjw on 2017/11/16 14:52
 * Email : 1521975316@qq.com
 */
public class SignUpDao {

    public static boolean signUp(UserBean bean) {
        String sql = "INSERT INTO users (loginID, address, details, loginDate, phone, pswd) VALUES (?, ?, ?, ?, ?, ?)";
        return DBUtils.write(
                sql,
                bean.getLoginID(),
                bean.getAddress(),
                bean.getDetails(),
                bean.getLoginDate(),
                bean.getPhone(),
                bean.getPswd()
        );
    }

}
