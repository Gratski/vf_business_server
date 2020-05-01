ALTER TABLE access_code ADD COLUMN confirmed bool default false;
CREATE TABLE IF NOT EXISTS admin_user(
    id integer primary key not null references app_user(id)
);