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
            /* Estilo para el encabezado */
            .navbar {
                margin-bottom: 30px;
            }
            .navbar-brand {
                font-weight: bold;
                font-size: 1.5rem;
            }
            .hero-section {
                background-color: #007bff;
                color: white;
                padding: 60px 0;
                text-align: center;
                border-radius: 8px;
                margin-bottom: 30px;
            }
            .hero-section h1 {
                font-size: 2.5rem;
                margin-bottom: 20px;
            }
            .hero-section p {
                font-size: 1.2rem;
            }
            .footer {
                margin-top: 50px;
                padding: 10px;
                text-align: center;
                background-color: #343a40;
                color: white;
            }
        </style>
    </head>
    <body>
        <!-- Barra de navegación -->
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
                        <a class="nav-link" href="interfazUsuario.jsp">Ir a la Interfaz de Usuario</a>
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

        <!-- Sección principal -->
        <div class="container">
            <div class="hero-section">
                <h1>Bienvenido a la Gestión de Tareas</h1>
                <p>Administra tus tareas de manera sencilla y eficiente.</p>
            </div>
        </div>

        <!-- Footer -->
        <div class="footer">
            <p>&copy; 2024 - Gestión de Tareas. Todos los derechos reservados.</p>
        </div>
    </body>
</html>
