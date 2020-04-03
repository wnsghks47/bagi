package dvd;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import javax.swing.table.AbstractTableModel;

import model.DBcon;
import model.VideoModel;
import model.vo.Video;

public class VideoView extends JPanel implements ActionListener{ //4 
	JTextField tfVideonum,tfVideotitle,tfvideoDirector,tfvideoActor;
	JComboBox comVideoGenre;
	JTextArea taVideoContant;
	
	JCheckBox cbmultiInsert;
	JTextField tfInsertCount;
	
	JButton bVideoInsert,bVideoModify,bVideoDelete;
	
	JComboBox comVideoSearch;
	JTextField tfVideoSearch;
	JTable tableVideo;
	
	
	VideoTableModel tbModelVideo;
	VideoModel model;
	
	public VideoView() {
		//������ ȭ�鱸�� 
		addLayout();
		initStyle();
		evenProc();
		connectDB();
		
//		try { //DBcon�� �ߵǾ����� ����Ʈ�ϱ�
//			DBcon.getConnection();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
	public void connectDB() {
		try {
			model=new VideoModel();
			System.out.println("���� db����");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void evenProc() {
		cbmultiInsert.addActionListener(this);
		bVideoDelete.addActionListener(this);
		bVideoInsert.addActionListener(this);
		bVideoModify.addActionListener(this);
		
		
		
		tableVideo.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
//				System.out.println("��ȣ��ȣ");
				
				int row=tableVideo.getSelectedRow();
				int col=0;
				String data=(String) tableVideo.getValueAt(row, col);
				int no=Integer.parseInt(data);
				
				try {
					Video vo=model.selectbyPk(no);
					//���� vo�� ���ڵ尡 ��� vo
					selectbyPk(vo);
					
				} catch (SQLException e1) {
				}
				
			}
		});
	}
	public void selectbyPk(Video vo) {
		tfVideonum.setText(String.valueOf(vo.getVideoNo()));
		tfVideotitle.setText(vo.getVideoName());
		tfvideoDirector.setText(vo.getDirector());
		tfvideoActor.setText(vo.getActor());
		taVideoContant.setText(vo.getExp());
		comVideoGenre.setSelectedItem(vo.getGenre());
	}
	private void initStyle() {
		tfVideonum.setEditable(false); //������ȣ Ŭ�����ϰԸ���� initStyle �޼ҵ� ����
		tfInsertCount.setEditable(false);//refactor > extract method 
	}

