CREATE TABLE IF NOT EXISTS book (
    id         BIGSERIAL PRIMARY KEY,
    title      VARCHAR(255)   NOT NULL,
    author     VARCHAR(255)   NOT NULL,
    isbn       VARCHAR(20),
    price      NUMERIC(10, 2),
    created_at TIMESTAMPTZ    NOT NULL DEFAULT now()
);
