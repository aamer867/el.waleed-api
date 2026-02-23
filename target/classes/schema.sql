CREATE TABLE IF NOT EXISTS Pages (
    id VARCHAR(4) NOT NULL,
    title VARCHAR(20) NOT NULL,
    slug VARCHAR(15) NOT NULL,
    updated_at TIMESTAMP,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS Sections (
    id VARCHAR(4) NOT NULL,
    page_id VARCHAR(4) NOT NULL,
    title VARCHAR(20) NOT NULL,
    header VARCHAR(300),
    description VARCHAR(1000),
    updated_at TIMESTAMP,
    PRIMARY KEY (id, page_id)
);

CREATE TABLE IF NOT EXISTS Sub_sections (
    id VARCHAR(4) NOT NULL,
    section_id VARCHAR(4) NOT NULL,
    title VARCHAR(20) NOT NULL,
    type VARCHAR(20),
    data JSON NOT NULL,
    updated_at TIMESTAMP,
    PRIMARY KEY (id, section_id)
);

ALTER TABLE Sections
    ADD FOREIGN KEY (page_id) REFERENCES Pages(id);
ALTER TABLE Sub_sections
    ADD FOREIGN KEY (section_id) REFERENCES Sections(id);