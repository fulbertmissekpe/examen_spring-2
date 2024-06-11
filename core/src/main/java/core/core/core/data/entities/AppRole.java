package core.core.core.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "roles")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Data
public class AppRole extends AbstractEntity {

    @Column(nullable = false,unique = true)
    protected String roleName;
    @ManyToMany(mappedBy = "roles")
    List<AppUser> users;

    @Override
    public String toString() {
        return "AppRole{" +
                "roleName='" + roleName + '\'' +
                '}';
    }

    public AppRole(String roleName) {
        this.roleName = roleName;
    }
}
