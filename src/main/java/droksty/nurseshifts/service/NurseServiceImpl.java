package droksty.nurseshifts.service;

import droksty.nurseshifts.dto.NurseRequestDto;
import droksty.nurseshifts.dto.NurseResponseDto;
import droksty.nurseshifts.mapper.NurseMapper;
import droksty.nurseshifts.model.Nurse;
import droksty.nurseshifts.repository.NurseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NurseServiceImpl implements NurseService {

    private final NurseRepository repository;
    private final NurseMapper mapper;

    // --- Public API methods ---

    @Override
    public NurseResponseDto create(NurseRequestDto requestDto) {
        Nurse nurse = repository.save(mapper.toEntity(requestDto));
        return mapper.toResponseDto(nurse);
    }

    @Transactional
    @Override
    public NurseResponseDto update(Long id, NurseRequestDto requestDto) {
        Nurse existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nurse not found with ID: " + id));
        updateEntityFromDto(requestDto, existing);
        Nurse updated = repository.save(existing);
        return mapper.toResponseDto(updated);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public NurseResponseDto getById(Long id) {
        return repository.findById(id)
                .map(mapper::toResponseDto)
                .orElseThrow(() -> new RuntimeException("Nurse not found with ID: " + id));
    }

    @Override
    public Nurse getEntityById(Long id) {
        if (id == null) return null;
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nurse not found with ID: " + id));
    }

    @Override
    public List<NurseResponseDto> getAll() {
        return repository.findAll().stream()
                .map(mapper::toResponseDto)
                .toList();
    }

    @Override
    public List<NurseResponseDto> getAllByLastName(String lastName) {
        return repository.findByLastNameContainingIgnoreCase(lastName).stream()
                .map(mapper::toResponseDto)
                .toList();
    }


    // --- Private helpers ---

    private void updateEntityFromDto(NurseRequestDto requestDto, Nurse nurse) {
        nurse.setFirstName(requestDto.getFirstName());
        nurse.setLastName(requestDto.getLastName());
    }
}
