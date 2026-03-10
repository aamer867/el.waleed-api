-- SET FOREIGN_KEY_CHECKS=0;
-- =========================
-- CLEAR TABLES
-- =========================
DELETE FROM subsections;
DELETE FROM sections;
DELETE FROM pages;

-- =========================
-- PAGES
-- =========================
INSERT INTO pages (id, title, slug) VALUES
                                        ('A01', 'Home', 'home_page'),
                                        ('A02', 'About', 'about_page'),
                                        ('A03', 'Services', 'services_page'),
                                        ('A04', 'Contact', 'contact_page'),
                                        ('A05', 'Clients', 'clients_page');

-- =========================
-- SECTIONS
-- =========================
INSERT INTO sections (id, page_id, title) VALUES
                                              ('B01', 'A01', 'landing_page'),
                                              ('B02', 'A01', 'mission_vision_values'),
                                              ('B03', 'A01', 'services_part'),
                                              ('B04', 'A01', 'clients_part'),
                                              ('B05', 'A01', 'contact_part');

-- =========================
-- subsections
-- =========================

-- Landing Header
INSERT INTO subsections (id, section_id, title, type, data) VALUES
    ('C01','B01','header_chosen_words','WORDS',
     '{ "words": ["Financial","Advisors","Chartered","Accountants","Tax","Experts"] }');

-- Landing Cards
INSERT INTO subsections (id, section_id, title, type, data) VALUES
    ('C02','B01','landing_cards','CARD',
     '{ "cards": [
         { "title": "card01", "image_url": "/sources/static/images/card01.jpg", "header": "Feasibility Study", "description": "We will conduct a feasibility study to determine the feasibility of your business." },
         { "title": "card02", "image_url": "/sources/static/images/card02.jpg", "header": "Taxes", "description": "Let us do it" }
     ]}');

-- Bank Logos
INSERT INTO subsections (id, section_id, title, type, data) VALUES
    ('C03','B01','bank_logos','IMG',
     '{"banks":[
       {
         "name": "bank_misr",
         "image_url": "/sources/static/images/bank_misr.png",
         "link": "https://www.banquemisr.com"
       },
       {
         "name": "bank_ahly",
         "image_url": "/sources/static/images/bank_ahly.png",
         "link": "https://www.nbe.com.eg"
       },
       {
         "name": "bank_mizrahi",
         "image_url": "/sources/static/images/bank_mizrahi.png",
         "link": "https://www.mizrahi-tefahot.co.il"
       }
     ]}');
-- Mission / Vision / Goals
INSERT INTO subsections (id, section_id, title, type, data) VALUES
    ('C04','B02','vision','CARD',
     '{ "title": "VISION", "header": "Innovative, empowering, sustainable, inclusive", "description": "Our strong belief in our profession inspires us to build a diverse and robust organization.", "img_url": "/resources/static/images/vision.jpg" }');

INSERT INTO subsections (id, section_id, title, type, data) VALUES
    ('C05','B02','mission','CARD',
     '{ "title": "MISSION", "header": "Deliver excellence with integrity", "description": "Our mission is to provide high-quality professional services built on trust and transparency.", "img_url": "/resources/static/images/mission.jpg" }');

INSERT INTO subsections (id, section_id, title, type, data) VALUES
    ('C06','B02','goals','CARD',
     '{ "title": "GOALS", "header": "Growth, quality, long-term partnerships", "description": "Our goals focus on continuous improvement and innovation.", "img_url": "/resources/static/images/goals.jpg" }');

-- Services Cards
INSERT INTO subsections (id, section_id, title, type, data) VALUES
    ('C07','B03','services','CARD',
     '{ "cards": [
         { "img_url": "/resources/static/images/service01.jpg", "header": "Feasibility Studies", "description": "We evaluate business ideas and projects." },
         { "img_url": "/resources/static/images/service02.jpg", "header": "Tax Advisory", "description": "Strategic tax planning and compliance services." },
         { "img_url": "/resources/static/images/service03.jpg", "header": "Financial Consulting", "description": "Tailored financial solutions." },
         { "img_url": "/resources/static/images/service04.jpg", "header": "Audit & Assurance", "description": "Independent audit services." },
         { "img_url": "/resources/static/images/service05.jpg", "header": "Business Advisory", "description": "Support business transformation." }
     ]}');

-- Clients Cards
INSERT INTO subsections (id, section_id, title, type, data) VALUES
    ('C08','B04','clients','CARD',
     '{ "cards": [
         { "img_url": "/resources/static/images/client01.jpg", "header": "Corporate Clients", "description": "Strategic advisory services." },
         { "img_url": "/resources/static/images/client02.jpg", "header": "SMEs", "description": "Cost-effective solutions." },
         { "img_url": "/resources/static/images/client03.jpg", "header": "Startups", "description": "From idea to execution." },
         { "img_url": "/resources/static/images/client04.jpg", "header": "Non-Profit Organizations", "description": "Governance and compliance." },
         { "img_url": "/resources/static/images/client05.jpg", "header": "International Clients", "description": "Cross-border advisory." }
     ]}');

-- Contact Info
INSERT INTO subsections (id, section_id, title, type, data) VALUES
    ('C09','B05','contact_info','INFO',
     '{ "email": "info@yourcompany.com", "address": "123 Business Street, Downtown, Cairo, Egypt", "opening_hours": "Sunday – Thursday, 9:00 AM – 5:00 PM" }');
-- SET FOREIGN_KEY_CHECKS=1;