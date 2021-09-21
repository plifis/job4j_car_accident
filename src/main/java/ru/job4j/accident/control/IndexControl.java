package ru.job4j.accident.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.AccidentHibernate;
import ru.job4j.accident.service.AccidentService;


import java.util.ArrayList;
import java.util.List;


@Controller
public class IndexControl {
    private final AccidentService accidents;

    public IndexControl(AccidentService accidents) {
        this.accidents = accidents;
    }

//    @GetMapping("/")
//    public String index(Model model) {
//        model.addAttribute("accidents", accidents.getAllAccidents());
//        return "index";
//    }


    @GetMapping("/")
    public String index(Model model) {
        List<Accident> res = new ArrayList<>();
        accidents.getAllAccidents().forEach(res::add);
        model.addAttribute("accidents", res);
        return "index";
    }

}