	private void addLayout() {
		tfVideonum=new JTextField();
		tfvideoActor=new JTextField();
		tfvideoDirector=new JTextField();
		tfVideotitle=new JTextField();
		
		
		String [] cbGenreStr= {"���","�׼�","����","�ڸ޵�","�ô��",};
		comVideoGenre=new JComboBox(cbGenreStr);
		
		taVideoContant=new JTextArea();
		
		cbmultiInsert= new JCheckBox("�����԰�");
		tfInsertCount= new JTextField("1",5);
		
		bVideoInsert=new JButton("�԰�");
		bVideoModify=new JButton("����");
		bVideoDelete=new JButton("����");
		
		String[] cbVideoSearch= {"����","����"};
		comVideoSearch=new JComboBox(cbVideoSearch);
		tfVideoSearch=new JTextField(15);
		
		tbModelVideo=new VideoTableModel();
		tableVideo=new JTable(tbModelVideo);
		tableVideo.setModel(tbModelVideo);
		
		//j�ǳ� ȭ�鱸��
		
		JPanel p_west=new JPanel();
		p_west.setLayout(new BorderLayout());
		
		//j�ǳ� 2 ȭ�鱸��
		JPanel p_west_center=new JPanel();
		p_west_center.setLayout(new BorderLayout());
		
		//j�ǳ� 3 ȭ�鱸��
		JPanel p_west_center_north=new JPanel();
		p_west_center_north.setLayout(new GridLayout(5,2));
		
		//j�ǳ� 3�� ���۷�Ʈ ����
		p_west_center_north.add(new JLabel("������ȣ"));
		p_west_center_north.add(tfVideonum);
		
		p_west_center_north.add(new JLabel("�帣"));
		p_west_center_north.add(comVideoGenre); //�帣
		
		p_west_center_north.add(new JLabel("����"));
		p_west_center_north.add(tfVideotitle);
		
		p_west_center_north.add(new JLabel("����"));
		p_west_center_north.add(tfvideoDirector);
		
		p_west_center_north.add(new JLabel("���"));
		p_west_center_north.add(tfvideoActor);
		
		//�ǳ� 14 ȭ�鱸��
		JPanel p_west_center_center=new JPanel();
		p_west_center_center.setLayout(new BorderLayout());
		
		p_west_center_center.add(new Label("����"),BorderLayout.WEST);
		p_west_center_center.add(taVideoContant,BorderLayout.CENTER);
		//�ǳ� 13,4�� �ǳ� 12�� ����
		p_west_center.add(p_west_center_north,BorderLayout.NORTH);
		p_west_center.add(p_west_center_center,BorderLayout.CENTER);
		
		p_west_center.setBorder(new TitledBorder("���������Է�"));
		//�ı�
		JPanel p_west_south=new JPanel();
		p_west_south.setLayout(new GridLayout(2,1));
		
		JPanel west_south_1=new JPanel();
		west_south_1.setLayout(new FlowLayout());
		
		west_south_1.add(cbmultiInsert);
		west_south_1.add(tfInsertCount);
		west_south_1.add(new JLabel("��"));
		west_south_1.setBorder(new TitledBorder("�����Է½ü���"));
		
		JPanel west_south_2=new JPanel();
		west_south_2.setLayout(new GridLayout(1,3));
		west_south_2.add(bVideoInsert);
		west_south_2.add(bVideoDelete);
		west_south_2.add(bVideoModify);
		
		
		//p_west_south �� west_south1.2����
		p_west_south.add(west_south_1);
		p_west_south.add(west_south_2);
		
		
		p_west.add(p_west_center,BorderLayout.CENTER);
		p_west.add(p_west_south,BorderLayout.SOUTH);
		
		//�����ǳ� p_east����
		//���� �ǳ�
		JPanel p_east=new JPanel();
		p_east.setLayout(new BorderLayout());
		
		//���� �ǳ� ����
		JPanel p_east_north=new JPanel();
		p_east_north.add(comVideoSearch);
		p_east_north.add(tfVideoSearch);
		
		p_east_north.setBorder(new TitledBorder("���� �˻�"));
		
		p_east.add(p_east_north,BorderLayout.NORTH);
		
		p_east.add(new JScrollPane(tableVideo),BorderLayout.CENTER);
		
		
		
		
		setLayout(new GridLayout(1,2));
		add(p_west);
		add(p_east);
		
			
				
			}
		
	
	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println("asdfhkjfdskfds");
		Object evt=e.getSource();
		if (evt==cbmultiInsert) {
			tfInsertCount.setEditable(cbmultiInsert.isSelected());
			}else if(evt==bVideoInsert) { 
//				System.out.println("bVideoInsert press"); //�μ�Ʈ��ư
				Video vo= new Video();
				vo.setGenre ((String)comVideoGenre.getSelectedItem());
				vo.setVideoName(tfVideotitle.getText());
				vo.setActor(tfvideoActor.getText());
				vo.setDirector(tfvideoDirector.getText());
				vo.setExp(taVideoContant.getText());
				
				int count=Integer.parseInt(tfInsertCount.getText());
				//vo�� �Է��� �ڷḦ(��ȭ����)�� ����
				
				try {
					model.insertVideo(vo, count);
					JOptionPane.showMessageDialog(null, "�԰�Ϸ�");
					tfVideonum.setText(null);
					tfvideoActor.setText(null);
					tfvideoDirector.setText(null);
					tfVideoSearch.setText(null);
					tfVideotitle.setText(null);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
	}//3
	
	class VideoTableModel extends AbstractTableModel{

		ArrayList data=new ArrayList<>();
		String[] columnNames= {"������ȣ","����","�帣","����","���"};
		@Override
		public int getColumnCount() {
		
			return columnNames.length;
		}

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return data.size();
		}

		@Override
		public Object getValueAt(int row, int col) {
			ArrayList temp=(ArrayList) data.get(row);
			return temp.get(col);
		}
		@Override
		public String getColumnName(int col) {
			
			return columnNames[col];
		}
		
	}
	}
