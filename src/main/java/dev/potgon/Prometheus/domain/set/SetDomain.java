package dev.potgon.Prometheus.domain.set;

import dev.potgon.Prometheus.domain.exercise.ExerciseDomain;
import dev.potgon.Prometheus.domain.workout.WorkoutDomain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SetDomain {

    private Long id;
    private ExerciseDomain exercise;
    private WorkoutDomain workout;
    private Integer setReps;
    private Double setWeight;
    private Integer setOrder;
}
