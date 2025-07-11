package pl.dawid0604.carhunters.car.service.core;

/**
 * Service interface for managing locations in the system.
 *
 * <p>
 *     This sealed interface defines the contract for all
 *     locations-related operations. It is intended to be
 *     implemented by classes that provide the actual for
 *     creating, retrieving, updating and deleting entities.
 * </p>
 *
 * <p>
 *     The interface is sealed, restricting its implementation
 *     to {@link LocationServiceImpl}. This enforces a clear and
 *     controlled service hierarchy, ensuring that all advertisement
 *     logic is centralized and consistent.
 * </p>
 *
 * @see LocationServiceImpl
 */
@SuppressWarnings("PMD.CommentSize")
public sealed interface LocationService permits LocationServiceImpl {
}
