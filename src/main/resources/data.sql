DELETE FROM Pages;
DELETE FROM Sections;
DELETE FROM Sub_sections;

INSERT INTO Pages VALUES ("A01",
                          "Home",
                          "home_page");

INSERT INTO Pages VALUES ("A02",
                          "About",
                          "about_page");

INSERT INTO Pages VALUES ("A03",
                          "Services",
                          "Services_page");

INSERT INTO Pages VALUES ("A04",
                          "Contact",
                          "contact_page");

INSERT INTO Pages VALUES ("A05",
                          "Clients",
                          "Clients_page");

-- Adding Landing Page to the Home Page:
INSERT INTO Sections VALUES ("B01",
                             "A01",
                             "landing_page",
                             "We Can Serve You in",
                             "A professional team of financial advisors, chartered accountants, and tax experts ensures that your business reaches the highest levels of success"
                             );

-- Adding Words of the Header:
INSERT INTO Sub_sections VALUES ("C01",
                                 "B01",
                                 "header_chosen_words",
                                 "WORDS",
                                 '{"words":'["Financial","Advisors","Chartered","Accountants","Tax","Experts"]'}'
                                 );

-- Adding Cards of the landing page:
INSERT INTO Sub_sections (id, section_id, title, type, data) VALUES (
             'C02',
             'B01',
             'cards',
             'CARD',
             '{
                 "cards": [
                     {
                         "title": "card01",
                         "image_url": "/sources/static/images/card01.jpg",
                         "header": "Feasibility Study",
                         "description": "We will conduct a feasibility study to determine the feasibility of your business."
                     },
                     {
                         "title": "card02",
                         "image_url": "/sources/static/images/card02.jpg",
                         "header": "Taxes",
                         "description": "Let us do it"
                     }
                 ]
             }'
         );

-- Adding Bank Logos:
INSERT INTO Sub_sections (id, section_id, title, type, data) VALUES (
             'C03',
             'B01',
             'bank_logos',
             'IMG',
             '{
                 "bank_misr": "/sources/static/images/bank_misr.png",
                 "bank_ahly": "/sources/static/images/bank_ahly.png",
                 "bank_mizrahi": "/sources/static/images/bank_mizrahi.png"
             }'
         );

-- Adding the Mission, Vision and Values to the Main Page:
INSERT INTO Sections (id, page_id, title) VALUES (
                                                  "B02",
                                                  "A01",
                                                  "mission_vision_values",
                             );

-- Adding the Vision:
INSERT INTO Sub_sections (id, section_id, title, type, data) VALUES (
                                                                        'C04',
                                                                        'B02',
                                                                        'vision',
                                                                        'CARD',
                                                                        '{
                                                                            "title": "VISION",
                                                                            "header": "Innovative, empowering, sustainable, inclusive",
                                                                            "description": "Our strong belief in our profession inspires us to build a diverse and robust organization. We strive to create a competent and creative team to achieve exceptional success with both local and international clients, making us their top choice.",
                                                                            "img_url": "/resources/static/images/vision.jpg"
                                                                        }'
                                                                    );

-- Adding the Mission:
INSERT INTO Sub_sections (id, section_id, title, type, data) VALUES (
                                                                        'C05',
                                                                        'B02',
                                                                        'mission',
                                                                        'CARD',
                                                                        '{
                                                                            "title": "MISSION",
                                                                            "header": "Deliver excellence with integrity",
                                                                            "description": "Our mission is to provide high-quality professional services built on trust, transparency, and deep expertise, helping our clients grow sustainably and confidently in a dynamic business environment.",
                                                                            "img_url": "/resources/static/images/mission.jpg"
                                                                        }'
                                                                    );

-- Adding the Goals:
INSERT INTO Sub_sections (id, section_id, title, type, data) VALUES (
                                                                        'C06',
                                                                        'B02',
                                                                        'goals',
                                                                        'CARD',
                                                                        '{
                                                                            "title": "GOALS",
                                                                            "header": "Growth, quality, long-term partnerships",
                                                                            "description": "Our goals focus on continuous improvement, developing our people, embracing innovation, and building long-term partnerships that create measurable value for our clients and stakeholders.",
                                                                            "img_url": "/resources/static/images/goals.jpg"
                                                                        }'
                                                                    );

