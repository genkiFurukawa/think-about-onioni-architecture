package osu.shi.sample.v1.repository;

import osu.shi.sample.v1.entity.Task;

import java.util.List;

public interface TaskRepositoryV1 {
    List<Task> fetchTaskList();
}
