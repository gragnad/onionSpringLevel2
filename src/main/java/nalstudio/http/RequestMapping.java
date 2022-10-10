package nalstudio.http;

import nalstudio.controller.*;
import nalstudio.controller.base.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class RequestMapping {
    private static final Logger log = LoggerFactory.getLogger(RequestMapping.class);

    Map<String, Controller> controllerMaps;


    public void initMapping() {
        controllerMaps = new HashMap<>();
        controllerMaps.put("/", new HomeController());
        controllerMaps.put("/users/loginForm", new ForwardController("/user/login.jsp"));
        controllerMaps.put("/users/form", new ForwardController("/user/form.jsp"));
        controllerMaps.put("/users", new ListUserController());
        controllerMaps.put("/users/login", new LoginController());
        controllerMaps.put("/users/profile", new ProfileController());
        controllerMaps.put("/users/logout", new LogoutController());
        controllerMaps.put("/users/create", new CreateUserController());
        controllerMaps.put("/users/update", new UpdateUserController());
        //controllerMaps.put("/users/updateForm", new HomeController());
    }

    public Controller findController(String url) {
        return controllerMaps.get(url);
    }

    void put(String url, Controller controller) {
        controllerMaps.put(url, controller);
    }
}
