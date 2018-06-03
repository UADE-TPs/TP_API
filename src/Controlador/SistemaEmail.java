package Controlador;

import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
public class SistemaEmail {
	
	private String usrMail;
	private String passMail;

	private static SistemaEmail instancia;
	
	private SistemaEmail()
	{
		this.usrMail = "listaderegalos.tp.api@gmail.com";
		this.passMail = "uade1234";
	}
	
	public static SistemaEmail getInstancia()
	{
		if (instancia == null)
			instancia = new SistemaEmail();
		return instancia;
	}
	
	public void enviarMail (String destinataro, String asunto, String mensaje) {
		try {
			
			Properties p = new Properties();
			p.put("mail.smtp.host","smtp.gmail.com");
			p.setProperty("mail.smtp.starttls.enable", "true");
			p.setProperty("mail.smtp.port", "587");
			p.setProperty("mail.smtp.user",this.usrMail);
			p.setProperty("mail.smtp.auth","true");
			
			Session s = Session.getDefaultInstance(p,null);
			BodyPart texto = new MimeBodyPart();
			texto.setText(mensaje);
			MimeMultipart m = new MimeMultipart();
			m.addBodyPart(texto);
			MimeMessage msj = new MimeMessage(s);
			msj.setFrom(new InternetAddress(this.usrMail));
			msj.addRecipient(Message.RecipientType.TO, new InternetAddress(destinataro));
			msj.setSubject(asunto);
			msj.setContent(m);
			
			Transport t = s.getTransport("smtp");
			t.connect(this.usrMail,this.passMail);
			t.sendMessage(msj, msj.getAllRecipients());
			t.close();
			
			
		}catch(Exception e)
		{
			System.out.println("Error en SistemaMail - envio de email");
		}
}
}
