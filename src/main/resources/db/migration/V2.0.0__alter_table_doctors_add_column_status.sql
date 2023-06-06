ALTER TABLE doctors ADD COLUMN status BOOLEAN;

UPDATE doctors SET status = TRUE;