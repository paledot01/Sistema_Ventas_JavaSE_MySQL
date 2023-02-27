# Sistema de venta de calzados | :clapper: [video de muestra][video_url]
Sistema de venta de calzados desarrollado en Java con MySQL como motor de base de datos.

[video_url]: https://drive.google.com/file/d/1xkekMJHkO5aSo4p88OzAjH64u8LYN37o/view?usp=share_link
![][Extra_GIF_Main]

## Primer avance (GUI)
Se realizó:
- La estructura de paneles del sistema.
- Eleccion de la fuente de texto y colores.
- Diseño del logo con su variante.
- El desarrollo de la Base de Datos en MySQL.
- Creación de una animacion para el menu desplegable con Thread.

| Imagen 1 | Imagen 2 | Imagen 3 |
| ------------- |:-------------:| :-----:|
| ![][1st_img_1] | ![][1st_img_2] | ![][1st_img_3] |

## Segundo Avance

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

## Tercer Avance
Se desarrollo el mantenimiento Calzado con muchas de las caracteristicas del mantenimiento Empleado como, los reportes y los codigos autogenerados, ademas :
- Se incluyo dentro de este, otros mantenimientos que eran necesarios, esto con el fin de agilizar los registros de los calzados sin tener que entrar a otras ventanas para hacer esto.
- Se añadio la opcion de transferir desde el panel Modelo, el nombre, para facilitar el registro de los calzados.
- Se amplio, las consultas a la Base de Datos para que nos permita filtrar los registros con una mayor cantidad de opciones.
- Se realizo validaciones para los valores criticos como los numeros que podrian generar errores en el sistema.

| Imagen 1 | Imagen 2 |
| ------------- |:-------------:|
| ![][3rd_img_1] | ![][3rd_img_2] |


## Cuarto Avance
- Se modificó los mantenimientos anterior para mejorar su rapidez a la hora de mostrar las listas.
- Se añadio un Reloj para el sistema con Thread.
- Se creo el Panel Venta que permite registrar una venta y generar el comprobante.
- Para el Panel Venta se creo una ventana para buscar los calzados.
- Se creo un evento personalizado para el "codigo de calzado" que permite detectar la modificacion de su contenido para ejecutar la accion de mostrar los detalles del calzado.
- Para mostrar los detalles del calzado que se va agregar a la lista se creo el diseño de una "hoja" usando la clase Graphics2D de Java.
- Se agregó el boton de eliminar dentro de la tabla, para aumentar la rapidez en el proceso.
- Se creo la plantilla para el comprobante de venta en los formatos A4 y Ticket.
- Se creo dos nuevos iconos para el CDP y se modificaron otros que se descargaron de internet.

Problemas solucionados:
- Al seleccionar el formato ticket para el CDP y realizar la venta, este mostraba la previsualizacion de manera correcta pero al exportarlo en formato PDF, la fuente de texto utilizado para la creacion de la plantilla se modificaba por una fuente por defecto.
- El boton dentro de la tabla podia realizar cualquier funcion programada, excepto eliminar la misma fila que contenia el boton. Esto ocurria porque al hacerle click al boton, la fila se eliminaba antes de que acabara la animacion que se activaba en el boton, provocando que el boton se quede flotando en la nada, y el sistema se bugeaba.
- Al realizar la venta, la hora que se mostraba en el comprobante estaba retrasado 5 horas. Esto ocurria porque la hora se registraba directamente en la Base de Datos con el metodo NOW() esto asu vez provocaba que tanto el MySql como el Eclipse le restaran cada uno 5 horas a la hora de la zona horaria internacional, porque estos estaban por defecto con la zona horaria local (del Sistema Operativo).

| Imagen 1 | Imagen 2 | Imagen 3 | Imagen 4 |
| ------------- |:-------------:|:-------------:|:-------------:|
| ![][4rd_img_1] | ![][4rd_img_2] | ![][4rd_img_3] | ![][4rd_img_4] |
| ![][4rd_img_5] | ![][4rd_img_6] | ![][4rd_img_7] | |

## Quinto y ultimo Avance
- Se modificó el código, tanto del sistema como de la Base de Datos para que estos sean más claros y entendible en su lectura.
- Se creo una ultima animación que genera un movimiento circular continuo de un componente. Esto se realizó con Thread y la clase Math.
- Se agregó un pequeño archivo de texto a este repositorio que contiene notas, observaciones, datos, comentarios, problemas y soluciones, que fui encontrando y apuntando a lo largo de todo el desarrollo de este proyecto, el archivo se encuentra dentro de la carpeta "extra".


![][Extra_BD_shoesformen]


| 1 Animacion_Circular___________________ | 2 | 3 Datos_extras |
| ------------- |:-------------:|:-------------:|
| ![][Extra_animacion_circular] | ![][Extra_distribucion_paneles] | ![][Extra_datos] |

---

### Herramientas utilizadas:
- **JDK 8**
- **Eclipse** como IDE principal para el desarrollo del sistema (version: 2022-06 R).
- **MySQL** como motor de la base de datos.
- **JasperSoft Studio** para la creacion de plantillas para los reportes en PDF.
- **Corel Draw** para la creación y modificación de iconos.
- **Visual Studio Code** para la edición de este README.md.
- **Git Bash** para subir y actualizar este repositorio.


### Nota:
- Se usaron iconos de <https://fontawesome.com/>, y para los iconos creados se tomo como referencia diseños de internet.

---



### Apreciación Final:
El proyecto lo inicie teniendo en mente crear un sistema de escritorio pequeño pero completo, y en el proceso practicar lo que vimos el primer año de la carrera pero tambien aprender nuevas cosas. Durante el desarrollo surgian ideas de implementar ciertas funciones que aunque no eran estrictamente necesarias para que el sistema funcione mejoraban la apariencia o rapidez de interacción con el sistema; debido a ello el desarrollo se extendió mucho más de lo que pensé y por las clases tuve que detenerlo por semanas e incluso meses. Aunque el sistema no fue concluido disfrute mucho el proceso del mismo y creo que el objetivo principal se cumplió.


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


[Extra_GIF_Main]: ./screenshot/Extra_GIF_Main.gif
[Extra_animacion_circular]: ./screenshot/Extra_animacion_circular.gif
[Extra_datos]: ./screenshot/Extra_datos.png
[Extra_distribucion_paneles]: ./screenshot/Extra_distribucion_paneles.png
[Extra_BD_shoesformen]: ./screenshot/Extra_BD_shoesformen.png