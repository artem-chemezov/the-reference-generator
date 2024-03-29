package com.example.host.db;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.example.host.Ref;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Queries {
    private JdbcTemplate jdbcTemplate;

    public Queries(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Ref getFull(String shortname) {
        Ref ref = jdbcTemplate.queryForObject(
                "SELECT * FROM reference WHERE shortname = ?",
                new Object[]{shortname},
                new RowMapper<Ref>() {
                    @Override
                    public Ref mapRow(ResultSet resultSet, int i) throws SQLException {
                        String shortname = resultSet.getString("shortname");
                        String fullname = resultSet.getString("fullname");
                        Ref ref = new Ref(shortname, fullname);
                        return ref;
                    }
                }
        );

        return ref;

    }

    public Ref getShort(String fullname) {
        Ref ref = jdbcTemplate.queryForObject(
                "SELECT * FROM reference WHERE fullname = ?",
                new Object[]{fullname},
                new RowMapper<Ref>() {
                    @Override
                    public Ref mapRow(ResultSet resultSet, int i) throws SQLException {
                        String shortname = resultSet.getString("shortname");
                        String fullname = resultSet.getString("fullname");
                        Ref ref = new Ref(shortname, fullname);
                        return ref;
                    }
                }
        );

        return ref;

    }
}
