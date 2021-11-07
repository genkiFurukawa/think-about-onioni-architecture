package osu.shi.sample.v2.presentation.controller.task;

import lombok.Data;
import osu.shi.sample.v2.use_case.task.TaskSaveParam;

@Data
public class TaskSaveRequest {
    private int id;
    private String name;

    public TaskSaveParam toParam() {
        return new TaskSaveParam(this.id, this.name);
    }
}
