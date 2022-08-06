# Sistema de venta de calzados
Sistema de venta de calzados en Java con Eclipse y MySQL como motor de base de datos.

## 1st version (GUI)
Se realizó:
- La estructura de paneles del sistema.
- Eleccion de la fuente de texto y colores.
- Diseño del logo con su variante.
- El desarrollo de la Base de Datos en MySQL.
- Creación de una animacion para el menu desplegable con Thread.

| Imagen 1 | Imagen 2 | Imagen 3 |
| ------------- |:-------------:| :-----:|
| ![][1st_img_1] | ![][1st_img_2] | ![][1st_img_3] |

## 2nd version

Se desarrollo el mantenimiento Empleado, el cual posee las siguientes funciones:
- Permite añadir un nuevo empleado, donde el sistema autogenera un código de identificacion asi como un usuario y contraseña, estos ultimos en funcion de sus datos personales.
- Podemos modificar los datos de cada empleado, para esto debemos primero hacer uso del buscador con sus filtros para localizarlo.
- Podemos hacer un reporte de los empleados en los formatos de texto, excel y pdf, estos tambien pueden hacer uso de los filtros.

para esta segunda version se realizo tambien:
- El diseño de los iconos de los reportes.
- La creacion de la plantilla para el reporte en Pdf.

| Imagen 1 | Imagen 2 | Imagen 3 | Imagen 4 |
| ------------- |:-------------:|:-------------:|:-------------:|
| ![][2nd_img_1] | ![][2nd_img_2] | ![][2nd_img_3] | ![][2nd_img_4] |

## 3rd version
Se desarrollo el mantenimiento Calzado con muchas de las caracteristicas del mantenimiento Empleado como, los reportes y los codigos autogenerados, ademas :
- Se incluyo dentro de este, otros mantenimientos que eran necesarios, esto con el fin de agilizar los registros de los calzados sin tener que entrar a otras ventanas para hacer esto.
- Se añadio la opcion de transferir desde el panel Modelo, el nombre, para facilitar el registro de los calzados.
- Se amplio, las consultas a la Base de Datos para que nos permita filtrar los registros con una mayor cantidad de opciones.
- Se realizo validaciones para los valores criticos como los numeros que podrian generar errores en el sistema.

| Imagen 1 | Imagen 2 |
| ------------- |:-------------:|
| ![][3rd_img_1] | ![][3rd_img_2] |

---

## 4th version
- Se modificó los mantenimientos anterior para mejorar su rapidez a la hora de mostrar los datos.
- Se añadio un Reloj para el sistema con Thread.
- Se creo el Panel Venta que permite registrar una venta y generar el comprobante.
- Para el Panel Venta se creo una ventana para buscar los calzados.
- Se creo un evento personalizado para el "codigo de calzado" que permite detectar la modificacion de su contenido para ejecutar la accion de mostrar los detalles del calzado.
- Para mostrar los detalles del calzado que se va agregar a la lista se creo el diseño de una hoja usando la clase Graphics2D de Java.
- Se agregó el boton de eliminar dentro de la tabla, para aumentar la rapidez en el proceso.
- Se creo la plantilla para el comprobante de venta en los formatos A4 y Ticket.
- Se creo dos nuevos iconos para el CDP y se modifico otros que se descargaron de internet.

Problemas solucionados:
- Al seleccionar el formato ticket para el CDP y realizar la venta, este mostraba la previsualizacion de manera correcta pero al exportarlo en formato PDF, la fuente de texto utilizado para la creacion de la plantilla se modificaba por una fuente por defecto.
- El boton dentro de la tabla podia realizar cualquier funcion programada, excepto eliminar la misma fila que contenia el boton. Esto ocurria porque al hacerle click al boton, la fila se eliminaba antes de que acabara la animacion que se activaba en el boton, provocando que el boton se quede flotando en la nada, y el sistema se bugeaba.
- Al realizar la venta, la hora que se mostraba en el comprobante estaba retrasado 5 horas. Esto ocurria porque la hora se registraba directamente en la Base de Datos con el metodo NOW() esto asu vez provocaba que tanto el MySql como el Eclipse le restaran cada uno 5 horas a la hora de la zona horaria internacional, porque estos estaban por defecto con la zona horaria local (del Sistema Operativo).

|  |  |  |  |
| ------------- |:-------------:|:-------------:|:-------------:|
| ![][4rd_img_1] | ![][4rd_img_2] | ![][4rd_img_3] | ![][4rd_img_4] |
| ![][4rd_img_5] | ![][4rd_img_6] | ![][4rd_img_7] | |


### Herramientas utilizadas:
- **Eclipse** como IDE principal para el desarrollo del sistema.
- **MySQL** como motor de la base de datos.
- **JasperSoft Studio** para la creacion de plantillas para los reportes en PDF.
- **Corel Draw** para la creacion de iconos.
- **Visual Studio Code** para la edicion de este README.md.
- **Git Bash** para subir y actualizar este repositorio.



---

### Nota:
- Se usaron iconos de <https://fontawesome.com/>, y para los iconos creados se tomo como referencia diseños de internet.


[1st_img_1]: ./screenshot/version_01_01.png
[1st_img_2]: ./screenshot/version_01_02.png
[1st_img_3]: ./screenshot/version_01_03.png

[2nd_img_1]: ./screenshot/version_02_01.png
[2nd_img_2]: ./screenshot/version_02_02.png
[2nd_img_3]: ./screenshot/version_02_03.png
[2nd_img_4]: ./screenshot/version_02_04.png

[3rd_img_1]: ./screenshot/version_03_01.png
[3rd_img_2]: ./screenshot/version_03_02.png

[4rd_img_1]: ./screenshot/version_04_01.png
[4rd_img_2]: ./screenshot/version_04_02.png
[4rd_img_3]: ./screenshot/version_04_03.png
[4rd_img_4]: ./screenshot/version_04_04.png
[4rd_img_5]: ./screenshot/version_04_05.png
[4rd_img_6]: ./screenshot/version_04_06.png
[4rd_img_7]: ./screenshot/version_04_07.png
