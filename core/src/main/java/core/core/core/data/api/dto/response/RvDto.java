package core.core.core.data.api.dto.response;

import core.core.core.data.entities.RV;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RvDto {
    private Long id;
    private String patient;
    private String medecin;
    private LocalDate dateHeure;
    private String specialite;

    public static RvDto toDto(RV rendezVous) {
        RvDto dto = new RvDto();
        dto.setId(rendezVous.getId());
        dto.setPatient(rendezVous.getPatient().getNom());
        dto.setMedecin(rendezVous.getMedecin().getNom());
        dto.setDateHeure(rendezVous.getDateHeure());
        dto.setSpecialite(String.valueOf(rendezVous.getMedecin().getSpecialite()));

        return dto;
    }
}
