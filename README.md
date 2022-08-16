# CRUD_Java
Implentando un Login, Registro y CRUD de productos

### Felipe Pazmiño

## 1. Diseño

### Login

 <img width="400" alt="image" src="https://user-images.githubusercontent.com/85601974/184793187-b4479dd7-5037-4747-9e9d-5f28646ef790.png">

 ### Register

 <img width="400" alt="image" src="https://user-images.githubusercontent.com/85601974/184511269-de6178af-b48f-49d5-aac5-a5694f842ee4.png">
 
### Crud

 <img width="600" alt="image" src="https://user-images.githubusercontent.com/85601974/184511296-51f18ce7-074d-4f28-bb6a-8f0cb2d42693.png">

## 2. Funcionalidad

### LOGIN 
+ `Iniciar Sesion` = Este boton podrá mandar errores si algun campo esta vacio, incompleto o incorrecto, Si el usuario existe abrira la siguiente pestaña
+ `Registrarse` =  Este boton redireccionará a la pestaña de registro
+ `Salir`= Al presionar el botón cierra el programa
### REGISTER
+ `Volver` = Este botón podrá redireccionar a la pestaña login
+ `Guardar` = Este botón comprueba si todos los campos estan llenos, de lo contrario al pulsarlo salta un error, de igual forma, cuando las contraseñas no coinciden y también valida si el correo cumple con el formato de correo. Además compreueba si el usuario ya existe en la base de datos
## CRUD
+ `Guardar` = Antes de pulsar el boton es necesario escribir todos los datos del producto, posteriormente al presionar el botón salta un aviso que el producto ha sido guardado correctamente y si existe algun error salta un aviso que dice "error al guardar producto"
+ `Modificar` = Primero es necesario marcar la celda de la tabla donde se desea modificar el producto, despues cambiar algun campo de este, una vez realizado esto presionar el botón. Saltará un aviso informando si se modifico el producto correctamente o si hubo algún error.
+ `Eliminar` = Antes de pulsar el boton es necesario seleccionar alguna celda de la tabla, posteriormente pulsar el botón que indicará un aviso si el producto se borro exitosamente o caso contrario si hubo algún error al borrar el producto
+ `Limpiar` = Si los datos estan llenos al presionar el botón limpia los datos de los campos
+ `Salir`= Este boton al ser presionado cierra la sesión y lo redirige a la pestaña del Login nuevamente

## 3. Complementos necesarios

+ Conector MySQL para JAVA: Este archivo .jar ayuda a crear la conexion con la base de datos
+ Xampp: ayuda a abrir los puertos para crear posterior crear la base de datos de manera local
