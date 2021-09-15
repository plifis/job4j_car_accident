package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.accident.control.AccidentControl;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.AccidentHibernate;
import ru.job4j.accident.repository.AccidentMem;
import ru.job4j.accident.repository.Store;

import java.util.Collection;


@Service
public class AccidentService {
    private final Store mem;

    public AccidentService(Store mem) {
        this.mem = mem;
    }

    @Transactional
    public void save(Accident accident, String[] ids) {
        this.mem.saveOrUpdate(accident, ids);
    }

    @Transactional
    public Collection<Accident> getAllAccidents() {
        return this.mem.getAllAccidents();
    }

    @Transactional
    public Accident findById(int id) {
        return this.mem.findById(Accident.class, id);
    }

    @Transactional
    public Collection<AccidentType> getAllTypes() {
        return this.mem.getAllTypes();
    }

    @Transactional
    public Collection<Rule> getAllRules() {
        return this.mem.getAllRules();
    }
}
