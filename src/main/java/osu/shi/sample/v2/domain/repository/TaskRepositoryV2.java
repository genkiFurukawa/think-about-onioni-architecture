package osu.shi.sample.v2.domain.repository;

import osu.shi.sample.v2.domain.entity.Task;

import java.util.List;

public interface TaskRepositoryV2 {
    List<Task> fetchTaskList();
    void save(Task task);
    void delete(int id);
}
