package com.levelup.webtest.controllers;

import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by denis_zavadsky on 2/7/15.
 */
public class ControllerHolder {

    private HashMap<String, ControllerIf> controllersMap = new HashMap<String, ControllerIf>();

    public void init(){
        Reflections reflections = new Reflections("com.levelup.webtest.controllers");
        Set<Class<?>> controllers = reflections.getTypesAnnotatedWith(com.levelup.webtest.controllers.Controller.class);
        for (Class controller: controllers){
            Controller annotation = (Controller) controller.getAnnotation(Controller.class);
            String url = annotation.url();
            try {
                controllersMap.put("/main"+url, (ControllerIf) controller.newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public ControllerIf getController(String url){
        return controllersMap.get(url);
    }
}
