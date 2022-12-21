package com.demo.framework.utils;

import com.demo.framework.controller.ControllerMapping;
import com.demo.framework.controller.Icontroller;
import org.reflections.Reflections;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class ApplicationcontrollerFinder {


    public Map<String,Icontroller>findControllers(){
        return new Reflections()
                .getTypesAnnotatedWith(ControllerMapping.class)
                .stream()
                .map(this::classAsIController)
                .map(this::getControllerInstance)
                .collect(Collectors.toMap(this::getUri, Function.identity()));
    }


    private Class<Icontroller>classAsIController(Class<?>controller){
        return (Class<Icontroller>) controller;
    }


    private Icontroller getControllerInstance(Class<Icontroller>icontrollerClass){
        try{
            return icontrollerClass.getConstructor().newInstance();
        }catch (Exception e){
            throw new RuntimeException(
                    "Controller cannot create instance cause %s : %s"
                            .formatted(icontrollerClass.getName(),e.getMessage()));
        }
    }


    private String getUri(Icontroller icontroller){
        return icontroller.getClass()
                .getAnnotation(ControllerMapping.class).
                value();
    }
}
