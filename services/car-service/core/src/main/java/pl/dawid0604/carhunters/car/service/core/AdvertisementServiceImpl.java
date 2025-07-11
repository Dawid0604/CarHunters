package pl.dawid0604.carhunters.car.service.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.dawid0604.carhunters.car.service.dao.AdvertisementEntity;
import pl.dawid0604.carhunters.car.service.dao.repository.AdvertisementRepository;

/**
 * Service implementation for managing advertisements in the system.
 *
 * <p>
 *     This class provides the business logic for creating, retrieving,
 *     updating and deleting entities. It extends {@link EntityBaseServiceImpl}
 *     with {@link AdvertisementEntity} as the entity type, inheriting common operations
 *     and additional base service functionality.
 * </p>
 *
 * <p>
 *     The class implements the sealed {@link AdvertisementService} interface,
 *     ensuring that all advertisement-related service logic is centralized
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
non-sealed class AdvertisementServiceImpl extends EntityBaseServiceImpl<AdvertisementEntity>
                                          implements AdvertisementService {

    @SuppressWarnings("PMD.CommentDefaultAccessModifier")
    AdvertisementServiceImpl(final AdvertisementRepository advertisementRepository) {
        super(advertisementRepository);
    }
}
