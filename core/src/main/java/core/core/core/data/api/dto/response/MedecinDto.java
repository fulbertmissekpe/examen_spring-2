package core.core.core.data.api.dto.response;

import core.core.core.data.entities.Medecin;
import core.core.core.data.enums.Specialite;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedecinDto {
    private Long id;
    private String nom;
    private String specialite;

    public static MedecinDto toDto(Medecin medecin) {
        MedecinDto dto = new MedecinDto();
        dto.setId(medecin.getId());
        dto.setNom(medecin.getNom());
        dto.setSpecialite(String.valueOf(medecin.getSpecialite()));
        return dto;
    }
}
