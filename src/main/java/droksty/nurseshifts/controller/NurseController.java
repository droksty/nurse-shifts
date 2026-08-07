package droksty.nurseshifts.controller;

import droksty.nurseshifts.dto.NurseRequestDto;
import droksty.nurseshifts.dto.NurseResponseDto;
import droksty.nurseshifts.service.NurseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "http://localhost:4200", "http://127.0.0.1:4200" })
@RestController
@RequestMapping("/nurses")
@RequiredArgsConstructor
public class NurseController {

    private final NurseService service;

    // --- REST Endpoints ---

    @PostMapping
    public ResponseEntity<NurseResponseDto> createNurse(@RequestBody NurseRequestDto requestDto) {
        NurseResponseDto createdNurse = service.create(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createdNurse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NurseResponseDto> updateNurse(@PathVariable Long id, @RequestBody NurseRequestDto requestDto) {
        NurseResponseDto updatedNurse = service.update(id, requestDto);
        return ResponseEntity.ok(updatedNurse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<NurseResponseDto> deleteNurse(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<NurseResponseDto>> getAllNurses() {
        List<NurseResponseDto> nurses = service.getAll();
        return ResponseEntity.ok(nurses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NurseResponseDto> getNurseById(@PathVariable Long id) {
        NurseResponseDto nurse = service.getById(id);
        return ResponseEntity.ok(nurse);
    }
}
