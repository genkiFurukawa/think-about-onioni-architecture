package osu.shi.sample.v2.presentation.controller.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;

@Getter
@AllArgsConstructor
public class ApiResponseObject {
    private final HashMap<String, Object> response;
}
