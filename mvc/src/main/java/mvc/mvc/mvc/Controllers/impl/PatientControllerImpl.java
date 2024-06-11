package mvc.mvc.mvc.Controllers.impl;

import core.core.core.data.entities.Patient;
import core.core.core.services.PatientService;
import lombok.RequiredArgsConstructor;
import mvc.mvc.mvc.Controllers.PatientController;
import mvc.mvc.mvc.dto.Responce.PatientDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PatientControllerImpl implements PatientController {
    private final PatientService service;
    @Override
    public String listerPatient(Model model, int page, int size, String date) {
        List<Patient> patientDtoList = service.getAll();
        model.addAttribute("patient", patientDtoList);

        return "Patient/patient";
    }
}
