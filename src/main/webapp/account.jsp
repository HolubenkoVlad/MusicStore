<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>My Account</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/account-css.css">
<script>

	$(document).ready(function() { 
            $('input[type="file"]').change(function(e) { 
                var photo = e.target.files[0].name; 
                $("#photoField").val(photo); 
  				$("#filename").text(photo);
  				$("#photoField1").val(photo); 
  				$("#filename1").text(photo);  
  				$("#photoField2").val(photo); 
  				$("#filename2").text(photo); 
            }); 
        });
$(document).ready(function() {
	$('#addGuitar').hide();
	$('#addDrum').hide();
	$('#addSynth').hide();
});

function showAddGuitarFields(){
	$('#addGuitar').show();
	$('#addDrum').hide();
	$('#addSynth').hide();
		$('#allTables').hide();
}

function showAddDrumFields(){
	$('#addDrum').show();
	$('#addGuitar').hide();
	$('#addSynth').hide();
		$('#allTables').hide();
}

function showAddSynthFields(){
	$('#addSynth').show();
	$('#addGuitar').hide();
	$('#addDrum').hide();
		$('#allTables').hide();
}

function hideAddGuitarFields(){
	$('#addGuitar').hide();
}

function hideAddDrumFields(){
	$('#addDrum').hide();
}

function hideAddSynthFields(){
	$('#addSynth').hide();
}

function guitarSender() {
      var guitarForm   = $('#guitarform').serialize();
            $.ajax({
                type: "POST",
                url: '<c:url value="/api/addguitar.do"></c:url>',
                data: guitarForm,
                success:function(msg){
                    const obj = JSON.parse(msg);
                        alert(obj.message);
                }
            });
}

function drumSender() {
      var drumForm   = $('#drumform').serialize();
            $.ajax({
                type: "POST",
                url: '<c:url value="/api/adddrum.do"></c:url>',
                data: drumForm,
                success:function(msg){
                    const obj = JSON.parse(msg);
                        alert(obj.message);
                }
            });
}

function synthesizerSender() {
      var synthForm   = $('#synthesizerform').serialize();
            $.ajax({
                type: "POST",
                url: '<c:url value="/api/addsynthesizer.do"></c:url>',
                data: synthForm,
                success:function(msg){
                    const obj = JSON.parse(msg);
                        alert(obj.message);
                }
            });
}

	function send() {
      var orderForm   = $('#form').serialize();
            $.ajax({
                type: "POST",
                url: '<c:url value="/add_order.do"></c:url>',
                data: orderForm,
                success:function(msg){
                    const obj = JSON.parse(msg);
                    if (obj.status) {
                        window.location.href = '<c:url value="/'+obj.message+'.jsp"></c:url>';                  
                    } else {
                        alert(obj.message);
                    }
                }
            });
}

function hideDrumTable(){
	$('#drumTable').empty();
}

function hideGuitarTable(){
	$('#guitarTable').empty();
}
function hideSynthesizerTable(){
	$('#synthesizerTable').empty();
}

function hideUserTable(){
	$('#userTable').empty();
}

function hideAllTables(){
	$('#allTables').hide();
}

