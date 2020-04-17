CREATE TABLE invoice(
    id serial primary key,
    sent_by int not null references professor(id),
    doc_url varchar(150) not null,
    created_at timestamp,
    updated_at timestamp
);