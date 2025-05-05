# Optimizando la gestión de datos en Java

Modificando arreglos de manera eficiente, incluyendo la capacidad de agregar, eliminar y actualizar elementos con integridad y coherencia de datos, así como seleccionar la estructura de datos adecuada para optimizar el rendimiento según los requisitos del problema.

## Descripción del Proyecto :scroll:

Gestionaremos un sistema de venta de entradas, se ha solicitado la implementación de un programa en Java que permita realizar diferentes operaciones. En esta ocasión, se solicita optimizar el rendimiento al definir la estructura de datos más adecuada (arreglos o listas), que se relacione con el manejo de datos primitivos, asegurando que el sistema responda a las operaciones de venta y descuento.

## Sobre el proyecto 🚀

### ✨ Requerimientos ✨

👌 1. Selecciona la estructura de datos. El sistema debe incluir:

- Arreglos para las ventas de entradas, asientos del teatro y clientes: estos arreglos deben almacenar información específica como ID de venta, ubicación del asiento y detalles del cliente.
- Lista para manejar descuentos y promociones, facilitando cambios y actualizaciones.
- Lista de reservas de asientos que contenga objetos o registros de cada reserva realizada, incluyendo detalles como el ID de reserva, el ID de cliente, etc. 

👌 2. Implementación de funcionalidades: 

- Venta de entradas: esta función debería asignar asientos, registrar ventas y añadir la información del cliente en los arreglos correspondientes.
- Descuentos y promociones: utiliza algoritmos que apliquen descuentos específicos del 10 % a los estudiantes y del 15 % a la tercera edad durante el proceso de venta de entradas.

👌 3. Optimización de rendimiento

Tendrás que implementar funciones o métodos que permitan la adición, eliminación y actualización de elementos en los arreglos utilizados, asegurando que la integridad de los datos se mantenga en todo momento. 

👌 4. Integridad y coherencia de datos: mecanismos de validaciones de entradas y referencias cruzadas entre arreglos para asegurar que los datos sean consistentes y fiables.

- Validaciones de entrada: asegurar que los datos ingresados (como información de clientes, asientos, o ventas) sean correctos y cumplan con los formatos esperados.
- Referencias cruzadas: verificar que los datos en diferentes arreglos (como los de asientos, ventas y clientes) se correspondan adecuadamente, por ejemplo, que un asiento vendido esté realmente disponible o que los datos de un cliente correspondan a una venta específica.

👌 5. Pruebas y optimización: Realiza pruebas exhaustivas del sistema, identificando cuellos de botella y posibles mejoras en el rendimiento y optimizando según sea necesario. 


## Visuales :mage_woman:

