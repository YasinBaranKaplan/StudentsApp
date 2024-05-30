import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Input extends JFrame {
	private String input = JOptionPane.showInputDialog("1:GUI 2:Konsol");
	
	
	public Input() {
		// TODO Auto-generated constructor stub
		super("Input");
		if(input.equals("1"))
			new SecIslem();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new Input();
	}
}


