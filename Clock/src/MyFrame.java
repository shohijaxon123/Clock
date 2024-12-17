import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame {
	
	private SimpleDateFormat timeFormat;
	private SimpleDateFormat dayFormat;
	private SimpleDateFormat dateFormat;
	
	private JLabel timeLabel;
	private JLabel dayLabel;
	private JLabel dateLabel;

	MyFrame(){
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Часы");
		this.setLayout(new FlowLayout());
		this.setSize(320, 200);
		this.setResizable(false);
		
		timeFormat = new SimpleDateFormat("HH:mm:ss");
		dayFormat = new SimpleDateFormat("EEEE");
		dateFormat = new SimpleDateFormat("dd MMMMM, yyyy");
		
		timeLabel = new JLabel();	
		timeLabel.setFont(new Font("Verdana", Font.PLAIN, 50));
		timeLabel.setForeground(new Color(0x00FF00));
		timeLabel.setBackground(Color.BLACK);
		timeLabel.setOpaque(true);
		
		dayLabel = new JLabel();
		dayLabel.setFont(new Font("Ink Free",Font.PLAIN,35));
		
		
		dateLabel = new JLabel();
		dateLabel.setFont(new Font("Ink Free",Font.PLAIN,25));
		  
		this.add(timeLabel);
		this.add(dayLabel);
		this.add(dateLabel);
		this.setVisible(true);
		setTime();
		
	}

	public void setTime() {
		while(true) {
			String time = timeFormat.format(Calendar.getInstance().getTime());
			String date = dateFormat.format(Calendar.getInstance().getTime());
			String day = dayFormat.format(Calendar.getInstance().getTime());
			
			timeLabel.setText(time);
			dayLabel.setText(day);
			dateLabel.setText(date);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
