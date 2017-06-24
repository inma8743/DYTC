drop table member;
drop table board;
create table member(
	id varchar2(15) primary key,
	password varchar2(10),
	name varchar2(20),
	age number,
	gender char(6),
	addr varchar2(100),
	regdate date default sysdate
);
create table board(
	num number primary key,
	id varchar2(15) references member(id),
	subject varchar2(100) ,
	content varchar2(3000),
	file_name varchar2(100),
	write_date date default sysdate,
	read_count number default 0
);
create sequence board_seq
	start with 1
	increment by 1
	
drop sequence board_seq	
	
select * from board;
select * from MEMBER;

select * from member where id = 'test' and password = 1234

insert into member values('haha', '1234', 'haho', 23, '남자', 'asddas', default);

insert into board values(board_seq.nextval, 'test', '안녕하세요', 'd','d', default, default);
insert into board values(board_seq.nextval, 'user', '안녕하세요', '내용','파일명', default, default);

update board set read_count = read_count + 1 where num = 1;