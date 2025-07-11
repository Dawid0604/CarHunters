package pl.dawid0604.carhunters.car.service.dao.repository;

import org.springframework.stereotype.Repository;
import pl.dawid0604.carhunters.car.service.dao.LocationEntity;

@Repository
public non-sealed interface LocationRepository
                  extends EntityBaseRepository<LocationEntity, Integer> { }
