<%--<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>--%>
<!DOCTYPE html >
<html lang="en">
<head>
<meta charset="utf-8">
		<title>Nuevo proyecto con Bootstrap 2.0</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
		<meta name="description" content="Bootstrap 2.0">
		<meta name="author" content="">
    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le fav and touch icons -->
		<link href="/ProyectoBolsaTrabajo/bootstrap/css/bootstrap.css" rel="stylesheet">

		<style type="text/css">
			body { 
				padding-bottom: 40px;
				padding-top: 10px; 
			}
		</style>
		<link href="/ProyectoBolsaTrabajo/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
		<link href="/ProyectoBolsaTrabajo/bootstrap/css/docs.css" rel="stylesheet">
		
		<script src="/ProyectoBolsaTrabajo/bootstrap/js/jquery.js"></script>
		<script src="/ProyectoBolsaTrabajo/bootstrap/js/bootstrap.js"></script>
		<script src="/ProyectoBolsaTrabajo/bootstrap/js/bootstrap-transition.js"></script>
		<script src="/ProyectoBolsaTrabajo/bootstrap/js/bootstrap-alert.js"></script>
		<script src="/ProyectoBolsaTrabajo/bootstrap/js/bootstrap-modal.js"></script>
		<script src="/ProyectoBolsaTrabajo/bootstrap/js/bootstrap-dropdown.js"></script>
		<script src="/ProyectoBolsaTrabajo/bootstrap/js/bootstrap-scrollspy.js"></script>
		<script src="/ProyectoBolsaTrabajo/bootstrap/js/bootstrap-tab.js"></script>
		<script src="/ProyectoBolsaTrabajo/bootstrap/js/bootstrap-tooltip.js"></script>
		<script src="/ProyectoBolsaTrabajo/bootstrap/js/bootstrap-popover.js"></script>
		<script src="/ProyectoBolsaTrabajo/bootstrap/js/bootstrap-button.js"></script>
		<script src="/ProyectoBolsaTrabajo/bootstrap/js/bootstrap-collapse.js"></script>
		<script src="/ProyectoBolsaTrabajo/bootstrap/js/bootstrap-carousel.js"></script>
		<script src="/ProyectoBolsaTrabajo/bootstrap/js/bootstrap-typeahead.js"></script>
		
		<link href="/ProyectoBolsaTrabajo/jquery/css/flick/jquery-ui-1.9.0.custom.css" rel="stylesheet">
		<script src="/ProyectoBolsaTrabajo/jquery/js/jquery-1.8.2.js"></script>
		<script src="/ProyectoBolsaTrabajo/jquery/js/jquery-ui-1.9.0.custom.js"></script>
		
		<style>
			body{
				font: 80.5% "Trebuchet MS", sans-serif;
				margin: 50px;
			}
			.demoHeaders {
				margin-top: 2em;
			}
			#dialog-link {
				padding: .4em 1em .4em 20px;
				text-decoration: none;
				position: relative;
			}
			#dialog-link span.ui-icon {
				margin: 0 5px 0 0;
				position: absolute;
				left: .2em;
				top: 50%;
				margin-top: -8px;
			}
			#icons {
				margin: 0;
				padding: 0;
			}
			#icons li {
				margin: 2px;
				position: relative;
				padding: 4px 0;
				cursor: pointer;
				float: left;
				list-style: none;
			}
			#icons span.ui-icon {
				float: left;
				margin: 0 4px;
			}
			
			  label, input { display:block; }
        input.text { margin-bottom:12px; width:95%; padding: .4em; }
        fieldset { padding:0; border:0; margin-top:25px; }
        h1 { font-size: 1.2em; margin: .6em 0; }
        div#users-contain { width: 350px; margin: 20px 0; }
        div#users-contain table { margin: 1em 0; border-collapse: collapse; width: 100%; }
        div#users-contain table td, div#users-contain table th { border: 1px solid #eee; padding: .6em 10px; text-align: left; }
        .ui-dialog .ui-state-error { padding: .3em; }
        .validateTips { border: 1px solid transparent; padding: 0.3em; }
	</style>
		 <script  type="text/javascript">
		 var usuario="";
		 var email="";
		 var password="";
    $(function() {
        var //name = $( "#name" ),
            email = $( "#email" ),
            password = $( "#password" ),
            allFields = $( [] ).add( email ).add( password ),
            tips = $( ".validateTips" );
 
        function updateTips( t ) {
            tips
                .text( t )
                .addClass( "ui-state-highlight" );
            setTimeout(function() {
                tips.removeClass( "ui-state-highlight", 1500 );
            }, 500 );
        }
 	/* 	function cargarCv(){
 			$('#cargaCV').submit
 		} */
        function checkLength( o, n, min, max ) {
            if ( o.val().length > max || o.val().length < min ) {
                o.addClass( "ui-state-error" );
                updateTips( "Length of " + n + " must be between " +
                    min + " and " + max + "." );
                return false;
            } else {
                return true;
            }
        }
 
        function checkRegexp( o, regexp, n ) {
            if ( !( regexp.test( o.val() ) ) ) {
                o.addClass( "ui-state-error" );
                updateTips( n );
                return false;
            } else {
                return true;
            }
        }
        
        function sesion(){

                   //  var namee=$("#name").val();
                    var emaill=$("#email").val();
                    var clavee=$("#password").val(); 
                  //  alert("name1=="+namee) ;
                    alert("email1=="+emaill) ;
                    alert("password1=="+clavee) ;
           
                    $.post('/ProyectoBolsaTrabajo/ServletLogin', 
                      {  
                    	 txtUsuario: emaill,
                    	 txtContrasena: clavee 
                      }, 
                        function(data) {
                    	  if(data){
                    		  alert("el dato es=="+data) ;
                    		 // var nom=data.nombre;
                    		  //alert("nom=="+nom);
                    		  var coreo=data.usuario;
                    		  alert("usuario=="+coreo);
                    		 
                    		//  $('#nombres').html(data.nombre);
                    		  $('#usuario').html(data.usuario);
                    		//  $('#claves').html(data.password);
                    		
                    		 // return true;
                    	  }else{
                    		  alert("error de dato") ;
                    		  //return false;
                    	  }
                    },'json');
        }
 
        $( "#dialog-form" ).dialog({
            autoOpen: false,
            height: 320,
            width: 350,
            modal: true,
            buttons: {
                "Iniciar Sesion": function() {
                	sesion();
                    var bValid = true;
               allFields.removeClass( "ui-state-error" );
 
                  //  bValid = bValid && checkLength( name, "username", 3, 16 );
                    bValid = bValid && checkLength( email, "email", 6, 80 );
                    bValid = bValid && checkLength( password, "password", 5, 16 );
 
                  //  bValid = bValid && checkRegexp( name, /^[a-z]([0-9a-z_])+$/i, "Username may consist of a-z, 0-9, underscores, begin with a letter." );
                  //  From jquery.validate.js (by joern), contributed by Scott Gonzalez: http://projects.scottsplayground.com/email_address_validation/
                    bValid = bValid && checkRegexp( email, /^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i, "eg. ui@jquery.com" );
                    bValid = bValid && checkRegexp( password, /^([0-9a-zA-Z])+$/, "Password field only allow : a-z 0-9" );

                    if ( bValid ) {
                        $( "#users tbody" ).append( "<tr>" +
                        //    "<td>" + name.val() + "</td>" +
                            "<td>" + email.val() + "</td>" +
                            "<td>" + password.val() + "</td>" +
                        "</tr>" );
                        $( this ).dialog( "close" );
                    }   
  
                },
                Cancel: function() {
                    $( this ).dialog( "close" );
                }
            },
            close: function() {
                allFields.val( "" ).removeClass( "ui-state-error" );
            }
        });
 
        $( "#create-user" )
            .button()
            .click(function() {
                $( "#dialog-form" ).dialog( "open" );
            });
       	$('#cargaCV').button().click(function(){
       		 nomusuario=$('#usuario').val();
       		alert("Usuario="+nomusuario);
       		$.post('/ProyectoBolsaTrabajo/ServletPostulante',
       		{
       			postulante:nomusuario
       		},
       		function(data){
       			if(data){
       				alert("Ok");
       				return true;
       			}else{
       				alert("error");
       				return false;
       			}
       			
       		},'json');
       	}); 
    });
    </script>
		
