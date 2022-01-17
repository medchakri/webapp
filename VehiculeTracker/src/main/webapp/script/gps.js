$(document).ready(function() {

    $.ajax({
        url: "tracker",
        data: { po:"load" },
        method: "POST",
        success: function(data) {
            remplir(data);
        }
    });

	$("#create").click(function() {
		var simNumber = $("#simNumber").val();
		
		$.ajax({
			url: "tracker",
			data: {simNumber: simNumber},
			method: "POST",
			success: function(data) {
				remplir(data);
			}
		});
	});
	
	 $(document).on("click",".remove",function(){

                var current_element = $(this);

                $.ajax({
                  url: "tracker",
                  type:'POST',
				  data: {simNumber: simNumber },
                  success:function(data){
                      if(data == 1)
                      {
                           current_element.closest("tr").remove();
						   remplir(data);

                      }
                  }
                });
    });


	function remplir(data) {
		var ligne = "";
		data.forEach(t => {
			ligne += "<tr><td>" + t.id + "</td><td>" + t.simNumber + "</td><td><a href='#' class='remove'>supprimer</a></td><td>Modifier</td></tr>";
		});
		$("#content").html(ligne);

	}

});