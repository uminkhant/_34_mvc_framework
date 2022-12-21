package com.demo.application.view;

import com.demo.framework.model.Model;
import com.demo.framework.view.View;

public class AddNumberView implements View {
    @Override
    public String render(Model model) {
        return "The result of %s and %s :: %s"
                .formatted(
                        model.get("num1"),
                        model.get("num2"),
                        model.get("result"));
    }
}
