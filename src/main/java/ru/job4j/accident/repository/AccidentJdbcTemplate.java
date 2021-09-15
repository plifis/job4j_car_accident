package ru.job4j.accident.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;

import java.util.List;

//@Repository
public class AccidentJdbcTemplate implements Store {
    private final JdbcTemplate jdbc;

    public AccidentJdbcTemplate(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Accident saveOrUpdate(Accident accident, String[] ids) {
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

    @Override
    public List<Accident> getAllAccidents() {
        return jdbc.query("select disctinct id, name, text, address from accident a join fetch a.type join fetch a.rules",
                (rs, row) -> {
                    Accident accident = new Accident();
                    accident.setId(rs.getInt("id"));
                    accident.setName(rs.getString("name"));
                    return accident;
                });
    }

    @Override
    public List<Rule> getAllRules() {
        return jdbc.query("select id, name from rule",
                (rs, row) -> {
                    Rule rule = new Rule();
                    rule.setId(rs.getInt("id"));
                    rule.setName(rs.getString("name"));
                    return rule;
                });
    }

    @Override
    public  List<AccidentType> getAllTypes() {
        return jdbc.query("select id, name from type",
                (rs, row) -> {
                    AccidentType type = new AccidentType();
                    type.setId(rs.getInt("id"));
                    type.setName(rs.getString("name"));
                    return  type;
                });
    }

    @Override
    public <T> T findById(Class<T> cl, int id) {
        return jdbc.queryForObject("select name from accident a join fetch where id = ?", cl, id);
    }

}