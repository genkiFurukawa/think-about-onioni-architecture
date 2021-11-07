package osu.shi.sample.v2.infrastructure;

import org.springframework.stereotype.Component;

import osu.shi.sample.v2.domain.entity.Task;
import osu.shi.sample.v2.domain.repository.TaskRepositoryV2;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskRepositoryV2Impl implements TaskRepositoryV2 {
    @Override
    public List<Task> fetchTaskList() {
        var taskList = new ArrayList<Task>();
        for (int i = 1; i < 10; i++) {
            taskList.add(new Task(i, String.valueOf(i)));
        }
        return taskList;
    }

    @Override
    public void save(Task task) {
        // 省略
    }

    @Override
    public void delete(int id) {
        // 省略
    }
}
