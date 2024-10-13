# Título: La Operación de Galton en la Fábrica de Campanas de Gauss
## Hecho por Alberto Valera y Inés Elena Gómez 
### Link repositorio GitGub: https://github.com/aalbertovalera48/Parcial1AlbertoyInes.git

El proyecto se separa por una carpeta java y una resources:
En la carpeta java 9 packages :
## CampanaGauss
### Clase Componente 
- Clase que modela un componente producido por las estaciones de trabajo.
- tipo: Indica el tipo de componente producido
### Clase EstacionTrabajo
- Simula una estación de trabajo que produce componentes de un tipo específico.
- Estos componentes se colocan en un buffer compartido que es consumido por la línea de ensamblaje
### Clase FabricaSimulacion
- Clase principal que orquesta la simulación de la fábrica.
- Crea dos estaciones de trabajo que producen diferentes tipos de componentes y una línea de ensamblaje que consume los componentes.
### Clase LineaEnsamblaje
- Simula la línea de ensamblaje que consume componentes del buffer producido por las estaciones de trabajo.
### Clase VisualizacionDistribucion
- Esta clase implementa una interfaz gráfica que muestra la distribución en tiempo real de los componentes producidos.
- Los componentes se agrupan en 10 contenedores que simulan una distribución normal.
  
## Conttrollers
- Este proyecto contiene un conjunto de controladores basados en Spring Boot que gestionan la funcionalidad de autenticación de usuarios, registro y la redirección de rutas dentro de la aplicación web.
### HomeController
- Este controlador maneja las rutas básicas y redirige a las vistas correspondientes para login, registro y simulación.
    - @GetMapping("/login"): Redirige al formulario de inicio de sesión.
    - @GetMapping("/registro"): Redirige al formulario de registro de usuario, y pasa un objeto RegistroData al modelo.
    - @GetMapping("/simulacion"): Redirige a la vista de simulación.
### LoginController
- Este controlador gestiona las rutas y lógica relacionadas con el inicio de sesión, registro de usuarios y cierre de sesión.
    - #### Funcionalidades
       - Inicio de Sesión (Login)
           - GET /login: Muestra el formulario de inicio de sesión.
           - POST /login: Valida las credenciales del usuario utilizando UsuarioService.
           - Dependiendo del resultado, redirige al usuario a su página personal o muestra un error si la autenticación falla.
        - Registro de Usuario
            - GET /registro: Muestra el formulario de registro de usuario.
            - POST /registro: Procesa el registro de un nuevo usuario, validando los datos ingresados y asegurando que no exista ya un usuario con el mismo email en el sistema. 
        - Cierre de Sesión (Logout)
            - GET /logout: Cierra la sesión del usuario y redirige a la página de inicio de sesión.

## Data

### LoginData
- LoginData es una clase simple que representa los datos del formulario de inicio de sesión. Incluye los campos email y password, y contiene los getters y setters correspondientes para acceder a estos valores.
  
### ManagerUserSession
- ManagerUserSession es una clase que gestiona las sesiones de usuario mediante HttpSession para realizar una autorización básica y almacenar el estado de inicio de sesión del usuario.
  
### RegistroData
- RegistroData es una clase que representa los datos que el usuario proporciona durante el registro.
- Incluye validaciones básicas como la del formato de correo electrónico y el formato de la fecha de nacimiento

### Usuario
- Usuario es la entidad principal que representa a los usuarios de la aplicación en la base de datos.

## Exceptions
. Este paquete contiene excepciones personalizadas que son utilizadas en la aplicación para manejar errores específicos relacionados con los usuarios y el servicio de usuarios. 
### UsuarioNoLogeadoException
- Esta excepción se utiliza cuando un usuario intenta acceder a recursos o ejecutar acciones sin haber iniciado sesión en la aplicación
-  Está anotada con @ResponseStatus para retornar un código de estado HTTP 401 Unauthorized junto con un mensaje personalizado.
    - HttpStatus.UNAUTHORIZED: Esta excepción retorna un código de estado 401, lo que indica que el usuario no está autorizado para realizar la solicitud.
    - Mensaje personalizado: Se muestra el mensaje "Usuario no autorizado" cuando se lanza la excepción.
