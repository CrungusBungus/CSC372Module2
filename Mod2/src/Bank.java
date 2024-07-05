import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.*; 
import java.awt.event.*; 

class Account {
	Double Balance;
	
	public Account(Double bal) {
		Balance = bal;
	}
	
	public Double getBalance() {
		return Balance;
	}
	
	public void addBalance(Double bal) {
		Balance += bal;
	}
	
	public void subBalance(Double bal) {
		Balance -= bal;
	}
}

public class Bank {
	public static void main(String[] args) {
		Account acc = new Account(500.00);
		
		JFrame f = new JFrame("BankApp");
		f.setSize(600,400);
		f.setVisible(true);
		
		JLabel bal = new JLabel();
		bal.setBounds(120,50,360,60);
		bal.setText("Balance: " + acc.getBalance());
		bal.setForeground(Color.white);
		bal.setBorder(BorderFactory.createLineBorder(Color.white));
		bal.setHorizontalAlignment(SwingConstants.CENTER);
		f.add(bal);
		
		JButton wd = new JButton("Withdraw");
		wd.setBounds(150,220,300,35);
		f.add(wd);
		JButton de = new JButton("Deposit");
		de.setBounds(150,270,300,35);
		f.add(de);
		
		TextField tf = new TextField();
		tf.setBounds(150,140,300,50);
		f.add(tf);
		
		JPanel pan = new JPanel();
		pan.setBackground(Color.DARK_GRAY);
		f.add(pan);
		
		wd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double mon = Double.parseDouble(tf.getText());
				acc.subBalance(mon);
				bal.setText("Balance: " + acc.getBalance());
			}
		});
		de.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double mon = Double.parseDouble(tf.getText());
				acc.addBalance(mon);
				bal.setText("Balance: " + acc.getBalance());
			}
		});
		
	}
}