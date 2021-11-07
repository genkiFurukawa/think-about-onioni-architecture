package osu.shi.sample.v2.use_case.task;

import org.springframework.stereotype.Service;
import osu.shi.sample.v2.domain.entity.Task;
import osu.shi.sample.v2.domain.repository.TaskRepositoryV2;

@Service
public class TaskDeleteUseCase {
    private final TaskRepositoryV2 taskRepositoryV2;

    public TaskDeleteUseCase(
            TaskRepositoryV2 taskRepositoryV2
    ) {
        this.taskRepositoryV2 = taskRepositoryV2;
    }

    public boolean deleteTask(int id) {
        if (!Task.canRemove(taskRepositoryV2.fetchTaskList())) {
            throw new IllegalArgumentException();
        }

        taskRepositoryV2.delete(id);
        return false;
    }
}
