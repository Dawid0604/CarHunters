package pl.dawid0604.carhunters.car.service.core;

/**
 * Service interface for managing advertisements in the system.
 *
 * <p>
 *     This sealed interface defines the contract for all
 *     advertisement-related operations. It is intended to be
 *     implemented by classes that provide the actual for creating,
 *     retrieving, updating, and deleting entities.
 * </p>
 *
 * <p>
 *     The interface is sealed, restricting its implementation to
 *     {@link AdvertisementServiceImpl}. This enforces a clear and
 *     controlled service hierarchy, ensuring that all advertisement
 *     logic is centralized and consistent.
 * </p>
 *
 * @see AdvertisementServiceImpl
 */
@SuppressWarnings("PMD.CommentSize")
public sealed interface AdvertisementService permits AdvertisementServiceImpl {
}
