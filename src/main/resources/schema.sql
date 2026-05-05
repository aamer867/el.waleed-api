CREATE TABLE IF NOT EXISTS pages (
    id VARCHAR(4) NOT NULL,
    title VARCHAR(40) NOT NULL,
    slug VARCHAR(15) NOT NULL,
    updated_at TIMESTAMP,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS sections (
    id VARCHAR(10) NOT NULL,
    page_id VARCHAR(4) NOT NULL,
    title VARCHAR(40) NOT NULL,
    header VARCHAR(300),
    description VARCHAR(1000),
    header_ar VARCHAR(300),
    description_ar VARCHAR(1000),
    type VARCHAR(20),
    position INT,
    updated_at TIMESTAMP,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS subsections (
    id VARCHAR(4) NOT NULL,
    section_id VARCHAR(10) NOT NULL,
    title VARCHAR(40) NOT NULL,
    type VARCHAR(20),
    data JSON NOT NULL,
    data_ar JSON,
    updated_at TIMESTAMP,
    position INT,
    PRIMARY KEY (id)
);

ALTER TABLE sections
    ADD FOREIGN KEY (page_id) REFERENCES pages(id);
ALTER TABLE subsections
    ADD FOREIGN KEY (section_id) REFERENCES sections(id);