package core.core.core.data.api.dto.request;


import core.core.core.data.entities.RV;
import core.core.core.data.enums.Specialite;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class RvRequest {
    private String patient;
    private Long medecin;
    private String dateHeure;
    private String specialite;



}
