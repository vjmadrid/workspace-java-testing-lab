CREATE TABLE usermessage (
  id BIGSERIAL PRIMARY KEY,
  description VARCHAR(255) NOT NULL,
  vip BOOLEAN NOT NULL,
  creationdate TIMESTAMP NOT NULL,
  deleteddate TIMESTAMP
)