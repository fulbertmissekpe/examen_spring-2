package core.core.core.services;

import core.core.core.data.entities.Medecin;

import java.util.List;

public interface MedecinService {
    void save(Medecin data);
    List<Medecin> getAll();

}
