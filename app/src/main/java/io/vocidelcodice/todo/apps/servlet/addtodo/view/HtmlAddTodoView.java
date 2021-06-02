package io.vocidelcodice.todo.apps.servlet.addtodo.view;

import io.vocidelcodice.todo.addtodo.presenter.AddTodoView;
import io.vocidelcodice.todo.addtodo.presenter.AddTodoViewModel;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HtmlAddTodoView implements AddTodoView {
    private final HttpServletResponse response;

    public HtmlAddTodoView(HttpServletResponse response) {
        this.response = response;
    }

    @Override
    public void render(AddTodoViewModel viewModel) {
        try {
            response.getWriter().println(messageFrom(viewModel));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String messageFrom(AddTodoViewModel viewModel) {
        if (viewModel.errorMessage.isBlank()) {
            return viewModel.message;
        } else {
            return viewModel.errorMessage;
        }
    }
}
