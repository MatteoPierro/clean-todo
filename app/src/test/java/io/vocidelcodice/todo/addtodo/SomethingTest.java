package io.vocidelcodice.todo.addtodo;

import io.vocidelcodice.todo.SpyTestingAPI;
import org.junit.jupiter.api.Test;

public class SomethingTest {

    public static final String A_MESSAGE = "Something TODO";

    @Test
    void xyz() {
        TestingAPI todoApp = new SpyTestingAPI();
        todoApp.addTodo(A_MESSAGE);
        todoApp.outputShouldBe(A_MESSAGE);  //        anOutputWithId(123).withPriority(HIGH).withMessage(A_MESSAGE)
    }


}
