package dev.potgon.Prometheus.domain.common;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenericPersistencePort<T> {

    List<T> getAll();

    T getById(Long id);

    T createOrUpdate(T entity);

    void deleteById(Long id);

}
