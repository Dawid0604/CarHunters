package pl.dawid0604.carhunters.car.service.dao;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import static lombok.AccessLevel.PROTECTED;

/**
 * Base class for all entities that exposes a public
 * identifier.
 *
 * <p>
 *     This class is designed as a sealed class, restricting
 *     subclassing to {@link AdvertisementEntity}, {@link CarBrandEntity},
 *     {@link CarEntity}, {@link LocationEntity} and its descendants, enforcing
 *     a clear and controlled hierarchy.
 * </p>
 *
 * <p>
 *     The {@link #publicId} field is intended for use in
 *     external systems such as Frontend, APIs and is never
 *     used as a primary key in the database.
 * </p>
 *
 * <p>
 *     The {@link #publicId} is encrypted using JNano for
 *     security reasons and must be decrypted to obtain the
 *     internal entity ID. This approach helps prevent enumeration
 *     and direct access to internal database keys.
 * </p>
 *
 * @see CarEntity
 * @see LocationEntity
 * @see CarBrandEntity
 * @see MappedSuperclass
 * @see AuditedEntityBase
 * @see AdvertisementEntity
 */
@SuperBuilder
@Getter @Setter
@MappedSuperclass
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
public abstract sealed class EntityBase extends AuditedEntityBase
                                        permits AdvertisementEntity, CarBrandEntity,
                                                CarEntity, LocationEntity {

    /**
     * Public Identifier which is exposed on the outside.
     */
    @Column(name = "public_id")
    private String publicId;
}
