<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BUS - Agregar nuevo</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body background="imagenes/advertencia.jpg">
        <div class="container">
            <div class="row">
                <div class="col-12 text-center">
                    <div class="row">
                        <div class="col-12 text-center">
                            <br/>
                            <br/>
                            <br/>
                            <br/>
                            <form class="login1">
                                <fieldset>
                                    <br><center><legend><h1 style="color:#FF0000">ADVERTENCIA</h1></legend></center><br>
                                    <span> Al oprimir cualquiera de los botones sera redireccionado 
                                        a una pagina principal en calidad de <b>USUARIO</b> o <b>ADMINISTRADOR</b>, 
                                        sí elige la primera al momento de tomar la acción de retornar a ser administrador 
                                        seran requeridos datos de ingreso.<br>¿Desea continuar?</span>
                                    <div class="form-group">
                                        <br>
                                        <a class="btn btn-success btn-block" href="PrincipalUsuarios.jsp">USUARIO</a><br>
                                        <a class="btn btn-danger btn-block" href="PrincipalAdministracion.jsp">ADMINISTRADOR</a><br>
                                    </div>
                                </fieldset>
                            </form>
                        </div>    
                    </div>     
                </div>          
            </div>   
        </div>
    </body>
</html>