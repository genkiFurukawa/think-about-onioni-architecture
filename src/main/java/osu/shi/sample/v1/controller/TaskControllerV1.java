package osu.shi.sample.v1.controller;

import org.springframework.web.bind.annotation.*;
import osu.shi.sample.v1.entity.ApiResponseList;
import osu.shi.sample.v1.entity.ApiResponseObject;
import osu.shi.sample.v1.entity.Task;
import osu.shi.sample.v1.entity.TaskSaveRequest;
import osu.shi.sample.v1.service.TaskService;

@RestController
public class TaskControllerV1 {
    private final TaskService taskService;

    public TaskControllerV1(
        TaskService taskService
    ) {
        this.taskService = taskService;
    }

    @GetMapping(value = "/v1/task")
    public ApiResponseList<Task> taskList() {
        return taskService.fetchTaskList();
    }

    @PostMapping(value = "/v1/task")
    public ApiResponseObject saveTask(@RequestBody TaskSaveRequest taskSaveRequest) {
        return taskService.saveTask(taskSaveRequest);
    }

    @DeleteMapping(value = "/v1/task/{id}")
    public ApiResponseObject deleteTask(@PathVariable int id) {
        return taskService.deleteTask(id);
    }
}
