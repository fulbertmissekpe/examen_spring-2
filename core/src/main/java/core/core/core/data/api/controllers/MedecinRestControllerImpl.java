package core.core.core.data.api.controllers;

import core.core.core.data.api.dto.RestResponse;
import core.core.core.data.api.dto.response.MedecinDto;
import core.core.core.data.api.dto.response.PatientDto;
import core.core.core.data.entities.Medecin;
import core.core.core.data.entities.Patient;
import core.core.core.services.MedecinService;
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
public class MedecinRestControllerImpl implements MedecinRestController{
    private final MedecinService service;
    @Override
    public ResponseEntity<Map<Object, Object>> listerMedecin() {
        List<Medecin> patient = service.getAll();
        List<MedecinDto> list = patient.stream().map(MedecinDto::toDto).toList();
        return new ResponseEntity<>(RestResponse.response(list, HttpStatus.OK), HttpStatus.OK);
    }
}
