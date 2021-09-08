package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.control.AccidentControl;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.AccidentMem;

import java.util.Collection;

@Service
public class AccidentService {
    private final AccidentMem mem;

    public AccidentService(AccidentMem mem) {
        this.mem = mem;
    }

    public void save(Accident accident) {
        this.mem.saveOrUpdate(accident);
    }

    public Collection<Accident> getAllAccident() {
        return this.mem.getAccidents();
    }

    public Accident findById(int id) {
        return this.mem.getId(id);
    }


}
