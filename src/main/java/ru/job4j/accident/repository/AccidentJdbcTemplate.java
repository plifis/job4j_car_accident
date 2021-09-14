package ru.job4j.accident.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;

import java.util.List;

//@Repository
public class AccidentJdbcTemplate {
    private final JdbcTemplate jdbc;

    public AccidentJdbcTemplate(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Accident save(Accident accident) {
        if (accident.getId() == 0) {
            jdbc.update("insert into accident (name) values (?)",
                    accident.getName());
            return accident;
        } else {
            jdbc.update("update accident set (name, text, address) = (?, ?, ?, ?) where = (?)", accident.getName(),
                    accident.getText(), accident.getAddress(), accident.getId());
            return accident;
        }
    }

    public List<Accident> getAllAccidents() {
        return jdbc.query("select id, name, text, address from accident",
                (rs, row) -> {
                    Accident accident = new Accident();
                    accident.setId(rs.getInt("id"));
                    accident.setName(rs.getString("name"));
                    return accident;
                });
    }

    public List<Rule> getRules() {
        return jdbc.query("select id, name from rule",
                (rs, row) -> {
                    Rule rule = new Rule();
                    rule.setId(rs.getInt("id"));
                    rule.setName(rs.getString("name"));
                    return rule;
                });
    }

    public  List<AccidentType> getTypes() {
        return jdbc.query("select id, name from type",
                (rs, row) -> {
                    AccidentType type = new AccidentType();
                    type.setId(rs.getInt("id"));
                    type.setName(rs.getString("name"));
                    return  type;
                });
    }

    public Accident findById(int id) {
        return jdbc.queryForObject("select name from accident where id = ?", Accident.class, id);
    }

}