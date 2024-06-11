package mvc.mvc.mvc.Controllers.impl;

import core.core.core.data.entities.RV;
import core.core.core.services.RvService;
import lombok.RequiredArgsConstructor;
import mvc.mvc.mvc.Controllers.RvControler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class RvControllerImpl implements RvControler {
    private final RvService service;
    @Override
    public String listerRv(Model model, int page, int size, String date) {
        System.out.println("ok");
        List<RV>   rendezVousList =service.getAll();
        System.out.println(rendezVousList);
        model.addAttribute("rendezVousList", rendezVousList);
        return "rendezvous/list";
    }

    @Override
    public String saveSession(Long id, Long medecinIndex) {
        return "";
    }
}
