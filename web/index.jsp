<%-- 
    Document   : index
    Created on : May 24, 2022, 9:38:02 AM
    Author     : ADMIN
--%>

<%@page import="com.sun.corba.se.impl.protocol.giopmsgheaders.Message"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="node_modules/bootstrap/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="./styles.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="card row align-item-center">
            <div class="card-header bg-primary text-white align-self-center">
                <h2>Date Time Checker</h2>
            </div>
            <div class="card-body align-self-center">
                <form action="processServlet" method="post">
                    <div class="form-group">
                        <label>Day:</label> 
                        <input type="text" name="txtDay" placeholder="Day" />
                    </div>    
                    <div class="form-group">
                        <label>Month:</label> 
                        <input type="text" name="txtMonth" placeholder="Month" />
                    </div>
                    <div class="form-group">
                        <label>Year:</label> 
                        <input type="text" name="txtYear" placeholder="Year" />
                    </div>
                   <input type="submit" class="btn btn-primary" value="Check" />
                </form>     
                <% String errorMessage = (String)request.getAttribute("alertMsg");%>
                <% if (errorMessage != "" && errorMessage != null) {%>
                    <script type="text/javascript">
                       var msg = "<%=errorMessage%>";
                       alert(msg);
                    </script>
                <%}%> 
                <% String messageBox = (String)request.getAttribute("Msg");%>
               <% if (messageBox != "" && messageBox != null) {%>
                    <script type="text/javascript">
                        var msg = "<%=messageBox%>";
                        alert(msg);
                    </script>
                <%}%> 
            </div> 
        </div>
	    <script src="node_modules/jquery/dist/jquery.slim.min.js"></script>
	    <script src="node_modules/popper.js/dist/umd/popper.min.js"></script>
	    <script src="node_modules/bootstrap/dist/js/bootstrap.min.js"></script>

    </body>
</html>
