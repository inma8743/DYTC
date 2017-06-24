package board.dto;

import java.sql.Date;

public class Board {
	private int number,readCount;
	private String id,subject,content,fileName;
	private Date writeDate;
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	
}
/*create table board(
		num number primary key,
		id varchar2(15) references member(id),
		subject varchar2(100) ,
		content varchar2(3000),
		file_name varchar2(100),
		write_date date default sysdate,
		read_count number default 0
	);*/