package SingletonAndBuilder.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Builder
public class Child {
    private String name;
    private int age;
    private float averageGrade;
}
