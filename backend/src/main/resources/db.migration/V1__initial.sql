create sequence if not exists hibernate_sequence;
create table if not exists public.flyway_schema_history
(
    installed_rank integer not null
        constraint flyway_schema_history_pk
            primary key,
    version varchar(50),
    description varchar(200) not null,
    type varchar(20) not null,
    script varchar(1000) not null,
    checksum integer,
    installed_by varchar(100) not null,
    installed_on timestamp default now() not null,
    execution_time integer not null,
    success boolean not null
);


create index if not exists flyway_schema_history_s_idx
    on public.flyway_schema_history (success);

create table kk_party
(
	id bigint not null
		constraint kk_party_pkey
			primary key,
	code varchar(255),
	name varchar(255)
);

alter table kk_party owner to postgres;

create table kk_person
(
	id bigint not null
		constraint kk_person_pkey
			primary key,
	first_name varchar(255),
	last_name varchar(255),
	party_id bigint
		constraint fk887uk8lq522b8k0iovolko1uy
			references kk_party
);

alter table kk_person owner to postgres;

create table kk_motion
(
	id bigint not null
		constraint kk_motion_pkey
			primary key,
	document varchar(255),
	motie_id bigint not null,
	submit_date timestamp,
	title varchar(255),
	vote_date timestamp,
	votes_total integer not null,
	co_submitter_id bigint
		constraint fk5shxk0qc5uxocflgbwlbw5m4
			references kk_person,
	first_signatory_id bigint
		constraint fkrxi9ydwqg496ca1diikbyhn91
			references kk_person,
	modified_motion_id bigint
		constraint fkqff5eqhfbx4xythvmsn1vyoh8
			references kk_motion,
	second_signatory_id bigint
		constraint fkr85jsrkpxfg0f9f3j92o03t2a
			references kk_person,
	submitter_id bigint
		constraint fk3cjjltdgtm1y9mxxdoqois1hr
			references kk_person
);

alter table kk_motion owner to postgres;

create table kk_vote
(
	id bigint not null
		constraint kk_vote_pkey
			primary key,
	result varchar(255),
	votes integer not null,
	motion_id bigint
		constraint fkk2d38pdvk97h01ta0xl06j2i9
			references kk_motion,
	party_id bigint
		constraint fkeihavds7lt37u9ts929wefxgq
			references kk_party
);

alter table kk_vote owner to postgres;

create table kk_motion_votes
(
	motion_id bigint not null
		constraint fkpeoq3g5uamivinjhloifi1hwb
			references kk_motion,
	votes_id bigint not null
		constraint uk_re6mewo6b35wwmmc0eeni5h80
			unique
		constraint fks60pu8uy2jujt4656eyib7ira
			references kk_vote
);

alter table kk_motion_votes owner to postgres;

