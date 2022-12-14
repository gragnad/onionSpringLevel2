package nalstudio.controller;

import core.db.DataBase;
import nalstudio.controller.base.Controller;
import nalstudio.model.User;
import nalstudio.util.UserSessionUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebServlet(value = {"/users/login", "/users/loginFrom"})
public class LoginController implements Controller {
    private static final long serialVersionUID = 1L;

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        forward("/user/login.jsp", req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String userId = req.getParameter("userId");
//        String password = req.getParameter("password");
//        User user = DataBase.findUserById(userId);
//        if (user == null) {
//            req.setAttribute("loginFailed", true);
//            forward("/user/login.jsp", req, resp);
//            return;
//        }
//
//        if (user.matchPassword(password)) {
//            HttpSession session = req.getSession();
//            session.setAttribute(UserSessionUtils.USER_SESSION_KEY, user);
//            resp.sendRedirect("/");
//        } else {
//            req.setAttribute("loginFailed", true);
//            forward("/user/login.jsp", req, resp);
//        }
//    }
//
//    private void forward(String forwardUrl, HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//        RequestDispatcher rd = req.getRequestDispatcher(forwardUrl);
//        rd.forward(req, resp);
//    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        User user = DataBase.findUserById(userId);
        if (user == null) {
            request.setAttribute("loginFailed", true);
            return "/user/login.jsp";
        }

        if (user.matchPassword(password)) {
            HttpSession session = request.getSession();
            session.setAttribute(UserSessionUtils.USER_SESSION_KEY, user);
            return redirect + "/index.jsp";
        } else {
            request.setAttribute("loginFailed", true);
            return "/user/login.jsp";
        }
    }
}
