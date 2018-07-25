create database if not exists product_db;
use product_db;

drop table if exists Produit;

create table Produit (
   numero integer primary key auto_increment ,
   label varchar(64),
   prix double
);

insert into Produit(numero, label, prix) values (1, "cahier" , 2.56);
insert into Produit(numero, label, prix) values (2, "stylo" , 1.58);
insert into Produit(numero, label, prix) values (3, "classeur" , 3.26);

select * from Produit;