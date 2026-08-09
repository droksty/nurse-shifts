package droksty.nurseshifts.dto;

import droksty.nurseshifts.model.ShiftType;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ShiftAssignmentRequestDto {
    private LocalDate date;
    private ShiftType shiftType;
    private Long nurseId;
}
