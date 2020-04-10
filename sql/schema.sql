create schema prevengic;

create table if not exists prevengic.chemical_profiles
(
    cp_id         serial primary key,
    cp_vla_ec_mgm double precision,
    cp_vla_ec_ppm double precision,
    cp_vla_ed_mgm double precision,
    cp_vla_ed_ppm double precision
);

alter table prevengic.chemical_profiles
    owner to admin;


create table if not exists prevengic.notes
(
    n_id          serial primary key,
    n_code        varchar(255),
    n_description varchar(1512)
);

alter table prevengic.notes
    owner to admin;


create table if not exists prevengic.chemical_profiles_notes
(
    chp_chemical_profile_id integer not null
        references prevengic.chemical_profiles,
    chp_notes_id            integer not null
        references prevengic.notes,
    constraint chemical_profiles_notes_pkey
        primary key (chp_chemical_profile_id, chp_notes_id)
);

alter table prevengic.chemical_profiles_notes
    owner to admin;


create table if not exists prevengic.warning_advices
(
    wa_id          serial primary key,
    wa_code        varchar(255),
    wa_description varchar(1512)
);

alter table prevengic.warning_advices
    owner to admin;


create table if not exists prevengic.chemical_profiles_warning_advices
(
    cpwa_chemical_profile_id integer not null
        references prevengic.chemical_profiles,
    cpwa_warning_advices_id  integer not null
        references prevengic.warning_advices,
    constraint chemical_profiles_warning_advices_pkey
        primary key (cpwa_chemical_profile_id, cpwa_warning_advices_id)
);

alter table prevengic.chemical_profiles_warning_advices
    owner to admin;


create table if not exists prevengic.compounds
(
    c_id                  serial primary key,
    c_name                varchar(255),
    c_ncas                varchar(255),
    c_nce                 varchar(255),
    c_url                 varchar(255),
    c_chemical_profile_id integer
        references prevengic.chemical_profiles
);

alter table prevengic.compounds
    owner to admin;
