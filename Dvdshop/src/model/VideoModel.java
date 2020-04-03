package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.vo.Video;

public class VideoModel {
	Connection con;
	public VideoModel() throws Exception {
		con=DBcon.getConnection();
	}
	public Video selectbyPk(int no) throws SQLException {
		Video vo=new Video();
		
		String sql="select * from vinfo where vicode="+no;
		PreparedStatement pstmt=con.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		while (rs.next()) {
			vo.setVideoNo(Integer.parseInt(rs.getString("VICODE")));
			vo.setActor(rs.getString("ACTOR"));
			vo.setDirector(rs.getString("director"));
			vo.setGenre(rs.getString("genre"));
			vo.setVideoName(rs.getString("title"));
			vo.setExp(rs.getString("detail"));
			
		}
		rs.close();
		pstmt.close();
		return vo;
	}
	public void insertVideo(Video dao, int count) throws Exception {
		con.setAutoCommit(false);
		for (int i = 0; i < count; i++) {
			//preparedstatment style
//			String sql1="INSERT INTO vinfo(vicode,title,genre,director,actor,detail)" + 
//					"VALUES(seq_vicode.nextval,?,?,?,?,?)";
//			PreparedStatement ps1=con.prepareStatement(sql1);
////			ps1.setString(1, dao.getVideoName());
//			ps1.setString(2, dao.getGenre());
//			ps1.setString(3, dao.getDirector());
//			ps1.setString(4, dao.getActor());
//			ps1.setString(5, dao.getExp());
			
			
			//statment style
			Statement stat=con.createStatement();
			String tit=dao.getVideoName();
			String gen=dao.getGenre();
			String dir=dao.getDirector();
			String act=dao.getActor();
			String exp=dao.getExp();
					
			String sql1="INSERT INTO vinfo(vicode,title,genre,director,actor,detail)" + 
					"VALUES(seq_vicode.nextval,'"+tit+"','"+gen+"','"+dir+"','"+act+"','"+exp+"')";
			
			
			//½ÇÇà
//			int r1=ps1.executeUpdate(); //preparedstatment style
			
			int r1=stat.executeUpdate(sql1);
			
			System.out.println("sql1 : "+sql1);
			if (r1!=1) {
				con.rollback();
			}
			con.commit();
//			ps1.close(); //preparedstatment style
			stat.close();
			
		}
		con.setAutoCommit(true);
	}
	public void deletevideo(Video vo, int no) {
		// TODO Auto-generated method stub
		
	}
	}
	
}