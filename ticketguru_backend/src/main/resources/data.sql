
-- USER GROUPS

INSERT INTO UserGroups
    (name)
VALUES
    ('user');
INSERT INTO UserGroups
    (name
    )
VALUES
    ('admin');
INSERT INTO UserGroups
    (name
    )
VALUES
    ('boss');

-- USERS

INSERT INTO Users
    (password, name, userGroup_ID, active)
VALUES
    ('$2a$10$/..0qbQN09s20ZVao53j0..hr2dgkS52zVn68b0ZlGcZBzczkoH.y', 'pepe', 1, 1);
INSERT INTO Users
    (password, name, userGroup_ID, active)
VALUES
    ('$2a$10$K.vSuwrxuG7arNO7nGkAyuPs0Op4JCDxd7hdhiwpF/egYpePZWYay', 'john', 2, 1);
INSERT INTO Users
    (password, name, userGroup_ID, active)
VALUES
    ('$2a$10$tG3a9iRmIpPH3Hkj/EwLYetL8i/A6jBJIF4OQZS.UPV14sOmQB9Nq', 'kuningas', 3, 1);
INSERT INTO Users
    (password, name, userGroup_ID, active)
VALUES
    ('keke', 'keke', 1, 0);


-- EVENTTYPES

INSERT INTO EventTypes
    (name, info)
VALUES
    ('Teatteri', 'Silkkaa teatteria'
);

-- AGELIMITS

INSERT INTO AgeLimits
    (name, specifier)
VALUES
    ('K7', 'Tapahtuma kielletty alle 7-vuotiailta');

INSERT INTO AgeLimits
    (name, specifier)
VALUES
    ('K13', 'Tapahtuma kielletty alle 13-vuotiailta');

-- POSTCODES

INSERT INTO Postcodes
    (postcode_ID, city, country)
VALUES
    (00002, 'Helsinki', 'Finland');
INSERT INTO Postcodes
    (postcode_ID, city, country
    )
VALUES
    (00100, 'Helsinki', 'Finland');
INSERT INTO Postcodes
    (postcode_ID, city, country
    )
VALUES
    (00130, 'Helsinki', 'Finland'
);
INSERT INTO Postcodes
    (postcode_ID, city, country
    )
VALUES
    (00140, 'Helsinki', 'Finland'
);
INSERT INTO Postcodes
    (postcode_ID, city, country
    )
VALUES
    (00150, 'Helsinki', 'Finland'
);
INSERT INTO Postcodes
    (postcode_ID, city, country
    )
VALUES
    (00160, 'Helsinki', 'Finland'
);

-- VENUES

INSERT INTO Venues
    (name, streetAddress, postcode_ID, tel, email, www, contactPerson)
VALUES
    ('Helsingin Teatteri', 'Kekkosenkatu 3', '00140', '09 1234566', 'teatteri@teatteri.fi', 'www.helsinginteatteri.com', 'John Wayne');

-- EVENTORGANIZERS

INSERT INTO EventOrganizers
    (name, streetAddress, postcode_ID, tel, email, www, contactPerson)
VALUES
    ('GREAT EVENTS OY', 'Tapahtumakatu 16 a 78', '00150', '09 7865566', 'great@events.fi', 'www.greatevents.com', 'Texas Ted');

-- EVENTS

INSERT INTO Events
    (name, eventType_ID, dateTime, eventOrganizer_ID, venue_ID, ticketCapacity, ageLimit_ID, info)
VALUES
    (
        'Koodari Kemut 2020', 1, '2020-03-01 20:0:00', 1, 1, 1500, 2, 'Mika koodaa ja muut kattelee. Kannattaa tulla kauempaakin'
    );

-- TICKETTYPES

INSERT INTO TicketTypes
    (name)
VALUES
    (
        'Aikuisten lippu'
    );
INSERT INTO TicketTypes
    (name)
VALUES
    (
        'Lasten lippu'
    );

-- TICKETSTATUSES

INSERT INTO TicketStatuses (name) VALUES ('voimassa');

-- EVENTTICKETS

INSERT INTO EventTickets
    (event_ID, ticketType_ID, ticketCount, price)
VALUES
    (
        1, 2, 1000, 20
    );

-- TICKETS

-- INSERT INTO Tickets (eventTicket_ID, ticketStatus_ID, checkSum) VALUES (1, 1, 'hbfhbvhfbvrhbgeyfgf')

-- SALEROWS

-- INSERT INTO SaleRows (ticket_ID, saleEvent_ID, discount) VALUES (1, 1, 0 );

-- SALEEVENTS

INSERT INTO SaleEvents (dateTime, user_ID) VALUES ('2020-03-03 10:0:00', 3);
