package core.core.core.data.entities;

import core.core.core.data.enums.Specialite;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor

@Setter
@Getter
@Builder
@Data
@Table(name = "Medecin")
public class Medecin extends AppUser{
    @Column()
    @Enumerated(value = EnumType.STRING)
    private Specialite specialite;

}
