CREATE TABLE medical_appointment (

    id SERIAL NOT NULL,
    id_doctor INTEGER NOT NULL,
    id_patient INTEGER NOT NULL,
    date TIMESTAMP NOT NULL,

    CONSTRAINT pk_id_medical_appointment PRIMARY KEY(id),
    CONSTRAINT fk_id_doctor FOREIGN KEY("id_doctor") REFERENCES doctors(id),
    CONSTRAINT fk_id_patient FOREIGN KEY("id_patient") REFERENCES patient(id)
)