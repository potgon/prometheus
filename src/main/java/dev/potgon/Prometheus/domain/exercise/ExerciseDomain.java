package dev.potgon.Prometheus.domain.exercise;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseDomain {

    private Long id;
    private String exerciseName;
    private String exerciseMuscleGroup;
    private String exerciseSpecificMuscleGroup;
    private String exerciseDescription;
}
