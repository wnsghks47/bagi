package notice.vo;

import java.util.Date;

public class Notice {
	private String seq;
	private String title;
	private String writer;
	private String content;
	private Date regdate;
	private int hit;
	private String filesrc;
	private String orgfilesrc;
	
	
	
	public String getOrgfilesrc() {
		return orgfilesrc;
	}
	public void setOrgfilesrc(String orgfilesrc) {
		this.orgfilesrc = orgfilesrc;
	}
	public String getFilesrc() {
		return filesrc;
	}
	public void setFilesrc(String filesrc) {
		this.filesrc = filesrc;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	
	

}
