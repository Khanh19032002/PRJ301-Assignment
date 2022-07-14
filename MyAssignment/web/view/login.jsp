<%-- 
    Document   : login
    Created on : Jul 14, 2022, 5:42:51 PM
    Author     : KakaNoob
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>FPT University Academic Portal</h1>
        
         <form action="login" method="POST">
            Username: <input type="text" name="user"/><br/>
            Password: <input type="password" name="pass"/> <br/>
            <input type="submit" value="Login"/>
        </form>    
    </body>
</html>
