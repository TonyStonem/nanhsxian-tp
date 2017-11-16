package cn.xjw.tpweb.servlet;

import cn.xjw.tpweb.db.bean.UserBean;
import cn.xjw.tpweb.db.dao.SignInDao;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by xjw on 2017/11/15 16:29
 * Email : 1521975316@qq.com
 */
public class SingInServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String username = req.getParameter("name");
        String pswd = req.getParameter("pswd");
        if (username == null || username.isEmpty() || pswd == null || pswd.isEmpty()) {
            out.print("账号或密码不能为空");
            out.close();
            return;
        }
        UserBean bean = SignInDao.query4LoginID(username);
        if (bean == null) {
            out.print("账号不存在");
            out.close();
            return;
        }
        if (!bean.getPswd().equals(pswd)) {
            out.print("密码错误");
            out.close();
            return;
        }
        out.print("Sign in >> 用户:" + username + ";密码:" + pswd);
        System.out.println("sign in.");
        out.close();
    }
}
