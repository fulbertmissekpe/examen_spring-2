package core.core.core.data.api.controllers;

import core.core.core.data.api.dto.RestResponse;
import core.core.core.data.api.dto.request.RvRequest;
import core.core.core.data.api.dto.response.RvDto;
import core.core.core.data.entities.Patient;
import core.core.core.data.entities.RV;
import core.core.core.data.repository.PatientRepo;
import core.core.core.services.RvService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
@CrossOrigin(value = "http://localhost:4200")
public class RvRestControllerImpl implements RvRestController {
    private final RvService service;
    private final PatientRepo patientRepo;
    @Override
    public ResponseEntity<Map<Object, Object>> listerRv() {
        List<RV> articles = service.getAll();
        System.out.println(articles);
        List<RvDto> list = articles.stream().map(RvDto::toDto).toList();
        System.out.println(list);
        return new ResponseEntity<>(RestResponse.response(list, HttpStatus.OK), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<Object, Object>> listerRvBy(String name) {
        Patient patient=patientRepo.findByUsername(name);
        List<RV> articles = service.getRbVousByPatient(patient);

        System.out.println(articles);
        List<RvDto> list = articles.stream().map(RvDto::toDto).toList();
        System.out.println(list);
        return new ResponseEntity<>(RestResponse.response(list, HttpStatus.OK), HttpStatus.OK);
    }
    public Page<RV> convertListToPage(List<RV> list, int pageNumber, int pageSize) {
        int start = pageNumber * pageSize;
        int end = Math.min((pageNumber + 1) * pageSize, list.size());

        List<RV> content = list.subList(start, end);

        return new PageImpl<>(content, PageRequest.of(pageNumber, pageSize), list.size());
    }
    @Override
    public ResponseEntity<Map<Object, Object>> save(RvRequest rvRequest, BindingResult bindingResult) {
         Map<Object, Object> response;
        if (bindingResult.hasErrors()){
            Map<String, String> errors =new HashMap<>();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            fieldErrors.forEach(fieldError -> errors.put(fieldError.getField(),fieldError.getDefaultMessage()));
            response= RestResponse.response(errors, HttpStatus.NOT_FOUND);
        }else{
            service.AddRv(rvRequest);
            response= RestResponse.response(rvRequest,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
