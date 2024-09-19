package com.sena.modelo_tarea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;


@Service
public class emailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public String enviarAsignacionTarea(String destinatario){
        try{
            String asunto = "¡Nueva Tarea Asignada!";
            String cuerpo = ""
            + "<body style=\"font-family: Arial, sans-serif; background-color: #f8f9fa; margin: 0; padding: 20px;\">\r\n"
            + "  <div class=\"container\" style=\"max-width: 600px; margin: auto; background: white; padding: 20px; border-radius: 8px; box-shadow: 0 2px 10px rgba(0,0,0,0.1);\">\r\n"
            + "    <h1 style=\"font-size: 24px; color: #333;\">¡Hola!</h1>\r\n"
            + "    <p style=\"font-size: 16px; color: #555;\">Se te ha asignado una nueva tarea.</p>\r\n"
            + "    <p style=\"font-size: 16px; color: #555;\">¡Buena suerte con tu tarea! Si tienes preguntas, no dudes en contactarnos.</p>\r\n"
            + "    <footer style=\"margin-top: 20px; font-size: 14px; color: #888;\">\r\n"
            + "      <p>Síguenos en nuestras redes sociales:</p>\r\n"
            + "      <ul style=\"list-style: none; padding: 0; display: flex;\">\r\n"
            + "        <li style=\"margin-right: 10px;\"><box-icon name='facebook' type='logo'></box-icon></li>\r\n"
            + "        <li style=\"margin-right: 10px;\"><box-icon name='instagram' type='logo'></box-icon></li>\r\n"
            + "        <li><box-icon name='twitter' type='logo'></box-icon></li>\r\n"
            + "      </ul>\r\n"
            + "    </footer>\r\n"
            + "  </div>\r\n"
            + "</body>"
            + "<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>"
            + "<script src=\"https://unpkg.com/boxicons@2.1.4/dist/boxicons.js\"></script>";

            

            var retorno=enviarCorreo(destinatario,asunto,cuerpo);
            if(retorno) {
                return "se envió correctamente";
            }else {
                return "No se pudo envíar";
            }

        }catch (Exception e) {
            // TODO: handle exception
            return "Error al envíar "+e.getMessage();
        }
    }

    public boolean enviarCorreo(String destinatario, String asunto, String cuerpo) throws MessagingException {
		try {
			MimeMessage message=javaMailSender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(message,true);
			
			helper.setTo(destinatario);
			helper.setSubject(asunto);
			helper.setText(cuerpo,true);
			
			javaMailSender.send(message);
			return true;
		}catch (Exception e) {

			return false;
		}
		
	}
}
