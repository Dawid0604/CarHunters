package pl.dawid0604.carhunters.car.service.dao;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.SEQUENCE;
import static lombok.AccessLevel.PACKAGE;

/**
 * Entity representing a locality in the system.
 *
 * <p>
 *     The class maps to the {@code locations} table in the database
 *     and extends {@link EntityBase}, inheriting the public identifier
 *     and auditing fields.
 * </p>
 *
 * <p>
 *     Each instance of this entity corresponds to a single locality,
 *     which can be used by the advertisement.
 * </p>
 *
 * <p>
 *     <b>Inheritance:</b>
 *     <ul>
 *         <li>
 *             Inherits the {@code publicId} field for secure external
 *             identification.
 *         </li>
 *
 *         <li>
 *             Inherits the {@code lastModificationDate} and {@code createdDate}
 *             field for auditing.
 *         </li>
 *     </ul>
 * </p>
 *
 */
@Entity
@Getter
@SuperBuilder
@Table(name = "locations")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = PACKAGE)
@AllArgsConstructor(access = PACKAGE)
@SuppressFBWarnings("EI_EXPOSE_REP2")
public non-sealed class LocationEntity extends EntityBase {

    /**
     * The entity identifier. It uses sequence managed
     * by database provider.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "location_sequence"

    ) @SequenceGenerator(
            name = "location_sequence",
            sequenceName = "location_sequence"
    )
    private Integer locationId;

    /**
     * Each instance may have an ancestor (parent location), forming a
     * hierarchical structure.
     * <p>
     *     <b>Example:</b>
     *     <ul>
     *         <li>
     *             <b>Location:</b> Mazowieckie, Warszawa.
     *         </li>
     *
     *         <li>
     *             The <b>Mazowieckie</b> ancestor is not present
     *             because it is itself own ancestor. In this case
     *             the parent variable value will be equal {@code null}.
     *         </li>
     *
     *         <li>
     *             The <b>Warszawa</b> has <b>Mazowieckie</b> as its ancestor.
     *         </li>
     *     </ul>
     * </p>
     *
     * <p>
     *     This field is <b>unmodifiable</b> - read only.
     * </p>
     */
    @ManyToOne
    @JoinColumn(name = "parent_id", updatable = false)
    @SuppressFBWarnings("EI_EXPOSE_REP")
    private LocationEntity parent;

    /**
     * The locality name (e.g., Warszawa).
     *
     * <p>
     *     This field cannot be {@code null} and
     *     is <b>unmodifiable</b> - read only.
     * </p>
     */
    @Column(name = "name", nullable = false, updatable = false)
    private String name;

    /**
     * The full locality name (path).
     * <p>
     *     For example, we have location <b>Warszawa</b>, the
     *     full name will be equal <b>Mazowieckie, Warszawa</b>.
     *     The path includes all ancestors and the locality itself.
     * </p>
     *
     * <p>
     *     This field cannot be {@code null} and
     *     is <b>unmodifiable</b> - read only.
     * </p>
     */
    @Column(name = "FullName", nullable = false, updatable = false)
    private String fullName;

    /**
     * The type of location (e.g., {@link LocationType#TOWN}).
     */
    @Enumerated(STRING)
    @Column(name = "Type")
    private LocationType type;
}
