create table user(
    username varchar(20) primary key,
    password varchar(20) not null
);

insert into user(username, password) values('admin', '1234');

create table passenger(
    username varchar(20) primary key,
    name varchar(20) not null,
    age int not null,
    gender varchar(10) not null,
    address varchar(20) not null,
    contact varchar(20) not null
);

desc passenger;

select * from passenger;

select * from passenger;

create table payroll(
    salaryId varchar(20) primary key,
    amount varchar(20) not null,
    date int not null,
    month int not null,
    status varchar(10) not null
);

create table employee(
    empId varchar(20) primary key,
    name varchar(20) not null,
    age int not null,
    gender varchar(10) not null,
    address varchar(20) not null,
    contact varchar(20) not null
);

create table attendance(
    attId varchar(20) primary key,
    time time not null,
    date date not null,
    status varchar(10) not null,
    empId varchar(20),
    foreign key (empId) references employee(empId) on delete cascade on update cascade
);

create table trains(
    trainId varchar(20) primary key,
    type varchar(20),
    noOfSeats int not null,
    status varchar(10) not null
);

create table trainSchedule(
    scheduleId varchar(20) primary key,
    trainId varchar(20) not null,
    fromStation varchar(20) not null,
    toStation varchar(20) not null,
    date date not null,
    time time not null,
    timeperiod varchar(10) not null,
    foreign key (trainId) references trains(trainId) on delete cascade on update cascade
);

create table delivery(
    deliveryId varchar(20) primary key,
    trainId varchar(20) not null,
    date date not null,
    time time not null,
    weight int not null,
    price double not null,
    foreign key (trainId) references trains(trainId) on delete cascade on update cascade
);

create table driver(
    driverId varchar(20) primary key,
    empId varchar(20) not null,
    trainId varchar(20) not null,
    foreign key (empId) references employee(empId) on delete cascade on update cascade,
    foreign key (trainId) references trains(trainId) on delete cascade on update cascade
);

create table seats(
    seatId varchar(20) primary key,
    trainId varchar(20) not null,
    class varchar(10) not null,
    avaliability varchar(10) not null,
    foreign key (trainId) references trains(trainId) on delete cascade on update cascade
);

create table reservation(
    reservationId varchar(20) primary key,
    trainId varchar(20) not null,
    seatId varchar(20) not null,
    foreign key (trainId) references trains(trainId) on delete cascade on update cascade,
    foreign key (seatId) references seats(seatId) on delete cascade on update cascade
);


