CREATE TABLE consultas (
                           id BIGSERIAL NOT NULL PRIMARY KEY,
                           medico_id BIGINT NOT NULL REFERENCES medicos(id),
                           paciente_id BIGINT NOT NULL REFERENCES pacientes(id),
                           data TIMESTAMP NOT NULL
);