package dev.potgon.Prometheus.infrastructure.persistence.set;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SetRepository extends JpaRepository<SetEntity, Long> {
}
