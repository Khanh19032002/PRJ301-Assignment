<%-- 
    Document   : LoginError
    Created on : Jul 14, 2022, 6:00:16 PM
    Author     : KakaNoob
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
            <script>
            var count = 3;
            function redirect()
            {
                count--;
                document.getElementById('timer').innerHTML = count;
                if(count <= 0)
                {
                    window.location.href = '../login';
                }
            }
            setInterval(redirect,1000);
        </script>
    </head>
    <body>
        <h1>FPT University Academic Portal</h1>
        <h2>Login Failed!</h2>
     Redirect to login page after <span id="timer">3</span> seconds!
    </body>
</html>
