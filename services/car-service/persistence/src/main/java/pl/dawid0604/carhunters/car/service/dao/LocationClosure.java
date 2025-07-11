package pl.dawid0604.carhunters.car.service.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PACKAGE;

/**
 * Entity representing a closure table entry for location hierarchy.
 *
 * <p>
 *     This class maps to the {@code location_closures} table in the database
 *     and is used to efficiently represent ancestor-descendant relationships
 *     between locations. It enables fast hierarchical queries, such as
 *     retrieving all descendants or ancestors of a given location, which is
 *     essential for efficient advertisement searching.
 * </p>
 *
 * <p>
 *     Each instance of this entity represents a single path in the location
 *     hierarchy, defined by an ancestor location, a descendant location, and
 *     the depth of relationship.
 * </p>
 *
 * <p>This entity uses a composite primary key defined by {@link LocationClosureId}</p>
 *
 * @see Table
 * @see Entity
 * @see LocationClosureId
 */
@Entity
@Getter
@Builder
@EqualsAndHashCode
@IdClass(LocationClosureId.class)
@Table(name = "location_closures")
@NoArgsConstructor(access = PACKAGE)
@AllArgsConstructor(access = PACKAGE)
public class LocationClosure {

    /**
     * The identifier of the ancestor location in the
     * hierarchy.
     * <p>
     *     This field is part of the composite primary key
     *     and cannot be updated.
     * </p>
     */
    @Id
    @Column(name = "ancestor_id", updatable = false)
    private long ancestorId;

    /**
     * The identifier of the descendant location in the
     * hierarchy.
     * <p>
     *     This field is part of the composite primary key
     *     and cannot be updated.
     * </p>
     */
    @Id
    @Column(name = "descendant_id", updatable = false)
    private long descendantId;

    /**
     * The number of steps between ancestor and descendant.
     * <p>
     * <b>Rules:</b>
     *  <ul>
     *      <li>
     *         For a direct parent-child relationship, the depth is 1 or more.
     *      </li>
     *
     *      <li>
     *         For a location itself (self-reference), the depth is 0.
     *      </li>
     *  </ul>
     * </p>
     *
     * <p>
     *     This field is unmodifiable.
     * </p>
     */
    @Column(name = "depth", updatable = false)
    private int depth;
}
