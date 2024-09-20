package dev.potgon.Prometheus.application.set.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateSetRequest {
    @NotNull
    private Long exerciseId;
    @NotNull
    private Integer setReps;
    @NotNull
    private Double setWeight;
    @NotNull
    private Integer setOrder;
}