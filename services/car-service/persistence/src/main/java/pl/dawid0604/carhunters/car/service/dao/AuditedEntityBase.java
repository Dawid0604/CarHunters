package pl.dawid0604.carhunters.car.service.dao;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

/**
 * Base class for all auditable entities.
 *
 * <p>
 *     The {@link #lastModificationDate} field is date
 *     of the last entity modification.
 * </p>
 *
 * <p>
 *     The {@link #createdDate} field is the entity creation date.
 *     This field is unmodifiable.
 * </p>
 *
 * <p>
 *     The class is annotated with {@link EntityListeners} and uses
 *     {@link  AuditingEntityListener} to automatically populate
 *     auditing fields.
 * </p>
 *
 * <p>
 *     This class is designed as a sealed class, restricting subclassing to
 *     {@link EntityBase} and its descendants, enforcing a clear and
 *     controlled hierarchy.
 * </p>
 *
 * @see EntityBase
 * @see EntityListeners
 * @see MappedSuperclass
 * @see AuditingEntityListener
 */
@SuperBuilder
@MappedSuperclass
@EqualsAndHashCode
@Getter @Setter(PRIVATE)
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public abstract sealed class AuditedEntityBase permits EntityBase {

    /**
     * The date of last entity modification. Is modifiable.
     */
    @LastModifiedDate
    @SuppressWarnings("PMD.LongVariable")
    @Column(name = "last_modification_date")
    private LocalDateTime lastModificationDate;

    /**
     * The date of entity creation. Is unmodifiable.
     */
    @CreatedDate
    @Column(name = "created_date", updatable = false)
    private LocalDateTime createdDate;
}
