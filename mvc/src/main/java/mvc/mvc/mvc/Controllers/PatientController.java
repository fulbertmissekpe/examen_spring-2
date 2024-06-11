package mvc.mvc.mvc.Controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface PatientController {
    @GetMapping("/patient")
    String listerPatient(Model model,
                             @RequestParam(defaultValue = "0")int page,
                             @RequestParam(defaultValue = "8")int size,
                             @RequestParam(required = false) String date
    ) ;
}
