package io.vocidelcodice.todo.addtodo.presenter;

public class AddTodoViewModel {
    public final String id;
    public final String priority;
    public final AddTodoViewModel.Color color;

    public AddTodoViewModel(String id, String priority, Color color) {
        this.id = id;
        this.priority = priority;
        this.color = color;
    }

    public enum Color {
        Green, Red
    }
}