function showTable() {
	$('#addDrum').hide();
	$('#addGuitar').hide();
	$('#addSynth').hide();
	$("#allTables").show();
	$('#drumTable').empty();
          $.ajax({
          	type: "GET",
              url: '<c:url value="/api/drums.do"></c:url>',
              dataType: 'json',
              async: true,
              success:function(listitems){
              	var content="<h3 id=\"casth\">Drums</h3>";
              	 content += "<table id=\"productsTable\" class=\"table\" border=\"1\" cellpadding=\"10px\">";
            	 content+="<thead class=\"thead-light\"><tr><th scope=\"col\">#</th><th scope=\"col\">Name</th><th scope=\"col\">Feature</th><th scope=\"col\">Price, &euro;</th><th scope=\"col\">Photo</th><th scope=\"col\">Number of drums</th><th scope=\"col\">Color</th><th scope=\"col\">Size</th><th scope=\"col\"></th><th scope=\"col\"></th></tr></thead>"
            	  $.each(listitems, function(index,item){
            	  	content+='<tbody>';
        			  content+='<tr>';
        		      content += '<th scope="row">' +  item.id + '</th>'+'<td>' +  item.name + '</td>';
        		      content += '<td>' +  item.feature + '</td>'+'<td>' +  item.price + '</td>'+'<td>' +  item.photo + '</td>'+'<td>' +  item.numberOfDrums + '</td>'+'<td>' +  item.color + '</td>'+'<td>' +  item.size + '</td>'
        		      +'<td><button onclick="showEdit('+item.id+')">Edit</button></td>';
        		      content+='<td><a href="<c:url value="/api/remove_drum.do?position='+item.id+'"/>">X</a></td>';
        		      content+='</tr>';
        		      content+='</tbody>';
            	  });
            		  content += "</table>"
            		  content+="<div id=\"eraseCart\"><a class=\"float-right\" onclick=\"hideDrumTable()\" >Hide table</a></div>"
            		  $('#drumTable').append(content);
              }
          });
          $('#guitarTable').empty();
          $.ajax({
          	type: "GET",
              url: '<c:url value="/api/guitars.do"></c:url>',
              dataType: 'json',
              async: true,
              success:function(listitems){
              	var content="<h3 id=\"casth\">Guitars</h3>";
              	 content += "<table id=\"productsTable\" class=\"table\" border=\"1\" cellpadding=\"10px\">";
            	 content+="<thead class=\"thead-light\"><tr><th scope=\"col\">#</th><th scope=\"col\">Name</th><th scope=\"col\">Feature</th><th scope=\"col\">Price, &euro;</th><th scope=\"col\">Photo</th><th scope=\"col\">Number of strings</th><th scope=\"col\">Material</th><th scope=\"col\">Type</th><th scope=\"col\"></th><th scope=\"col\"></th></tr></thead>"
            	  $.each(listitems, function(index,item){
            	  	content+='<tbody>';
        			  content+='<tr>';
        		      content += '<th scope="row">' +  item.id + '</th>'+'<td>' +  item.name + '</td>';
        		      content += '<td>' +  item.feature + '</td>'+'<td>' +  item.price + '</td>'+'<td>' +  item.photo + '</td>'+'<td>' +  item.numberOfStrings + '</td>'+'<td>' +  item.material + '</td>'+'<td>' +  item.type + '</td>'
        		      +'<td><button onclick="showEdit('+item.id+')">Edit</button></td>';
        		      content+='<td><a href="<c:url value="/api/remove_guitar.do?position='+item.id+'"/>">X</a></td>';
        		      content+='</tr>';
        		      content+='</tbody>';
            	  });
            		  content += "</table>"
            		  content+="<div id=\"eraseCart\"><a class=\"float-right\" onclick=\"hideGuitarTable()\" >Hide table</a></div>"
            		  $('#guitarTable').append(content);
              }
          });
          $('#synthesizerTable').empty();
          $.ajax({
          	type: "GET",
              url: '<c:url value="/api/synthesizers.do"></c:url>',
              dataType: 'json',
              async: true,
              success:function(listitems){
              	var content="<h3 id=\"casth\">Synthesizers</h3>";
              	 content += "<table id=\"productsTable\" class=\"table\" border=\"1\" cellpadding=\"10px\">";
            	 content+="<thead class=\"thead-light\"><tr><th scope=\"col\">#</th><th scope=\"col\">Name</th><th scope=\"col\">Feature</th><th scope=\"col\">Price, &euro;</th><th scope=\"col\">Photo</th><th scope=\"col\">Number of keys</th><th scope=\"col\">Type of keyboard</th><th scope=\"col\">Number of timbres</th><th scope=\"col\"></th><th scope=\"col\"></th></tr></thead>"
            	  $.each(listitems, function(index,item){
            	  	content+='<tbody>';
        			  content+='<tr>';
        		      content += '<th scope="row">' +  item.id + '</th>'+'<td>' +  item.name + '</td>';
        		      content += '<td>' +  item.feature + '</td>'+'<td>' +  item.price + '</td>'+'<td>' +  item.photo + '</td>'+'<td>' +  item.numberOfKeys + '</td>'+'<td>' +  item.typeOfKeyboard + '</td>'+'<td>' +  item.numberOfTimbres + '</td>'
        		      +'<td><button onclick="showEdit('+item.id+')">Edit</button></td>';
        		      content+='<td><a href="<c:url value="/api/remove_synthesizer.do?position='+item.id+'"/>">X</a></td>';
        		      content+='</tr>';
        		      content+='</tbody>';
            	  });
            		  content += "</table>"
            		  content+="<div id=\"eraseCart\"><a class=\"float-right\" onclick=\"hideSynthesizerTable()\" >Hide table</a></div>"
            		  $('#synthesizerTable').append(content);
              }
          });
          $('#hideTables').empty();
          var content="<br><a onclick=\"hideAllTables()\" >Hide tables</a>"
            		  $('#hideTables').append(content);
}

