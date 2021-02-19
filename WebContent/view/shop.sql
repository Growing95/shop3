create table cart(
c_idx number(10) not null primary key,
p_num VARCHAR2(10) not null,
p_name VARCHAR2(50) not null,
p_price number(10) not null,
p_saleprice number(10) not null,
amount number(10) not null,
id varchar2(50) not null
);
create SEQUENCE cart_seq
INCREMENT by 1
start with 1;
commit;



