package core.core.core.data.api.controllers;

import core.core.core.data.api.dto.RestResponse;
import core.core.core.data.api.dto.response.PatientDto;
import core.core.core.data.api.dto.response.RvDto;
import core.core.core.data.entities.Patient;
import core.core.core.data.entities.RV;
import core.core.core.services.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
@CrossOrigin(value = "http://localhost:4200")
public class PatientRestControllerImpl implements PatientRestController{
    private final PatientService service;
    @Override
    public ResponseEntity<Map<Object, Object>> listerPatient() {
        List<Patient> patient = service.getAll();
        List<PatientDto> list = patient.stream().map(PatientDto::toDto).toList();
        return new ResponseEntity<>(RestResponse.response(list, HttpStatus.OK), HttpStatus.OK);
    }
}