function showUserTable() {
	$('#userTable').empty();
          $.ajax({
          	type: "GET",
              url: '<c:url value="/api/users.do"></c:url>',
              dataType: 'json',
              async: true,
              success:function(listitems){
              	var content="<h3 id=\"casth\">Users</h3>";
              	 content += "<table id=\"productsTable\" class=\"table\" border=\"1\" cellpadding=\"10px\">";
            	 content+="<thead class=\"thead-light\"><tr><th scope=\"col\">#</th><th scope=\"col\">Surname</th><th scope=\"col\">Email</th><th scope=\"col\">Login</th><th scope=\"col\">Type</th><th scope=\"col\"></th><th scope=\"col\"></th></tr></thead>"
            	  $.each(listitems, function(index,item){
            	  	content+='<tbody>';
        			  content+='<tr>';
        		      content += '<th scope="row">' +  item.id + '</th>'+'<td>' +  item.surname + '</td>';
        		      content += '<td>' +  item.email + '</td>'+'<td>' +  item.login + '</td>'+'<td>' +  item.type.name + '</td>' +'<td><button onclick="showEdit('+item.id+')">Edit</button></td>';
        		      content+='<td><a href="<c:url value="/api/remove_user.do?position='+item.id+'"/>">X</a></td>';
        		      content+='</tr>';
        		      content+='</tbody>';
            	  });
            		  content += "</table>"
            		  content+="<div id=\"eraseCart\"><a class=\"float-right\" onclick=\"hideUserTable()\" >Hide table</a></div>"
            		  $('#userTable').append(content);
              }
          });
}
</script>
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="order.jsp"/>
<div class="container-block">
  <div class="block" class="align-self-stretch">
  	<c:choose>
  <c:when test="${login.getType().getName() eq 'admin'}">
  <div id="adminButtons">
  	<div class="col text-center">
  		<div class="row">
  		<div class="col">
<div class="dropdown">
  <button class="btn btn-primary btn-lg dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Add</button>
  <div class="dropdown-menu" aria-labelledby="dropdownMenu2">
    <button class="dropdown-item" onclick="showAddGuitarFields()">Guitar</button>
    <button class="dropdown-item" onclick="showAddDrumFields()">Drum</button>
    <button class="dropdown-item" onclick="showAddSynthFields()">Synthesizer</button>
  </div>
</div>
  		</div>
  		<div class="col">
<button class="btn btn-primary btn-lg" onclick="showTable()">Show products list</button>
  		</div>
  		<div class="col">
<button class="btn btn-primary btn-lg" onclick="showUserTable()">Show users list</button>
  		</div>
  		<div class="col">
<form action='<c:url value="/logout.do"/>' method="post"><input id="logout" class="btn btn-primary" type="submit" value="Exit"></form>
  		</div>
  	</div>
  <div id="allTables">
  		<div id="drumTable"></div>
  		<div id="guitarTable"></div>
  		<div id="synthesizerTable"></div>
  		<div id="hideTables"></div>
  </div>
  <div id="userTable"></div>
  <div id="addGuitar">
  	<form class="form-horizontal" action="javascript:void(null);" method="post" modelAttribute="guitar" id="guitarform" name="test" onsubmit="guitarSender()">
  <fieldset>
    <div id="legend">
      <legend class="">Add guitar</legend>
    </div>
          <div class="col-sm-10">
          	<div class="form-group row">
    	<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-default">Name</span>
  </div>
  <input class="form-control" name="name" type="text" id="name" placeholder="" class="input-xlarge">
</div> 
         </div>
    </div>
 <div class="form-group row"> 
          <div class="col-sm-10">
           <div class="form-group">
  <label for="comment" class="col-sm-2 col-form-label">Feature:</label>
  <textarea name="feature" class="form-control" rows="5" id="comment"></textarea>
</div>
         </div>
      </div>
<div class="form-group row"> 
           <div class="col-sm-10">
           	<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-default">Price</span>
  </div>
  <input class="form-control" name="price" type="number" id="price" placeholder="" class="input-xlarge">
</div>
        </div>
      </div>  
 <div class="form-group row">
           <div class="col-sm-10">
           	<div class="input-group">
           		<div class="input-group-prepend">
    <span class="input-group-text" id="inputGroupFileAddon01">Photo</span>
  </div>
  				<div class="custom-file">
  				  <input type="file" class="custom-file-input" id="inputGroupFile01"
  			    aria-describedby="inputGroupFileAddon01">
  			    <input type="hidden" name="photo" id="photoField">
  				  <label class="custom-file-label" id="filename" for="inputGroupFile01">Choose file</label>
  				</div>
			</div>
         </div>
      </div>
 <div class="form-group row">
           <div class="col-sm-10">
           	<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-default">Number of strings</span>
  </div>
  <input class="form-control" type="number" id="number_of_strings" name="numberOfStrings" placeholder="" class="input-xlarge">
