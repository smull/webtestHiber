package com.levelup.webtest.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by denis_zavadsky on 2/7/15.
 */
public interface ControllerIf {

    String service(HttpServletRequest request, HttpServletResponse response);
}
