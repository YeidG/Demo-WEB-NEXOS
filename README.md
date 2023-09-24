# CRUD-Java-Web-JSF-JPA
Proyecto CRUD Java Web con JSF y JPA en Eclipse
Instructivo para el Despliegue en WildFly

Requisitos Previos:

Asegúrate de tener Java 11 o superior instalado en tu máquina.
Descarga e instala WildFly en tu servidor de aplicaciones. Puedes seguir las instrucciones en la página oficial de WildFly: https://wildfly.org/downloads/
Configura una base de datos H2 en memoria como se mencionó anteriormente en el archivo standalone.xml de WildFly.
Pasos para Desplegar la Aplicación:

Paso 1: Compilación del Proyecto

Abre una terminal y navega hasta el directorio raíz de tu proyecto.

Ejecuta el siguiente comando para compilar el proyecto y generar el archivo WAR:

shell

mvn clean package
Esto generará un archivo WAR en la carpeta target de tu proyecto con el nombre demoNex.war.

Paso 2: Despliegue en WildFly

Inicia WildFly si aún no lo has hecho. Puedes hacerlo ejecutando el comando:

shell

./standalone.sh
o

shell

standalone.bat
según tu sistema operativo.

Abre un navegador web y accede a la consola de administración de WildFly en la siguiente dirección:

bash
http://localhost:9990/console

Inicia sesión en la consola de administración con tus credenciales de administrador.
En la consola de administración, selecciona "Deployments" en el menú de la izquierda.
Haz clic en el botón "Add Content" y selecciona el archivo WAR que generaste en el Paso 1 (demoNex.war).
Una vez cargado el archivo WAR, regresa a la página principal de "Deployments" y verás tu aplicación en la lista.
Haz clic en tu aplicación para seleccionarla y luego presiona el botón "Enable" para habilitarla.
Paso 3: Acceso a la Aplicación
Abre un navegador web y accede a la aplicación en la siguiente dirección:
bash
http://localhost:8080/demoNex/