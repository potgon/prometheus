package dev.potgon.Prometheus.infrastructure.persistence.workout;

import dev.potgon.Prometheus.infrastructure.persistence.exercise.ExerciseEntity;
import dev.potgon.Prometheus.infrastructure.persistence.exercise.enums.WorkoutDifficulty;
import dev.potgon.Prometheus.infrastructure.persistence.exercise.enums.WorkoutVisibility;
import dev.potgon.Prometheus.infrastructure.persistence.set.SetEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "workout")
public class WorkoutEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "workout_name", nullable = false, length = 50)
    private String workoutName;
    @Column(name = "workout_owner", nullable = false, length = 50)
    private String workoutOwner;
    @Column(name = "workout_description")
    private String workoutDescription;
    @Column(name = "workout_duration")
    private Integer workoutDuration;
    @Column(name = "workout_difficulty")
    @Enumerated(EnumType.STRING)
    private WorkoutDifficulty workoutDifficulty;
    @Column(name = "workout_sets")
    @OneToMany(mappedBy = "workout", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SetEntity> workoutSets;
    @Column(name = "workout_total_sets")
    private Integer workoutTotalSets;
    @Column(name = "workout_total_reps")
    private Integer workoutTotalReps;
    @Column(name = "workout_total_weight")
    private Double workoutTotalWeight;
    @Column(name = "workout_calories_burned")
    private Double workoutCaloriesBurned;
    @Column(name = "workout_tags")
    private String workoutTags;
    @Column(name = "workout_creation_date", nullable = false)
    private LocalDate workoutCreationDate;
    @Column(name = "workout_visibility", nullable = false)
    @Enumerated(EnumType.STRING)
    private WorkoutVisibility workoutVisibility;

}
