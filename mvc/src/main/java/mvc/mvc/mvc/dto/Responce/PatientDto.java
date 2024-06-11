package mvc.mvc.mvc.dto.Responce;

import core.core.core.data.entities.Patient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientDto {
    private Long id;
    private String nom;
    public static PatientDto  toDto(Patient patient){
        return PatientDto
                .builder()
                .id(patient.getId())
                .nom(patient.getNom())
                .build();
    }
}
