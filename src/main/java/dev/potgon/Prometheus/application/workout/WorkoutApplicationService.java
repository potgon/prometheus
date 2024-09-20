package dev.potgon.Prometheus.application.workout;


import dev.potgon.Prometheus.application.workout.request.CreateWorkoutRequest;
import dev.potgon.Prometheus.application.workout.response.CreateWorkoutResponse;
import dev.potgon.Prometheus.domain.exercise.ExerciseDomain;
import dev.potgon.Prometheus.domain.set.SetDomain;
import dev.potgon.Prometheus.domain.workout.WorkoutDomain;
import dev.potgon.Prometheus.domain.workout.WorkoutDomainService;
import dev.potgon.Prometheus.domain.workout.WorkoutPort;
import dev.potgon.Prometheus.infrastructure.persistence.set.mappers.SetMapper;
import dev.potgon.Prometheus.infrastructure.persistence.workout.mappers.WorkoutMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class WorkoutApplicationService {

    private final WorkoutPort workoutPort;
    private final WorkoutMapper mapper;
    private final SetMapper setMapper;

    public WorkoutDomain createWorkout(CreateWorkoutRequest request) {
        WorkoutDomain domain = mapper.requestToDomain(request);
        List<SetDomain> sets = request.getWorkoutSets().stream()
                .map(setRequest -> setMapper.requestToDomain(setRequest, domain))
                .toList();
        domain.setWorkoutSets(sets);
        domain.setWorkoutTotalSets(WorkoutDomainService.calculateTotalSets(domain));
        domain.setWorkoutTotalReps(WorkoutDomainService.calculateTotalReps(domain));
        domain.setWorkoutTotalWeight(WorkoutDomainService.calculateTotalWeight(domain));
        //TODO: compute caloriesBurned here
        domain.setWorkoutCreationDate(LocalDate.now());
        return workoutPort.createOrUpdate(domain);
    }

    public CreateWorkoutResponse createWorkoutResponse(WorkoutDomain domain) {
        return mapper.domainToResponse(domain);
    }
}
