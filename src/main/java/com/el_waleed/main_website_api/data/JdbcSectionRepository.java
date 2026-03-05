package com.el_waleed.main_website_api.data;

import com.el_waleed.main_website_api.dto.Section;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcSectionRepository implements SectionRepository{

    private JdbcTemplate jdbcTemplate;

    public JdbcSectionRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Section> findById(String id, String pageId) {
        List<Section> results = jdbcTemplate.query(
                "SELECT * FROM sections where id=?",
                this::mapRowToSection,
                id
        );

        return results.isEmpty() ? Optional.empty() : Optional.of(results.get(0));
    }

    @Override
    public List<Section> returnAllSections() {
        return jdbcTemplate.query(
                "SELECT * FROM sections",
                this::mapRowToSection
        );
    }


    private Section mapRowToSection(ResultSet row, int rowNum) throws SQLException {
        Section section = new Section();
        section.setId(row.getString("id"));
        section.setPageId(row.getString("page_id"));
        section.setTitle(row.getString("title"));
        section.setHeader(row.getString("header"));
        section.setDescription(row.getString("description"));
        section.setUpdatedAt(row.getDate("updated_at"));
        return section;
    }

    @Override
    public Section save(Section section) {
        jdbcTemplate.update(
                "INSERT INTO sections (id, page_id, title, header, description, updated_at) VALUES (?, ?, ?, ?, ?, ?)",
                section.getId(),
                section.getPageId(),
                section.getTitle(),
                section.getHeader(),
                section.getDescription(),
                section.getUpdatedAt()
        );
        return section;
    }

    @Override
    public Section update(Section section) {
        int rowsUpdatedCount = jdbcTemplate.update(
                "UPDATE sections SET title=?, header=?, description=?, updated_at=? WHERE id=? AND page_id=?",
                section.getTitle(),
                section.getHeader(),
                section.getDescription(),
                section.getUpdatedAt(),
                section.getId(),
                section.getPageId()
        );
        if (rowsUpdatedCount == 0) {
            throw new IllegalStateException("No rows were updated, with section Id: "
                    + section.getId() + ", and page Id: " + section.getPageId());
        }
        return section;
    }



}
