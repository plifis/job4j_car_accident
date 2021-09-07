package ru.job4j.accident.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.HashMap;
import java.util.Map;

@Repository
public class AccidentMem {
    private static final AccidentMem INST = new AccidentMem();
    private final Map<Integer, Accident> accidents = new HashMap<>();


    private Map<Integer, Accident> init() {
        this.accidents.put(1, new Accident(1, "Никита", "ДТП", "Троийкий 65"));
        this.accidents.put(2, new Accident(2, "Алексей", "Выезд на встречную полосу", "Дзержинского 12"));
        this.accidents.put(3, new Accident(3, "Никита", "Проезд на красный свет", "Воскресенская 120"));
        return accidents;
    }

    private AccidentMem() {
        this.init();
    }

    public static AccidentMem instOf() {
        return INST;
    }

    public Map<Integer, Accident> getAccidents() {
        return accidents;
    }

}
