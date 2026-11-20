<!DOCTYPE html> 
<html> 
<head> 
<title>Java Mail Demo</title> 
</head> 
<body> 
<h2>Send Email</h2> 
<form action="EmailServlet" method="post"> 
<label>Recipient Email:</label> 
<input type="email" name="to" required> 
<br><br> 
<label>Subject:</label> 
<input type="text" name="subject" required> 
<br><br> 
<label>Message:</label> 
<br> 
<textarea name="message" rows="8" cols="50" required></textarea> 
<br><br> 
        <input type="submit" value="Send Email"> 
 
    </form> 
 
</body> 
</html> 