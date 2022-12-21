package com.demo.application.view;

import com.demo.framework.model.Model;
import com.demo.framework.view.View;

public class IndexView implements View {
    @Override
    public String render(Model model) {
        return """
           <h1> THis is index view</h1><br>
           <ul>
            <li><a href='/add-number?num1=3&num2=3'>num1 + num2</a> </li>
            <li><a href='/square-number?&num=5'>num</a> </li>
           </ul>
         """;
    }
}
