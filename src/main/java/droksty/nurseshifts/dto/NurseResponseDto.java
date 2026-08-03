package droksty.nurseshifts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NurseResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
}
