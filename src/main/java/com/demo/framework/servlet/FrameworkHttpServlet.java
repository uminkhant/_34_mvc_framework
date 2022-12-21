package com.demo.framework.servlet;

import com.demo.framework.controller.Icontroller;
import com.demo.framework.ds.ModelAndView;
import com.demo.framework.model.Model;
import com.demo.framework.utils.ApplicationcontrollerFinder;
import com.demo.framework.view.View;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

@WebServlet(name = "framework-servlet",urlPatterns = "/*")
public class FrameworkHttpServlet extends HttpServlet {

    private Map<String, Icontroller>icontrollerMap;

    @Override
    public void init(ServletConfig config) throws ServletException {
      icontrollerMap=new ApplicationcontrollerFinder().findControllers();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String uri=req.getRequestURI();
        Icontroller icontroller=icontrollerMap.get(uri);

        if(icontroller!=null){

            ModelAndView modelAndView=icontroller.handleRequest(req);
            Model model=modelAndView.getModel();
            View view=modelAndView.getView();
            String renderString = view.render(model);
            resp.setContentType("text/html");
            resp.getWriter().println(renderString);

        }else{
            throw  new ServletException("Request uri %s cannot match any controller".formatted(uri));
        }
    }
}
