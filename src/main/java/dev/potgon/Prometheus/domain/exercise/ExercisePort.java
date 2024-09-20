package dev.potgon.Prometheus.domain.exercise;

import java.util.List;

public interface ExercisePort {
    List<ExerciseDomain> getAll();
    ExerciseDomain getById(Long id);
}
