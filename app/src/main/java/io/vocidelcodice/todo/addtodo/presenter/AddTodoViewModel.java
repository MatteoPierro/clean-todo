package io.vocidelcodice.todo.addtodo.presenter;

public class AddTodoViewModel {
    public final AddTodoViewModel.Color color;
    public final String message;
    public final String errorMessage;

    public static AddTodoViewModel success(String message, Color color) {
        return new AddTodoViewModel(message, "", color);
    }

    public static AddTodoViewModel failure(String errorMessage, Color color) {
        return new AddTodoViewModel("", errorMessage, color);
    }

    private AddTodoViewModel(String message, String errorMessage, Color color) {
        this.color = color;
        this.message = message;
        this.errorMessage = errorMessage;
    }

    public enum Color {
        Green, Red, Yellow
    }
}
