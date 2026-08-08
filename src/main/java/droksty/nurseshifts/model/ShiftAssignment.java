package droksty.nurseshifts.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = { "date", "shift_type", "nurse_id" }),
        indexes = {
            @Index(name = "idx_shift_type", columnList = "shift_type")
})
@Entity
public class ShiftAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false)
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    @Column(name = "shift_type", nullable = false)
    private ShiftType shiftType;

    @ManyToOne
    @JoinColumn(name = "nurse_id")
    private Nurse nurse;
}
