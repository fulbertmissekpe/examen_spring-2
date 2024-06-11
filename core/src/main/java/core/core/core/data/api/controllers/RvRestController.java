package core.core.core.data.api.controllers;

import core.core.core.data.api.dto.request.RvRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

public interface RvRestController {
    @GetMapping("/rvRest")//End Point
    ResponseEntity<Map<Object, Object>> listerRv();

    @PostMapping("/rvRest")
    ResponseEntity<Map<Object, Object>> save(@Valid @RequestBody RvRequest rvRequest, BindingResult bindingResult);
}
