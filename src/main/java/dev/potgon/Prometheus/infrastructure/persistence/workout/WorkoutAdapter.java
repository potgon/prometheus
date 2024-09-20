package dev.potgon.Prometheus.infrastructure.persistence.workout;

import dev.potgon.Prometheus.domain.workout.WorkoutDomain;
import dev.potgon.Prometheus.domain.workout.WorkoutPort;
import dev.potgon.Prometheus.infrastructure.persistence.workout.mappers.WorkoutMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class WorkoutAdapter implements WorkoutPort {

    private static final Logger logger = LoggerFactory.getLogger(WorkoutAdapter.class);
    private final WorkoutRepository repository;
    private final WorkoutMapper mapper;


    @Override
    public List<WorkoutDomain> getAll() {
        logger.info("Fetching all workouts");
        return repository.findAll()
                .stream()
                .map(mapper::entityToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public WorkoutDomain getById(Long id) {
        logger.info("Fetching workout with id {}", id);
        return repository.findById(id)
                .map(mapper::entityToDomain)
                .orElse(null);
    }

    @Override
    @Transactional
    public WorkoutDomain createOrUpdate(WorkoutDomain entity) {
        logger.info("Creating or updating workout with id {}", entity.getId());
        return repository.save(mapper.domainToEntity(entity)).getId() == null ? null : entity;
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        logger.info("Deleting workout with id {}", id);
        repository.deleteById(id);
    }
}
