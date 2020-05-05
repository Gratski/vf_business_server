CREATE TABLE ID NOT EXISTS payment_method(
    id serial primary key,
    wallet_id int not null references wallet(id)
    payment_email varchar(150) not null,
    is_default bool default false
);