</head>

<body><!-- Este es el Body -->

	<div class="container" class="well">
		<div id="usuario" align="right">
		</div>
		<br/>
		<table class="well" width="100%">
			<tr>
				<td style="width: 246px" width="246">
					<label><h3 style="color: blue;">bolsaTrabajo.com</h3></label>
					<!-- <img src="../bootstrap/img/logo.jpg" width="307" height="40"></td> -->
				<td align="right" style="width: 885px; " width="688">
					
						<button id="create-user" >Iniciar Sesion</button>
						<button class="btn btn-primary"  id="cargaCV" type="submit" >Cargar mi CV</button>
					
				</td>
			</tr>
		</table>
		<br/><br/><br/><br/>
	<!--  -->

	
	<div id="dialog-form" title="Iniciar Sesion">
    <p class="validateTips">Todas las casillas son obligatorias.</p>
 
    <form id="iniciosesion" method="post">
    <fieldset>
        <label for="email">Email o Nombre de Usuario</label>
        <input type="text" name="email" id="email" value="" class="text ui-widget-content ui-corner-all" />
        <label for="password">Password</label>
        <input type="password" name="password" id="password" value="" class="text ui-widget-content ui-corner-all" />
    </fieldset>
    </form>
</div>

<div id="users-contain" class="ui-widget">
    <h1>Existing Users:</h1>
    <table id="users" class="ui-widget ui-widget-content">
        <thead>
            <tr class="ui-widget-header ">
                
                <th>Email</th>
                <th>Password</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                
                <td>john.doe@example.com</td>
                <td>johndoe1</td>
            </tr>
        </tbody>
    </table>
</div>


</div>
</body>
</html>