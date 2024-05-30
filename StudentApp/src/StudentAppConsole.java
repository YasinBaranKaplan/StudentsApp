import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class StudentAppConsole {
  public static void main(String[] args) throws IOException {
	System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------");
	System.out.println("YeniDers:1 YeniOgrenci:2 ListeleDers:3 ListeleÖğrenci:4 EkleNot:5 ListeleNot:6 Çıkış:0");
	Scanner input = new Scanner(System.in);
	int girdi = input.nextInt();

	
	
	
	
	
	if(girdi==1) {
		File DersKayit = new File("C:\\Users\\kapla\\eclipse-workspace\\StudentApp\\src\\DersKayit");
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.print("Ders No? ");
		String dersNo = input.next();
		System.out.println();
		System.out.print("Ders Baslik? ");
		String dersBaslik= input.next();
		
		
		
		FileWriter fwriter = new FileWriter(DersKayit,true);
		BufferedWriter bwriter = new BufferedWriter(fwriter);
		bwriter.write(dersNo+"\t"+dersBaslik+"\n");
		bwriter.close();
		
	}
	
	if(girdi==2) {
		File DersKayit = new File("C:\\Users\\kapla\\eclipse-workspace\\StudentApp\\src\\OgrenciKayit");
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.print("Ogrenci No");
		String ogrenciNo = input.next();
		System.out.println();
		String ogrenciAd = input.next();
		System.out.println();
		String ogrenciSoyad = input.next();
		
		FileWriter fwriter = new FileWriter(DersKayit,true);
		BufferedWriter bwriter = new BufferedWriter(fwriter);
		bwriter.write(ogrenciNo+"\t"+ogrenciAd+"\t"+ogrenciSoyad);
		bwriter.close();
		
	}
}
}
