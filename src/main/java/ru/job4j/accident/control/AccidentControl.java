package ru.job4j.accident.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.AccidentMem;
import ru.job4j.accident.service.AccidentService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AccidentControl {
    private AccidentService service;
    private List<AccidentType> types = new ArrayList<>();
    List<Rule> rules = new ArrayList<>();


    public AccidentControl(AccidentService service) {
        this.service = service;
        types.add(AccidentType.of(1, "Две машины"));
        types.add(AccidentType.of(2, "Машина и человек"));
        types.add(AccidentType.of(3, "Машина и велосипед"));
        rules.add(Rule.of(1, "Статья. 1"));
        rules.add(Rule.of(2, "Статья. 2"));
        rules.add(Rule.of(3, "Статья. 3"));
    }


    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident, HttpServletRequest req) {
        String[] ids = req.getParameterValues("rIds");
        service.save(accident, ids);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") int id, Model model) {
        model.addAttribute("accident", service.findById(id));
        model.addAttribute("type", types);
        return "accident/update";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("types", types);
        model.addAttribute("rules", rules);
        return "accident/create";
    }
}