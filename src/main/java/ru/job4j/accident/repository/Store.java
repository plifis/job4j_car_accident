package ru.job4j.accident.repository;

import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;

import java.util.List;

public interface Store {
    public Accident saveOrUpdate(Accident accident, String[] ids);
    public List<Accident> getAllAccidents();
    public List<AccidentType> getAllTypes();
    public List<Rule> getAllRules();
    public <T> T findById(Class<T> cl, int id);
}
