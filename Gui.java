import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
//j1:폴더입력, j2:파일 문서별로 정리, j3:파일 크기 기준 기준 정리, j4:중요도 기준 정리, j5:중복파일 제거

public class Gui extends JFrame {
	private JTextField jtf1;
	public Gui() {
		Container ct = getContentPane();
		JPanel jp1 = new JPanel();
		JLabel jl1 = new JLabel("폴더 입력");
		this.jtf1 = new JTextField(19);
		JButton jb1 = new JButton(".");
		jb1.setPreferredSize(new Dimension(20,20));
		JPanel jp2 = new JPanel();
		JButton jb2 = new JButton("파일 문서별로 정리");
		jb2.setPreferredSize(new Dimension(250,30));
		JPanel jp3 = new JPanel();
		JButton jb3 = new JButton("파일 크기 기준 정리");
		jb3.setPreferredSize(new Dimension(250,30));
		JPanel jp4 = new JPanel();
		JButton jb4 = new JButton("중요도 기준 정리");
		jb4.setPreferredSize(new Dimension(250,30));
		JPanel jp5 = new JPanel();
		JButton jb5 = new JButton("중복파일 제거");
		jb5.setPreferredSize(new Dimension(250,30));
		
		ct.setLayout(new GridLayout(5,1));
		
		jp1.setLayout(new FlowLayout(FlowLayout.CENTER));
		jp1.add(jl1);
		jp1.add(jtf1);
		jp1.add(jb1);
		
		jp2.setLayout(new FlowLayout(FlowLayout.CENTER));
		jp2.add(jb2);
		
		jp3.setLayout(new FlowLayout(FlowLayout.CENTER));
		jp3.add(jb3);
		
		jp4.setLayout(new FlowLayout(FlowLayout.CENTER));
		jp4.add(jb4);
		
		jp5.setLayout(new FlowLayout(FlowLayout.CENTER));
		jp5.add(jb5);
		
		ct.add(jp1);
		ct.add(jp2);
		ct.add(jp3);
		ct.add(jp4);
		ct.add(jp5);
		
		setTitle("File Oraganize Manager");
		setSize(400,250);
		setVisible(true);
		
		jb1.addActionListener(e -> {
			String selectPath = DirectoryChooser.chooseDirectory(this);
			
			if(selectPath != null) {
				jtf1.setText(selectPath);
			}else {
				jtf1.setText("폴더선택이 취소되었습니다.");
			}
		});
		
		jb3.addActionListener(e -> {
			try {	
				FileOraganize.size(this);
				jtf1.setText("기준 정렬이 완료되었습니다.");
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		
		jb4.addActionListener(e -> {
			try {	
				FileOraganize.importance(this);
				jtf1.setText("기준 정렬이 완료되었습니다.");
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		
	}
	public String address() {
		return jtf1.getText();
	}
}
