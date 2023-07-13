create table if not exists storage(
                        id bigint auto_increment primary key,
                        name varchar(255) not null,
                        address varchar(255),
                        capacity int not null
);

create table if not exists item (
                      id bigint auto_increment primary key,
                      name varchar(255) not null,
                      code varchar(255) not null,
                      weight int,
                      dueTo date,
                      storage_id bigint,
                      foreign key (storage_id) references storage(id)
);