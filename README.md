# epe2-desarrollo-web
# epe2-desarrollo-web

Este repositorio contiene el código fuente para una aplicación de gestión de tareas desarrollada como parte de un proyecto para el Instituto Profesional IP Chile. La aplicación permite a los usuarios crear, asignar, actualizar y completar tareas, así como generar informes sobre el progreso del proyecto. 

## Descripción del Proyecto

La aplicación está construida utilizando Java Enterprise Edition (Java EE) e incluye los siguientes componentes:

- **Servlets**: Para manejar las solicitudes HTTP y dirigirlas a las capas correspondientes de la aplicación.
- **Session Beans**: Para manejar la lógica de negocio relacionada con la gestión de tareas, incluyendo Stateless, Stateful y Singleton.
- **JPA (Java Persistence API)**: Para la persistencia de datos, representando las tablas de la base de datos como entidades Java.
- **Interfaz de Usuario**: Páginas JSP para mostrar la interfaz de usuario, formularios para agregar nuevas tareas y tablas para mostrar tareas existentes.
- **Generación de Informes**: Funcionalidades para generar informes sobre el progreso del proyecto, utilizando bibliotecas de gráficos como Chart.js o JFreeChart.

## Estructura del Proyecto

El proyecto tiene la siguiente estructura de carpetas:

- `build`: Contiene los archivos de construcción y salida.
- `dist`: Contiene el archivo WAR desplegable.
- `nbproject`: Configuración del proyecto para NetBeans.
- `src`: Código fuente del proyecto.
- `test`: Archivos relacionados con pruebas.
- `web`: Archivos web, incluyendo JSP y otros recursos estáticos.

## Requisitos

- Java SE 11
- Java EE (Servlets, Session Beans, JPA)
- MySQL (o cualquier otro RDBMS compatible con JPA)
- NetBeans IDE (opcional, pero recomendado para el desarrollo)



## Uso

- **Inicio de Sesión**: Accede a la aplicación a través del navegador utilizando la URL proporcionada por tu servidor de aplicaciones.
- **Gestión de Tareas**: Utiliza la interfaz de usuario para crear, asignar, actualizar y completar tareas.
- **Informes**: Consulta los informes generados para ver el progreso del proyecto.





algunas imagenes al final


![formulario tareas](https://github.com/user-attachments/assets/c75fce9b-2689-4833-8a2c-7a1e1c9d853b)
![index](https://github.com/user-attachments/assets/909383fd-d693-4389-87db-8ed02ee2a316)
![interfazusuarios](https://github.com/user-attachments/assets/4ee06b96-8dca-403d-97fc-8a7fbc010729)
![usuarios](https://github.com/user-attachments/assets/db007f05-0aec-42fb-be9c-4ca0f1014d8d)
