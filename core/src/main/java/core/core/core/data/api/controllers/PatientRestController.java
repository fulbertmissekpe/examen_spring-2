package core.core.core.data.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

public interface PatientRestController {
    @GetMapping("/patientRest")//End Point
    ResponseEntity<Map<Object, Object>> listerPatient();
}
