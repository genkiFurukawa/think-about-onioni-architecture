package osu.shi.sample.v2.use_case.task;

import org.springframework.stereotype.Service;
import osu.shi.sample.v2.domain.entity.Task;
import osu.shi.sample.v2.domain.repository.TaskRepositoryV2;

@Service
public class TaskSaveUseCase {
    private final TaskRepositoryV2 taskRepositoryV2;

    public TaskSaveUseCase(
            TaskRepositoryV2 taskRepositoryV2
    ) {
        this.taskRepositoryV2 = taskRepositoryV2;
    }


    public void saveTask(TaskSaveParam taskSaveParam) {
        var canAdd = Task.canAdd(taskRepositoryV2.fetchTaskList(), taskSaveParam.getId());
        if (!canAdd) {
            throw new IllegalArgumentException();
        }

        var newTask = new Task(taskSaveParam.getId(), taskSaveParam.getName());
        taskRepositoryV2.save(newTask);
    }
}
