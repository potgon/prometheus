package dev.potgon.Prometheus.infrastructure.persistence.set.mappers;

import dev.potgon.Prometheus.application.set.request.CreateSetRequest;
import dev.potgon.Prometheus.domain.set.SetDomain;
import dev.potgon.Prometheus.domain.workout.WorkoutDomain;
import dev.potgon.Prometheus.infrastructure.persistence.set.SetEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface SetMapper {

    SetDomain entityToDomain(SetEntity setEntity);
    SetEntity domainToEntity(SetDomain setDomain);

    @Mappings({
            @Mapping(target = "exercise.id", source = "request.exerciseId"),
            @Mapping(target = "workout", source = "workout")
    })
    SetDomain requestToDomain(CreateSetRequest request, WorkoutDomain workout);
}
