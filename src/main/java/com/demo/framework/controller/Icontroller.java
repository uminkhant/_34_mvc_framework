package com.demo.framework.controller;

import com.demo.framework.ds.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;

public interface Icontroller {
    ModelAndView handleRequest(HttpServletRequest request);
}
