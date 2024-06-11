package core.core.core.services.impl;


import core.core.core.data.api.dto.request.RvRequest;
import core.core.core.data.api.dto.response.RvDto;
import core.core.core.data.entities.RV;
import core.core.core.data.enums.Specialite;
import core.core.core.data.repository.MedecinRepo;
import core.core.core.data.repository.PatientRepo;
import core.core.core.data.repository.RvRepo;
import core.core.core.services.RvService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RvServiceImpl implements RvService {
    private final RvRepo repo;
    private final MedecinRepo medecinRepo;
    private final PatientRepo patientRepo;
    @Override
    public void save(RV data) {
        repo.save(data);
    }

    @Override
    public List<RV> getAll() {
        return repo.findRVByActiveTrue();
    }


    @Override
    public List<RV> getRendezVousByDate(LocalDate date) {
        LocalDateTime start = date.atStartOfDay();
        LocalDateTime end = date.plusDays(1).atStartOfDay();
        return repo.findByDateHeureBetween(start, end);
    }

    @Override
    public void AddRv(RvRequest data) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date=  LocalDate.parse(data.getDateHeure(),dateFormatter);
        RV rv = new RV();
        rv.setDateHeure(date);
        rv.setSpecialite(Specialite.toEnum(Integer.parseInt(data.getSpecialite())));
        rv.setMedecin(medecinRepo.findById(data.getMedecin().intValue()));
        rv.setPatient(patientRepo.findById(data.getPatient().intValue()));
        rv.setActive(true);
        rv.setValide(false);

        repo.save(rv);

    }
}
