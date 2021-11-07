package osu.shi.sample.v1.infrastructure;

import org.springframework.stereotype.Component;
import osu.shi.sample.v1.entity.Task;
import osu.shi.sample.v1.repository.TaskRepositoryV1;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskRepositoryV1Impl implements TaskRepositoryV1 {
    @Override
    public List<Task> fetchTaskList() {
        var taskList = new ArrayList<Task>();
        for (int i = 1; i < 10; i++) {
            taskList.add(new Task(i, String.valueOf(i)));
        }
        return taskList;
    }
}
