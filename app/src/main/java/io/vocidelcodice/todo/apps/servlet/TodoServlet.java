package io.vocidelcodice.todo.apps.servlet;

import io.vocidelcodice.todo.addtodo.controller.AddTodoController;
import io.vocidelcodice.todo.addtodo.persistence.InMemoryAddTodoDataAccessInterface;
import io.vocidelcodice.todo.addtodo.presenter.AddTodoPresenter;
import io.vocidelcodice.todo.addtodo.presenter.AddTodoView;
import io.vocidelcodice.todo.addtodo.usecase.AddTodoDataAccessInterface;
import io.vocidelcodice.todo.addtodo.usecase.AddTodoInputBoundary;
import io.vocidelcodice.todo.addtodo.usecase.AddTodoOutputBoundary;
import io.vocidelcodice.todo.addtodo.usecase.AddTodoUseCase;
import io.vocidelcodice.todo.apps.servlet.addtodo.view.HtmlAddTodoView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TodoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        AddTodoDataAccessInterface dataAccessInterface = new InMemoryAddTodoDataAccessInterface();

        AddTodoView addTodoView = new HtmlAddTodoView(resp);
        AddTodoOutputBoundary addTodoPresenter = new AddTodoPresenter(addTodoView);

        AddTodoInputBoundary addTodoUseCase = new AddTodoUseCase(dataAccessInterface, addTodoPresenter);

        AddTodoController controller = new AddTodoController(addTodoUseCase);
        controller.addTodo(parseMessage(req));
    }

    private String parseMessage(HttpServletRequest req) throws IOException {
        return req.getReader().readLine();
    }
}
