package com.demo.application.controller;

import com.demo.application.view.SquareNumberView;
import com.demo.framework.controller.ControllerMapping;
import com.demo.framework.controller.Icontroller;
import com.demo.framework.ds.ModelAndView;
import com.demo.framework.model.Model;
import com.demo.framework.model.SampleModel;
import jakarta.servlet.http.HttpServletRequest;

@ControllerMapping("/square-number")
public class SquareNumberController implements Icontroller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request) {

        int num=Integer.parseInt(request.getParameter("num"));
        int result=num*num;

        Model model=new SampleModel();
        model.set("num",String.valueOf(num));
        model.set("result",String.valueOf(result));

        return new ModelAndView(model,new SquareNumberView());
    }
}
