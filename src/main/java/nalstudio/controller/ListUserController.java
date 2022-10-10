package nalstudio.controller;

import core.db.DataBase;
import nalstudio.controller.base.Controller;
import nalstudio.util.UserSessionUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/users")
public class ListUserController implements Controller {
    private static final long serialVersionUID = 1L;

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        if (req.getSession().getAttribute(UserSessionUtils.USER_SESSION_KEY) == null) {
//            resp.sendRedirect("/users/loginForm");
//            return;
//        }
//
//        req.setAttribute("users", DataBase.findAll());
//
//        RequestDispatcher rd = req.getRequestDispatcher("/user/list.jsp");
//        rd.forward(req, resp);
//    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if(!UserSessionUtils.isLogined(request.getSession())) {
            return redirect + "/user/login.jsp";
        }
        request.setAttribute("users", DataBase.findAll());
        return "/user/list.jsp";
    }
}
