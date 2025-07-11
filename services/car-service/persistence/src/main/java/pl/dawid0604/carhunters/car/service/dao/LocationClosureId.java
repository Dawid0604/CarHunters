package pl.dawid0604.carhunters.car.service.dao;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

import static lombok.AccessLevel.PACKAGE;

/**
 * Composite primary key class for {@link LocationClosure}.
 *
 * <p>
 *     This class represents the composite key used in the
 *     closure tables for locations. It contains two fields:
 *     <ul>
 *         <li>
 *             {@link #ancestorId} - the identifier of the ancestor location
 *         </li>
 *
 *         <li>
 *             {@link #descendantId} - the identifier od the descendant location.
 *         </li>
 *     </ul>
 *
 *     Both fields together uniquely identify a single path in the location
 *     hierarchy.
 * </p>
 *
 * <p>
 *     This class must implement {@link Serializable} and override
 *     {@link #equals(Object)} and {@link #hashCode()} to be compatible
 *     with JPA requirements.
 * </p>
 *
 * @see jakarta.persistence.IdClass
 * @see LocationClosure
 */
@EqualsAndHashCode
@NoArgsConstructor(access = PACKAGE)
@AllArgsConstructor(access = PACKAGE)
public class LocationClosureId implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * The identifier of the ancestor location in the hierarchy.
     */
    @SuppressWarnings("unused")
    private long ancestorId;

    /**
     * The identifier of the descendant location in the hierarchy.
     */
    @SuppressWarnings("unused")
    private long descendantId;
}
