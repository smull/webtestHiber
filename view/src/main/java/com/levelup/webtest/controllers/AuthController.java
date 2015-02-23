package com.levelup.webtest.controllers;

import com.levelup.webtest.Constants;
import com.levelup.webtest.dao.DatabaseUtilBean;
import com.levelup.webtest.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by denis_zavadsky on 2/7/15.
 */
@Controller(url = "/auth")
public class AuthController implements ControllerIf {

    @Override
    public String service(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter(Constants.LOGIN_EMAIL_PARAMETER);
        String password = request.getParameter(Constants.LOGIN_PASSWORD_PARAMETER);

        DatabaseUtilBean databaseUtilBean = new DatabaseUtilBean();
        User user = databaseUtilBean.login(login,password);
        if (user!=null){
            request.getSession().setAttribute("user",user);
            return "/content.jsp";
        } else {
            return "/login";
        }
    }
}
