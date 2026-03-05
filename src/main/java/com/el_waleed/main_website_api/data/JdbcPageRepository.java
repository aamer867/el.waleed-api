package com.el_waleed.main_website_api.data;

import com.el_waleed.main_website_api.dto.Page;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcPageRepository {

    private JdbcTemplate jdbcTemplate;

    public JdbcPageRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // @Override
    public Optional<Page> findById(String id) {
        List<Page> results = jdbcTemplate.query(
                "SELECT * FROM pages WHERE id = ?",
                this::mapRowToPage,
                id
        );
        return results.isEmpty() ? Optional.empty() : Optional.of(results.get(0));
    }

    private Page mapRowToPage(ResultSet rs, int rowNum) throws SQLException {
        Page page = new Page();
        page.setId(rs.getString("id"));
        page.setTitle(rs.getString("title"));
        page.setSlug(rs.getString("slug"));
        page.setUpdatedAt(rs.getDate("updated_at"));

        return page;
    }


}
