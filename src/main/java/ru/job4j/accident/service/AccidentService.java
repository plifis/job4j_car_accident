package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.*;

import java.util.Collection;


@Service
public class AccidentService {
    private final AccidentRepository accidentRepository;
    private final AccidentTypeRepository typeRepository;
    private final RuleRepository ruleRepository;

    public AccidentService(AccidentRepository accidentRepository, AccidentTypeRepository typeRepository, RuleRepository ruleRepository) {
        this.accidentRepository = accidentRepository;
        this.typeRepository = typeRepository;
        this.ruleRepository = ruleRepository;
    }

    @Transactional
    public void save(Accident accident, String[] ids) {
        for (String id : ids) {
            accident.addRule(this.ruleRepository.findById(Integer.parseInt(id)).get());
        }
        accident.setType(this.typeRepository.findById(accident.getType().getId()).get());
        this.accidentRepository.save(accident);
    }

    @Transactional
    public Collection<Accident> getAllAccidents() {
        return this.accidentRepository.findAll();
    }

    @Transactional
    public Accident findAccidentById(int id) {
        return this.accidentRepository.findById(id).get();
    }


    @Transactional
    public Collection<AccidentType> getAllTypes() {
        return (Collection<AccidentType>) this.typeRepository.findAll();
    }

    @Transactional
    public Collection<Rule> getAllRules() {
        return (Collection<Rule>) this.ruleRepository.findAll();
    }
}