</div>
      		</div>
 </div>
 <div class="form-group row">
           <div class="col-sm-10">
           	<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-default">Material</span>
  </div>
  <input class="form-control" type="text" id="material" name="material" placeholder="" class="input-xlarge">
</div>
      		</div>
 </div>
 <div class="form-group row">
           <div class="col-sm-10">
           	<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-default">Type</span>
  </div>
  <input class="form-control" type="text" id="type" name="type" placeholder="" class="input-xlarge">
</div>
      		</div>
 </div>
    <div class="control-group">
      <div class="controls">
        <br><div class="col text-center"><input class="btn btn-primary" id="centered" type="submit" name="submit" value="ADD"></div>
      </div>
    </div>
  </fieldset>
</form>
<div id="hideGuitar"><a class="float-right" onclick="hideAddGuitarFields()">Hide table</a></div>
  </div>
  <div id="addDrum">
  		<form class="form-horizontal" action="javascript:void(null);" method="post" modelAttribute="drum" id="drumform" name="test" onsubmit="drumSender()">
  <fieldset>
    <div id="legend">
      <legend class="">Add drum</legend>
    </div>
          <div class="col-sm-10">
          	<div class="form-group row">
    	<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-default">Name</span>
  </div>
  <input class="form-control" name="name" type="text" id="name" placeholder="" class="input-xlarge">
</div> 
         </div>
    </div>
 <div class="form-group row"> 
          <div class="col-sm-10">
           <div class="form-group">
  <label for="comment" class="col-sm-2 col-form-label">Feature:</label>
  <textarea name="feature" class="form-control" rows="5" id="comment"></textarea>
</div>
         </div>
      </div>
<div class="form-group row"> 
           <div class="col-sm-10">
           	<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-default">Price</span>
  </div>
  <input class="form-control" name="price" type="number" id="price" placeholder="" class="input-xlarge">
</div>
        </div>
      </div>  
 <div class="form-group row">
           <div class="col-sm-10">
           	<div class="input-group">
           		<div class="input-group-prepend">
    <span class="input-group-text" id="inputGroupFileAddon01">Photo</span>
  </div>
  				<div class="custom-file">
  				  <input type="file" class="custom-file-input" id="inputGroupFile01"
  			    aria-describedby="inputGroupFileAddon01">
  			    <input type="hidden" name="photo" id="photoField1">
  				  <label class="custom-file-label" id="filename1" for="inputGroupFile01">Choose file</label>
  				</div>
			</div>
         </div>
      </div>
 <div class="form-group row">
           <div class="col-sm-10">
           	<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-default">Number of drums</span>
  </div>
  <input class="form-control" type="number" id="number_of_drums" name="numberOfDrums" placeholder="" class="input-xlarge">
</div>
      		</div>
 </div>
 <div class="form-group row">
           <div class="col-sm-10">
           	<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-default">Color</span>
  </div>
  <input class="form-control" type="text" id="color" name="color" placeholder="" class="input-xlarge">
</div>
      		</div>
 </div>
 <div class="form-group row">
           <div class="col-sm-10">
           	<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-default">Size</span>
  </div>
  <input class="form-control" type="text" id="size" name="size" placeholder="" class="input-xlarge">
</div>
      		</div>
 </div>
    <div class="control-group">
      <div class="controls">
        <br><div class="col text-center"><input class="btn btn-primary" id="centered" type="submit" name="submit" value="ADD"></div>
      </div>
    </div>
  </fieldset>
</form>
<div id="hideGuitar"><a class="float-right" onclick="hideAddDrumFields()">Hide table</a></div>
  </div>
  <div id="addSynth">
  	<form class="form-horizontal" action="javascript:void(null);" method="post" modelAttribute="synthesizer" id="synthesizerform" name="test" onsubmit="synthesizerSender()">
  <fieldset>
    <div id="legend">
      <legend class="">Add synthesizer</legend>
    </div>
          <div class="col-sm-10">
          	<div class="form-group row">
    	<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-default">Name</span>
  </div>
  <input class="form-control" name="name" type="text" id="name" placeholder="" class="input-xlarge">
