package com.demo.application.controller;

import com.demo.application.view.AddNumberView;
import com.demo.framework.controller.ControllerMapping;
import com.demo.framework.controller.Icontroller;
import com.demo.framework.ds.ModelAndView;
import com.demo.framework.model.Model;
import com.demo.framework.model.SampleModel;
import jakarta.servlet.http.HttpServletRequest;

@ControllerMapping(value = "/add-number")
public class AddNumberController implements Icontroller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request) {

        int num1=Integer.parseInt(request.getParameter("num1"));
        int num2=Integer.parseInt(request.getParameter("num2"));
        int result=num1+num2;
        Model model=new SampleModel();
        model.set("num1",String.valueOf("num1"));
        model.set("num2",String.valueOf("num2"));
        model.set("result",String.valueOf(result));

        return new ModelAndView(model,new AddNumberView());
    }
}
