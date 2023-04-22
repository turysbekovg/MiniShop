create table users(
    id bigserial primary key,
    username varchar(255) not null unique,
    password varchar (255) not null
);

create table products(
    id bigserial primary key,
    title varchar(255) not null,
    price float not null,
    quantity int not null
);

create table orders (
    id bigserial primary key,
    user_id bigint not null,
    address varchar(255) not null,
    created_date_time timestamp not null,
    foreign key (user_id) references users(id)
);

create table order_details (
    id bigserial primary key,
    order_id bigint not null,
    product_id bigint not null,
    price float not null,
    quantity int not null,
    foreign key (order_id) references orders(id),
    foreign key (product_id) references products(id)
);