# App todo Backend usando arquitectura Hexagonal

La Aplicacíon cuenta con 5 endpoints, 4 para agregar, recuperar,modificar y eliminar tareas, más uno extra que se encarga
de llamar a una fake api externa para simular que hay más contenido sobre los usuarios que han realizado las tareas.
Las tareas se almacenan en una base de datos local.

# Apartado técnico
He usado las siguientes dependencias en Gradle:

* Conector MySQL
* Springboot Web
* JPA

###
La base de datos es relacional con el gestor MySQL.

### Características de la aplicación 

* Agrega, consulta, actualiza, elimina y simula un usuario para las tareas a través de sus endpoints.
* Respuestas Http en base a si la operación se ha podido realizar o no
* Uso del patrón de diseño hexagonal (o ports-adapter) como práctica con el mismo.

## --English version:

# Backend todoApp using Hexagonal architecture

The Application has 5 endpoints, four of them with the purpose of add, get, update adn delete tasks. Futhermore the app has another
one endpoint that calls an external fake Api to simulate more content related with the user who made the task.

# Tech used

I used the next Gradle dependencies:

* MySQL connector
* Springboot web
* JPA

### 
I used a MySql relational database executed in a local machine.

### Features:

* Add, get, update delete abnd obtain more information from a simulate user through the App endpoints.
* Dynamic http responses basing on the success of the operation.
* Hexagonal (or ports-adapter) design pattern was used in order to practice with this architecture.


## Creado por Israel Fernandez Agudo
## Made by Israel Fernandez Agudo

