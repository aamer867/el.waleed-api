package com.el_waleed.main_website_api.data;

import com.el_waleed.main_website_api.dto.Section;
import com.el_waleed.main_website_api.dto.SubSection;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    private String unwrapJson(String value) {
        if (value == null) return null;
        String trimmed = value.trim();
        if (trimmed.startsWith("\"")) {
            try {
                // Jackson will parse the outer JSON string and give back the inner value
                return new ObjectMapper().readValue(trimmed, String.class);
            } catch (JsonProcessingException e) {
                // Not a valid JSON string literal — return as-is
                return value;
            }
        }
        return value;
    }

    @Override
    public SubSection update(SubSection subSection) {

        SubSection oldData = findById(subSection.getId(), subSection.getSectionId())
                .orElseThrow(() -> new RuntimeException("SubSection not found"));

        if (subSection.getContentJson() == null) {
            subSection.setContentJson(unwrapJson(oldData.getContentJson()));
        }

        if (subSection.getArContentJson() == null) {
            subSection.setArContentJson(unwrapJson(oldData.getArContentJson()));
        }

        int rowsUpdated = jdbcTemplate.update(
                "UPDATE subsections SET title=?, type=?, data=?, data_ar=?, updated_at=?, position=? " +
                        "WHERE id=? AND section_id=?",
                subSection.getTitle(),
                subSection.getType(),
                unwrapJson(subSection.getContentJson()), // JSON as string
                unwrapJson(subSection.getArContentJson()),
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
        subSection.setArContentJson(row.getString("data_ar"));
        subSection.setUpdatedAt(row.getTimestamp("updated_at"));
        subSection.setPosition(row.getInt("position"));
        return subSection;
    }
}