-- Adding the Services Part:
INSERT INTO Sections (id, page_id, title) VALUES (
                                                  "B03",
                                                  "A01",
                                                  "services_part"
                                                 );

-- Adding Services cards:
INSERT INTO Sub_sections (id, section_id, title, type, data) VALUES (
                                                                        'C07',
                                                                        'B03',
                                                                        'services',
                                                                        'CARD',
                                                                        '{
                                                                            "cards": [
                                                                                {
                                                                                    "img_url": "/resources/static/images/service01.jpg",
                                                                                    "header": "Feasibility Studies",
                                                                                    "description": "We evaluate business ideas and projects by analyzing market demand, financial viability, and operational risks to support informed decision-making."
                                                                                },
                                                                                {
                                                                                    "img_url": "/resources/static/images/service02.jpg",
                                                                                    "header": "Tax Advisory",
                                                                                    "description": "Our tax experts provide strategic planning, compliance, and optimization services to help businesses meet regulatory requirements efficiently."
                                                                                },
                                                                                {
                                                                                    "img_url": "/resources/static/images/service03.jpg",
                                                                                    "header": "Financial Consulting",
                                                                                    "description": "We deliver tailored financial solutions, performance analysis, and growth strategies designed to strengthen your organization’s financial position."
                                                                                },
                                                                                {
                                                                                    "img_url": "/resources/static/images/service04.jpg",
                                                                                    "header": "Audit & Assurance",
                                                                                    "description": "We offer independent audit and assurance services that enhance transparency, credibility, and stakeholder confidence."
                                                                                },
                                                                                {
                                                                                    "img_url": "/resources/static/images/service05.jpg",
                                                                                    "header": "Business Advisory",
                                                                                    "description": "Our advisors support business transformation, risk management, and long-term planning to drive sustainable success."
                                                                                }
                                                                            ]
                                                                        }'
                                                                    );

-- Adding Clients Part:
INSERT INTO Sections (id, page_id, title) VALUES (
                                                  "B04",
                                                  "A01",
                                                  "clients_part"
                                                 );

-- Adding Clients cards:
INSERT INTO Sub_sections (id, section_id, title, type, data) VALUES (
                                                                        'C08',
                                                                        'B03',
                                                                        'clients',
                                                                        'CARD',
                                                                        '{
                                                                            "cards": [
                                                                                {
                                                                                    "img_url": "/resources/static/images/client01.jpg",
                                                                                    "header": "Corporate Clients",
                                                                                    "description": "We partner with corporations across various industries, providing strategic financial and advisory services tailored to complex business needs."
                                                                                },
                                                                                {
                                                                                    "img_url": "/resources/static/images/client02.jpg",
                                                                                    "header": "Small & Medium Enterprises",
                                                                                    "description": "We support SMEs with practical, cost-effective solutions that help them grow, optimize operations, and remain competitive."
                                                                                },
                                                                                {
                                                                                    "img_url": "/resources/static/images/client03.jpg",
                                                                                    "header": "Startups",
                                                                                    "description": "We guide startups from idea to execution, offering financial planning, feasibility studies, and advisory services for sustainable growth."
                                                                                },
                                                                                {
                                                                                    "img_url": "/resources/static/images/client04.jpg",
                                                                                    "header": "Non-Profit Organizations",
                                                                                    "description": "We assist non-profits with governance, compliance, and financial transparency to help them maximize their social impact."
                                                                                },
                                                                                {
                                                                                    "img_url": "/resources/static/images/client05.jpg",
                                                                                    "header": "International Clients",
                                                                                    "description": "We work with international clients entering local markets, providing cross-border advisory, tax, and regulatory support."
                                                                                }
                                                                            ]
                                                                        }'
                                                                    );

-- Adding Contact Part:
INSERT INTO Sections (id, page_id, title) VALUES (
                                                  "B05",
                                                  "A01",
                                                  "contact_part"
                                                 );

-- Adding Contact Us info
INSERT INTO Sub_sections (id, section_id, title, type, data) VALUES (
                                                                        'C10',
                                                                        'B04',
                                                                        'contact_info',
                                                                        'INFO',
                                                                        '{
                                                                            "email": "info@yourcompany.com",
                                                                            "address": "123 Business Street, Downtown, Cairo, Egypt",
                                                                            "opening_hours": "Sunday – Thursday, 9:00 AM – 5:00 PM"
                                                                        }'
                                                                    );