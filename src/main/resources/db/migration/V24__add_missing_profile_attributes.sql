ALTER TABLE app_user ADD COLUMN gender varchar(20);
ALTER TABLE app_user ADD COLUMN birthday date;
ALTER TABLE app_user ADD COLUMN phone_number_country int references country(id);
ALTER TABLE app_user ADD COLUMN phone_number varchar(20);