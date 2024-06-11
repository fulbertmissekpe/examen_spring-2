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
@Table(name = "Secretaire")
public class Secretaire extends AppUser {
    @Column(nullable = true)
    protected String service;
}
