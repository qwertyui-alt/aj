package MailDemo; 
 
import java.io.IOException; 
import java.io.PrintWriter; 
 
import jakarta.mail.Authenticator; 
import jakarta.mail.Message; 
import jakarta.mail.MessagingException; 
import jakarta.mail.PasswordAuthentication; 
import jakarta.mail.Session; 
import jakarta.mail.Transport; 
import jakarta.mail.internet.InternetAddress; 
import jakarta.mail.internet.MimeMessage; 
 
import jakarta.servlet.ServletException; 
import jakarta.servlet.annotation.WebServlet; 
import jakarta.servlet.http.HttpServlet; 
import jakarta.servlet.http.HttpServletRequest; 
import jakarta.servlet.http.HttpServletResponse; 
 
@WebServlet("/EmailServlet") 
public class EmailServlet extends HttpServlet { 
 
    private static final long serialVersionUID = 1L; 
 
    protected void doPost(HttpServletRequest request, 
                          HttpServletResponse response) 
            throws ServletException, IOException 
    { 
 
        response.setContentType("text/html"); 
        PrintWriter out = response.getWriter(); 
 
        // Get data from JSP form 
        String to = request.getParameter("to"); 
        String subject = request.getParameter("subject"); 
        String messageText = request.getParameter("message"); 
 
        // Sender's Gmail account 
        final String from = "shreyaamore21@gmail.com"; 
 
        // Gmail App Password 
        final String password = "zesu pnba xnpp yeyd"; 
 
        // Gmail SMTP configuration 
        String host = "smtp.gmail.com"; 
        String port = "587"; 
 
        // Create SMTP properties 
        java.util.Properties properties = 
                new java.util.Properties(); 
 
        properties.put("mail.smtp.host", host); 
        properties.put("mail.smtp.port", port); 
        properties.put("mail.smtp.auth", "true"); 
        properties.put("mail.smtp.starttls.enable", "true"); 
 
        // Create mail session 
        Session session = Session.getInstance( 
                properties, 
                new Authenticator() { 
                    protected PasswordAuthentication 
                    getPasswordAuthentication() { 
                        return new PasswordAuthentication( 
                                from, password); 
                    } 
                }); 
 
        try { 
            // Create email message 
            Message message = new MimeMessage(session); 
 
            // Sender 
            message.setFrom(new InternetAddress(from)); 
 
            // Receiver 
            message.setRecipients( 
                    Message.RecipientType.TO, 
                    InternetAddress.parse(to)); 
 
            // Subject 
            message.setSubject(subject); 
 
            // Message body 
            message.setText(messageText); 
 
            // Send email 
            Transport.send(message); 
 
            out.println("<h2>Email sent successfully!</h2>"); 
            out.println("<p>Mail sent to: " + to + "</p>"); 
 
        } catch (MessagingException e) { 
            out.println("<h2>Email could not be sent.</h2>"); 
            out.println("<p>Error: " + e.getMessage() + "</p>"); 
            e.printStackTrace(); 
        } 
    }}