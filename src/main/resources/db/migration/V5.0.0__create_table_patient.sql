CREATE TABLE patient (

    id SERIAL NOT NULL,
    name VARCHAR(200) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    cpf VARCHAR (11) NOT NULL UNIQUE,
    public_place VARCHAR(255) NOT NULL,
    neighborhood VARCHAR(100) NOT NULL,
    cep VARCHAR(9) NOT NULL,
    complement VARCHAR(100),
    number VARCHAR(20),
    uf CHAR(2) NOT NULL,
    city VARCHAR(100) NOT NULL,
    telephone varchar(20) not null,
    status BOOLEAN,

    CONSTRAINT pk_id_patient PRIMARY KEY (id)
);