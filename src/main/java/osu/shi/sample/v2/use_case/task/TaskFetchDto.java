package osu.shi.sample.v2.use_case.task;

import lombok.AllArgsConstructor;
import lombok.Getter;
import osu.shi.sample.v2.domain.entity.Task;

import java.util.List;

@AllArgsConstructor
@Getter
public class TaskFetchDto {
    private List<Task> taskList;
}
