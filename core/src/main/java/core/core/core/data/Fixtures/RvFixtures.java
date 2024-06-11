package core.core.core.data.Fixtures;

import core.core.core.data.entities.Medecin;
import core.core.core.data.entities.Patient;
import core.core.core.data.entities.RV;
import core.core.core.data.repository.MedecinRepo;
import core.core.core.data.repository.PatientRepo;
import core.core.core.data.repository.RvRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RequiredArgsConstructor
//@Component
//@Order(5)
public class RvFixtures implements CommandLineRunner {
    private final MedecinRepo medecinRepo;
    private final PatientRepo patientRepo;
    private final RvRepo rvRepo;
//    private final MedecinRespository medecinRespository;
//    private final IRdvRepository rdvRepository;
//    private final IPatientRespository patientRespository;
//    private final IAppUserRepository appUserRepository;

    @Override
    public void run(String... args) throws Exception {
            for (int i = 0; i < 10; i++) {
                RV rdv = new RV();
                rdv.setDateHeure(LocalDate.now());
                Patient patient = null;
                Medecin medecin = null;
                if(i<3){
                    medecin =  medecinRepo.findById(1);
                    patient =  patientRepo.findById(1) ;
                } else if (i<6) {
                    medecin =  medecinRepo.findById(2) ;
                    patient = patientRepo.findById(2) ;
                }
                else {
                    medecin = medecinRepo.findById(3) ;
                    patient = patientRepo.findById(3) ;

                }
                rdv.setMedecin(medecin);
                System.out.println(medecin);
               // rdv.setSpecialite(medecin.getSpecialite());
                rdv.setPatient(patient);
                rdv.setActive(true);
                rvRepo.save(rdv);

            }

        }

}
