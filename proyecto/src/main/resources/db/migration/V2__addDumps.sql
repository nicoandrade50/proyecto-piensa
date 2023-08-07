CREATE TABLE IF NOT EXISTS dump (

    id SERIAL,
dump_description VARCHAR(50) NOT NULL,
    status BOOLEAN,
    maintenance VARCHAR(50) NOT NULL,
    classrooms_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (classrooms_id) REFERENCES classrooms (id)

);