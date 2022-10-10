package nalstudio.controller.base;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {

    String redirect = "redirect:";

    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
