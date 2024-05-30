/*import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class Example extends JFrame {
    public Example() {
        super("Example");

        // İlk panel oluştur
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.RED);
        panel1.setBounds(50, 50, 200, 200); // Koordinatları ve boyutu ayarla

        // İkinci panel oluştur
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.BLUE);
        panel2.setBounds(300, 50, 200, 200); // Koordinatları ve boyutu ayarla

        // Layout yöneticisini kaldır
        setLayout(null);

        // Panelleri çerçeveye ekle
        add(panel1);
        add(panel2);

        setSize(550, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Example();
    }
}*/

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class Example extends JFrame {
    public Example() {
        super("Example");

        // Ana panel oluştur
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null); // Layout yöneticisini kaldır

        // İç panel oluştur
        JPanel innerPanel = new JPanel();
        innerPanel.setLayout(null);
        innerPanel.setBackground(Color.WHITE);
        innerPanel.setBounds(50, 50, 200, 200); // İç panelin koordinatlarını ve boyutunu ayarla
        mainPanel.add(innerPanel); // Ana panele iç paneli ekle

        // Buton oluştur
        JButton button = new JButton("Buton");
        button.setBounds(20, 50, 100, 30); // Butonun koordinatlarını ve boyutunu ayarla
        innerPanel.add(button); // İç panele butonu ekle

        // Ana pencereye ana paneli ekle
        add(mainPanel);

        setSize(350, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Example();
    }
}

