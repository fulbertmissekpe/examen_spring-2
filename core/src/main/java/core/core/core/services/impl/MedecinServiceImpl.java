package core.core.core.services.impl;

import core.core.core.data.entities.Medecin;
import core.core.core.data.repository.MedecinRepo;
import core.core.core.services.MedecinService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedecinServiceImpl implements MedecinService {
    private final MedecinRepo   medecinRepo;
    @Override
    public void save(Medecin data) {
        medecinRepo.save(data);
    }

    @Override
    public List<Medecin> getAll() {
        return medecinRepo.findMedecinByActiveTrue();
    }
}
