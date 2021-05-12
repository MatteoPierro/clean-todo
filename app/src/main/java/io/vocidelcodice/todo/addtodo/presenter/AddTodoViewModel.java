package io.vocidelcodice.todo.addtodo.presenter;

public class AddTodoViewModel {
    public String id;
    public String priority;
    public AddTodoViewModel.Color color;

    public enum Color {
        Green, Red
    }
}
