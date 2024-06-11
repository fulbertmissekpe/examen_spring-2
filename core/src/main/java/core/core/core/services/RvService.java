package core.core.core.services;

import core.core.core.data.api.dto.request.RvRequest;
import core.core.core.data.api.dto.response.RvDto;
import core.core.core.data.entities.Medecin;
import core.core.core.data.entities.RV;

import java.time.LocalDate;
import java.util.List;

public interface RvService{
    void save(RV data);
    List<RV> getAll();
    List<RV> getRendezVousByDate(LocalDate date);
   void AddRv(RvRequest data);

}
