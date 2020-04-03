package dvdshop;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

import dvd.VideoView;

public class VideoShop extends JFrame{//2
	VideoView video;
	public VideoShop() {
		video= new VideoView(); //호출
		
		JTabbedPane pane=new JTabbedPane();
		pane.addTab("비디오관리", video);
		pane.addTab("비디오관리2", null);
		pane.setSelectedIndex(0);
		add("Center",pane);
		
		
		setSize(800,600);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new VideoShop();
		
	
}
}
