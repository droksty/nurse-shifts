package droksty.nurseshifts.controller;

import droksty.nurseshifts.dto.ShiftAssignmentRequestDto;
import droksty.nurseshifts.dto.ShiftAssignmentResponseDto;
import droksty.nurseshifts.service.ShiftAssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = { "http://localhost:4200", "http://127.0.0.1:4200" })
@RestController
@RequestMapping("/shift-assignments")
@RequiredArgsConstructor
public class ShiftAssignmentController {

    private final ShiftAssignmentService service;

    // --- REST Endpoints ---

    @PostMapping
    public ResponseEntity<ShiftAssignmentResponseDto> create(@RequestBody ShiftAssignmentRequestDto requestDto) {
        ShiftAssignmentResponseDto responseDto = service.create(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShiftAssignmentResponseDto> update(@PathVariable Long id, @RequestBody ShiftAssignmentRequestDto requestDto) {
        ShiftAssignmentResponseDto responseDto = service.update(id, requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<ShiftAssignmentResponseDto> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShiftAssignmentResponseDto> get(@PathVariable Long id) {
        ShiftAssignmentResponseDto responseDto = service.getById(id);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping
    public ResponseEntity<List<ShiftAssignmentResponseDto>> getByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to) {
        List<ShiftAssignmentResponseDto> response = service.getByDateRange(from, to);
        return ResponseEntity.ok(response);
    }
}
