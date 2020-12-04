package com.github.kvncont;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

public class ToDo {
    @NotNull
    public String id;

    @NotNull
    public String task;

    @NotNull
    public boolean isComplete;

    @NotNull
    public Date time;

    public ToDo(String task, boolean isComplete, Date time) {
        this.id = UUID.randomUUID().toString();
        this.task = task;
        this.isComplete = isComplete;
        this.time = time;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "id='" + id + '\'' +
                ", task='" + task + '\'' +
                ", isComplete=" + isComplete +
                ", time=" + time +
                '}';
    }
}