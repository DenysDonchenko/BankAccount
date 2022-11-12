create database bank_account;
create schema com;

drop table com."user";
drop table com."transaction";
drop table com."account";

create table com."user"
(
    id          uuid DEFAULT gen_random_uuid() PRIMARY KEY,
    first_name  character varying(50) not null,
    second_name character varying(50) not null,
    email       character varying(70) not null,
    phone       character varying(13) not null
);

create table com."account"
(
    id           uuid DEFAULT gen_random_uuid() PRIMARY KEY,
    id_user      uuid                  not null references com."user" (id),
    number       character varying(20) not null,
    total_amount decimal               not null
);

create table com."transaction"
(
    id          uuid DEFAULT gen_random_uuid() PRIMARY KEY,
    id_sender   uuid                   not null references com."account" (id),
    id_receiver uuid                   not null references com."account" (id),
    appointment character varying(100) not null,
    amount      decimal                not null,
    created_at timestamp              not null

);
