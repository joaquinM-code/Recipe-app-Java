/*Populating H2 database on startup*/
/*Spring boot will look into the root for this file and schema.sql*/
INSERT INTO category (name) VALUES('Spanish');
INSERT INTO category (name) VALUES('Italian');
INSERT INTO category (name) VALUES('Chinese');
INSERT INTO category (name) VALUES('American');

INSERT INTO unit_of_measure(uom) VALUES('Teaspoon');
INSERT INTO unit_of_measure(uom) VALUES('Tablespoon');
INSERT INTO unit_of_measure(uom) VALUES('Cup');
INSERT INTO unit_of_measure(uom) VALUES('Pinch');
INSERT INTO unit_of_measure(uom) VALUES('Gram');
INSERT INTO unit_of_measure(uom) VALUES('Clove');
INSERT INTO unit_of_measure(uom) VALUES('Unit');