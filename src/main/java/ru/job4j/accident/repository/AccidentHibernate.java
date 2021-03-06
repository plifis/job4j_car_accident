package ru.job4j.accident.repository;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;

import java.util.List;

public class AccidentHibernate implements Store {
    private final SessionFactory sf;

    public AccidentHibernate(SessionFactory sf) {
        this.sf = sf;
    }


    public Accident saveOrUpdate(Accident accident, String[] ids) {
        for (String id : ids) {
            accident.addRule(this.findById(Rule.class, Integer.parseInt(id)));
        }
        accident.setType(this.findById(AccidentType.class, accident.getType().getId()));
        try (Session session = sf.openSession()) {
            session.save(accident);
            return accident;
        }
    }

    public List<Accident> getAllAccidents() {
        try (Session session = sf.openSession()) {
            List<Accident> list = session.createQuery( "select distinct a from Accident a "
                            + "join fetch a.type "
                            + "join fetch a.rules order by a.id",
                    Accident.class).list();
            return list;
        }
    }


    public List<AccidentType> getAllTypes() {
        try(Session session = sf.openSession()) {
            return session.createQuery("from AccidentType", AccidentType.class).list();
        }
    }


    public List<Rule> getAllRules() {
        try (Session session = sf.openSession()) {
            return session.createQuery("from Rule", Rule.class).list();
        }
    }

    public <T> T findById(Class<T> cl, int id) {
        try(Session session = sf.openSession()) {
            return session.get(cl, id);
        }
    }
}
