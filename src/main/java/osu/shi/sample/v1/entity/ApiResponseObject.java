package osu.shi.sample.v1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiResponseObject {
    private HashMap<String, Object> response;
}
