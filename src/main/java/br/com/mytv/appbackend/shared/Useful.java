package br.com.mytv.appbackend.shared;


import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Useful {

	public static byte[] loadBytes(String file) {
		
		FileInputStream in = null;

		try {
			in = new FileInputStream(file);
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			
			int bytesread = 0;
			byte[] tbuff = new byte[512];

			while (true) {
				bytesread = in.read(tbuff);
				if (bytesread == -1) // if EOF
					break;
				buffer.write(tbuff, 0, bytesread);
			}
			return buffer.toByteArray();
		} catch (IOException e) {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e2) {
				}
			}
			return null;
		}
	}
	
	
//	public void retornaXML(){  
//        Statement stmt;  
//        String query = "select arquivo from historico_envio where id = ";  
//        try{  
//            stmt = conn.createStatement();  
//  
//            ResultSet rs = stmt.executeQuery(query);  
//            byte[] b = null;  
//            while (rs.next()){  
//                b = rs.getBytes(&quot;arquivo&quot;);  
//            }  
//              
//              
//            FileOutputStream fileOutputStream = new FileOutputStream(new File(&quot;/home/deivid/Desktop/aluno.xml&quot;));  
//            fileOutputStream.write(b);  
//            fileOutputStream.flush();             // &lt;&lt;--- ATENÇÃO AQUI 
//            fileOutputStream.close();  
//              
//        }catch (Exception e) {  
//            e.printStackTrace();  
//        }  
//    }
}
