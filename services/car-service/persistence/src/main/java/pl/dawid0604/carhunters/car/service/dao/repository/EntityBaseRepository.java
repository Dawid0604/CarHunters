package pl.dawid0604.carhunters.car.service.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import pl.dawid0604.carhunters.car.service.dao.EntityBase;

@NoRepositoryBean
public sealed interface EntityBaseRepository<E extends EntityBase, I>
              extends JpaRepository<E, I>
              permits AdvertisementRepository,
                      CarBrandRepository,
                      CarRepository,
                      LocationRepository { }
