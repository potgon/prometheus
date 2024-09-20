package dev.potgon.Prometheus.infrastructure.persistence.set;

import dev.potgon.Prometheus.infrastructure.persistence.exercise.ExerciseEntity;
import dev.potgon.Prometheus.infrastructure.persistence.workout.WorkoutEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "exercise_set")
public class SetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "exercise_id", nullable = false)
    private ExerciseEntity exercise;
    @ManyToOne
    @JoinColumn(name = "workout_id", nullable = false)
    private WorkoutEntity workout;
    @Column(name = "set_reps")
    private Integer setReps;
    @Column(name = "set_weight")
    private Double setWeight;
    @Column(name = "set_order")
    private Integer setOrder;
}
