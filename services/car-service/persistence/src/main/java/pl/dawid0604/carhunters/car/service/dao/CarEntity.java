package pl.dawid0604.carhunters.car.service.dao;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import static jakarta.persistence.GenerationType.SEQUENCE;
import static lombok.AccessLevel.NONE;
import static lombok.AccessLevel.PACKAGE;

/**
 * Entity representing a car in the system.
 *
 * <p>
 *     This class maps to the {@code cars} table in the
 *     database and extends {@link EntityBase}, inheriting
 *     the public identifier and auditing fields.
 * </p>
 *
 * <p>
 *     Each instance of this entity corresponds to a single car,
 *     which can be referenced by an {@link AdvertisementEntity}.
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
 * @see Table
 * @see Entity
 * @see EntityBase
 * @see AuditedEntityBase
 */
@Entity
@Getter
@SuperBuilder
@Table(name = "cars")
@SuppressFBWarnings("EI_EXPOSE_REP2")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = PACKAGE)
@AllArgsConstructor(access = PACKAGE)
public non-sealed class CarEntity extends EntityBase {

    /**
     * The entity identifier. It uses sequence managed
     * by database provider.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "car_sequence"

    ) @SequenceGenerator(
            name = "car_sequence",
            sequenceName = "car_sequence"
    )
    private Long carId;

    /**
     * Representing car brand name (e.g., Alfa Romeo).
     * <p>
     *     This field is unmodifiable and references
     *     the {@link CarBrandEntity}.
     * </p>
     */
    @ManyToOne
    @Setter(NONE)
    @SuppressFBWarnings("EI_EXPOSE_REP")
    @JoinColumn(name = "brand_id", updatable = false)
    private CarBrandEntity brand;

    /**
     * The car name (e.g., Brera).
     * <p>
     *     This field cannot be {@code null}
     *     and should be <b>unique</b>.
     * </p>
     */
    @Column(name = "name", nullable = false, unique = true)
    private String name;
}
