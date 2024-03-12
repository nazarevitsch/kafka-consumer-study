CREATE TABLE IF NOT EXISTS message
(
    id              SERIAL PRIMARY KEY,
    key             TEXT,
    message         INT4,
    price           INT4,
    brand           TEXT,
    state           TEXT,
    offset_count    BIGINT,
    producer_id     INT4,
    consumer_id     INT4,
    consumer_group  TEXT,
    partition_id    INT4,
    thread_id       INT4,
    creation_date   TIMESTAMP
);
