package pl.dawid0604.carhunters.car.service.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.dawid0604.carhunters.car.service.dao.CarBrandEntity;
import pl.dawid0604.carhunters.car.service.dao.repository.CarBrandRepository;

/**
 * Service implementation for managing car brands in the system.
 *
 * <p>
 *     This class provides the business logic for creating, retrieving
 *     updating and deleting entities. It extends {@link EntityBaseServiceImpl}
 *     with {@link CarBrandEntity} as the entity type, inheriting common
 *     operations and additional base service functionality.
 * </p>
 *
 * <p>
 *     The class implements the sealed {@link CarBrandService} interface,
 *     ensuring that all advertisement-related service is centralized and
 *     consistent.
 * </p>
 *
 * <p>
 *     Annotated with {@link Service}, this class is automatically detected
 *     and managed by the Spring Container as service bean. The {@link Slf4j}
 *     annotation enables logging capabilities.
 * </p>
 */
@Slf4j
@Service
@SuppressWarnings({ "PMD.CommentSize", "PMD.LongVariable" })
non-sealed class CarBrandServiceImpl extends EntityBaseServiceImpl<CarBrandEntity>
                                     implements CarBrandService {

    @SuppressWarnings("PMD.CommentDefaultAccessModifier")
    CarBrandServiceImpl(final CarBrandRepository carBrandRepository) {
        super(carBrandRepository);
    }
}
