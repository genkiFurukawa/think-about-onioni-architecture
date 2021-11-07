package osu.shi.sample.v1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class ApiResponseList<T> {
    private final List<T> response;
}
