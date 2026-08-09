package droksty.nurseshifts.dto;

import droksty.nurseshifts.model.ShiftType;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ShiftAssignmentResponseDto {
    private Long id;
    private LocalDate date;
    private ShiftType shiftType;
    private NurseResponseDto nurse;
}