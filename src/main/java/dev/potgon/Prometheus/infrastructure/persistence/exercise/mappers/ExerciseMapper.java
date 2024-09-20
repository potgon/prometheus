package dev.potgon.Prometheus.infrastructure.persistence.exercise.mappers;

import dev.potgon.Prometheus.domain.exercise.ExerciseDomain;
import dev.potgon.Prometheus.infrastructure.persistence.exercise.ExerciseEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExerciseMapper {

    ExerciseDomain entityToDomain(ExerciseEntity entity);
    ExerciseEntity domainToEntity(ExerciseDomain domain);
}
