package io.vocidelcodice.todo;

import io.vocidelcodice.todo.addtodo.TestingAPI;
import io.vocidelcodice.todo.addtodo.entities.Todo;
import io.vocidelcodice.todo.addtodo.usecase.*;

import static io.vocidelcodice.todo.addtodo.usecase.AddTodoOutputData.Priority.HIGH;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpyTestingAPI implements TestingAPI {

    private final AddTodoDataAccessInterface dataAccess;
    private final SpyAddTodoOutputBoundary outputBoundary;
    private final AddTodoUseCase useCase;

    public SpyTestingAPI() {
        dataAccess = new DummyAddTodoDataAccessInterface();
        outputBoundary = new SpyAddTodoOutputBoundary();
        useCase = new AddTodoUseCase(dataAccess, outputBoundary);
    }

    @Override
    public void addTodo(String aMessage) {
        AddTodoInputData input = new AddTodoInputData(aMessage);
        useCase.execute(input);
    }

    @Override
    public void outputShouldBe(String aMessage) {
        AddTodoOutputData outputData = outputBoundary.output;
        assertEquals(123, outputData.id);
        assertEquals(HIGH, outputData.priority);
        assertEquals(aMessage, outputData.message);
    }

    private class SpyAddTodoOutputBoundary implements AddTodoOutputBoundary {
        public AddTodoOutputData output;

        @Override
        public void addTodoSucceeded(AddTodoOutputData addTodoOutputData) {
            this.output = addTodoOutputData;
        }

        @Override
        public void addTodoFailed(AddTodoViolations violation) {
        }
    }

    private class DummyAddTodoDataAccessInterface implements AddTodoDataAccessInterface {
        @Override
        public void add(Todo todo) {

        }
    }
}
