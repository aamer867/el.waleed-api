package com.el_waleed.main_website_api.data;

import com.el_waleed.main_website_api.dto.Section;
import com.el_waleed.main_website_api.dto.SubSection;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcSubSectionRepository implements SubSectionRepository{

    private JdbcTemplate jdbcTemplate;

    public JdbcSubSectionRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<SubSection> findById(String id, String sectionId) {
        List<SubSection> results = jdbcTemplate.query(
                "SELECT * FROM subsections where id=? AND section_id=?",
                this::mapRowToSubSection,
                id,
                sectionId
        );
        return results.isEmpty() ? Optional.empty() : Optional.of(results.get(0));
    }

    @Override
    public List<SubSection> returnAllSubSections(String sectionId) {
        return jdbcTemplate.query(
                "SELECT * FROM subsections where section_id=?",
                this::mapRowToSubSection,
                sectionId
        );
    }

    @Override
    public SubSection update(SubSection subSection) {
        int rowsUpdated = jdbcTemplate.update(
                "UPDATE subsections SET title=?, type=?, data=?, updated_at=?, position=? " +
                        "WHERE id=? AND section_id=?",
                subSection.getTitle(),
                subSection.getType(),
                subSection.getContentJson(), // JSON as string
                subSection.getUpdatedAt(),
                subSection.getPosition(),
                subSection.getId(),
                subSection.getSectionId()
        );

        if (rowsUpdated == 0) {
            throw new IllegalStateException(
                    "No rows were updated with SubSection id: " + subSection.getId() +
                            " and section_id: " + subSection.getSectionId()
            );
        }

        return subSection;
    }


    private SubSection mapRowToSubSection(ResultSet row, int rowNum) throws SQLException {
        SubSection subSection = new SubSection();
        subSection.setId(row.getString("id"));
        subSection.setSectionId(row.getString("section_id"));
        subSection.setTitle(row.getString("title"));
        subSection.setType(row.getString("type"));
        subSection.setContentJson(row.getString("data")); // or JSON handling
        subSection.setUpdatedAt(row.getTimestamp("updated_at"));
        subSection.setPosition(row.getInt("position"));
        return subSection;
    }
}
