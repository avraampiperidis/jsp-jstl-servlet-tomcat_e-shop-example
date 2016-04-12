<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="customer" class="bookstore.model.CustomerDaoHibernate" scope="session" />
<jsp:useBean id="cart" class="beans.MyCart" scope="session" />
<html>
       
    <head>       
        <title>book store.portal</title>    
    </head>
    
    <link href="css/layout.css" rel="stylesheet" type="text/css" />
    <script src="js/javascript.js" ></script>
    <script src="js/jquery-2.1.4.min.js" ></script>
    
<style>
    
table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    text-align: left;
    padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
    background-color: #4CAF50;
    color: white;
}

</style>
    
    <body>
        
        <div id="top">
            
            welcome <c:out value="${customer.uname}" />
            
            <a href="login.jsp" >| Login |</a> 
            <a href="LogoutServlet">| Log out |</a>
            <a href="index.jsp?p=register">| register |</a>
            <a href="" onclick="return showCart()">| show cart jquery |  </a> 
            <a href="index.jsp?p=cart">| show cart jstl |                 </a> 
            
            <a id="cartsize">  cart size <c:out value="${cart.items.size()}" /> </a>
          
        </div>
        
        
        <div id="left">
            
            <jsp:include page="/CategoryServlet" />
            
        </div>
        
        
        <div id="content">
            
            <c:choose>
                <c:when test="${empty param.cat}">
                   
                </c:when>
                <c:otherwise>
                    
                    <jsp:include page="/ProductServlet" >
                        <jsp:param name="cat" value="${param.cat}" />
                    </jsp:include>
                    
                </c:otherwise>
            </c:choose>
            
            <c:if test="${param.p == 'cart'}" >
                
                <table border="1">
                    <tr>
                        <th>remove</th>
                        <th>ID</th>
                        <th>Title</th>
                        <th>Description</th>
                        <th>price</th>
                        <th>Quantity</th>
                    </tr>
                    
                <c:forEach var="item" items="${cart.items}">
                    
                    <tr>
                    <td><a class='button-action'  href='RemoveItemServlet?product=${item.id}&param=remove' > remove </a> </td>
                    <td>${item.id}</td>
                    <td>${item.title}</td>      
                    <td>${item.description}</td>
                    <td>${item.price}</td>
                    <td>${item.quantity}</td>
                    </tr>
                    
                </c:forEach>
                    
                </table>
                
            </c:if>   
                
            
        </div>
        
        
        
        <div id="footer">
            footer@
        </div>
        
    </body>
    
</html>