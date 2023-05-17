CREATE TABLE usuarios (
    id SERIAL NOT NULL,
    login VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,

    CONSTRAINT pk_id_usuarios PRIMARY KEY (id)
)