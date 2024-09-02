<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Interfaz de Usuario</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <style>
            .header {
                background-color: #007bff;
                color: white;
                padding: 20px;
                text-align: center;
                border-bottom: 4px solid #0056b3;
            }
            .main-content {
                margin-top: 50px;
                padding: 20px;
                background-color: #f8f9fa;
                border-radius: 8px;
                box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.1);
                text-align: center;
            }
            .btn-custom {
                background-color: #28a745;
                border-color: #28a745;
                color: #fff;
                margin: 10px;
                font-size: 1.2rem;
                padding: 10px 20px;
                border-radius: 5px;
                transition: background-color 0.3s, border-color 0.3s;
            }
            .btn-custom:hover {
                background-color: #218838;
                border-color: #1e7e34;
                text-decoration: none;
            }
            .footer {
                margin-top: 50px;
                padding: 10px;
                text-align: center;
                background-color: #343a40;
                color: white;
                border-top: 4px solid #212529;
            }
        </style>
    </head>
    <body>
        <!-- Encabezado de navegación -->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
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

        <!-- Encabezado principal -->
        <div class="header">
            <h1>Bienvenido a la Interfaz de Usuario</h1>
            <p>Seleccione una opción para gestionar el sistema</p>
        </div>

        <!-- Contenido principal con botones de navegación -->
        <div class="container">
            <div class="main-content">
                <h2 class="mb-4">Seleccione una opción:</h2>
                <ul class="list-unstyled">
                    <li>
                        <a href="usuarios.jsp" class="btn btn-custom btn-lg">Gestión de Usuarios</a>
                    </li>
                    <li>
                        <a href="tareas.jsp" class="btn btn-custom btn-lg">Tareas</a>
                    </li>
                    <li>
                        <a href="formulariosTarea.jsp" class="btn btn-custom btn-lg">Formulario de Tareas</a>
                    </li>
                </ul>
            </div>
        </div>

        <!-- Footer simple -->
        <div class="footer">
            <p>&copy; 2024 - EPE2. INC.</p>
        </div>

        <!-- Scripts de Bootstrap -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>
