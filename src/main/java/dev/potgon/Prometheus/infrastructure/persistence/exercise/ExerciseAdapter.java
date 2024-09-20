package dev.potgon.Prometheus.infrastructure.persistence.exercise;

import dev.potgon.Prometheus.domain.exercise.ExerciseDomain;
import dev.potgon.Prometheus.domain.exercise.ExercisePort;
import dev.potgon.Prometheus.infrastructure.persistence.exercise.mappers.ExerciseMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ExerciseAdapter implements ExercisePort {

    private static final Logger logger = LoggerFactory.getLogger(ExerciseAdapter.class);
    private final ExerciseRepository repository;
    private final ExerciseMapper mapper;

    @Override
    public List<ExerciseDomain> getAll() {
        logger.info("Fetching all exercises");
        return repository.findAll()
                .stream()
                .map(mapper::entityToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public ExerciseDomain getById(Long id) {
        logger.info("Fetching exercise with id {}", id);
        return repository.findById(id)
                .map(mapper::entityToDomain)
                .orElse(null);
    }

}
