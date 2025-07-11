package pl.dawid0604.carhunters.car.service.dao.repository;

import org.springframework.stereotype.Repository;
import pl.dawid0604.carhunters.car.service.dao.AdvertisementEntity;

@Repository
public non-sealed interface AdvertisementRepository
                  extends EntityBaseRepository<AdvertisementEntity, Long> { }
