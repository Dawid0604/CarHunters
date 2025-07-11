package pl.dawid0604.carhunters.car.service.dao.repository;

import org.springframework.stereotype.Repository;
import pl.dawid0604.carhunters.car.service.dao.CarEntity;

@Repository
public non-sealed interface CarRepository
                  extends EntityBaseRepository<CarEntity, Long> {
}
