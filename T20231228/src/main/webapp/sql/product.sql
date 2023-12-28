create table product (
 product_code char(8) primary key, -- P2023-01
 product_name varchar2(100) not null, --이름
 product_desc varchar2(300) not null, --설명
 origin_price number not null, --가격
 sale_price number, --할인가격
 like_it number default 3, --추천수
 image varchar2(30)
);
insert into product values('P2023-01', '과테말라 원두', '과테말라산 원두입니다.', 3500, 3000, 5, '과테말라.jpg');
