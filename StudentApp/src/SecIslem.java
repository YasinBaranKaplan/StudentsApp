import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

public class SecIslem extends JFrame implements ItemListener {
    private JRadioButton yeniDers;
    private JRadioButton yeniOgrenci; 
    private JRadioButton listeleDers; 
    private JRadioButton listeleOgrenci;	
    private JRadioButton ekleNot;
    private JRadioButton listeleNot;
    private JTextField dersKod;
    private JTextField dersBaslik;
    private JTextField ogrenciNo;
    private JTextField ogrenciAd;
    private JTextField ogrenciSoyad;
    private JTextArea dersList;
    private JPanel yeniDersPanel;
    private JPanel yeniOgrenciPanel;
    private JPanel listeleDersPanel;
    private JButton kaydet;
    private JButton temizle;

    public SecIslem() {
        super("Ogrenci Islemleri");

        // Radyo butonlarını oluştur
        yeniDers = new JRadioButton("Yeni Ders");
        yeniOgrenci = new JRadioButton("Yeni Ogrenci");
        listeleDers = new JRadioButton("Dersleri Listele");
        listeleOgrenci = new JRadioButton("Ogrencileri Listele");
        ekleNot = new JRadioButton("Not Ekle");
        listeleNot = new JRadioButton("Notlari Listele");

        // Radyo butonlarını gruplandır
        ButtonGroup group = new ButtonGroup();
        group.add(yeniDers);
        group.add(yeniOgrenci);
        group.add(listeleDers);
        group.add(listeleOgrenci);
        group.add(ekleNot);
        group.add(listeleNot);

        // Panel oluştur ve radyo butonlarını panele ekle
        JPanel panel = new JPanel(new GridLayout(6,1));
        panel.add(yeniDers);
        panel.add(yeniOgrenci);
        panel.add(listeleDers);
        panel.add(listeleOgrenci);
        panel.add(ekleNot);
        panel.add(listeleNot);
        panel.setBounds(10,25,200,200);
        
        Border tborder = BorderFactory.createTitledBorder("Seçenekler");
        panel.setBorder(tborder);
        
       
        setLayout(null);
        

        // Radyo butonlarına item listener ekle
        yeniDers.addItemListener(this);
        yeniOgrenci.addItemListener(this);
        listeleDers.addItemListener(this);
        listeleOgrenci.addItemListener(this);
        ekleNot.addItemListener(this);
        listeleNot.addItemListener(this);

        // Paneli çerçeveye ekle
        add(panel);

        setSize(300,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    
    @Override
    public void itemStateChanged(ItemEvent e) {
    	 // Önce mevcut panelleri kaldır
        if (yeniDersPanel != null) {
            remove(yeniDersPanel);
        }
        if (yeniOgrenciPanel != null) {
            remove(yeniOgrenciPanel);
        }
        if(listeleDersPanel != null) {
        	remove(listeleDersPanel);
        }
        
    	if(yeniDers.isSelected()) {
    		
    		JLabel label1 = new JLabel("Ders Kod");
    		dersKod = new JTextField();
    		JLabel label2 = new JLabel("Ders Baslik");
    		dersBaslik = new JTextField();
    		kaydet = new JButton("Kaydet");
    		temizle = new JButton("Temizle");
    		
    		yeniDersPanel = new JPanel(new GridLayout(3,2));
    		yeniDersPanel.add(label1);yeniDersPanel.add(dersKod);yeniDersPanel.add(label2);yeniDersPanel.add(dersBaslik);
    		yeniDersPanel.add(kaydet);yeniDersPanel.add(temizle);
    		
    		
    		Border border = BorderFactory.createTitledBorder("Yeni Ders");
            yeniDersPanel.setBorder(border);
            yeniDersPanel.setBounds(250,25 , 200, 200);
    		add(yeniDersPanel);
    		
    		setSize(500,300);
    		
    		//Butonlar için actionlist ekleme
    		kaydet.addActionListener(new ActionListener() {
				String dbKod = dersKod.getText()+" "+dersBaslik.getText();
				@Override
				 public void actionPerformed(ActionEvent e) {
			        // Ders kodu ve başlığını al
			        String dbKod = dersKod.getText() + " " + dersBaslik.getText();
			        String dosyaYolu = "C:\\Users\\kapla\\eclipse-workspace\\StudentApp\\src\\Ders";
			        try {
			            // FileWriter kullanarak dosyayı açın. Var olan dosya üzerine yazacak.
			            FileWriter yazici = new FileWriter(dosyaYolu);
			            yazici.write(dbKod);
			            yazici.close();

			            
			            JOptionPane.showMessageDialog(null, "Başarıyla kaydedildi.");
			        } catch (IOException ex) {
			            
			            JOptionPane.showMessageDialog(null, "Dosyaya yazılırken bir hata oluştu: " + ex.getMessage(), "Hata", JOptionPane.ERROR_MESSAGE);
			            ex.printStackTrace();
					}
				}
			});
    		
    		temizle.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					dersKod.setText("");
					dersBaslik.setText("");
					JOptionPane.showMessageDialog(null, "Alanlar Temizlendi.");
				}
			});
    		
    		revalidate();
            repaint();
    	}
    	
