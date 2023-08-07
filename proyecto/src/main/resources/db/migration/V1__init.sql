CREATE TABLE IF NOT EXISTS classrooms (

id SERIAL,
description VARCHAR(30) NOT NULL,
teacher VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);