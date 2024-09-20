package dev.potgon.Prometheus.infrastructure.persistence.exercise;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "exercise")
public class ExerciseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "exercise_name", nullable = false)
    private String exerciseName;
    @Column(name = "exercise_muscle_group", nullable = false)
    private String exerciseMuscleGroup;
    @Column(name = "exercise_specific_muscle_group")
    private String exerciseSpecificMuscleGroup;
    @Column(name = "exercise_description")
    private String exerciseDescription;
    //TODO: expand with more descriptive attributes

}
