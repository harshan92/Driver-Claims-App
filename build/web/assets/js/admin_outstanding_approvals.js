/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$( document ).ready(function() {
    console.log( "ready!" );
    var body = document.getElementById("table_area");
    var body2 = document.getElementById("table_area2");
    
    if(body !== null && body2 !== null)
    {
        body.innerHTML ="Please wait";
        body2.innerHTML ="Please wait";
        console.log( "table exits!" );
        requestMembersData(body);
        requestClaimsData(body2);
    }
});

function tableCreateMembers(body,data) {
    
    var tbl = document.createElement('table');
    tbl.style.width = '100%';
    tbl.setAttribute('border', '1');
    tbl.style.border="1px solid red";
    var tbdy = document.createElement('tbody');
    
    var th1 = document.createElement('th');
    var th2 = document.createElement('th');
    var th3 = document.createElement('th');
    var th4 = document.createElement('th');
    var th5  = document.createElement('th');
    
    th1.innerHTML = "Username" ;
    th2.innerHTML = "User Type" ;
    th3.innerHTML = "Name" ;
    th4.innerHTML = "Status" ;
    th5.innerHTML = "Details" ;
    
    tbdy.appendChild(th1);
    tbdy.appendChild(th2);
    tbdy.appendChild(th3);
    tbdy.appendChild(th4);
    tbdy.appendChild(th5);
    
    
    

    for (var i = 0; i < data.length; i++)
    {
        var tr = document.createElement('tr');
        var td1 = document.createElement('td');
        var td2 = document.createElement('td');
        var td3 = document.createElement('td');
        var td4 = document.createElement('td');
       
        var link = document.createElement('a');
        link.appendChild(document.createTextNode("Details"));
        link.title = "Details";
        link.href = "admin_see_user.jsp?userid="+data[i][4];
        
        td1.appendChild(document.createTextNode(data[i][0]));
        td2.appendChild(document.createTextNode(data[i][1]));
        td3.appendChild(document.createTextNode(data[i][2]));
        td4.appendChild(document.createTextNode(data[i][3]));
       
        
        tr.appendChild(td1);
        tr.appendChild(td2);
        tr.appendChild(td3);
        tr.appendChild(td4);
        tr.appendChild(link);
        
        tbdy.appendChild(tr);
    }

    
    tbl.appendChild(tbdy);
    body.appendChild(tbl);
}

function tableCreateClaims(body,data) {
    
    var tbl = document.createElement('table');
    tbl.style.width = '100%';
    tbl.setAttribute('border', '1');
    tbl.style.border="1px solid red";
    var tbdy = document.createElement('tbody');
    
    var th1 = document.createElement('th');
    var th2 = document.createElement('th');
    var th3 = document.createElement('th');
    var th4 = document.createElement('th');
    var th5  = document.createElement('th');
    
    th5.innerHTML = "Member" ;
    th1.innerHTML = "Date" ;
    th2.innerHTML = "Rationale" ;
    th3.innerHTML = "Status" ;
    th4.innerHTML = "Amount" ;
    
    tbdy.appendChild(th1);
    tbdy.appendChild(th2);
    tbdy.appendChild(th3);
    tbdy.appendChild(th4);
    tbdy.appendChild(th5);
    
    
    

    for (var i = 0; i < data.length; i++)
    {
        var tr = document.createElement('tr');
        var td1 = document.createElement('td');
        var td2 = document.createElement('td');
        var td3 = document.createElement('td');
        var td4 = document.createElement('td');
    
       
        var link = document.createElement('a');
        link.appendChild(document.createTextNode(data[i][4]));
        link.title = "Details";
        link.href = "admin_see_user.jsp?userid="+data[i][5];
      
        td1.appendChild(document.createTextNode(data[i][0]));
        td2.appendChild(document.createTextNode(data[i][1]));
        td3.appendChild(document.createTextNode(data[i][2]));
        td4.appendChild(document.createTextNode("\u00A3"+data[i][3]));
       
        
        tr.appendChild(td1);
        tr.appendChild(td2);
        tr.appendChild(td3);
        tr.appendChild(td4);
        tr.appendChild(link);
        
        tbdy.appendChild(tr);
    }

    
    tbl.appendChild(tbdy);
    body.appendChild(tbl);
}





function requestMembersData(body)
{
    $.post("AdminSeeUsersController",{type : "NA" },function( data ) {
        //alert( "Data Loaded: " + JSON.stringify(data )+"<br/1>"+data.length);
        body.innerHTML ="";
        if(data == "Could not process request")
        {
            body.innerHTML = "Please Refersh page";
        }else
        {
            
            tableCreateMembers(body,data);
         
        }
         
    });
}


function requestClaimsData(body)
{
    $.post("AdminSeeClaimsController",{type : "NA" },function( data ) {
        //alert( "Data Loaded: " + JSON.stringify(data )+"<br/1>"+data.length);
        body.innerHTML = "";
        if(data == "Could not process request")
        {
            body.innerHTML = "Please Refersh page"
        }else
        {
            
            tableCreateClaims(body,data);
         
        }
         
    });
    
     
    
}


$(document).ajaxError(function (event, jqxhr, settings, thrownError) {
      var body = document.getElementById("table_area");
      body.innerHTML="Please Refersh page";
});