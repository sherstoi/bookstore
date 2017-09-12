-- Table: "Author"

-- DROP TABLE "Author";

CREATE TABLE "Author"
(
  "ID" integer NOT NULL, -- Author ID
  "Name" character varying(255) NOT NULL,
  CONSTRAINT "Author_pkey" PRIMARY KEY ("ID" )
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "Author"
  OWNER TO bookstore;
COMMENT ON TABLE "Author"
  IS 'Descriptions of books authors';
COMMENT ON COLUMN "Author"."ID" IS 'Author ID';


-- Index: auhtor_name_idx

-- DROP INDEX auhtor_name_idx;

CREATE INDEX auhtor_name_idx
  ON "Author"
  USING btree
  ("Name" COLLATE pg_catalog."default" );

