package cn.xjw.tpweb.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by xjw on 2017/11/27 21:03
 * Email : 1521975316@qq.com
 */
public class HomeAction extends ActionSupport{

    @Override
    public String execute() throws Exception {
        System.out.println("get List.");
        return NONE;
    }
}
