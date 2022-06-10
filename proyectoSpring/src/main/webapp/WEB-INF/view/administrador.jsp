<%-- 
    Document   : administrador.jsp
    Created on : 09-may-2022, 20:13:12
    Author     : ruben
--%>


<%@page import="java.util.List"%>
<%@ page import="es.grupo2.proyectospring.dto.UsuarioDTO" %>
<%@ page import="es.grupo2.proyectospring.dto.ProductoDTO" %>
<%@ page import="es.grupo2.proyectospring.dto.CategoriaDTO" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin View</title>
    </head>
    <body>
        <h1>Listado de usuarios</h1>
        <form method="post" action="/administrador">
            Nombre: <input type="text" name="filtroUs" value="" />
            <input type="submit" value="Filtrar" />
        </form>
        
        <%
            List<UsuarioDTO> usuarios = (List)request.getAttribute("usuarios");
            if (usuarios == null || usuarios.isEmpty() ) {
        %>    
        <h2>No hay usuarios</h2>
        <%
            } else { 
        %>    
        <table border="1">
            <tr>
                <th>NOMBRE</th>
                <th>APELLIDOS</th>                
                <th>DOMICILIO</th>                                
                <th>CIUDAD</th>     
                <th>EDAD</th>                     
                <th>SEXO</th>
                <th>CONTRASEÑA</th>
            </tr>
        <%    
                for (UsuarioDTO usuario: usuarios) {
        %>    
        <tr>
            <td><%= usuario.getNombre()%></td>
            <td><%= usuario.getApellidos() %></td>            
            <td><%= usuario.getDomicilio() %></td>                     
            <td><%= usuario.getCiudad() %></td>                                 
           <td><%= usuario.getEdad() %></td>                      
           <td><%= usuario.getSexo() %></td>
           <td><%= usuario.getContraseña()%></td>
           <td><a href="UsuarioBorrarServlet?idUs=<%= usuario.getId() %>">Borrar</a></td> 
           <td><a href="UsuarioNuevoEditarServlet?idUs=<%= usuario.getId() %>">Editar</a></td>            
        </tr>
        
        <%
                }
        %>
        </table>
        <%
            }
        %>        
        <a href="UsuarioNuevoEditarServlet">Crear nuevo usuario... </a>
        
        <h1>Listado de productos</h1>
        <form method="post" action="/administrador">
            Titulo: <input type="text" name="filtroProducto" value="" />
            <input type="submit" value="Filtrar" />
        </form>
        
        <%
            List<ProductoDTO> productos = (List)request.getAttribute("productos");
            if (productos == null || productos.isEmpty() ) {
        %>    
        <h2>No hay usuarios</h2>
        <%
            } else { 
        %>    
        <table border="1">
            <tr>
                <th>TITULO</th>
                <th>DESCRIPCION</th>                
                <th>PRECIO SALIDA</th>                                
                <th>FOTO</th>     
                <th>CATEGORIA</th>                                                                                                                               
            </tr>
        <%    
                for (ProductoDTO pr: productos) {
        %>    
        <tr>
            <td><%= pr.getTitulo()%></td>
            <td><%= pr.getDescripcion()%></td>            
            <td><%= pr.getPrecioSalida()%></td>                     
            <td><%= pr.getURLfoto()%></td>                                 
           <td><%= pr.getCategoriaProducto()%></td>                                        
           <td><a href="ProductoBorrarServlet?idPr=<%= pr.getId() %>">Borrar</a></td> 
           <td><a href="ProductoNuevoEditarServlet?idPr=<%= pr.getId() %>">Editar</a></td>            
        </tr>
        
        <%
                }
        %>
        </table>
        <%
            }
        %>        
        <a href="ProductoNuevoEditarServlet">Crear nuevo producto... </a>
        
        <h1>Listado de categorias</h1>
        <form method="post" action="/administrador">
            Titulo: <input type="text" name="filtroCategoria" value="" />
            <input type="submit" value="Filtrar" />
        </form>
        
        <%
            List<CategoriaDTO> categorias = (List)request.getAttribute("categorias");
            if (categorias == null || categorias.isEmpty() ) {
        %>    
        <h2>No hay categorias</h2>
        <%
            } else { 
        %>    
        <table border="1">
            <tr>
                <th>ID</th>
                <th>TITULO</th>
                <th>DESCRIPCION</th>                                                                                                                                             
            </tr>
        <%    
                for (CategoriaDTO c: categorias) {
        %>    
        <tr>
            <td><%= c.getId()%></td>
            <td><%= c.getTitulo()%></td>            
            <td><%= c.getDescripcion()%></td>                                                             
           <td><a href="CategoriaBorrarServlet?idCa=<%= c.getId() %>">Borrar</a></td> 
           <td><a href="CategoriaNuevoEditarServlet?idCa=<%= c.getId() %>">Editar</a></td>            
        </tr>
        
        <%
                }
        %>
        </table>
        <%
            }
        %>        
        <a href="CategoriaNuevoEditarServlet">Crear nueva categoria... </a>
        
        <h1>Listado de analistas</h1>
        
        <%
            List<UsuarioDTO> analistas = (List)request.getAttribute("analistas");
            if (analistas == null || analistas.isEmpty() ) {
        %>    
        <h2>No hay analistas</h2>
        <%
            } else { 
        %>    
        <table border="1">
            <tr>
                <th>NOMBRE</th>
                <th>APELLIDOS</th>                
                <th>DOMICILIO</th>                                
                <th>CIUDAD</th>     
                <th>EDAD</th>                     
                <th>SEXO</th>                                                                                                          
            </tr>
        <%    
                for (UsuarioDTO usuario: analistas) {
        %>    
        <tr>
            <td><%= usuario.getNombre()%></td>
            <td><%= usuario.getApellidos() %></td>            
            <td><%= usuario.getDomicilio() %></td>                     
            <td><%= usuario.getCiudad() %></td>                                 
           <td><%= usuario.getEdad() %></td>                      
           <td><%= usuario.getSexo() %></td>                  
           <td><a href="AnalistaBorrarServlet?idAn=<%= usuario.getId() %>">Borrar</a></td>             
        </tr>
        
        <%
                }
        %>
        </table>
        <%
            }
        %>        
        <a href="AnalistaNuevoServlet">Crear nuevo analista... </a>

        <h1>Listado de usuarios de Marketing</h1>
        <%
            List<UsuarioDTO> marketing = (List)request.getAttribute("marketing");
            if (marketing == null || marketing.isEmpty() ) {
        %>
        <h2>No hay usuarios de marketing</h2>
        <%
            } else {
        %>
        <table border="1">
            <tr>
                <th>NOMBRE</th>
                <th>APELLIDOS</th>
                <th>DOMICILIO</th>
                <th>CIUDAD</th>
                <th>EDAD</th>
                <th>SEXO</th>
            </tr>
        <%
                for (UsuarioDTO usuario: marketing) {
        %>
        <tr>
            <td><%= usuario.getNombre()%></td>
            <td><%= usuario.getApellidos() %></td>
            <td><%= usuario.getDomicilio() %></td>
            <td><%= usuario.getCiudad() %></td>
           <td><%= usuario.getEdad() %></td>
           <td><%= usuario.getSexo() %></td>
           <td><a href="MarketingBorrarServlet?idMa=<%= usuario.getId() %>">Borrar</a></td>
        </tr>

        <%
                }
        %>
        </table>
        <%
            }
        %>
        <a href="MarketingNuevoServlet">Crear nuevo usuario de marketing... </a>
        <a href="index.html">Salir</a>
    </body>
</html>