Menú interactivo inicial con manjeo de errores según inputs del usuario:
![Captura de pantalla 2025-05-05 144111](https://github.com/user-attachments/assets/9b8480e7-e0c5-4695-b06a-aee78c3b01f0)

En esta ocasión se incorporó la funcionalidad de que al terminar de ejecutar un "case" o una opción del menú, el programa hace una pausa indicandole al usuario que presione ENTER para volver al menú y este se despliega nuevamente para elegir la siguiente acción. 

Opción 1: muestra el menu de promociones
![Captura de pantalla 2025-05-05 144155](https://github.com/user-attachments/assets/49de99d1-b696-405e-92e2-277932851d23)


Opción 2: muestra el mapa inicial, con el estado actual cada vez que se inicia una reserva/compra.
Se decidió la estructura de datos de Array ya que es una cantidad definida de elementos con las que se puede trabajar, optimizando así este segmento del código. 
![Captura de pantalla 2025-05-05 144353](https://github.com/user-attachments/assets/9015d8c8-aa12-4716-a851-c1398466d02f)

Opciones 4, 5, 6, 7, no se ejecutan si no existe una reserva o venta previamente: 

![Captura de pantalla 2025-05-05 144527](https://github.com/user-attachments/assets/0215f345-5901-4428-bb75-3d17fb79c4ad)

![Captura de pantalla 2025-05-05 144538](https://github.com/user-attachments/assets/c59826d3-e4dd-4f5d-9b92-2ff8e1813ffa)

![Captura de pantalla 2025-05-05 144547](https://github.com/user-attachments/assets/752280c2-3a63-4f3c-9e75-a20355989b8a)

![Captura de pantalla 2025-05-05 144610](https://github.com/user-attachments/assets/731fff08-7c5a-4f09-bd59-a04bc2f4222d)

La opcion 8 de Estadísticas Generales en estado inicial muestra todas las variables e incluye un resumen del mapa en el momento de la consulta. En este caso es antes de hacer alguna operación: 
![Captura de pantalla 2025-05-05 150236](https://github.com/user-attachments/assets/12767cc7-42aa-450c-8b34-bd85baa869f6)

En las opciones 9, 10, 11 y 12, donde se despliegan las listas, al inicio como no tiene información le indica al usuario que no hay registros todavía:

![Captura de pantalla 2025-05-05 150336](https://github.com/user-attachments/assets/09c93bb4-511f-4fe3-b702-1fa2ccf85044)

![Captura de pantalla 2025-05-05 150347](https://github.com/user-attachments/assets/4ddaa31a-5c6e-4a3a-bc1d-9ea4f4284ff1)

![Captura de pantalla 2025-05-05 150402](https://github.com/user-attachments/assets/9c28d9a6-100f-467c-8fa6-a6f6e1b39286)

![Captura de pantalla 2025-05-05 150413](https://github.com/user-attachments/assets/b062315d-b72f-463e-aa76-35a7bbbdc6a7)

En el proceso principal que es la reserva de las entradas, se despliega el mapa de manera inicial para que el usuario pueda ver el estado actual de los asientos y se procede a solicitar los datos, por cada dato, se validan inputs del usuario manejando errores: 

Para la cantidad de entradas se valida si desea más entradas de las disponibles, o si ingresa 0 o con strings:

![Captura de pantalla 2025-05-05 151246](https://github.com/user-attachments/assets/b859eff1-7dce-489f-b3b6-e750e31238b8)

Se valida si la ubicación es una opción distinta a las mencionadas: 
![Captura de pantalla 2025-05-05 151121](https://github.com/user-attachments/assets/253c6f14-bc77-42b5-9191-4247ca981df9)

Se solicita el ingreso de la ubicación del asiento uno por uno según la cantidad de entradas y se valida el input del usuario, solicitando el ingreso correcto de datos.

Si selecciona VIP que es la fila A , e ingresa el asiento B1, el programa indica que "no pertenece a la ubicación seleccionada"

![Captura de pantalla 2025-05-05 151448](https://github.com/user-attachments/assets/867ce989-bcec-4ab8-a6cf-5eea5804cfb9)

Si el usuario ingresa un asiento que ya está reservado u ocupado infomra que "el asiento no está disponible":
![Captura de pantalla 2025-05-05 151639](https://github.com/user-attachments/assets/0be7453f-b005-41b5-a394-c3c7a0a25278)

Con la selección hecha, retroalimenta al usuario visualmente de su elección y pide siguiente dato:

![Captura de pantalla 2025-05-05 151735](https://github.com/user-attachments/assets/61c2dfba-cfae-4b82-b70b-5109bd68afa8)

Solicita últimos datos para aplicación de descuentos, retroalimentando con el valor de la entrada y el descuento a aplicar: 

![Captura de pantalla 2025-05-05 151923](https://github.com/user-attachments/assets/318d845f-5845-47a9-af4e-ca6238483f04)

Al finalizar el proceso de reserva:
- genera un resumen de la reserva
- si el cliente no ha sido ya registrado, lo registra retroalimentando con un mensaje
- informa el numero de la reserva
- indica instrucciones para proceder, informando que lo devolverán al menú principal
- 
![Captura de pantalla 2025-05-05 152023](https://github.com/user-attachments/assets/c9f18e98-e686-4c4e-95db-eabef7ec6952)

En la opcion 4 de modificación de entrada, valida la cantidad de entradas que desea devolver para modificar su reserva y retroalimenta mostrando el mapa con la liberación de los asientos y manteniendo la reserva pertinente.

![Captura de pantalla 2025-05-05 152833](https://github.com/user-attachments/assets/41067f16-87ea-47ad-9e79-c26c8f32a71b)

Si se desea eliminar la reserva, la opción pide una segunda verificación y si la persona opta por NO eliminar la reserva, los asientos continúan reservados: 

![Captura de pantalla 2025-05-05 153351](https://github.com/user-attachments/assets/b6eacb84-01ac-4786-9a5a-bc177bf1523f)

Si la persona sí desea eliminar la reserva: 

![Captura de pantalla 2025-05-05 153455](https://github.com/user-attachments/assets/d0e1d0fc-4b4c-4d40-ae5a-62a26fb8998e)

Si el usuario ingresa una respuesta no valida, se maneja esto: 

![Captura de pantalla 2025-05-05 153545](https://github.com/user-attachments/assets/cea54a6f-aaa0-4472-bfab-f4da07d5a4f5)

Si la persona NO confirma la compra, se liberan los asientos de su reserva y se verifican en el mapa: 
![Captura de pantalla 2025-05-05 153632](https://github.com/user-attachments/assets/41cf7af0-9cbd-4c89-90e2-9a1bcdc9f13c)

El ejercicio fue realizar una reserva, no confimarla como compra, de todas maneras, la lista de reservas la registra como realizada, ya que existió, pero no se generó la compra: 
![Captura de pantalla 2025-05-05 153757](https://github.com/user-attachments/assets/e66c7bcc-d827-4e61-99a7-a1ca6043558b)

Así mismo se creó el registro del cliente: 
![Captura de pantalla 2025-05-05 153854](https://github.com/user-attachments/assets/1ba22d5e-f005-4a2e-9247-3a29f55a9b54)


Al confirmar la compra, se muestra el mapa con los asientos ocupados "OO":
![Captura de pantalla 2025-05-05 154253](https://github.com/user-attachments/assets/efd90fe1-07aa-4a26-a232-0334800ff776)

ANULACION DE COMPRA:
En el siguiente caso, se realiza la compra de asiento b1 y b2 y se anula la compra
- mostrando la liberación de los asientos.
- se genera la lista de ventas anuladas
- la venta efectiva se elimina de la lista ventas
- las estadisticas generales contabilizan ventas totales como la sumatoria de las efectivas y anuladas, con sus clasificaciones
  
![Captura de pantalla 2025-05-05 154429](https://github.com/user-attachments/assets/b9f89bb5-9bc0-46f3-a0db-d4247da8f4ba)

![Captura de pantalla 2025-05-05 154643](https://github.com/user-attachments/assets/c9734cd2-6d53-4cd0-845d-d6dc762d211a)

En este ejercicio se realizan tres reservas, tres compras y una de ella se anula generando las listas: 
![Captura de pantalla 2025-05-05 160104](https://github.com/user-attachments/assets/4caefb12-f54d-4474-8437-7d3b6f0682bf)

![Captura de pantalla 2025-05-05 160054](https://github.com/user-attachments/assets/ba0634e3-e3ac-417d-9e07-4243426ef19a)

![Captura de pantalla 2025-05-05 160112](https://github.com/user-attachments/assets/c1a43c7a-9593-437f-be61-86baae96bccd)

![Captura de pantalla 2025-05-05 160122](https://github.com/user-attachments/assets/26cd4e1e-b613-4966-918c-f4fda974c94e)

Luego de varios movimientos se puede pedir una estadistica general en el estado actual, que incluye la sumatoria o resta de los ingresos según los totales a pagar. 

![Captura de pantalla 2025-05-05 160209](https://github.com/user-attachments/assets/146e97bc-7677-4a3e-97da-212f7cc7624e)


Se valida descuentos a aplicar según edad se determina el tipo de Descuento, si es estudiante, tercera edad, sin descuento o
promoción 4 entradas: 
Si bien por la edad identifica aplicar descuento estudiante, en el resumen de la reserva indica el tipo de descuento con mayor beneficio para el cliente, en este caso, el descuento grupal es el válido: 
![Captura de pantalla 2025-05-05 154109](https://github.com/user-attachments/assets/42d22fe6-1b1d-4dea-a0e4-9112feee0565)






Se solicita el nombre y se genera el resumen de la reserva. 

IMPORTANTE: en este caso se plantea el programa con la reserva y la compra de manera separada, para efectuar la compra debe salir si o si al menú principal y elegir dicha opción. Las instrucciones se le indican al usuario:


Con la opción 13 se entrega un mensaje de salida y se cierra el programa:
![Captura de pantalla 2025-05-05 150811](https://github.com/user-attachments/assets/8da14056-011a-45b8-b11c-f731172497ae)


## Observación:
El programa permitiría la generación de un listado de boletas, ya que existe la lista que almacena toda esa inforamción, las cuales tienen un mayor detalle, y contiene la información de cada venta realizada de manera correlativa, pero no se agregó en esta ocasión. 





## Autora ⚡ 

- **Andrea Rosero** ⚡  - [Andrea Rosero](https://github.com/andreaendigital)
