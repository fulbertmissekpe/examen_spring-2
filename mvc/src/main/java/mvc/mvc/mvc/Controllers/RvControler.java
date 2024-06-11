package mvc.mvc.mvc.Controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

public interface RvControler {
    @GetMapping("/rv")
    String listerRv(Model model,
                             @RequestParam(defaultValue = "0")int page,
                             @RequestParam(defaultValue = "8")int size,@RequestParam(required = false) String date);
    @PostMapping("/save-rv/{id}")
    String saveSession(@PathVariable Long id, @RequestParam("medecin") Long medecinIndex);
}
