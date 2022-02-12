CREATE TABLE book (
  id serial,
  name varchar(100),
  pages integer,
  isbn varchar(100),
  price decimal
);

INSERT INTO book
  (name, pages, isbn, price)
VALUES
  ('Ugly Love', 352, '9781471136726' , 10),
  ('It Ends With Us', 384, '9781471156267', 11),
  ('No Longer Human', 176, '9780811204811' , 17);

UPDATE
  book
SET
  price = 15
WHERE
  name = 'Ugly Love';

UPDATE
  book
SET
  price = 20;