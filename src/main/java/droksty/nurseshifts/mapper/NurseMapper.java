package droksty.nurseshifts.mapper;

import droksty.nurseshifts.dto.NurseRequestDto;
import droksty.nurseshifts.dto.NurseResponseDto;
import droksty.nurseshifts.model.Nurse;
import org.springframework.stereotype.Component;

@Component
public class NurseMapper {

    public NurseResponseDto toResponseDto(Nurse entity) {
        return entity == null
                ? null
                : new NurseResponseDto(entity.getId(), entity.getFirstName(), entity.getLastName());
    }

    public Nurse toEntity(NurseRequestDto dto) {
        return dto == null
                ? null
                : Nurse.builder()
                    .firstName(dto.getFirstName())
                    .lastName(dto.getLastName())
                    .build();
    }
}
