package dev.potgon.Prometheus.domain.workout;

import dev.potgon.Prometheus.domain.exercise.ExerciseDomain;
import dev.potgon.Prometheus.domain.set.SetDomain;
import dev.potgon.Prometheus.infrastructure.persistence.exercise.enums.WorkoutDifficulty;
import dev.potgon.Prometheus.infrastructure.persistence.exercise.enums.WorkoutVisibility;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class WorkoutDomain {
    private Long id;
    private String workoutName;
    private String workoutOwner;
    private String workoutDescription;
    private Integer workoutDuration;
    private WorkoutDifficulty workoutDifficulty;
    private List<SetDomain> workoutSets;
    private Integer workoutTotalSets;
    private Integer workoutTotalReps;
    private Double workoutTotalWeight;
    private Double workoutCaloriesBurned;
    private String workoutTags;
    private LocalDate workoutCreationDate;
    private WorkoutVisibility workoutVisibility;

}