</div> 
         </div>
    </div>
 <div class="form-group row"> 
          <div class="col-sm-10">
           <div class="form-group">
  <label for="comment" class="col-sm-2 col-form-label">Feature:</label>
  <textarea name="feature" class="form-control" rows="5" id="comment"></textarea>
</div>
         </div>
      </div>
<div class="form-group row"> 
           <div class="col-sm-10">
           	<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-default">Price</span>
  </div>
  <input class="form-control" name="price" type="number" id="price" placeholder="" class="input-xlarge">
</div>
        </div>
      </div>  
 <div class="form-group row">
           <div class="col-sm-10">
           	<div class="input-group">
           		<div class="input-group-prepend">
    <span class="input-group-text" id="inputGroupFileAddon01">Photo</span>
  </div>
  				<div class="custom-file">
  				  <input type="file" class="custom-file-input" id="inputGroupFile01"
  			    aria-describedby="inputGroupFileAddon01">
  			    <input type="hidden" name="photo" id="photoField2">
  				  <label class="custom-file-label" id="filename2" for="inputGroupFile01">Choose file</label>
  				</div>
			</div>
         </div>
      </div>
 <div class="form-group row">
           <div class="col-sm-10">
           	<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-default">Number of keys</span>
  </div>
  <input class="form-control" type="number" id="number_of_keys" name="numberOfKeys" placeholder="" class="input-xlarge">
</div>
      		</div>
 </div>
 <div class="form-group row">
           <div class="col-sm-10">
           	<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-default">Type of keyboard</span>
  </div>
  <input class="form-control" type="text" id="type_of_keyboard" name="typeOfKeyboard" placeholder="" class="input-xlarge">
</div>
      		</div>
 </div>
 <div class="form-group row">
           <div class="col-sm-10">
           	<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-default">Number of timbres</span>
  </div>
  <input class="form-control" type="number" id="type" name="numberOfTimbres" placeholder="" class="input-xlarge">
</div>
      		</div>
 </div>
    <div class="control-group">
      <div class="controls">
        <br><div class="col text-center"><input class="btn btn-primary" id="centered" type="submit" name="submit" value="ADD"></div>
      </div>
    </div>
  </fieldset>
</form>
<div id="hideGuitar"><a class="float-right" onclick="hideAddSynthFields()">Hide table</a></div>
  </div>
  </div>
  </div>
  
  </c:when>
  <c:otherwise>
  	<div class="row">
  		<div class="col-6">
  			<div id="legend">
     			 <legend class="welcome">Welcome, ${login.getSurname()}</legend>
            </div>
  		</div>
  		<div class="col">
 <form action='<c:url value="/logout.do"/>' method="post"><input id="logout" class="btn btn-primary" type="submit" value="Exit"></form>
  		</div>
  	</div>
  	
    <c:choose>
    <c:when test="${Cart.getCount() eq 0 || empty Cart}">
       <h3 id="emptycart">Cart is empty</h3>
     </c:when>
    <c:otherwise>
    <h3 id="casth">Cart</h3>
    <div class="w-100 p-3" class="text-center">
    	 <table id="productsTable" class="table" border="1" cellpadding="10px">
       	<thead class="thead-light">
    <tr>
      <th scope="col">#</th>
      <th scope="col">id</th>
      <th scope="col">Name</th>
      <th scope="col">Feature</th>
       <th scope="col">Price, &euro;</th>
       <th scope="col">Quantity</th>
       <th scope="col"></th>
    </tr>
  </thead>
  <tbody>
  	<c:forEach var="cart" items="${Cart.getItems()}" varStatus="status">
  	<tr>
  		<th scope="row">${status.index+1}</th>
      <td>${cart.getProduct().getId()}</td>
      <td>${cart.getProduct().getName()}</td>
      <td>${cart.getProduct().toString()}</td>
      <td>${cart.getTotalprice()}</td>
  		<td>${cart.getCount()}</td>
  		<td><a href="<c:url value="/remove_from_cart.do?position=${status.index}"/>">X</a></td>
  	</tr>
  	</c:forEach>
  </tbody>
</table>
    </div>
<div id="totalPrice"><p class="float-right"><strong>Total price: ${Cart.getTotalPrice()} euro.</strong></p></div>
<div class="col text-center"><div id="orderButton"><button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#exampleModalCenter">&nbsp;&nbsp;&nbsp;Order&nbsp;&nbsp;&nbsp;</button></div></div>
<div id="eraseCart"><a class="float-right" href="<c:url value="/erase_cart.do"/>"><strong>Erase cart</strong></a></div>
</c:otherwise>
</c:choose>
</c:otherwise>
</c:choose>
  </div>
</div>
</body>
</html>