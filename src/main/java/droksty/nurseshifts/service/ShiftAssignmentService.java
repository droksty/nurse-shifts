package droksty.nurseshifts.service;

import droksty.nurseshifts.dto.ShiftAssignmentRequestDto;
import droksty.nurseshifts.dto.ShiftAssignmentResponseDto;

import java.time.LocalDate;
import java.util.List;

public interface ShiftAssignmentService {

    ShiftAssignmentResponseDto create(ShiftAssignmentRequestDto requestDto);
    ShiftAssignmentResponseDto update(Long id, ShiftAssignmentRequestDto requestDto);
    void delete(Long id);
    ShiftAssignmentResponseDto getById(Long id);
    List<ShiftAssignmentResponseDto> getByDateRange(LocalDate from, LocalDate to);
}
