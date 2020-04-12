ALTER TABLE discipline ADD COLUMN equipment varchar(255) not null default '';
ALTER TABLE discipline ADD COLUMN goal varchar(255) not null default '';
ALTER TABLE discipline ADD COLUMN calories real not null default 0;

