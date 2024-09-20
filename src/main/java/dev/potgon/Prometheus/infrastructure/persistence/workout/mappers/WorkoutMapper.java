package dev.potgon.Prometheus.infrastructure.persistence.workout.mappers;

import dev.potgon.Prometheus.application.workout.request.CreateWorkoutRequest;
import dev.potgon.Prometheus.application.workout.response.CreateWorkoutResponse;
import dev.potgon.Prometheus.domain.workout.WorkoutDomain;
import dev.potgon.Prometheus.infrastructure.persistence.workout.WorkoutEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WorkoutMapper {

    WorkoutDomain requestToDomain(CreateWorkoutRequest request);
    WorkoutEntity domainToEntity(WorkoutDomain domain);
    CreateWorkoutResponse domainToResponse(WorkoutDomain domain);
    WorkoutDomain entityToDomain(WorkoutEntity entity);
}
