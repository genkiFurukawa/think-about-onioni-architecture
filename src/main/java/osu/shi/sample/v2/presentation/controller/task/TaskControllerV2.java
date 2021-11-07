package osu.shi.sample.v2.presentation.controller.task;

import org.springframework.web.bind.annotation.*;
import osu.shi.sample.v2.domain.entity.Task;
import osu.shi.sample.v2.presentation.controller.common.ApiResponseList;
import osu.shi.sample.v2.presentation.controller.common.ApiResponseObject;
import osu.shi.sample.v2.use_case.task.TaskDeleteUseCase;
import osu.shi.sample.v2.use_case.task.TaskFetchUseCase;
import osu.shi.sample.v2.use_case.task.TaskSaveUseCase;

import java.util.HashMap;

@RestController
public class TaskControllerV2 {
    private final TaskFetchUseCase taskFetchUseCase;
    private final TaskSaveUseCase taskSaveUseCase;
    private final TaskDeleteUseCase taskDeleteUseCase;

    public TaskControllerV2(
            TaskFetchUseCase taskFetchUseCase,
            TaskSaveUseCase taskSaveUseCase,
            TaskDeleteUseCase taskDeleteUseCase
    ) {
        this.taskFetchUseCase = taskFetchUseCase;
        this.taskSaveUseCase = taskSaveUseCase;
        this.taskDeleteUseCase = taskDeleteUseCase;
    }

    @GetMapping(value = "/v2/task")
    public ApiResponseList<Task> fetchTaskList() {
        var taskFetchDto = taskFetchUseCase.fetchTaskList();
        return new ApiResponseList<>(taskFetchDto.getTaskList());
    }

    @PostMapping(value = "/v2/task")
    public ApiResponseObject saveTask(@RequestBody TaskSaveRequest taskSaveRequest) {
        taskSaveUseCase.saveTask(taskSaveRequest.toParam());

        var response = new HashMap<String, Object>();

        var apiResponse = new ApiResponseObject(response);
        return apiResponse ;
    }

    @DeleteMapping(value = "/v2/task/{id}")
    public ApiResponseObject deleteTask(@PathVariable int id) {
        var doneDelete = taskDeleteUseCase.deleteTask(id);

        var response = new HashMap<String, Object>();
        response.put("success", doneDelete);

        var apiResponse = new ApiResponseObject(response);
        return apiResponse ;
    }
}
