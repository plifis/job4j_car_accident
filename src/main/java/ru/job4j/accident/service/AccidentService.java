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

    public void createAccident(Accident accident) {
        this.mem.addAccident(accident);
    }

    public void editAccident(int i, Accident accident) {
        this.mem.updateAccident(i, accident);
    }

    public Collection<Accident> getAllAccident() {
        return this.mem.getAccidents();
    }


}
