package pl.dawid0604.carhunters.car.service.dao;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import io.hypersistence.utils.hibernate.type.search.PostgreSQLTSVectorType;
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
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Type;

import java.math.BigDecimal;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.SEQUENCE;
import static lombok.AccessLevel.NONE;
import static lombok.AccessLevel.PACKAGE;

/**
 * Entity representing an advertisement in the system.
 * <p>
 *     This class maps to the {@code advertisements} table in the database
 *     and extends {@link EntityBase}, inheriting the public identifier and
 *     auditing fields.
 * </p>
 *
 * <p>
 *     Each instance of this entity corresponds to a single advertisement,
 *     which can be created, displayed or managed.
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
 * @see Entity
 * @see Table
 * @see EntityBase
 * @see AuditedEntityBase
 */
@Entity
@SuperBuilder
@Getter @Setter
@Table(name = "advertisements")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = PACKAGE)
@AllArgsConstructor(access = PACKAGE)
@SuppressFBWarnings("EI_EXPOSE_REP2")
@SuppressWarnings("PMD.TooManyFields")
public non-sealed class AdvertisementEntity extends EntityBase {

    /**
     * The entity identifier. It uses sequence managed
     * by database provider.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "advertisement_sequence"

    ) @SequenceGenerator(
            name = "advertisement_sequence",
            sequenceName = "advertisement_sequence"
    )
    private Long advertisementId;

    /**
     * The locality of advertisement. For the frontend
     * only a {@code fullName} field have to be exposed.
     */
    @ManyToOne
    @JoinColumn(name = "location_id")
    @SuppressFBWarnings("EI_EXPOSE_REP")
    private LocationEntity location;

    /**
     * Advertisement car, which contain
     * the brand name and model.
     */
    @ManyToOne
    @Setter(NONE)
    @JoinColumn(name = "car_id")
    @SuppressFBWarnings("EI_EXPOSE_REP")
    private CarEntity car;

    /**
     * The advertisement price. The value
     * is represented by dwo decimal places.
     */
    @Column(name = "price")
    private BigDecimal price;

    /**
     * The car mileage measured by km
     * (e.g., 50000). This field cannot be
     * {@code null} and <b>negative</b>.
     */
    @Column(name = "mileage")
    private int mileage;

    /**
     * The engine capacity measured by
     * dcm/3 (e.g., 1999). This field cannot be
     * {@code null} and <b>negative</b>.
     */
    @Column(name = "engine_capacity")
    private int engineCapacity;

    /**
     * The engine power measured by
     * HP (e.g., 120). This field cannot be
     * {@code null} and <b>negative</b>.
     */
    @Column(name = "engine_power")
    private int enginePower;

    /**
     * Information about the car is england type.
     * The default value is {@code false}
     */
    @Column(name = "england_type")
    private boolean englandType;

    /**
     * The advertisement title. This field is used
     * by {@link #searchVector} to provide advanced
     * text searching by PostgresSQL. This field
     * cannot be {@code null}.
     */
    @Column(name = "title", nullable = false)
    private String title;

    /**
     * The advertisement description. This field is used
     * by {@link #searchVector} to provides advanced
     * text searching by PostgresSQL. This field cannot
     * be {@code null}.
     */
    @Column(name = "description", nullable = false)
    private String description;

    /**
     * The production year (e.g., 2001). The field
     * cannot be {@code null} and <b>negative</b>.
     */
    @Column(name = "production_year")
    private int productionYear;

    /**
     * The advertisement owner identifier. This value
     * comes from the <b>user-service</b>. The field
     * cannot be {@code null}, <b>negative</b> and <b>not updatable</b>.
     * It is required and set only during entity creation.
     */
    @Setter(NONE)
    @Column(name = "owner_id", updatable = false, nullable = false)
    private long ownerId;

    /**
     * The special PostgresSQL column to providing
     * advanced text searching. This field is used by
     * {@link #title} and {@link #description} field.
     */
    @Type(PostgreSQLTSVectorType.class)
    @Column(name = "search_vector", insertable = false,
                                    updatable = false)
    private String searchVector;

    /**
     * The unique car VIN number.
     */
    @Column(name = "vin")
    private String vin;

    /**
     * The type of petrol (e.g., {@link PetrolType#DIESEL}).
     */
    @Enumerated(STRING)
    @Column(name = "petrol_type")
    private PetrolType petrolType;

    /**
     * The car condition (e.g., {@link VehicleCondition#NOT_DAMAGED}).
     */
    @Enumerated(STRING)
    @Column(name = "condition")
    private VehicleCondition condition;

    /**
     * The type of gearbox (e.g., {@link GearboxType#MANUAL}).
     */
    @Enumerated(STRING)
    @Column(name = "gearbox_type")
    private GearboxType gearboxType;

    /**
     * The type of body (e.g, {@link VehicleBodyType#COUPE}).
     */
    @Enumerated(STRING)
    @Column(name = "body_type")
    private VehicleBodyType bodyType;
}
