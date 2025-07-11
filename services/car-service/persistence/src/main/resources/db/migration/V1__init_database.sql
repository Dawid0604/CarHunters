create sequence advertisement_sequence start with 1 increment by 50;
create sequence brand_sequence start with 1 increment by 50;
create sequence car_sequence start with 1 increment by 50;
create sequence location_sequence start with 1 increment by 50;

create table brands(
    id bigint default nextval('brand_sequence') not null,
    public_id varchar(12) not null unique,
    name varchar(32),
    last_modification_date timestamp,
    created_date timestamp not null,

    primary key (id)
);

create table cars(
    id bigint default nextval('brand_sequence') not null,
    public_id varchar(12) not null unique,
    name varchar(64),
    brand_id bigint not null,
    last_modification_date timestamp,
    created_date timestamp not null,

    primary key (id),
    constraint fk_brand foreign key (brand_id) references brands(id)
);

create table locations(
    id bigint default nextval('location_sequence') not null,
    public_id varchar(12) not null unique,
    parent_id bigint,
    name varchar(128),
    full_name varchar(256),
    type varchar(20),
    last_modification_date timestamp,
    created_date timestamp not null,

    primary key (id),
    constraint fk_parent foreign key (parent_id) references locations(id)
);

create table location_closures(
    ancestor_id bigint not null,
    descendant_id bigint not null,
    depth int not null,

    primary key (ancestor_id, descendant_id),
    constraint fk_ancestor foreign key (ancestor_id) references locations(id),
    constraint fk_descendant foreign key (descendant_id) references locations(id)
);

create table advertisements(
    id bigint default nextval('advertisement_sequence') not null,
    public_id varchar(12) not null unique,
    location_id int not null,
    car_id bigint not null,
    price numeric(10, 2),
    mileage int,
    engine_capacity int,
    engine_power int,
    england_type boolean default false,
    title text not null,
    description text not null,
    search_vector TSVECTOR,
    production_year int,
    owner_id bigint not null,
    vin varchar(17) not null,
    petrol_type varchar(20),
    condition varchar(20),
    gearbox_type varchar(20),
    body_type varchar(20),
    last_modification_date timestamp,
    created_date timestamp not null,

    primary key (id),
    constraint fk_car foreign key (car_id) references cars(id),
    constraint fk_location foreign key (location_id) references locations(id)
);

CREATE TRIGGER advertisements_search_vector_update
       BEFORE INSERT OR UPDATE ON advertisements
       FOR EACH ROW
       EXECUTE FUNCTION tsvector_update_trigger(
            search_vector, 'pg_catalog.english',
            title, description
       );

CREATE INDEX idx_advertisements_search_vector
    ON advertisements USING GIN (search_vector);