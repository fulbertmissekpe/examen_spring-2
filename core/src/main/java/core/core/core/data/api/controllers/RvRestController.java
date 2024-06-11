package core.core.core.data.api.controllers;

import core.core.core.data.api.dto.request.RvRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

public interface RvRestController {
    @GetMapping("/rvRest")//End Point
    ResponseEntity<Map<Object, Object>> listerRv();
    @GetMapping("/rvRest/patient/{name}")//End Point
    ResponseEntity<Map<Object, Object>> listerRvBy(@PathVariable String name);
    
    @PostMapping("/rvRest")
    ResponseEntity<Map<Object, Object>> save(@Valid @RequestBody RvRequest rvRequest, BindingResult bindingResult);
}
