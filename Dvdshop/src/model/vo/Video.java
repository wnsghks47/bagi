package model.vo;

public class Video {
	private int videoNo; //db에서 vicode
	private String genre;  //db에서 title
	private String videoName; //db에서 genre
	private String director; //db에서 director
	private String actor; //db에서 actor
	private String exp; //db에서 detail
	
	
	//오른쪽 마우스키 source > genelate setters getters
	public int getVideoNo() {
		return videoNo;
	}
	public void setVideoNo(int videoNo) {
		this.videoNo = videoNo;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getVideoName() {
		return videoName;
	}
	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getExp() {
		return exp;
	}
	public void setExp(String exp) {
		this.exp = exp;
	}
	
	
}
