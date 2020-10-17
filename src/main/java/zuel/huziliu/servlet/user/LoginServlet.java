package zuel.huziliu.servlet.user;



import zuel.huziliu.pojo.User;
import zuel.huziliu.service.user.UserServiceimp;
import zuel.huziliu.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userCode=req.getParameter("userCode");
        String userPassword = req.getParameter("userPassword");
        UserServiceimp userServiceimp=new UserServiceimp();
        User user = userServiceimp.login(userCode, userPassword);
        if(user!=null&&user.getUserPassword().equals(userPassword)){
            req.getSession().setAttribute(Constants.USER_SESSION,user);
            resp.sendRedirect("/jsp/frame.jsp");
        }
        else{
            req.setAttribute("error","用户名或者密码不正确");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
