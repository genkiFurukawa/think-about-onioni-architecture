package osu.shi.sample.v1.service;

import org.springframework.stereotype.Service;
import osu.shi.sample.v1.entity.ApiResponseList;
import osu.shi.sample.v1.entity.ApiResponseObject;
import osu.shi.sample.v1.entity.Task;
import osu.shi.sample.v1.entity.TaskSaveRequest;
import osu.shi.sample.v1.repository.TaskRepositoryV1;

import java.util.HashMap;

@Service
public class TaskService {
    private final TaskRepositoryV1 taskRepositoryV1;

    public TaskService(
        TaskRepositoryV1 taskRepositoryV1
    ) {
        this.taskRepositoryV1 = taskRepositoryV1;
    }

    public ApiResponseList<Task> fetchTaskList() {
        return new ApiResponseList<>(taskRepositoryV1.fetchTaskList());
    }

    public ApiResponseObject saveTask(TaskSaveRequest taskSaveRequest) {
        // 仕様のチェック
        for (var task : taskRepositoryV1.fetchTaskList()) {
            if (taskSaveRequest.getId() == task.getId()) {
                throw new IllegalArgumentException();
            }
        }

        // 仕様のチェック
         if (taskSaveRequest.getName().equals("task")) {
             throw new IllegalArgumentException();
         }

         // 保存するメソッドを呼ぶ（省略）

        return new ApiResponseObject();
    }

    public ApiResponseObject deleteTask(int id) {
        if (taskRepositoryV1.fetchTaskList().size() < 1) {
            throw new IllegalArgumentException();
        }

        // 削除するメソッドを呼ぶ（省略）

        var apiResponse =  new ApiResponseObject();
        var response = new HashMap<String, Object>();
        response.put("success", false);
        apiResponse.setResponse(response);
        return apiResponse;
    }

}
