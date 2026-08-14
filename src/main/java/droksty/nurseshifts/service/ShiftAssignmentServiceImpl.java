package droksty.nurseshifts.service;

import droksty.nurseshifts.dto.ShiftAssignmentRequestDto;
import droksty.nurseshifts.dto.ShiftAssignmentResponseDto;
import droksty.nurseshifts.mapper.ShiftAssignmentMapper;
import droksty.nurseshifts.model.ShiftAssignment;
import droksty.nurseshifts.repository.ShiftAssignmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShiftAssignmentServiceImpl implements ShiftAssignmentService {

    private final ShiftAssignmentRepository repository;
    private final ShiftAssignmentMapper shiftAssignmentMapper;
    private final NurseService nurseService;


    // --- Public API methods ---

    @Override
    public ShiftAssignmentResponseDto create(ShiftAssignmentRequestDto requestDto) {
        ShiftAssignment shiftAssignment = shiftAssignmentMapper.toEntity(requestDto);
        shiftAssignment.setNurse(nurseService.getEntityById(requestDto.getNurseId()));
        return shiftAssignmentMapper.toResponseDto(repository.save(shiftAssignment));
    }

    @Transactional
    @Override
    public ShiftAssignmentResponseDto update(Long id, ShiftAssignmentRequestDto requestDto) {
        ShiftAssignment existingShift = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("ShiftAssignment not found with ID: " + id));
        updateEntityFromDto(existingShift, requestDto);
        return shiftAssignmentMapper.toResponseDto(repository.save(existingShift));
    }

    @Override
    public void delete(Long id) {
        ShiftAssignment shiftAssignment = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("ShiftAssignment not found with ID: " + id));
        repository.delete(shiftAssignment);
    }

    @Override
    public ShiftAssignmentResponseDto getById(Long id) {
        return repository.findById(id)
                .map(shiftAssignmentMapper::toResponseDto)
                .orElseThrow(() -> new RuntimeException("ShiftAssignment not found with ID: " + id));
    }

    @Override
    public List<ShiftAssignmentResponseDto> getByDateRange(LocalDate from, LocalDate to) {
        if (from == null || to == null)
            throw new IllegalArgumentException("Both 'from' and 'to' dates must be provided for a range search.");
        if (from.isAfter(to))
            throw new IllegalArgumentException("The 'from' date (" + from + ") cannot be after the 'to' date (" + to + ").");
        return repository.findByDateBetween(from, to).stream()
                .map(shiftAssignmentMapper::toResponseDto)
                .toList();
    }

    // --- Private helpers ---

    private void updateEntityFromDto(ShiftAssignment existingShift, ShiftAssignmentRequestDto requestDto) {
        existingShift.setDate(requestDto.getDate());
        existingShift.setShiftType(requestDto.getShiftType());
        existingShift.setNurse(nurseService.getEntityById(requestDto.getNurseId()));
    }
}
