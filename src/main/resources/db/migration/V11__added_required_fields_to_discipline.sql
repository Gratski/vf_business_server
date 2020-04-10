ALTER TABLE class ADD COLUMN scheduled_to timestamp not null;
ALTER TABLE class ADD COLUMN scheduled_to_day timestamp not null;
ALTER TABLE class ADD COLUMN status varchar(25) not null;
ALTER TABLE class ADD COLUMN reviews_score real not null;