ALTER TABLE professor ADD COLUMN IF NOT EXISTS nif varchar(255) not null;

CREATE TABLE IF NOT EXISTS picture(
    id serial primary key,
	designation varchar(255) not null,
    extension varchar(10) not null,
	created_at timestamp,
	updated_at timestamp
);

ALTER TABLE category ADD COLUMN IF NOT EXISTS picture_id int references picture(id);
ALTER TABLE category ADD COLUMN IF NOT EXISTS icon varchar(50);
ALTER TABLE category ADD COLUMN IF NOT EXISTS created_at timestamp;
ALTER TABLE category ADD COLUMN IF NOT EXISTS updated_at timestamp;

CREATE TABLE IF NOT EXISTS discipline_repetition (
    id serial primary key,
    discipline_id int not null references discipline(id),
    professor_id int not null references professor(id),
    starts_at timestamp,
    ends_at timestamp,
    enabled boolean default false,
    approved boolean default false,
    created_at timestamp,
	updated_at timestamp
);

ALTER TABLE "class" ADD COLUMN IF NOT EXISTS started_at timestamp not null;
ALTER TABLE "class" ADD COLUMN IF NOT EXISTS ended_at timestamp;
ALTER TABLE "class" ADD COLUMN IF NOT EXISTS created_at timestamp;
ALTER TABLE "class" ADD COLUMN IF NOT EXISTS updated_at timestamp;

ALTER TABLE discipline ADD COLUMN IF NOT EXISTS enabled boolean default false;

ALTER TABLE class_attendant ADD COLUMN IF NOT EXISTS updated_at timestamp;
ALTER TABLE class_attendant ADD COLUMN IF NOT EXISTS left_at timestamp;

ALTER TABLE category DROP COLUMN parent;
ALTER TABLE category ADD COLUMN IF NOT EXISTS parent_id int references category(id);