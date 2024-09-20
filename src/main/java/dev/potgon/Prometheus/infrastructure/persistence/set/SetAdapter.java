package dev.potgon.Prometheus.infrastructure.persistence.set;

import dev.potgon.Prometheus.domain.set.SetDomain;
import dev.potgon.Prometheus.domain.set.SetPort;
import dev.potgon.Prometheus.infrastructure.persistence.set.mappers.SetMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class SetAdapter implements SetPort {

    private static final Logger logger = LoggerFactory.getLogger(SetAdapter.class);
    private final SetRepository repository;
    private final SetMapper mapper;

    @Override
    public List<SetDomain> getAll() {
        logger.info("Fetching all sets");
        return repository.findAll()
                .stream()
                .map(mapper::entityToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public SetDomain getById(Long id) {
        logger.info("Fetching set with id {}", id);
        return repository.findById(id)
                .map(mapper::entityToDomain)
                .orElse(null);
    }

    @Override
    public SetDomain createOrUpdate(SetDomain entity) {
        logger.info("Creating or updating set with id {}", entity.getId());
        return repository.save(mapper.domainToEntity(entity)).getId() == null ? null : entity;
    }

    @Override
    public void deleteById(Long id) {
        logger.info("Deleting set with id {}", id);
        repository.deleteById(id);
    }
}
