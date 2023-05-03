ALTER TABLE medicos ADD COLUMN status BOOLEAN;

UPDATE medicos SET status = TRUE;