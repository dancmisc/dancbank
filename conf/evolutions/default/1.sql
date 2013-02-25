# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table account (
  id                        varchar(255) not null,
  account_number            varchar(255),
  balance                   double,
  name                      varchar(255),
  address                   varchar(255),
  phone                     varchar(255),
  constraint uq_account_account_number unique (account_number),
  constraint pk_account primary key (id))
;

create table transaction (
  id                        varchar(255) not null,
  transaction_type          varchar(255),
  reference                 varchar(255),
  amount                    double,
  account_number            varchar(255),
  date                      date,
  constraint pk_transaction primary key (id))
;

create sequence account_seq;

create sequence transaction_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists account;

drop table if exists transaction;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists account_seq;

drop sequence if exists transaction_seq;

