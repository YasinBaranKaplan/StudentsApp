import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Input extends JFrame {
	private String input = JOptionPane.showInputDialog("1:GUI 2:Konsol");
	
	
	public Input() {
		// TODO Auto-generated constructor stub
		super("Input");
		if(input.equals("1"))
			new SecIslem();
		
		else if(input.equals("2"))
			new StudentAppConsole();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(false);
	}
	
	
	public static void main(String[] args) {
		new Input();
	}
}


