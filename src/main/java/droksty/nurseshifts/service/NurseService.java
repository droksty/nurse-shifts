package droksty.nurseshifts.service;

import droksty.nurseshifts.dto.NurseRequestDto;
import droksty.nurseshifts.dto.NurseResponseDto;
import droksty.nurseshifts.model.Nurse;

import java.util.List;

public interface NurseService {

    NurseResponseDto create(NurseRequestDto nurseDto);
    NurseResponseDto update(Long id, NurseRequestDto nurseDto);
    void delete(Long id);
    NurseResponseDto getById(Long id);
    Nurse getEntityById(Long id);
    List<NurseResponseDto> getAll();
    List<NurseResponseDto> getAllByLastName(String lastName);
}
