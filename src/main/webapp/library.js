$(document).ready(function() {
	$("#addLink").click(function(e) {
		event.preventDefault();
		$("#addForm").show();
		$("#findForm").hide();
		$("#addResult").hide();
		$("#findResult").hide();
		$("#isbn").val("");
		$("#title").val("");
	});
	$("#addBtn").click(function() {
		event.preventDefault();
		$("#addForm").hide();
		var isbn = $("#isbn").val();
		var title = $("#title").val();
		var publisher = $("#publisher").val();
		var author1 = $("#author1").val();
		var author2 = $("#author2").val();
		var book = {
			"isbn" : isbn,
			"title" : title,
			"publisher": {"name" : publisher},
			"authors" : [
				{ "name" : author1 },
				{ "name" : author2 }
			]
		};
		$.ajax({
			url : 'rest/library/book',
			type : 'post',
		//	dataType : 'json',
			contentType : 'application/json; charset=utf-8',
			data : JSON.stringify(book),
			success : function(result, status, xhr) {
				//alert("got response ajax res");
				$("#addResult").show();
			}
		}).error(ajaxError);
//		.done(function(data){
//			alert("got response ajax res")
//			$("#addResult").show();
	});

	$("#findLink").click(function() {
		event.preventDefault();
		$("#addForm").hide();
		$("#findForm").show();
		$("#addResult").hide();
		$("#findResult").hide();
		$("#isbnFind").val("");
	});
	$("#findBtn").click(function() {
		event.preventDefault();
		$("#findForm").hide();
		var isbn = $("#isbnFind").val();
		$.ajax({
			url : 'rest/library/book/' + isbn,
			type : 'get',
			dataType : 'json',
			contentType : "application/json; charset=utf-8",
			success : function(data) {
				//alert("found the book;");
			//	var jsonRes=$.parseJSON(data);
				//alert("json res " + data[0][0].isbn);
				
				//alert(data.isbn + "  " + data.title);
				$("#foundIsbn").text(data.isbn);
				$("#foundTitle").text(data.title);
				$("#fpublisher").text(data.publisher.name);
				$("#fauthor1").text(data.authors[0].name);
				$("#fauthor2").text(data.authors[1].name);
				//alert(data.authors[0].name);
				$("#findResult").show();
			}
		}).error(ajaxError);
	});
});
function ajaxError(jqXHR,textstatus,errorThrown){
	
	alert("errorThrown: " + errorThrown + " textstatus: " + textstatus + " jqXHR: " +jqXHR)
	//$("#addResult").show();
	
}
