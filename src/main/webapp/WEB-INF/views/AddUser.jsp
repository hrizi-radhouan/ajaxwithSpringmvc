<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Users using ajax</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</head>
<body>
	<h2 align="center">Welcome to AJAX</h2>
	<div align="center">
	

		<c:forEach items="${variablesListModel.getListVaraibles()}" var="row">
	
		<label>${row.getName()} :<input type="checkbox" id="${row.getID()}" name="${row.getName()}" value="${row.getName()}"
			onchange="doAjaxPost(this,'${row.getID()}','${row.getName()}','${row.getMiniBudget()}','${row.getMaxBudget()}')"><br /></label>
		
		</c:forEach>
		
		
		
	</div>
	
	<div id="disp" align="center">
	<table border="2px"><tr><td>Variable</td><td>Mini Budget</td><td>Max Budget</td></tr></table>
	</div>
	<script type="text/javascript">
var y;
	function doAjaxPost(elem, id,nameVariable,miniBudget,maxBudget) {
		// get the form values
		if (elem.checked) {
			//var name = x;
			
			$.ajax({
				type : "POST",
				url : "/test/AddUser.htm",
				data : "selectedVar="+id+":"+nameVariable +":"+miniBudget+":"+maxBudget,
				success : function(json) {
					// we have the response
				//	$('#info1').html(user);
					var myTable ="<table border=\"2px\"><tr><td>Variable</td><td>Mini Budget</td><td>Max Budget</td></tr>";
				
					var variables = json.split(";")
					var myRes="";
					
					for(item in  variables){
						variable = variables[item];
						var res = variable.split(":");
						var name = "<tr><td>"+res['1']+"</td>";
						var miniBudget = "<td>"+res['2']+"</td>";
						var maxBudget = "<td>"+res['3']+"</td></tr>";
						myRes=name+miniBudget+maxBudget+myRes;
						
						
					}
					var finalRes=myTable+myRes+"</table>" 
					$('#disp').html(finalRes);
						
					
					
			

				},
				error : function(e) {
					alert('Error: ' + e);
				}
			});

		} else {
			//var name = x;
			$.ajax({
				type : "POST",
				url : "/test/DeleUser.htm",
				data : "selectedVar="+id+":"+nameVariable +":"+miniBudget+":"+maxBudget,
				success : function(json) {
					// we have the response
					
					var myTable ="<table border=\"2px\"><tr><td>Variable</td><td>Mini Budget</td><td>Max Budget</td></tr>";
					
					var variables = json.split(";")
					var myRes="";
					
					for(item in  variables){
						variable = variables[item];
						var res = variable.split(":");
						var name = "<tr><td>"+res['1']+"</td>";
						var miniBudget = "<td>"+res['2']+"</td>";
						var maxBudget = "<td>"+res['3']+"</td></tr>";
						myRes=name+miniBudget+maxBudget+myRes;
						
						
					}
					var finalRes=myTable+myRes+"</table>" 
					$('#disp').html(finalRes);
					
			
					//$('#name').val('');

				},
				error : function(e) {
					alert('Error: ' + e);
				}
			});

		}
	}
</script>
</body>
</html>