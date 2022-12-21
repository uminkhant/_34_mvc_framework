package com.demo.application.controller;

import com.demo.application.view.IndexView;
import com.demo.framework.controller.ControllerMapping;
import com.demo.framework.controller.Icontroller;
import com.demo.framework.ds.ModelAndView;
import com.demo.framework.model.SampleModel;
import jakarta.servlet.http.HttpServletRequest;

@ControllerMapping(value = "/")
public class IndexController implements Icontroller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request) {
        return new ModelAndView(new SampleModel(),new IndexView());
    }
}
