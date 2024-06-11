package core.core.core.data.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

public interface MedecinRestController {
    @GetMapping("/medecinRest")//End Point
    ResponseEntity<Map<Object, Object>> listerMedecin();
}
