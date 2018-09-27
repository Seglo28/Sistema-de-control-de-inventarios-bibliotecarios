<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BUS - Agregar nuevo</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body background="imagenes/actualizar.jpg">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="col-md-12">
                        <br/>
                        <div class="row">
                            <div class="col-12 text-center">
                                <h4><i>Autores y sus libros - Agregar nuevo registro</i></h4>
                            </div>
                        </div>
                    </div>
                    <br>
                    <br>
                    <div class="row">
                        <div class="col-12 text-center">
                            <form action="diagrama?action=Insertar" method="post">
                                <table class="table table-hover" width="10%" border="2" cellspacing="5">
                                    <tr>
                                        <td>
                                            Autor: 
                                            <select name="id_autor">
                                                <option value="1">Elija un autor</option>
                                                <c:forEach items="${autor}" var="a1">
                                                    <option value="${a1.id_autor}">${a1.nombre}</option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            Libro: 
                                            <select name="id_libro">
                                                <option value="1">Elija un libro</option>
                                                <c:forEach items="${libro}" var="lb1">
                                                    <option value="${lb1.id_libro}">${lb1.nombre}</option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                </table>
                                <input type="submit" value="Insertar"/>
                            </form>
                            <br>
                            <br>
                            <br>
                            <div class="row">
                                <div class="col-12 text-center">
                                    <a class="btn btn-success" href="Inicio.jsp">Inicio</a>
                                </div>
                            </div>
                        </div>
                    </div>    
                </div>     
            </div>          
        </div>     
    </div>   
</body>
</html>