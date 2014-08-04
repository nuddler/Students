/*$("li").on("click",function(){
	alert("1");
	}
)*/
$( document ).ready(function() {
	$("#formularz").validate(
			{
				rules: {
					vorName: {
						required: true,
						minlength: 2
					}
				},
				messages: {
					vorName: {
						required: 'Pole wymagane',
						minlength: 'Wpisz conajmniej {0} znaki'
					}
				}
			}
			
	);
	/*$("form").click(function(){
		alert($(this).text());
		}	
	)*/
});

/*alert("1");*/