-- Table: "Book"

-- DROP TABLE "Book";

CREATE TABLE "Book"
(
  "ISBN" character varying(255) NOT NULL,
  "Title" character varying(255) NOT NULL,
  "Description" text,
  "DateOfPublication" date,
  "ImageURL" character varying(200),
  "Price" numeric(15,2),
  "AuthorID" integer NOT NULL,
  CONSTRAINT "Book_pkey" PRIMARY KEY ("ISBN" ),
  CONSTRAINT author_id_fkey FOREIGN KEY ("AuthorID")
      REFERENCES "Author" ("ID") MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE CASCADE
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "Book"
  OWNER TO bookstore;
COMMENT ON TABLE "Book"
  IS 'Table describe book entity';

-- Index: book_dateofpub_idx

-- DROP INDEX book_dateofpub_idx;

CREATE INDEX book_dateofpub_idx
  ON "Book"
  USING btree
  ("DateOfPublication" );

-- Index: book_title_idx

-- DROP INDEX book_title_idx;

CREATE INDEX book_title_idx
  ON "Book"
  USING btree
  ("Title" COLLATE pg_catalog."default" );

-- Index: fki_author_id_fkey

-- DROP INDEX fki_author_id_fkey;

CREATE INDEX fki_author_id_fkey
  ON "Book"
  USING btree
  ("AuthorID" );