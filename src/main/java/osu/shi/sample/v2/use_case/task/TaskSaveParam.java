package osu.shi.sample.v2.use_case.task;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TaskSaveParam {
    private final int id;
    private final String name;
}
