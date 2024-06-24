# Generador de Cotizaciones Inventario - README

Este proyecto JavaFX es un sistema para generar cotizaciones y gestionar inventarios de producto y usuarios proyecto de Ingienieria II de la Universidad Tecnologica de Panama.

## Estructura del Proyecto

El proyecto está organizado en los siguientes paquetes principales:
### com.quotegen.controllers

Este paquete contiene los controladores de los archivos FXML, los cuales manejan la lógica de la interfaz gráfica y la interacción con el usuario. aqui almacenare todo las funcionalidades
de las vistas en un paquete llamado `com.quotegen.controllers` esto es para organizar la logica de las vistas con las views que estara en un paquete aparte llamado  
`com.quotegen.views` que es donde se guardaran las vistas que se mostraran al usuario.

#### Ejemplo de uso:
Los controladores se vinculan a los archivos FXML en `com.quotegen.views` para gestionar eventos y actualizar la interfaz de usuario.

### com.quotegen.assets 
#### Descripción:
Los archivos CSS en este directorio personalizan la apariencia de los elementos de la interfaz gráfica para mantener consistencia y mejorar la usabilidad.
En este paquete se encuentran los recursos CSS que definen los estilos de los componentes de JavaFX. En javaFX se suele utilizar archivos css para añadir colores css algunas funciones 
como hover y otras cosas que con css se pueden hacer mas facil . por ejemplo agregar una sola clase para agregarle un diseño a varios componentes a la vez . en este caso lo utilice 
en el textfield de login . 

### com.quotegen.views

Aquí se almacenan los archivos FXML que representan las distintas interfaces de usuario del sistema. en este como lo mencione se guarda las vistas que se mostraran al usuario por el proposito de que se vinculen con los controladores .

#### Propósito:
Los archivos FXML se utilizan junto con los controladores en `com.quotegen.controllers` para definir la estructura y el comportamiento de las ventanas y diálogos de la aplicación.

### com.quotegen.domain
En este paquete se encuentran las clases de dominio que representan las entidades del negocio, como productos, clientes, y cotizaciones.

#### Propósito:
Las clases en este directorio encapsulan la lógica del negocio y los datos asociados, proporcionando métodos para interactuar con la base de datos y calcular cotizaciones.

## Requisitos del Paquete
Asegúrate de tener los siguientes paquetes y dependencias instaladas antes de proceder con la instalación:

- JDK 17 y JDK 8 IMPORTANTE
- JavaFX SDK 21 (es la version que tengo descargado para evitar problemas descargate esa )

## Paso a Paso de Instalación

Sigue estos pasos para configurar y ejecutar la aplicación:
1. **Clona el repositorio:**
    ```sh
    git clone [URL del repositorio]
    ```
2. **Importa el proyecto en tu IDE preferido:**
    - Abre tu IDE (Neetbeans 22 es el que tengo puedes descargar cualquiera pero si quieres usa ese ) 
    - Importa el proyecto como un proyecto JavaFX.

3. **Sigue los pasos del video:** 
     -Aqui explica como se configura un proyecto de JAVAFX [https://www.youtube.com/watch?v=ej5YrLYtLF0]
     -Si te sale un error tipo **Failed to automatically set-up a JavaFX Platform** Mira este video :
     -[https://www.youtube.com/watch?v=la-wtMeWNnI]

5. **Ejecuta la aplicación:**
    - Compila y ejecuta el proyecto desde tu IDE.
    - Explora las diferentes funcionalidades de la aplicación.

## Descripción Adicional
**⚠️ IMPORTANTE: Asegúrate de Leer todos los pasos y la arquitectura del proyecto. Parte de Edwin Gonzales**
Tu trabajar en el paquete llamado `com.quotegen.implement` quiero que primero me hagas el tema de json de generar un json con la siguiente structura de la clase extendida del paquete 
`com.quotegen.domain` llamada **User** . con sus atributos requerido . ahi agrege `src/main/java/com/quotegen/domain/User.java`. Lo que haras es definir el metodo o la funcion solo definirlo hay un ejemplo en :`src/main/java/com/quotegen/implement/IUser.java` y luego implentar los metodo de la interface guiate de como lo cree. hay un ejemplo en la clase `src/main/java/com/quotegen/implement/UserInmplement.java` .  

##Descripcion de lo que haras  

- Quiero un metodo donde primero haga un tipo de recorrido del **Archivo.JSON** y lo guardes en un arraylist .  
- Quiero un metodo donde tenga ese arraylist y por medio del recorrido del **ArrayList** hagas **(INSERT ,UPDATE, DELETE, SELECT) **(Ya sabras la logica que aplicaras la idea es que se guarden los datos tanto sobreescribiendo o guardando de alguna manera para asi poder recorrer el archivo para generar los cards.  
- Tambien haras lo mismo con otro Archivo json llamado **Product** que hara la misma funcion que usuario ** (SELECT, UPDATE, DELETE,INSERT)**
- Por ultimo un metodo donde pueda Obtener ese arrayList del JSON actualizado  (USER, PRODUCT).

