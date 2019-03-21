/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$( document ).ready(function() {
    console.log( "ready!" );
    var body = document.getElementById("table_area");
    
    if(body !==null)
    {
        body.innerHTML="Please Wait"
        console.log( "table exits!" );
        requestData(body);
    }
});

function tableCreate(body,data) {
    
    var tbl = document.createElement('table');
    tbl.style.width = '100%';
    tbl.setAttribute('border', '1');
    tbl.style.border="1px solid red";
    var tbdy = document.createElement('tbody');
    
    var th1 = document.createElement('th');
    var th2 = document.createElement('th');
    var th3 = document.createElement('th');
    var th4 = document.createElement('th');
    
    th4.innerHTML = "Member" ;
    th1.innerHTML = "Date" ;
    th2.innerHTML = "Type of Payment" ;
    th3.innerHTML = "Amount" ;
    
    tbdy.appendChild(th1);
    tbdy.appendChild(th2);
    tbdy.appendChild(th3);
    tbdy.appendChild(th4);
    
    
    

    for (var i = 0; i < data.length; i++)
    {
        var tr = document.createElement('tr');
        var td1 = document.createElement('td');
        var td2 = document.createElement('td');
        var td3 = document.createElement('td');
    
       
        var link = document.createElement('a');
        link.appendChild(document.createTextNode(data[i][3]));
        link.title = "Details";
        link.href = "admin_see_user.jsp?userid="+data[i][4];
      
        td1.appendChild(document.createTextNode(data[i][0]));
        td2.appendChild(document.createTextNode(data[i][1]));
        td3.appendChild(document.createTextNode("\u00A3"+data[i][2]));
       
        
        tr.appendChild(td1);
        tr.appendChild(td2);
        tr.appendChild(td3);
        tr.appendChild(link);
        
        tbdy.appendChild(tr);
    }

    
    tbl.appendChild(tbdy);
    body.appendChild(tbl);
}


function requestData(body)
{
    $.post("AdminSeePaymentsController",{type : "data" },function( data ) {
        //alert( "Data Loaded: " + JSON.stringify(data )+"<br/1>"+data.length);
        body.innerHTML = "";
        if(data == "Could not process request")
        {
            body.innerHTML = "Please Refersh page"
        }else
        {
            
            tableCreate(body,data);
         
        }
         
    });
    
   
}

  
$(document).ajaxError(function (event, jqxhr, settings, thrownError) {
    var body = document.getElementById("table_area");
    body.innerHTML = "Please Refersh page";
});