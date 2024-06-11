package core.core.core.data.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor

@Setter
@Getter
@Builder
@Data
@Table(name = "Patient")
public class Patient extends AppUser {
    @Column(nullable = true)
    protected String mat;

}
