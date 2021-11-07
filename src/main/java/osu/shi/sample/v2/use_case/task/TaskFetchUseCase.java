package osu.shi.sample.v2.use_case.task;

import org.springframework.stereotype.Service;
import osu.shi.sample.v2.domain.repository.TaskRepositoryV2;

@Service
public class TaskFetchUseCase {
    private final TaskRepositoryV2 taskRepositoryV2;

    public TaskFetchUseCase(
            TaskRepositoryV2 taskRepositoryV2
    ) {
        this.taskRepositoryV2 = taskRepositoryV2;
    }

    public TaskFetchDto fetchTaskList() {
        var taskList = taskRepositoryV2.fetchTaskList();
        return new TaskFetchDto(taskList);
    }
}
