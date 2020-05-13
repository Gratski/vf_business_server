INSERT INTO public.currency
(designation, symbol)
VALUES('Euro', '€');

INSERT INTO public.currency
(designation, symbol)
VALUES('US Dollar', '$');

INSERT INTO public.currency
(designation, symbol)
VALUES('AU Dollar', '$');

INSERT INTO public.currency
(designation, symbol)
VALUES('UK Pounds', '£');

INSERT INTO public.currency
(designation, symbol)
VALUES('Real BR', 'Real');

ALTER TABLE wallet DROP COLUMN currency;
ALTER TABLE wallet ADD COLUMN currency_id int references currency(id);



