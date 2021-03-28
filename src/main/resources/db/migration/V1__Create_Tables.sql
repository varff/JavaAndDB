create table avtoowners
(
    id          serial
        constraint avto
            primary key,
    surname     text,
    owner_name  text,
    middle_name text,
    tel_number  text,
    address     text,
    mark        text,
    avto_number text,
    teh_number  text,
    avto_cost   money,
    avto_year   int
);
insert into avtoowners (surname, owner_name, middle_name, tel_number, address, mark, avto_number, teh_number,avto_cost,avto_year)
values ('Варфоломеев', 'Алексей', 'Сергеевич', '+375296666666', 'Октябрьская 10', 'Жигули', '1234AB-7', 'AICI1234567891234',10000,1985);

insert into avtoowners (surname, owner_name, middle_name, tel_number, address, mark, avto_number, teh_number,avto_cost,avto_year)
values ('Ясинецкий', 'Алексей', 'Вячеславович', '+375298888888', 'Зеленая 3', 'Москвич', '1235AB-7', 'AICI0000000000001',10000,1980);

insert into avtoowners (surname, owner_name, middle_name, tel_number, address, mark, avto_number, teh_number,avto_cost,avto_year)
values ('Наумов', 'Даниил', 'Дмитриевич', '+375291111111', 'Веселая 8', 'Волга', '1845AB-7', 'AICI27437823423874238',15000,1980);

insert into avtoowners (surname, owner_name, middle_name, tel_number, address, mark, avto_number, teh_number,avto_cost,avto_year)
values ('Чехов', 'Антон', 'Павлович', '+375293333333', 'Каштанкина 4', 'Audi', '1860AB-7', 'AICI27437823423877563',15000,2017);

insert into avtoowners (surname, owner_name, middle_name, tel_number, address, mark, avto_number, teh_number,avto_cost,avto_year)
values ('Берия', 'Лаврентий', 'Павлович', '+375292222222', 'Расстрельная 5', 'Черный воронок', '1953AB-7', 'AICI27437823423097563',14000,2017);
ALTER TABLE avtoowners
    ADD vendor_id int;

update avtoowners
set vendor_id = 4
where id in (4,5);

update avtoowners
set vendor_id = 2
where id = 2;

update avtoowners
set vendor_id = 1
where id = 1;

update avtoowners
set vendor_id = 3
where id = 3;
create table vendor
(
    id          serial
        constraint ven
            primary key,
    venname     text,
    vendescription  text
);
insert into vendor (venname, vendescription)
values ('ТАЗ', 'Тольяттинский автомобильный завод');

insert into vendor (venname, vendescription)
values ('МАЗ', 'Московский автомобильный завод');

insert into vendor (venname, vendescription)
values ('Wolkswagen', 'Немецкое качество, выгодная цена');

insert into vendor (venname, vendescription)
values ('ГАЗ', 'Убийственный комфорт');