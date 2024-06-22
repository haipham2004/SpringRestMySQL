-- create table users(
-- username varchar(50),
-- password varchar(50),
-- enabled tinyint
-- );

-- create table authorities(
-- username varchar(50),
-- authority varchar(50)
-- )

CREATE TABLE Account(
ma varchar(50) primary key,
passwords varchar(200),
enableds Tinyint
);

CREATE TABLE Roles (
    ma VARCHAR(50) NOT NULL,
    authoritys VARCHAR(50) NOT NULL,
    UNIQUE(ma, authoritys),
    CONSTRAINT FK_RO_AC FOREIGN KEY (ma) REFERENCES Account(ma)
);
INSERT INTO  Account VALUES
('HaiPham1','{bcrypt}$2a$12$JeHwRoeRh71611Emnp.4le8m8FdIAnM0c0./JM1HucQnmiRAGoV9O',1),
('HaiPham2','{bcrypt}$2a$12$JThck5ibX.QJMZ5QQiBd9eWvAMNhhmAS5qusWQx3F8h1VcDfK9FnW',1),
('HaiPham3','{bcrypt}$2a$12$k2X02LpfozRSvuIqgnv6.ekPoi0PxLZImaIgRmksYpdnY00CfLlIS',1);
INSERT INTO  Roles VALUES
('HaiPham1','ROLE_ADMIN'),
('HaiPham2','ROLE_MANAGE'),
('HaiPham3','ROLE_TEACHER'),
('HaiPham3','ROLE_MANAGE');