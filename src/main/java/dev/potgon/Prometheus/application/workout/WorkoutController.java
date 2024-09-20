package dev.potgon.Prometheus.application.workout;

import dev.potgon.Prometheus.application.workout.request.CreateWorkoutRequest;
import dev.potgon.Prometheus.application.workout.response.CreateWorkoutResponse;
import dev.potgon.Prometheus.domain.workout.WorkoutDomain;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/workout")
@AllArgsConstructor
public class WorkoutController {

    private final WorkoutApplicationService service;

    @PostMapping("/new")
    public ResponseEntity<CreateWorkoutResponse> createWorkout(@Valid @RequestBody CreateWorkoutRequest createWorkoutRequest) {
        WorkoutDomain domain = service.createWorkout(createWorkoutRequest);
        return ResponseEntity.ok(service.createWorkoutResponse(domain));
    }
}
