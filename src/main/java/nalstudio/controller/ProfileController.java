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
import java.io.IOException;

//@WebServlet("/users/profile")
public class ProfileController implements Controller {
    private static final long serialVersionUID = 1L;

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String userId = req.getParameter("userId");
//        User user = DataBase.findUserById(userId);
//        if (user == null) {
//            throw new NullPointerException("사용자를 찾을 수 없습니다.");
//        }
//        req.setAttribute(UserSessionUtils.USER_SESSION_KEY, user);
//        RequestDispatcher rd = req.getRequestDispatcher("/user/profile.jsp");
//        rd.forward(req, resp);
//    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String userId = request.getParameter("userId");
        User user = DataBase.findUserById(userId);
        if (user == null) {
            throw new NullPointerException("사용자를 찾을 수 없습니다.");
        }
        request.setAttribute(UserSessionUtils.USER_SESSION_KEY, user);
        return "/user/profile.jsp";
    }
}
