package com.levelup.webtest;

import com.levelup.dao.AccountRepository;
import com.levelup.webtest.controllers.ControllerHolder;
import com.levelup.webtest.controllers.ControllerIf;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by denis_zavadsky on 2/7/15.
 */
public class DispatcherServlet extends HttpServlet {

    private String CSS_URL_PART = "";
    private String JS_URL_PART = "";
    private ControllerHolder controllerHolder;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AccountRepository repository = new AccountRepository();
        String url = request.getRequestURI();
//        String serverPart = request.getProtocol()+"://"+request.getServerName()+request.getServerPort()+request.getContextPath();
//        String path = request.getContextPath();
//        url = url.replaceAll(serverPart,"");

        //int position = url.lastIndexOf("/");
        //String controllerUrlPart = url.substring(position);

        ControllerIf controller = controllerHolder.getController(url);
        String view = null;
        if (controller!=null){
            view = controller.service(request,response);
        }
        if (view != null){
            getServletContext().getRequestDispatcher(view).forward(request,response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Url not found!");
        }
    }

//    @Override
//    public void init() throws ServletException {
//        super.init();
//        controllerHolder = new ControllerHolder();
//        controllerHolder.init();
//    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        CSS_URL_PART = config.getInitParameter(Constants.CSS_PART_PARAMETER);
        JS_URL_PART = config.getInitParameter(Constants.JS_PART_PARAMETER);
        controllerHolder = new ControllerHolder();
        controllerHolder.init();
    }
}
