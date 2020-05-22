package qaz.galamat.test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import qaz.galamat.test.entity.User;
import qaz.galamat.test.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private UserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        System.out.println("Custom authentication");
        String username = authentication.getName();
        System.out.println(">>>>> USERNAME=" + username);
        User user = userService.findUserByName(username);

        //place it in session
        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        System.out.println(">>>>" + user.getFirstName());
        System.out.println(">>>>" + user.getLastName());
        // redirect to home page
        response.sendRedirect(request.getContextPath()+"/home");
    }
}
