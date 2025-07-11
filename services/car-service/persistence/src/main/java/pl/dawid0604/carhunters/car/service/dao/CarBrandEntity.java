package pl.dawid0604.carhunters.car.service.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import static jakarta.persistence.GenerationType.SEQUENCE;
import static lombok.AccessLevel.PACKAGE;

/**
 * Entity representing a car brand in the system.
 *
 * <p>
 *     This class maps to the {@code brands} table in the
 *     database and extends {@link EntityBase}, inheriting
 *     the public identifier and auditing fields.
 * </p>
 *
 * <p>
 *     Each instance of this entity corresponds to a single
 *     brand, which can be referenced by a {@link CarEntity}.
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
@SuperBuilder
@Getter @Setter
@Table(name = "brands")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = PACKAGE)
@AllArgsConstructor(access = PACKAGE)
public non-sealed class CarBrandEntity extends EntityBase {

    /**
     * The entity identifier. It uses sequence managed
     * by database provider.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "brand_sequence"

    ) @SequenceGenerator(
            name = "brand_sequence",
            sequenceName = "brand_sequence"
    )
    private Long brandId;

    /**
     * The brand name (e.g., Alfa Romeo).
     * <p>
     *     This field cannot be {@code null} and
     *     should be <b>unique</b>.
     * </p>
     */
    @Column(name = "name", nullable = false, unique = true)
    private String name;
}
