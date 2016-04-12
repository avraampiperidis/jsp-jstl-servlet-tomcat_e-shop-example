     
function addToCart(id) {
        
  $.ajax({
      
      url: 'AddToCartServlet?product='+id,
      success : function (result) {
          
          $("#cartsize").empty();
          
          $("#cartsize").text("|cart size:"+result);
          
      }
      
  });
  
            
}


function showCart() {
    
    //old pure servlet way
    //$.getJSON("GetCartProductsToJsonServlet",function(data){
    
    //jersey rest way
      $.getJSON("rest/showcart",function(data){        
        $("#content").empty();
        
        var content = "<table border='1'>";
        
        content += "<tr>";
        
        content += "<th>remove</th>";
        content += "<th>ID</th>";
        content += "<th>Title</th>";
        content += "<th>Description</th>";
        content += "<th>Price</th>";
        content += "<th>Quantity</th>";
        
        content += "</tr>";
        
        
        for(var i =0, len = data["products"].length; i < len; i++) {
            content += "<tr>";
            
            content += "<td><a class='button-action'  href='RemoveItemServlet?product="+data["products"][i]["id"]+"&param=remove' > remove </a> </td>";
            content += "<td>"+data["products"][i]["id"]+"</td>";
            content += "<td>"+data["products"][i]["title"]+"</td>";
            content += "<td>"+data["products"][i]["description"]+"</td>";
            content += "<td>"+data["products"][i]["price"]+"</td>";
            content += "<td>"+data["products"][i]["quantity"]+"</td>";
            
            content += "</tr>";
            
        }
        
        content += "</table>";
        
        $("#content").append(content);
        
    });
    
    return false;
}
        
    