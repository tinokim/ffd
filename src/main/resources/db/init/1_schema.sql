-- public.item_seq definition

-- DROP SEQUENCE item_seq;

CREATE SEQUENCE item_seq;


-- public.order_seq definition

-- DROP SEQUENCE order_seq;

CREATE SEQUENCE order_seq;


-- public.user_seq definition

-- DROP SEQUENCE user_seq;

CREATE SEQUENCE user_seq;

-- public."user" definition

-- Drop table

-- DROP TABLE "user";

CREATE TABLE "user" (
	"index" int8 DEFAULT nextval('user_seq'::regclass) NOT NULL,
	id varchar(255) NOT NULL,
	pw varchar(255) NOT NULL,
	"name" varchar(255) NOT NULL,
	remarks varchar(255) NOT NULL,
	address varchar(255) NOT NULL,
	phone varchar(300) NOT NULL,
	"role" varchar(255) NULL,
	created_date timestamp NOT NULL,
	last_modified_date timestamp NOT NULL,
	email varchar NULL,
	emil_chk varchar NULL,
	CONSTRAINT users_id_key UNIQUE (id),
	CONSTRAINT users_pkey PRIMARY KEY (index)
);


-- public.item definition

-- Drop table

-- DROP TABLE item;

CREATE TABLE item (
	"index" int8 DEFAULT nextval('item_seq'::regclass) NOT NULL,
	"name" varchar(255) NOT NULL,
	price int8 NOT NULL,
	stock int8 NOT NULL,
	status varchar(255) NOT NULL,
	created_date timestamp NOT NULL,
	last_modified_date timestamp NOT NULL,
	detail varchar(255) NOT NULL,
	CONSTRAINT items_pkey PRIMARY KEY (index),
	CONSTRAINT items_item_seq_foreign FOREIGN KEY ("index") REFERENCES "user"("index")
);


-- public."order" definition

-- Drop table

-- DROP TABLE "order";

CREATE TABLE "order" (
	"index" int8 DEFAULT nextval('order_seq'::regclass) NOT NULL,
	"name" varchar(255) NOT NULL,
	price int8 NOT NULL,
	stock int8 NOT NULL,
	"status" varchar(255) NOT NULL,
	user_index int8 NOT NULL,
	created_date timestamp NOT NULL,
	last_modified_date timestamp NOT NULL,
	item_index int8 NOT NULL,
	CONSTRAINT orders_pkey PRIMARY KEY (index),
	CONSTRAINT orders_item_seq_foreign FOREIGN KEY (item_index) REFERENCES item("index"),
	CONSTRAINT orders_user_seq_foreign FOREIGN KEY (user_index) REFERENCES "user"("index")
);

CREATE SEQUENCE wishlist_seq;

CREATE TABLE wishlist (
	"index" BIGINT default nextval('wishlist_seq'::regclass) NOT NULL,
	"user_index" BIGINT NOT NULL,
	"item_index" BIGINT NOT NULL,
	"name" VARCHAR(255) NOT NULL,
	price BIGINT NOT NULL,
	stock BIGINT NOT NULL,
	status VARCHAR(255) NOT NULL,
	created_date TIMESTAMP NOT NULL,
	last_modified_date TIMESTAMP NOT NULL,
	detail VARCHAR(255) NOT NULL,
	CONSTRAINT wishlist_pkey PRIMARY KEY ("index"),
	CONSTRAINT users_wishlist_user_index_foreign FOREIGN KEY ("user_index") REFERENCES "user"("index"),
	CONSTRAINT items_wishlist_item_index_foreign FOREIGN KEY ("item_index") REFERENCES "item"("index")
);