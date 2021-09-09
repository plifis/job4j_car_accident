package ru.job4j.accident.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.control.AccidentControl;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.Rule;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

@Repository
public class AccidentMem {
    private static final AtomicInteger count = new AtomicInteger(0);
    private final Map<Integer, Accident> accidents = new HashMap<>();
    private final Map<Integer, Rule> rules = new HashMap();


    private Map<Integer, Accident> init() {
        this.accidents.put(count.incrementAndGet(), new Accident(1, "Никита", "ДТП", "Троийкий 65"));
        this.accidents.put(count.incrementAndGet(), new Accident(2, "Алексей", "Выезд на встречную полосу", "Дзержинского 12"));
        this.accidents.put(count.incrementAndGet(), new Accident(3, "Никита", "Проезд на красный свет", "Воскресенская 120"));
        this.rules.put(1, Rule.of(1, "Статья. 1"));
        this.rules.put(2, Rule.of(2, "Статья. 2"));
        this.rules.put(3, Rule.of(3, "Статья. 3"));
        return accidents;
    }

    public AccidentMem() {
        this.init();
    }

    public void saveOrUpdate(Accident accident, String[] ids) {
        if (accident.getId() == 0) {
            int idAcc = count.incrementAndGet();
            accident.setId(idAcc);
            this.accidents.put(idAcc, setRulesToAccident(accident, ids));
        } else {
            this.accidents.replace(accident.getId(), setRulesToAccident(accident, ids));
        }
    }

    private Accident setRulesToAccident(Accident accident, String[] ids) {
        Stream.of(ids).forEach(idR -> {
            accident.getRules().add(this.rules.get(Integer.parseInt(idR)));
        });
        return accident;
    }

    public Accident getId(int id) {
        return this.accidents.get(id);
    }

    public Collection<Accident> getAccidents() {
        return accidents.values();
    }


    public static AtomicInteger getCount() {
        return count;
    }

    public Map<Integer, Rule> getRules() {
        return rules;
    }
}
