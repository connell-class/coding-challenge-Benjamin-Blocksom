CREATE OR REPLACE FUNCTION trigger_set_timestamp()
RETURNS TRIGGER AS $$
BEGIN
  NEW.updated_at = NOW();
  RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TABLE grocerylists (
  list_id SERIAL NOT NULL PRIMARY KEY,
  list_name TEXT,
  created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
  updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
  completed_at TIMESTAMPTZ
);

create table groceryskus (
	sku_name text unique primary key,
	category text
);

CREATE TABLE grocerycart (
  list_id integer,
  item_name TEXT,
  quantity integer,
  primary key (list_id, item_name),
  foreign key (item_name) references groceryskus (sku_name),
  foreign key (list_id) references grocerylists (list_id)
);


CREATE TRIGGER set_timestamp
BEFORE UPDATE ON grocerylists
FOR EACH ROW
EXECUTE PROCEDURE trigger_set_timestamp();


-- Dummy data
INSERT INTO grocerylists (list_name) 
VALUES ('my list'), ('your list'), ('store list')  RETURNING *;

insert into groceryskus (sku_name, category)
values ('bananas', 'food'), ('oranges', 'food'), ('video tape rewinder', 'electronics'), ('skivies','clothing');

insert into grocerycart (list_id, item_name, quantity)
values (1, 'bananas', 2), (1, 'video tape rewinder', 1), (2, 'oranges', 1), (2, 'skivies', 3),
(3, 'bananas', 6), (3, 'oranges', 6);

-- Queries

-- Show all
select * from grocerylists;
select * from grocerycart;
select * from groceryskus;


