# Título: La Operación de Galton en la Fábrica de Campanas de Gauss
## Hecho por Alberto Valera y Inés Elena Gómez 
### Link repositorio GitGub: https://github.com/aalbertovalera48/Parcial1AlbertoyInes.git

El proyecto se separa por una carpeta java y una resources:
En la carpeta java 9 packages :
# Proyecto: Fábrica de Campanas de Gauss

Este proyecto simula la operación de una fábrica utilizando un tablero de Galton para la distribución de componentes. Utiliza tecnologías como Java, Spring Boot, SQL, y Maven.

## Directorios y Clases

### `CampanaGauss`
Este paquete contiene las clases relacionadas con la producción y visualización de componentes.

#### `Componente`
Clase que modela un componente producido por las estaciones de trabajo.
- **tipo**: Indica el tipo de componente producido.
- **getTipo()**: Devuelve el tipo de componente.

#### `EstacionTrabajo`
Simula una estación de trabajo que produce componentes de un tipo específico.
- **buffer**: Cola compartida donde se colocan los componentes producidos.
- **tipoComponente**: Tipo de componente que produce la estación.
- **run()**: Produce componentes y los coloca en el buffer.

#### `FabricaSimulacion`
Clase principal que orquesta la simulación de la fábrica.
- **main(String[] args)**: Configura y ejecuta la simulación de la fábrica con estaciones de trabajo y línea de ensamblaje.

#### `LineaEnsamblaje`
Simula la línea de ensamblaje que consume componentes del buffer producido por las estaciones de trabajo.
- **run()**: Consume componentes del buffer y simula el ensamblaje.

#### `VisualizacionDistribucion`
Esta clase implementa una interfaz gráfica que muestra la distribución en tiempo real de los componentes producidos.
- **contenedores**: Array que almacena la cantidad de componentes en cada contenedor.
- **VisualizacionDistribucion()**: Constructor que inicia un temporizador para actualizar la visualización.
- **paintComponent(Graphics g)**: Dibuja los contenedores y la distribución de componentes.
- **actualizarDistribucion(int contenedor)**: Actualiza la cantidad de componentes en un contenedor específico.

### `GaltonSpringBoot`
Este paquete implementa una versión de la simulación del Tablero de Galton utilizando Spring Boot para ofrecer una interfaz web.

#### `Pelota1`
Simula el comportamiento de una bola en el tablero de Galton.
- **Pelota1(TableroGalton1 board)**: Constructor que recibe el tablero de Galton.
- **run()**: Simula la caída de una bola y actualiza el contenedor correspondiente en el tablero.

### `Exceptions`
Este paquete contiene excepciones personalizadas que son utilizadas en la aplicación para manejar errores específicos relacionados con los usuarios y el servicio de usuarios.

#### `UsuarioNoLogeadoException`
Excepción que se lanza cuando un usuario no autorizado intenta acceder a recursos protegidos.
- **UsuarioNoLogeadoException()**: Constructor de la excepción.

### `GaltonAplicacion`
Este paquete contiene la clase principal de la aplicación que configura y ejecuta la simulación del tablero de Galton.

#### `SimulacionGalton`
Configura y ejecuta la simulación del tablero de Galton con bolas cayendo en contenedores.
- **main(String[] args)**: Configura y ejecuta la simulación del tablero de Galton con bolas cayendo en contenedores.

### `org.example.parcial1`
Este paquete contiene la clase principal de la aplicación Spring Boot.

#### `Parcial1Application`
Clase principal anotada con `@SpringBootApplication` que inicia la aplicación.
- **Parcial1Application()**: Constructor de la clase principal.

### `Services`
Este paquete contiene la clase `UsuarioService`, que maneja la lógica de negocio relacionada con los usuarios de la aplicación.

#### `UsuarioService`
Maneja la lógica de negocio relacionada con los usuarios de la aplicación.
- **login(String eMail, String password)**: Permite a un usuario iniciar sesión utilizando su correo electrónico y contraseña.
- **registrar(Usuario usuario)**: Registra un nuevo usuario en la aplicación.

### `Controllers`
Este paquete contiene un conjunto de controladores basados en Spring Boot que gestionan la funcionalidad de autenticación de usuarios, registro y la redirección de rutas dentro de la aplicación web.

#### `HomeController`
Maneja las rutas básicas y redirige a las vistas correspondientes para login, registro y simulación.
- **@GetMapping("/login")**: Redirige al formulario de inicio de sesión.
- **@GetMapping("/registro")**: Redirige al formulario de registro de usuario, y pasa un objeto `RegistroData` al modelo.
- **@GetMapping("/simulacion")**: Redirige a la vista de simulación.

#### `LoginController`
Gestiona las rutas y lógica relacionadas con el inicio de sesión, registro de usuarios y cierre de sesión.
- **loginForm()**: Muestra el formulario de login.
- **loginSubmit()**: Procesa el login del usuario.
- **registroForm()**: Muestra el formulario de registro.
- **registroSubmit()**: Procesa el registro de un nuevo usuario.
- **logout()**: Cierra la sesión del usuario.

### `Interfaces`
Este paquete se basa en el patrón de diseño de repositorio, que proporciona una forma de abstraer la lógica de acceso a datos de la lógica de negocio.

#### `CrudRepository`
Define las operaciones básicas de creación, lectura, actualización y eliminación (CRUD) para las entidades.

#### `UsuarioRepository`
Especializada para trabajar con la entidad Usuario.
- **findByEmail(String email)**: Busca un usuario por su email.

## Archivos de Configuración

### `application.properties`
Contiene configuraciones de la aplicación, como la base de datos, el servidor RabbitMQ, y Thymeleaf.

### `data.sql`
Script SQL para poblar la base de datos con datos iniciales.

## Plantillas HTML

### `home.html`
Página de inicio con enlaces a la simulación, login y registro.

### `login.html`
Formulario de login para usuarios.

### `registro.html`
Formulario de registro para nuevos usuarios.

### `simulacion.html`
Página para visualizar la simulación del tablero de Galton.

### `visualizacion.html`
Página para la visualización en tiempo real de la caída de bolas.

### `error.html`
Página de error para manejar rutas no encontradas.

### `fragments.html`
Fragmentos reutilizables de HTML para la cabecera y scripts.

