package com.offcn.shopping.servlet;

import com.offcn.shopping.bean.User;
import com.offcn.shopping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by 金喆
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {

    @Autowired
    private UserService userService ;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String method = request.getParameter("method");//login

        if("login".equals(method))
        {
            this.login(request,response);
        }
        if("addUI".equals(method))
        {
            this.login(request,response);
        }

        if("add".equals(method))
        {
            this.login(request,response);
        }

        if("delete".equals(method))
        {
            this.login(request,response);
        }

        if("editUI".equals(method))
        {
            this.login(request,response);
        }
        if("edit".equals(method))
        {
            this.login(request,response);
        }
        if("findAll".equals(method))
        {
            this.login(request,response);
        }


    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //设置编码
        request.setCharacterEncoding("utf-8");

        //2.接收数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //由于参数过少，没有必要封装对象


        //3.调用业务层方法。


        User user = userService.findUserByUserNameAndPassword(username, password);

        System.out.println(user);
        if(null == user)
        {//登陆错误跳回到登陆页面
            //登录失败时重定向到login.jsp,本质是像login.jsp发送请求
            response.sendRedirect("/login.jsp?message=loginerror");

        }else{
            //正确的跳转到 商品页面

            //获取Session对象 ，并把上面查询到的user对象放入到session中
            HttpSession session = request.getSession();
            session.setAttribute("user",user);

            response.sendRedirect("/ProductShowServlet");
        }
    }
}
