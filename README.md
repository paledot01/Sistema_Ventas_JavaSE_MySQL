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
Se desarrollo el mantenimiento Calzado con muchas de las caracteristicas del mantenimiento Empleado como, los reportes o los codigos que se autogenera, pero se añadieron otras nuevas :
- Se incluyo dentro de este, otros mantenimientos que eran necesarios, esto con el fin de agilizar los registros de los calzados sin tener que entrar a otras ventanas para hacer esto.
- Se añadio la opcion de transferir desde el panel Modelo el nombre, para facilitar el registro de los calzados.
- Se amplio, las consultas a la Base de Datos para que nos permita filtrar los registros con una mayor cantidad de opciones.
- Se realizo validaciones para los valores criticos como los numeros que podrian generaban errores en el sistema.

| Imagen 1 | Imagen 2 |
| ------------- |:-------------:|
| ![][3rd_img_1] | ![][3rd_img_2] |

---

### Herramientas utilizadas:
- **Eclipse** como IDE principal para el desarrollo del sistema.
- **MySQL** como motor de la base de datos.
- **JasperSoft** Studio para la creacion del reporte en PDF.
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
[3rd_img_2]: ./screenshot/version_03_02.gif

