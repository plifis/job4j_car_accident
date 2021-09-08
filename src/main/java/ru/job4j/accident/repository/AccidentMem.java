package ru.job4j.accident.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.control.AccidentControl;
import ru.job4j.accident.model.Accident;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AccidentMem {
    private static final AtomicInteger count = new AtomicInteger(0);
    private final Map<Integer, Accident> accidents = new HashMap<>();


    private Map<Integer, Accident> init() {
        this.accidents.put(count.incrementAndGet(), new Accident(1, "Никита", "ДТП", "Троийкий 65"));
        this.accidents.put(count.incrementAndGet(), new Accident(2, "Алексей", "Выезд на встречную полосу", "Дзержинского 12"));
        this.accidents.put(count.incrementAndGet(), new Accident(3, "Никита", "Проезд на красный свет", "Воскресенская 120"));
        return accidents;
    }

    public AccidentMem() {
        this.init();
    }

    public void addAccident(Accident accident) {
        this.accidents.put(count.incrementAndGet(),accident);
    }

    public void updateAccident(int i, Accident accident) {
        this.accidents.replace(i, accident);
    }


    public Collection<Accident> getAccidents() {
        return accidents.values();
    }

}
