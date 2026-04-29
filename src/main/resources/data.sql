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
     '{ "cards": [
         { "word": "Financial" },
         { "word": "Advisors" },
         { "word": "Chartered" },
         { "word": "Accountants" },
         { "word": "Tax" },
         { "word": "Experts" }
     ] }');
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
     '{"cards":[
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

INSERT INTO subsections (id, section_id, title, type, data) VALUES
    ('C04','B02','mission_vision_values','CARD',
     '{
       "cards": [
         {
           "title": "VISION",
           "header": "Innovative, Empowering, Sustainable, Inclusive",
           "description": "Our vision is to become a trusted leader in financial advisory services.",
           "image_url": "/resources/static/images/vision.jpg"
         },
         {
           "title": "MISSION",
           "header": "Deliver Excellence with Integrity",
           "description": "Our mission is to provide high-quality professional services built on trust.",
           "image_url": "/resources/static/images/mission.jpg"
         },
         {
           "title": "VALUES",
           "header": "Integrity, Professionalism, Commitment, Innovation",
           "description": "Our values guide everything we do and shape our relationship with clients.",
           "image_url": "/resources/static/images/values.jpg"
         },
         {
           "title": "GOALS",
           "header": "Growth, Quality, Long-Term Partnerships",
           "description": "Our goals focus on continuous improvement and sustainable business growth.",
           "image_url": "/resources/static/images/goals.jpg"
         }
       ]
     }');

-- Services Cards
INSERT INTO subsections (id, section_id, title, type, data) VALUES
    ('C08','B03','services','CARD',
     '{ "cards": [
         { "image_url": "/resources/static/images/service01.jpg", "header": "Feasibility Studies", "description": "We evaluate business ideas and projects." },
         { "image_url": "/resources/static/images/service02.jpg", "header": "Tax Advisory", "description": "Strategic tax planning and compliance services." },
         { "image_url": "/resources/static/images/service03.jpg", "header": "Financial Consulting", "description": "Tailored financial solutions." },
         { "image_url": "/resources/static/images/service04.jpg", "header": "Audit & Assurance", "description": "Independent audit services." },
         { "image_url": "/resources/static/images/service05.jpg", "header": "Business Advisory", "description": "Support business transformation." }
     ]}');

-- Clients Cards
INSERT INTO subsections (id, section_id, title, type, data) VALUES
    ('C09','B04','clients','CARD',
     '{ "cards": [
         { "image_url": "/resources/static/images/client01.jpg", "header": "Corporate Clients", "description": "Strategic advisory services." },
         { "image_url": "/resources/static/images/client02.jpg", "header": "SMEs", "description": "Cost-effective solutions." },
         { "image_url": "/resources/static/images/client03.jpg", "header": "Startups", "description": "From idea to execution." },
         { "image_url": "/resources/static/images/client04.jpg", "header": "Non-Profit Organizations", "description": "Governance and compliance." },
         { "image_url": "/resources/static/images/client05.jpg", "header": "International Clients", "description": "Cross-border advisory." }
     ]}');

-- Contact Info
INSERT INTO subsections (id, section_id, title, type, data) VALUES
    ('C10','B05','contact_info','INFO',
     '{ "cards": [
         {
             "email": "info@yourcompany.com",
             "address": "123 Business Street, Downtown, Cairo, Egypt",
             "opening_hours": "Sunday – Thursday, 9:00 AM – 5:00 PM",
             "phone": "+1234567890"
         }
     ] }');
    -- SET FOREIGN_KEY_CHECKS=1;