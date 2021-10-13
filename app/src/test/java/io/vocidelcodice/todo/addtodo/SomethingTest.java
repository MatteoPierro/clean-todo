package io.vocidelcodice.todo.addtodo;

import io.vocidelcodice.todo.addtodo.entities.Todo;
import io.vocidelcodice.todo.addtodo.usecase.*;
import org.junit.jupiter.api.Test;

import static io.vocidelcodice.todo.addtodo.usecase.AddTodoOutputData.Priority.HIGH;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomethingTest {

    public static final String A_MESSAGE = "Something TODO";

    @Test
    void xyz() {
        AddTodoDataAccessInterface dataAccess = new DummyAddTodoDataAccessInterface();
        SpyAddTodoOutputBoundary outputBoundary = new SpyAddTodoOutputBoundary();
        AddTodoUseCase useCase = new AddTodoUseCase(dataAccess, outputBoundary);

        AddTodoInputData input = new AddTodoInputData(A_MESSAGE);
        useCase.execute(input);

        AddTodoOutputData outputData = outputBoundary.output;
        assertEquals(123, outputData.id);
        assertEquals(HIGH, outputData.priority);
        assertEquals(A_MESSAGE, outputData.message);
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
