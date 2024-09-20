package dev.potgon.Prometheus.domain.workout;

import dev.potgon.Prometheus.domain.set.SetDomain;

public class WorkoutDomainService {

    public static Integer calculateTotalSets(WorkoutDomain domain) {
        return domain.getWorkoutSets().size();
    }

    public static Integer calculateTotalReps(WorkoutDomain domain) {
        return domain.getWorkoutSets().stream()
                .map(SetDomain::getSetReps)
                .reduce(0, Integer::sum);
    }

    public static Double calculateTotalWeight(WorkoutDomain domain) {
        return domain.getWorkoutSets().stream()
                .map(SetDomain::getSetWeight)
                .reduce(0.0, Double::sum);
    }
}
