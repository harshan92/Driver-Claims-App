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
     console.log( "table exits!" );
        tableCreate(body);
        requestData("admin","admin");
    }
});

function tableCreate(body) {
    
    var tbl = document.createElement('table');
    tbl.style.width = '100%';
    tbl.setAttribute('border', '1');
    var tbdy = document.createElement('tbody');
    
    var th1 = document.createElement('th');
    var th2 = document.createElement('th');
    var th3 = document.createElement('th');
    var th4 = document.createElement('th');
    var th5 = document.createElement('th');
    
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
    
    
    

    for (var i = 0; i < 3; i++)
    {
        var tr = document.createElement('tr');
        var td = document.createElement('td');
        td.appendChild(document.createTextNode('Hello'));
        //td.setAttribute('rowSpan', '2');
        tr.appendChild(td);
        tbdy.appendChild(tr);
    }

    
    tbl.appendChild(tbdy);
    body.appendChild(tbl);
}


function requestData(username,password)
{
    $.post("AdminSeeUsersController",{ username : "admin", password: "admin"},function( data ) {
         alert( "Data Loaded: " + data );
    });
}