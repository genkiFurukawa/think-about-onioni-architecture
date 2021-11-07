package osu.shi.sample.v2.presentation.controller.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class ApiResponseList<T> {
    private final List<T> response;
}
