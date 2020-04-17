CREATE TABLE wallet (
    id serial primary key,
    belongs_to int not null references app_user(id),
    balance real not null,
    currency varchar(20),
    created_at timestamp,
    updated_at timestamp
);

CREATE TABLE wallet_transaction(
    id serial primary key,
    wallet_id int not null references wallet(id),
    amount real not null,
    direction varchar(3) not null,
    transaction_type varchar(25) not null,
    created_at timestamp,
    updated_at timestamp
);

CREATE TABLE comission (
    id serial primary key,
    from_number int not null,
    until_number int not null,
    amount real not null,
    created_at timestamp,
    updated_at timestamp
);

WITH add_base_commission AS (
    insert into comission(from_number, until_number, amount, created_at, updated_at)
    values(0, 4, 0.0, current_timestamp, current_timestamp)
    RETURNING *
), add_minimum_commission AS (
    insert into comission(from_number, until_number, amount, created_at, updated_at)
    values(5, 9, 1.0, current_timestamp, current_timestamp)
    RETURNING *
), add_medium_commission AS (
    insert into comission(from_number, until_number, amount, created_at, updated_at)
    values(10, 24, 2.5, current_timestamp, current_timestamp)
    RETURNING *
), add_maximum_commission AS (
    insert into comission(from_number, until_number, amount, created_at, updated_at)
    values(25, 50, 5.0, current_timestamp, current_timestamp)
    RETURNING *
) select * from add_maximum_commission;