package osu.shi.sample.v2.domain.entity;

import lombok.Data;

import java.util.List;

@Data
public class Task {
    private int id;
    private String name;

    public Task (int id, String name) {
        if (name.equals("task")) {
            throw new IllegalArgumentException();
        }

        this.id = id;
        this.name = name;
    }

    public static boolean canAdd(List<Task> taskList, int id) {
        if (taskList == null) {
            return false;
        }

        for (var task : taskList) {
            if (task.getId() == id) {
                return false;
            }
        }

        return true;
    }

    public static boolean canRemove(List<Task> taskList) {
        if (taskList == null) {
            return false;
        }

        return taskList.size() > 1;
    }
}
