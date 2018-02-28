drop table if exists BZKATEGORIJA;

drop table if exists BZPRODAJA;

drop table if exists BZPRODAVAC;

drop table if exists BZVOZILO;

/*==============================================================*/
/* Table: BZKATEGORIJA                                            */
/*==============================================================*/
create table BZKATEGORIJA
(
   IDKATEGORIJE         int not null AUTO_INCREMENT,
   NAZIVKATEGORIJE      varchar(254),
   primary key (IDKATEGORIJE)
);

/*==============================================================*/
/* Table: BZPRODAJA                                               */
/*==============================================================*/
create table BZPRODAJA
(
   IDPRODAJE            int not null AUTO_INCREMENT,
   IDPRODAVCA           int not null,
   IDVOZILA             int not null,
   DATUM                datetime,
   primary key (IDPRODAJE)
);

/*==============================================================*/
/* Table: BZPRODAVAC                                              */
/*==============================================================*/
create table BZPRODAVAC
(
   IDPRODAVCA           int not null AUTO_INCREMENT,
   IME                  varchar(254),
   PREZIME              varchar(254),
   ADRESA               varchar(254),
   BROJTELEFONA         int,
   USERNAME             varchar(254),
   PASSWORD             varchar(254),
   primary key (IDPRODAVCA)
);

/*==============================================================*/
/* Table: BZVOZILO                                                */
/*==============================================================*/
create table BZVOZILO
(
   IDVOZILA             int not null AUTO_INCREMENT,
   IDKATEGORIJE         int not null,
   MARKA                varchar(254),
   MODEL                varchar(254),
   CENA                 int,
   GODINAPROIZVODNJE    int,
   BOJA                 varchar(254),
   primary key (IDVOZILA)
);

alter table BZPRODAJA add constraint FK_RELATIONSHIP_2BZ foreign key (IDVOZILA)
      references BZVOZILO (IDVOZILA) on delete restrict on update restrict;

alter table BZPRODAJA add constraint FK_RELATIONSHIP_4BZ foreign key (IDPRODAVCA)
      references BZPRODAVAC (IDPRODAVCA) on delete restrict on update restrict;

alter table BZVOZILO add constraint FK_RELATIONSHIP_1BZ foreign key (IDKATEGORIJE)
      references BZKATEGORIJA (IDKATEGORIJE) on delete restrict on update restrict;