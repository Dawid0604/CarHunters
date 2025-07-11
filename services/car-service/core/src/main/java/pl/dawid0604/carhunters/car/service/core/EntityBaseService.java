package pl.dawid0604.carhunters.car.service.core;

import pl.dawid0604.carhunters.car.service.dao.EntityBase;

/**
 * Base service interface for domain entities
 * extending {@link EntityBase}.
 *
 * <p>
 *     The interface defines common service methods
 *     to ensure consistent implementation across
 *     all entity services.
 * </p>
 *
 * <p>
 *     The interface is sealed, restricting its
 *     implementation to {@link EntityBaseServiceImpl}.
 *     This enforces a controlled and predictable service
 *     hierarchy, ensuring consistency across all entity
 *     services.
 * </p>
 *
 * @param <E> the type of entity managed by this service,
 *            must extend {@link EntityBase}.
 *
 * @see EntityBase
 * @see EntityBaseServiceImpl
 */
@SuppressWarnings({ "PMD.CommentSize", "unused" })
sealed interface EntityBaseService<E extends EntityBase> permits EntityBaseServiceImpl {

}