### UusarioServiceException
- UsuarioServiceException es una excepción personalizada que puede ser lanzada por la capa de servicios cuando se produce un error relacionado con el manejo de usuarios.
- Esta excepción hereda de RuntimeException y permite incluir un mensaje descriptivo sobre el error.
## GaltonAplicacion
- Este proyecto implementa una simulación visual del Tablero de Galton usando Java y Swing
-  La simulación permite visualizar cómo las bolas caen a través de un tablero de clavos, con un gráfico de distribución que se actualiza dinámicamente para mostrar cómo las bolas se acumulan en contenedores al final.
### GraficoDistrobucion
- Esta clase es un componente gráfico personalizado que muestra un histograma con la cantidad de bolas que han caído en cada contenedor.
- Utiliza barras verticales de color azul para representar la acumulación de bolas.
  
### Pelota
- La clase Pelota simula el comportamiento de una bola individual al caer por el tablero de Galton.
- La bola se mueve hacia la izquierda o la derecha de manera aleatoria en cada fila de clavos.
  
### SimulacionGalton
- Esta es la clase principal que configura el entorno gráfico y coordina la simulación.
    - ExecutorService: Permite ejecutar múltiples bolas concurrentemente utilizando hilos para simular la caída en paralelo.
    - TableroGalton y GraficoDistribucion: Se integran en una interfaz gráfica que muestra el tablero y el histograma de la distribución de bolas.
### TableroGalton
- El TableroGalton es el componente gráfico que dibuja los clavos del tablero, muestra las bolas mientras caen y contiene los contenedores donde se acumulan las bolas.
    - addBallPosition(Point position): Almacena las posiciones de las bolas mientras caen, permitiendo que se dibujen en tiempo real.
    - addToBin(int bin): Actualiza el contenedor donde cae la bola al final de su trayectoria.
      
## GaltonSpringBoot
- Este paquete implementa una versión de la simulación del Tablero de Galton utilizando Spring Boot para ofrecer una interfaz web que simula la caída de bolas en el tablero.
  
### Pelota1
- Esta clase implementa el comportamiento de una bola en el tablero de Galton.
- Cada vez que se ejecuta una instancia de esta clase, simula la caída de una bola y la coloca en uno de los contenedores del tablero.
  
### SimulacionController
- El SimulacionController es un controlador Spring que maneja las solicitudes HTTP y coordina la simulación.
  
### TableroGalton1
- El TableroGalton1 representa el tablero de Galton donde las bolas caen y se acumulan en contenedores.
- Usa un generador aleatorio para simular el desplazamiento de las bolas a través de las filas de clavos.

## Interfaces
- Se basa en el patrón de diseño de repositorio, que proporciona una forma de abstraer la lógica de acceso a datos de la lógica de negocio.
  
### CrudRepository
- La interfaz CrudRepository extiende la interfaz Repository de Spring Data.
- Esta interfaz define las operaciones básicas de creación, lectura, actualización y eliminación (CRUD) para las entidades.
  
### UsuarioRepository
- La interfaz UsuarioRepository extiende CrudRepository y está especializada para trabajar con la entidad Usuario.
- Define métodos específicos para la gestión de usuarios, como la búsqueda por correo electrónico.
  
## org.example.parcial1
- Este paquete contiene la clase principal de la aplicación Spring Boot.
- Esta clase es el punto de entrada que inicia la aplicación, configurando el contexto de Spring y comenzando a escuchar las solicitudes en el servidor.
### Parcial1Application
- La clase Parcial1Application está anotada con @SpringBootApplication, lo que indica que es una clase de configuración de Spring Boot.

## Services
- Este paquete contiene la clase UsuarioService, que maneja la lógica de negocio relacionada con los usuarios de la aplicación.
- Esta clase se encarga de gestionar el registro, inicio de sesión y búsqueda de usuarios en la base de datos.
  
