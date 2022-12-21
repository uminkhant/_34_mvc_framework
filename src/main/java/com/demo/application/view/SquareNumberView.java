package com.demo.application.view;

import com.demo.framework.model.Model;
import com.demo.framework.view.View;

public class SquareNumberView implements View {
    @Override
    public String render(Model model) {
        return "The result of %s square is :: %s"
                .formatted(
                        model.get("num"),
                        model.get("result"));
    }
}
