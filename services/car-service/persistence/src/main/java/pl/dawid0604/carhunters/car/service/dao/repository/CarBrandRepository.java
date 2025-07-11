package pl.dawid0604.carhunters.car.service.dao.repository;

import org.springframework.stereotype.Repository;
import pl.dawid0604.carhunters.car.service.dao.CarBrandEntity;

@Repository
public non-sealed interface CarBrandRepository
                  extends EntityBaseRepository<CarBrandEntity, Long> { }
