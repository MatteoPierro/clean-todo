package io.vocidelcodice.todo.addtodo.presenter;

import io.vocidelcodice.todo.addtodo.presenter.AddTodoViewModel.Color;
import io.vocidelcodice.todo.addtodo.usecase.AddTodoOutputBoundary;
import io.vocidelcodice.todo.addtodo.usecase.AddTodoOutputData;
import io.vocidelcodice.todo.addtodo.usecase.AddTodoViolations;

public class AddTodoPresenter implements AddTodoOutputBoundary {

    private final ViewModelPublisher viewModelPublisher;

    public AddTodoPresenter(ViewModelPublisher viewModelPublisher) {
        this.viewModelPublisher = viewModelPublisher;
    }

    @Override
    public void addTodoSucceeded(AddTodoOutputData addTodoOutputData) {
        AddTodoViewModel viewModel = AddTodoViewModel.success(
                successMessageFor(addTodoOutputData),
                colorForPriority(addTodoOutputData.priority)
        );
        viewModelPublisher.publish(viewModel);
    }

    @Override
    public void addTodoFailed(AddTodoViolations violation) {
        AddTodoViewModel viewModel = AddTodoViewModel.failure(violationToString(violation), Color.Red);
        viewModelPublisher.publish(viewModel);
    }

    private String successMessageFor(AddTodoOutputData addTodoOutputData) {
        return "TODO created with Id: " + idToString(addTodoOutputData.id)
                + " priority: " + priorityToString(addTodoOutputData.priority)
                + " message: " + addTodoOutputData.message;
    }

    private String violationToString(AddTodoViolations violation) {
        if (violation == AddTodoViolations.EMPTY_MESSAGE) {
            return "You must specify a message";
        }

        return "";
    }

    private Color colorForPriority(AddTodoOutputData.Priority priority) {
        if (priority == AddTodoOutputData.Priority.HIGH) return Color.Green;
        return Color.Yellow;
    }

    private String idToString(Integer id) {
        return String.valueOf(id);
    }

    private String priorityToString(AddTodoOutputData.Priority priority) {
        return priority.name();
    }
}
