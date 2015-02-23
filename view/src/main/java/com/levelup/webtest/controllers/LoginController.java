package com.levelup.webtest.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by denis_zavadsky on 2/7/15.
 */
@Controller(url = "/login")
public class LoginController implements ControllerIf {

    @Override
    public String service(HttpServletRequest request, HttpServletResponse response) {
        return "/newlogin.jsp";
    }
}
