package pl.dawid0604.carhunters.car.service.core;

/**
 * Service interface for managing cars in the system.
 *
 * <p>
 *     This sealed interface defines the contract for all
 *     advertisement-related operations. It is intended to be
 *     implemented by classes that provide the actual for creating,
 *     retrieving, updating and deleting entities.
 * </p>
 *
 * <p>
 *     The interface is sealed, restricting its implementation to
 *     {@link CarServiceImpl}. This enforces a clear and controlled
 *     service hierarchy, ensuring that all cars logic is centralized
 *     and consistent.
 * </p>
 *
 * @see CarServiceImpl
 */
@SuppressWarnings("PMD.CommentSize")
public sealed interface CarService permits CarServiceImpl {

}
