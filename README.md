
# ****API RESTFUL "EXAMEN: JAVA"****

**Considerar lo siguiente:**
* Para poder hacer consumo de la API Restful se recomiendan los siguientes programas:
* Cómo entorno de desarrollo: Intellij (Opcional).
* Para poder probar la API mediante solicitudes y poder generar el token: Postman (Obligatorio).

**Procedimiento para poder usar Postman:**
1. Crear colección.
2. Agregar una solicitud seleccionando "Add Request" en los puntos suspensivos.
3. Asignando el formato de request e insertando la url.
4. Seleccionar Body en la pestaña "raw" con el formato JSON
5. Colocar en cada entrada de texto los siguientes endpoints para cada controller.

**Datos para el acceso a la base de datos:**

* Enlace: [http://localhost:8080/h2-console/]()
* username: h2
* passwoord: h2
* url: jdbc:h2:mem:test

**Procedimiento JWT:**

Una vez realice el registro en el "" le retornara un token de acceso pero para poder logearse debe acceder 
a la base de datos para poder habilitar el usuario creado. Selecciona la entidad "log_usuario", edita en 
la columna "is_enabled" cambiandola de "FALSE" a "TRUE". Posterior a eso puede volver a Postman y logearse
con su nombre de usuario y contraseña.

**Endpoints.
Registro de usuario:**

`{
"firstname": "Juan",
"lastname": "Rodriguez",
"username": "Juan",
"email": "juan@rodriguez.org",
"password":"hunter2"
}`

**Inicio de sesión de usuario:**

`{
"username": "Juan",
"password":"hunter2"
}`

**Creación de usuario en la entidad persona:**

`{
"name": "Juan Rodriguez",
"email": "juan@rodriguez.org",
"password": "hunter2",
"phones": [
{
"number": "1234567",
"citycode": "1",
"contrycode": "57"
}
]
}`

**Actualización de usuario en la entidad persona:**

`{
"name": "Juan Rodriguez",
"email": "juan@rodriguez.org",
"password": "hunter",
"phones": [
{
"number": "8445",
"citycode": "6",
"contrycode": "51"
}
]
}`

**Posteriormente instalados los aplicativos recomendados se puede proceder a acceder a los siguientes enlaces:**
[http://localhost:8080/auth/register
]()[http://localhost:8080/auth/login
]()

Ambos enlaces son de formato request "POST" en Postman. Caso contrario de colocar otro formato request el aplicativo no lo considerará y rebotará un status 404.

**Para poder acceder al CRUD de la entidad persona pueden acceder a los siguientes enlaces:**

Creación de usuarios en la entidad, formato de request "POST":
[http://localhost:8080/persona/create
]()

Visualización de usuarios en la entidad, formato de request "GET":
[http://localhost:8080/persona/findAll
]()

Actualización de usuarios en la entidad, formato de request "UPDATE":
[http://localhost:8080/persona/update/{id}]()

Borrar usuarios de la entidad, formato de request "DELETE":
[http://localhost:8080/persona/delete/{id}]()

Para poder acceder y verificar que los datos han sido almacenados en la base de datos de H2 puede utilizar el siguiente enlace:
[http://localhost:8080/h2-console
]()

**Diagrama de solución:**


![Diagramamd.jpg](..%2FDiagramamd.jpg)