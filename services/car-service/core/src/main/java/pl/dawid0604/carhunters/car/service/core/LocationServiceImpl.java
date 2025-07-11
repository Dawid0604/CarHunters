package pl.dawid0604.carhunters.car.service.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.dawid0604.carhunters.car.service.dao.LocationEntity;
import pl.dawid0604.carhunters.car.service.dao.repository.LocationRepository;

/**
 * Service implementation for managing locations in the system.
 *
 * <p>
 *     This class provides the business logic for creating,
 *     retrieving, updating and deleting entities. It extends
 *     {@link EntityBaseServiceImpl} with {@link LocationEntity}
 *     as the entity type, inheriting common operations and
 *     additional base service functionality.
 * </p>
 *
 * <p>
 *     The class implements the sealed {@link LocationService} interface,
 *     ensuring that all locations-related service logic is centralized
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
@SuppressWarnings({ "PMD.CommentSize", "PMD.LongVariable" })
non-sealed class LocationServiceImpl extends EntityBaseServiceImpl<LocationEntity>
                                     implements LocationService {

    @SuppressWarnings("PMD.CommentDefaultAccessModifier")
    LocationServiceImpl(final LocationRepository locationRepository) {
        super(locationRepository);
    }
}
