package techproed.jdbcOrnekler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.text.html.HTMLEditorKit.ParserCallback;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Result;

public class Jdbc1Query01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		
		
		// 1) ilgili driver'i yuklemeliyiz. TV'nin fisini tak, mesela baska alet calismasin
		
		
	Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		// 2) baglanti olusturmaliyiz uydu sifreye girmeliyiz
	
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "1234");     
	
	
		// 3) SQL komutlari icin bir statement nesnesi olustur; her kanal icin kumandada yer ayarlamak
	
		Statement st = con.createStatement();
		
		// SQL ifadeleri yazabilir ve calistirabiliriz, kumandada 1e basarim TRT1 gelir
		
		ResultSet veri = st.executeQuery("SELECT isim, maas FROM personel WHERE id=123456789");
		
		
		// 5) sonuclari ve isledik
		
		while(veri.next()) {
			
			System.out.println(veri.getString("isim") + veri.getInt("maas"));
		
		System.out.println("Personel Adi: " + veri.getString(1) + " Maasi: " + veri.getInt(2));
		
		}
		
		// 6) olusturulan nesneleri bellekten kaldiralim
		
		con.close();
		st.close();
		veri.close();
		
		
		
	}

}
