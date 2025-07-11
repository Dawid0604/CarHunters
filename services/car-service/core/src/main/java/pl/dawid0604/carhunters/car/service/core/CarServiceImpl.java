package pl.dawid0604.carhunters.car.service.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.dawid0604.carhunters.car.service.dao.CarEntity;
import pl.dawid0604.carhunters.car.service.dao.repository.CarRepository;

/**
 * Service implementation for managing cars in the system.
 *
 * <p>
 *     This class provides the business logic for creating, retrieving,
 *     updating and deleting entities. It extends {@link EntityBaseServiceImpl}
 *     with {@link CarEntity} as the entity type, inheriting common operations
 *     and additional base service functionality.
 * </p>
 *
 * <p>
 *     The class implements the sealed {@link CarService} interface,
 *     ensuring that all cars-related service logic is centralized
 *     and consistent.
 * </p>
 *
 * <p>
 *     Annotated with {@link Service}, this class is automatically
 *     detected and managed by the Spring container as service bean.
 *     The {@link Slf4j} annotation enables logging capabilities.
 * </p>
 */
@Slf4j
@Service
@SuppressWarnings("PMD.CommentSize")
non-sealed class CarServiceImpl extends EntityBaseServiceImpl<CarEntity>
                                implements CarService {

    @SuppressWarnings({ "PMD.CommentDefaultAccessModifier", "PMD.LongVariable "})
    CarServiceImpl(final CarRepository carRepository) {
        super(carRepository);
    }
}