    	else if(yeniOgrenci.isSelected()) {
    		JLabel ogrenciNO = new JLabel("Ogrenci No");
    		ogrenciNo = new JTextField();
    		JLabel ogrenciAD = new JLabel("Ogrenci Ad");
    		ogrenciAd = new JTextField();
    		JLabel ogrenciSOYAD = new JLabel("Ogrenci Soyad");
    		ogrenciSoyad = new JTextField();
    		
    	    yeniOgrenciPanel = new JPanel(new GridLayout(4,2));
    		yeniOgrenciPanel.add(ogrenciNO);yeniOgrenciPanel.add(ogrenciNo);yeniOgrenciPanel.add(ogrenciAD);yeniOgrenciPanel.add(ogrenciAd);
    		yeniOgrenciPanel.add(ogrenciSOYAD);yeniOgrenciPanel.add(ogrenciSoyad);
    		yeniOgrenciPanel.add(kaydet);
    		yeniOgrenciPanel.add(temizle);
    		
    		Border tbord = BorderFactory.createTitledBorder("Yeni Öğrenci");
    		yeniOgrenciPanel.setBorder(tbord);
    		yeniOgrenciPanel.setBounds(250,25 , 200, 200);
    		add(yeniOgrenciPanel);
    		
    		setSize(500,300);
    		
    		kaydet.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String ogrenciBilgi = ogrenciNo.getText() + " " + ogrenciAd.getText() + " " + ogrenciSoyad.getText();
                    String dosyaYolu = "C:\\Users\\kapla\\eclipse-workspace\\StudentApp\\src\\Ogrenci";
                    try (FileWriter yazici = new FileWriter(dosyaYolu, true)) {
                        yazici.write(ogrenciBilgi + "\n");
                        JOptionPane.showMessageDialog(null, "Başarıyla kaydedildi.");
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Dosyaya yazılırken bir hata oluştu: " + ex.getMessage(), "Hata", JOptionPane.ERROR_MESSAGE);
                        ex.printStackTrace();
                    }
                }
            });
    		
    		temizle.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ogrenciNo.setText("");
                    ogrenciAd.setText("");
                    ogrenciSoyad.setText("");
                    JOptionPane.showMessageDialog(null, "Alanlar Temizlendi.");
                }
            });
    		
    		revalidate();
            repaint();
    	}
    	else if(listeleDers.isSelected()) {
    	    String dosyaYolu ="C:\\Users\\kapla\\eclipse-workspace\\StudentApp\\src\\Ders";
    	    BufferedReader okuyucu = null;
    	    try {
				okuyucu = new BufferedReader(new FileReader(dosyaYolu));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    		
    		dersList = new JTextArea("Ders No     Ders Baslık\n");
    	    listeleDersPanel = new JPanel(new GridLayout(1,1));
    	    listeleDersPanel.add(dersList);
    	    dersList.append(okuyucu.toString());
    	    
    	    Border tBorder = BorderFactory.createTitledBorder("Listele Ders");
    	    listeleDersPanel.setBorder(tBorder);
    	    listeleDersPanel.setBounds(250,25 , 200, 200); // Fix: set bounds of listeleDersPanel
    	    
    	    add(listeleDersPanel);
    	    revalidate();
    	    repaint();
    	}
    }

    public static void main(String[] args) {
        new SecIslem();
    }
}
