<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestión de Tareas</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <style>
            /* Cambia el fondo de la barra de navegación a un color más oscuro */
            .navbar {
                background-color: #343a40;
            }
            .navbar .nav-link, .navbar .navbar-brand {
                color: #fff;
            }
            .navbar .nav-link:hover {
                color: #ffc107;
            }
            
            /* Estiliza el formulario con bordes redondeados y sombra */
            .form-container {
                background-color: #f8f9fa;
                border-radius: 8px;
                box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.1);
                padding: 30px;
            }
            
            /* Botones personalizados */
            .btn-custom {
                background-color: #28a745;
                border-color: #28a745;
                color: #fff;
            }
            .btn-custom:hover {
                background-color: #218838;
                border-color: #1e7e34;
            }
            .btn-secondary-custom {
                background-color: #6c757d;
                border-color: #6c757d;
                color: #fff;
            }
            .btn-secondary-custom:hover {
                background-color: #5a6268;
                border-color: #545b62;
            }
        </style>
    </head>
    <body>
        <!-- Barra de navegación mejorada con un color de fondo más oscuro -->
        <nav class="navbar navbar-expand-lg">
            <a class="navbar-brand" href="index.jsp">Gestión de Tareas</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="index.jsp">Inicio <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="TareaControlador?action=listar">Tareas</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="UsuarioControlador?action=listar">Usuarios</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Salir</a>
                    </li>
                </ul>
            </div>
        </nav>

        <!-- Contenedor principal con un diseño más moderno para el formulario -->
        <div class="container mt-5">
            <div class="row">
                <div class="col-md-6 offset-md-3">
                    <div class="form-container">
                        <h2 class="text-center">Formulario de Tareas</h2>
                        <form action="TareaControlador?action=actualizar" method="post">
                            <input type="hidden" name="idTarea" value="${tarea.idTarea}">
                            <div class="form-group">
                                <label for="titulo">Título:</label>
                                <input type="text" class="form-control" id="titulo" name="titulo" value="${tarea.titulo}">
                            </div>
                            <div class="form-group">
                                <label for="descripcion">Descripción:</label>
                                <textarea class="form-control" id="descripcion" name="descripcion">${tarea.descripcion}</textarea>
                            </div>
                            <div class="form-group">
                                <label for="estado">Estado:</label>
                                <select class="form-control" id="estado" name="estado">
                                    <option value="Pendiente" ${tarea.estado == 'Pendiente' ? 'selected' : ''}>Pendiente</option>
                                    <option value="En Progreso" ${tarea.estado == 'En Progreso' ? 'selected' : ''}>En Progreso</option>
                                    <option value="Completada" ${tarea.estado == 'Completada' ? 'selected' : ''}>Completada</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="fecha">Fecha:</label>
                                <input type="date" class="form-control" id="fecha" name="fecha" value="${tarea.fecha}">
                            </div>
                            <input type="hidden" name="idUsuario" value="${tarea.idUsuario}">
                            <button type="submit" class="btn btn-custom">Guardar</button>
                            <a href="TareaControlador?action=lista" class="btn btn-secondary-custom">Cancelar</a>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
