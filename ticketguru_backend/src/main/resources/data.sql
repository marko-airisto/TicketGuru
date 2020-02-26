INSERT INTO USER_GROUPS
VALUES
    (1, 'user');
INSERT INTO USER_GROUPS
VALUES
    (2, 'admin');
INSERT INTO USER_GROUPS
VALUES
    (3, 'boss');

INSERT INTO USERS
VALUES
    (1, 'pepe', '$2a$10$/..0qbQN09s20ZVao53j0..hr2dgkS52zVn68b0ZlGcZBzczkoH.y', 1);
INSERT INTO USERS
VALUES
    (2, 'john', '$2a$10$K.vSuwrxuG7arNO7nGkAyuPs0Op4JCDxd7hdhiwpF/egYpePZWYay', 2);
INSERT INTO USERS
VALUES
    (3, 'kuningas', '$2a$10$tG3a9iRmIpPH3Hkj/EwLYetL8i/A6jBJIF4OQZS.UPV14sOmQB9Nq', 3);

INSERT INTO EVENT_TYPES
VALUES
    (1, 'Teatteri', 'Silkkaa teatteria'
);

INSERT INTO AGE_LIMITS
VALUES
    (1, 'K7', 'Tapahtuma kielletty alle 7-vuotiailta');

INSERT INTO POSTCODES
VALUES
    (1, 00002, 'Helsinki');
INSERT INTO POSTCODES
VALUES
    (2, 00002, 'Helsinki');
INSERT INTO POSTCODES
VALUES
    (3, 00100, 'Helsinki');
INSERT INTO POSTCODES
VALUES
    (4, 00102, 'Helsinki');
INSERT INTO POSTCODES
VALUES
    (5, 00120, 'Helsinki');
INSERT INTO POSTCODES
VALUES
    (6, 00130, 'Helsinki');

INSERT INTO VENUES
VALUES
    (1, 'Helsingin Teatteri', 'Kekkosenkatu 3', '09 1234566', 'teatteri@teatteri.fi', 'www.helsinginteatteri.com', 'John Wayne', 3);

INSERT INTO EVENT_ORGANIZERS
VALUES
    (1, 'GREAT EVENTS OY', 'Tapahtumakatu 16 a 78', '09 7865566', 'great@events.fi', 'www.greatevents.com', 'Texas Ted', 5);

INSERT INTO EVENTS
VALUES
    (
        1, '2020-03-01 20:0:00', 'Ihan pirun kovat bileet', 'Mika koodaa ja muut juopottelee. Kannattaa tulla kauempaakin', 1000, 1, 1, 1, 1
    );

INSERT INTO TICKET_TYPES
VALUES
    (
        1, 'Aikuisten lippu'
    );

INSERT INTO EVENT_TICKETS
VALUES
    (
        1, 55, 100, 1, 1
    )