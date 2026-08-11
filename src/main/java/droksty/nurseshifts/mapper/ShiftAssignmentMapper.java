package droksty.nurseshifts.mapper;

import droksty.nurseshifts.dto.ShiftAssignmentRequestDto;
import droksty.nurseshifts.dto.ShiftAssignmentResponseDto;
import droksty.nurseshifts.model.ShiftAssignment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ShiftAssignmentMapper {

    private final NurseMapper nurseMapper;

    public ShiftAssignmentResponseDto toResponseDto(ShiftAssignment entity) {
        if (entity == null) return null;
        return new ShiftAssignmentResponseDto(
                entity.getId(),
                entity.getDate(),
                entity.getShiftType(),
                nurseMapper.toResponseDto(entity.getNurse())
        );
    }

    public ShiftAssignment toEntity(ShiftAssignmentRequestDto dto) {
        if (dto == null) return null;
        return ShiftAssignment.builder()
                .date(dto.getDate())
                .shiftType(dto.getShiftType())
                .build();
    }
}