### UsuarioService
- Atributos
    - usuarioRepository: Interfaz que proporciona métodos para interactuar con la base de datos para operaciones relacionadas con el objeto Usuario.
    - Se inyecta mediante la anotación @Autowired.
- Métodos
    - Enum LoginStatus
      - Define el estado del inicio de sesión:
          - LOGIN_OK: Indica que el inicio de sesión fue exitoso.
          - USER_NOT_FOUND: Indica que no se encontró el usuario.
          - ERROR_PASSWORD: Indica que la contraseña es incorrecta
       
      - login(String eMail, String password)
        - Descripción: Permite a un usuario iniciar sesión utilizando su correo electrónico y contraseña.
        - Transacción: Marcado como @Transactional(readOnly = true), ya que solo realiza operaciones de lectura.
        - Flujo:
            - Busca al usuario en la base de datos por su correo electrónico.
            - Verifica si el usuario existe y si la contraseña coincide.
            - Devuelve el estado del inicio de sesión.
         
      - registrar(Usuario usuario)
          - Descripción: Registra un nuevo usuario en la aplicación.
          - Transacción: Marcado como @Transactional para permitir operaciones de escritura.
          - Requisitos
            - El correo electrónico y la contraseña no deben ser nulos.
            - El correo electrónico no debe estar ya registrado.
           
          - Flujo
            - Verifica si el usuario ya está registrado.
            - Lanza una excepción UsuarioServiceException si el registro no es válido.
            - Guarda el usuario en la base de datos.
           
### En la carpeta Resources tenemos 2 directorios: Data y templates

## Data
-  Este directorio contiene archivos relacionados con la gestión y el modelo de datos de la aplicación.
- RegistroData: Clase que representa los datos de registro de un usuario.

### Archivos

### data.sql

Este archivo contiene sentencias SQL para poblar las tablas de la base de datos con datos iniciales. Actualmente, inserta un usuario de ejemplo en la tabla usuarios.

### Contenido Ejemplo:

### SQL
INSERT INTO usuarios (id, email, nombre, password, fecha_nacimiento) VALUES('1', 'user@ua', 'Data.Usuario Ejemplo', '123', '2001-02-10');

## templates
Este directorio contiene varios recursos utilizados por la aplicación, incluyendo archivos de configuración, plantillas y activos estáticos.

### Estructura

- `application.properties`: Archivo de configuración para la aplicación Spring Boot.
- `templates/`: Directorio que contiene plantillas Thymeleaf para renderizar vistas HTML.
- `error.html`: Plantilla para mostrar mensajes de error.
- `fragments.html`: Plantilla que contiene fragmentos HTML reutilizables.
- `home.html`: Plantilla para la página de inicio.
- `login.html`: Plantilla para la página de inicio de sesión.
- `registro.html`: Plantilla para la página de registro.
- `simulacion.html`: Plantilla para la página de simulación.
- `jquery.min.js`: Biblioteca jQuery.
  

## Configuración

### application.properties

Este archivo contiene varias configuraciones para la aplicación Spring Boot, como detalles de conexión a la base de datos, niveles de registro y configuraciones de Thymeleaf.

### Plantillas Thymeleaf

El directorio templates contiene plantillas Thymeleaf utilizadas para renderizar vistas HTML. Cada plantilla corresponde a una página o componente específico de la aplicación.

### Uso

- **Página de Inicio**: La plantilla de la página de inicio (`home.html`) se utiliza para mostrar la página principal de la aplicación.
- **Página de Inicio de Sesión**: La plantilla de la página de inicio de sesión (`login.html`) se utiliza para la autenticación de usuarios.
- **Página de Registro**: La plantilla de la página de registro (`registro.html`) se utiliza para el registro de nuevos usuarios.
- **Página de Simulación**: La plantilla de la página de simulación (`simulacion.html`) se utiliza para mostrar la simulación del tablero de Galton.
- **Página de Error**: La plantilla de la página de error (`error.html`) se utiliza para mostrar mensajes de error al usuario.

