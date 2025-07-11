package pl.dawid0604.carhunters.car.service.core;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.dawid0604.carhunters.car.service.dao.EntityBase;
import pl.dawid0604.carhunters.car.service.dao.repository.EntityBaseRepository;

import static lombok.AccessLevel.PACKAGE;

/**
 * Abstract base service implementation for entities
 * extending {@link EntityBase}.
 *
 * <p>
 *     This non-sealed abstract class provides common service
 *     logic and a repository reference for all entity services
 *     on domain objects that extend {@link EntityBase}. It is
 *     intended to be extended by concrete service implementations
 *     for specific entity types.
 * </p>
 *
 * <p>
 *     The class uses constructor injection (via {@link RequiredArgsConstructor})
 *     to ensure that the repository dependency is always provided. The
 *     repository field allows subclasses to perform CRUD operations and
 *     custom queries on their entities.
 * </p>
 *
 * <p>
 *     Only explicitly permitted subclasses (see {@code permits} clause)
 *     can extend this class, which ensured controlled and predictable
 *     inheritance in the service layer.
 * </p>
 *
 * @param <E> the type of entity managed by this service, must
 *            extend {@link EntityBase}.
 *
 * @see EntityBase
 * @see EntityBaseRepository
 */
@Slf4j
@SuppressWarnings("PMD.CommentSize")
@RequiredArgsConstructor(access = PACKAGE)
abstract sealed class EntityBaseServiceImpl<E extends EntityBase>
                implements EntityBaseService<E>
                permits AdvertisementServiceImpl,
                        CarBrandServiceImpl,
                        CarServiceImpl,
                        LocationServiceImpl {

    /**
     * The {@link EntityBase} repository.
     */
    private final EntityBaseRepository<E, ?> repository;
}
