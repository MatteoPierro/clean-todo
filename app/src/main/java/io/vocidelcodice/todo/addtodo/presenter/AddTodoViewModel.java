package io.vocidelcodice.todo.addtodo.presenter;

public class AddTodoViewModel {
    public final String id;
    public final String priority;
    public final AddTodoViewModel.Color color;
    public final String message;
    public final String errorMessage;

    public static AddTodoViewModel success(String id, String priority, Color color, String message) {
        return new AddTodoViewModel(id, priority, color, message, "");
    }

    public static AddTodoViewModel failure(String errorMessage) {
        return new AddTodoViewModel("", "", null, "", errorMessage);
    }

    private AddTodoViewModel(String id, String priority, Color color, String message, String errorMessage) {
        this.id = id;
        this.priority = priority;
        this.color = color;
        this.message = message;
        this.errorMessage = errorMessage;
    }

    public enum Color {
        Green, Red
    }
}
