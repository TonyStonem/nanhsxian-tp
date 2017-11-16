package cn.xjw.tpweb.servlet;

import cn.xjw.tpweb.db.bean.UserBean;
import cn.xjw.tpweb.db.dao.SignInDao;
import cn.xjw.tpweb.db.dao.SignUpDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by xjw on 2017/11/15 16:29
 * Email : 1521975316@qq.com
 */
public class SingUpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserBean b = SignInDao.query4LoginID(req.getParameter("name"));
        if (b != null) {
            resp.getWriter().write("该账号已注册");
            return;
        }
        if (!SignUpDao.signUp(new UserBean(
                req.getParameter("name"),
                req.getParameter("address"),
                req.getParameter("details"),
                req.getParameter("loginDate"),
                req.getParameter("phone"),
                req.getParameter("pswd")
        ))) {
            resp.getWriter().write("注册失败");
            return;
        }
        resp.getWriter().write("注册成功");
        System.out.println("sign up.");
    }
}
