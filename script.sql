CREATE TABLE providers (
    id_provider int NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),
    created DATE,
    id_client int,
    PRIMARY KEY (id_provider)
);

INSERT INTO providers (name, created, id_client) VALUES ('Coca-cola', '2023-1-9', 5);
INSERT INTO providers (name, created, id_client) VALUES ('Pepsi', '2022-11-7', 5);
INSERT INTO providers (name, created, id_client) VALUES ('Redbull', '2023-2-28', 6);
INSERT INTO providers (name, created, id_client) VALUES ('Fanta', '2023-4-14', 7);
INSERT INTO providers (name, created, id_client) VALUES ('Casera', '2023-1-13', 8);
INSERT INTO providers (name, created, id_client) VALUES ('Trina', '2022-12-21', 6);