package io.vocidelcodice.todo.addtodo.presenter;

import java.util.Observable;

public class AddTodoViewModel extends Observable {
    public String id;
    public String priority;
    public AddTodoViewModel.Color color;

    public enum Color {
        Green, Red
    }

    public void notifyViews() {
        setChanged();
        notifyObservers();
    }
}
