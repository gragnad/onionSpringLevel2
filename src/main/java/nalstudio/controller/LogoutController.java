package nalstudio.controller;

import nalstudio.controller.base.Controller;
import nalstudio.util.UserSessionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        if(session.getAttribute(UserSessionUtils.USER_SESSION_KEY) != null) {
            session.removeAttribute(UserSessionUtils.USER_SESSION_KEY);
            return redirect + "/index.jsp";
        }
        return request.getRequestURI();
    }
}
