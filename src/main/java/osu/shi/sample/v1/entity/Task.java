package osu.shi.sample.v1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Task {
    private int id;
    private String name;
}
