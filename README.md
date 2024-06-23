# Generador de Cotizaciones Inventario - README

Este proyecto JavaFX es un sistema para generar cotizaciones y gestionar inventarios.

## Estructura del Proyecto

El proyecto está organizado en los siguientes paquetes principales:

### com.quotegen.controllers

Este paquete contiene los controladores de los archivos FXML, los cuales manejan la lógica de la interfaz gráfica y la interacción con el usuario.

#### Ejemplo de uso:
Los controladores se vinculan a los archivos FXML en `com.quotegen.views` para gestionar eventos y actualizar la interfaz de usuario.

### com.quotegen.assets

En este paquete se encuentran los recursos CSS que definen los estilos de los componentes de JavaFX.

#### Descripción:
Los archivos CSS en este directorio personalizan la apariencia de los elementos de la interfaz gráfica para mantener consistencia y mejorar la usabilidad.

### com.quotegen.views

Aquí se almacenan los archivos FXML que representan las distintas interfaces de usuario del sistema.

#### Propósito:
Los archivos FXML se utilizan junto con los controladores en `com.quotegen.controllers` para definir la estructura y el comportamiento de las ventanas y diálogos de la aplicación.

### com.quotegen.connection

Este paquete incluye las clases que gestionan la conexión y la interacción con la base de datos del sistema.

#### Funcionalidad:
Las clases aquí presentes establecen y mantienen la conexión con la base de datos, ejecutan consultas SQL y gestionan transacciones para garantizar la integridad de los datos.

### com.quotegen.domain

En este paquete se encuentran las clases de dominio que representan las entidades del negocio, como productos, clientes, y cotizaciones.

#### Propósito:
Las clases en este directorio encapsulan la lógica del negocio y los datos asociados, proporcionando métodos para interactuar con la base de datos y calcular cotizaciones.

## Configuración y Uso

Para ejecutar la aplicación:

1. Clona el repositorio desde [URL del repositorio].
2. Importa el proyecto en tu IDE preferido como un proyecto JavaFX.
3. Configura la base de datos y ajusta la configuración de conexión en `com.quotegen.connection`.
4. Ejecuta la aplicación y explora las diferentes funcionalidades.
