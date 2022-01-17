$(document).ready(function() {

    $.ajax({
        url: "Gps",
        data: { op:"load" },
        method: "POST",
        success: function(data) {
            remplir(data);
        }
    });

	$("#create").click(function() {
		var matricule = $("#matricule").val();
		var marque = $("#marque").val();
		var type = $("#type").val();
		$.ajax({
			url: "Gps",
			data: {matricule: matricule, marque: marque, type:type },
			method: "POST",
			success: function(data) {
				remplir(data);
			}
		});
	});
	
	 $(document).on("click",".remove",function(){

                var current_element = $(this);

                $.ajax({
                  url: "Gps",
                  type:'POST',
				  data: {matricule: matricule, marque: marque, type:type },
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
		data.forEach(e => {
			ligne += "<tr><td>" + e.id + "</td><td>" + e.matricule + "</td><td>" + e.type + "</td><td>" + e.marque + "</td><td><a href='#' class='remove'>supprimer</a></td><td><a href='#' class='remove'>Modifier</a></td></tr>";
		});
		$("#content").html(ligne);

	}

});