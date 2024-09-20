package dev.potgon.Prometheus.application.workout.request;

import dev.potgon.Prometheus.application.set.request.CreateSetRequest;
import dev.potgon.Prometheus.domain.set.SetDomain;
import dev.potgon.Prometheus.infrastructure.persistence.exercise.enums.WorkoutDifficulty;
import dev.potgon.Prometheus.infrastructure.persistence.exercise.enums.WorkoutVisibility;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateWorkoutRequest {
    @NotNull
    private String workoutName;
    @NotNull
    private Long workoutOwner;
    @Size(max = 255)
    private String workoutDescription;
    @NotNull
    private Integer workoutDuration;
    @NotNull
    private WorkoutDifficulty workoutDifficulty;
    @NotEmpty
    private List<@Valid CreateSetRequest> workoutSets;
    private String workoutTags;
    @NotNull
    private WorkoutVisibility workoutVisibility;

}
