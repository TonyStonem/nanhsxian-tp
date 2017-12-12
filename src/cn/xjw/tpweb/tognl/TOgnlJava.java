package cn.xjw.tpweb.tognl;

import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;

/**
 * Created by xjw on 2017/12/12 15:12
 * Email : 1521975316@qq.com
 */
public class TOgnlJava {

    public static void main(String[] args) {
        try {
            t();
            t1();
            t2();
        } catch (OgnlException e) {
            e.printStackTrace();
        }
    }

    //获取数据
    public static void t2() throws OgnlException {
        OgnlContext context = new OgnlContext();
        //获取OgnlContext中的数据
        context.put("name","Sid");
        String str = (String) Ognl.getValue("#name", context, context.getRoot());
        System.out.println(str);
        //获取 Root 中的数据
        User user = new User();
        user.setName("Tony");
        context.setRoot(user);
        String name = (String) Ognl.getValue("name", context, context.getRoot());
        System.out.println(name);
    }

    public static void t1() throws OgnlException {
        OgnlContext context = new OgnlContext();
        //调用对象静态方法
        Object obj = Ognl.getValue("@java.lang.Math@random()", context, context.getRoot());
        System.out.println(obj);
    }

    public static void t() throws OgnlException {
        OgnlContext context = new OgnlContext();
        //调用字符串的length方法, 'helloOgnl'.length() 就是OGNL的表达式
        Object obj = Ognl.getValue("'helloOgnl'.length()", context, context.getRoot());
        System.out.println(obj);
    }

}
