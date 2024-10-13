Este proyecto lo hemnos separado en 9 packages 
El primero es:
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
           - Dependiendo del resultado, redirige al usuario a su página personal o muestra un                error si la autenticación falla.
        - Registro de Usuario
            - GET /registro: Muestra el formulario de registro de usuario.
            - POST /registro: Procesa el registro de un nuevo usuario, validando los datos                    ingresados y asegurando que no exista ya un usuario con el mismo email en el                    sistema. 
        - Cierre de Sesión (Logout)
            - GET /logout: Cierra la sesión del usuario y redirige a la página de inicio de                   sesión.

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
### UsuarioNoLogeadoException
### UusarioServiceException

## GaltonAplicacion
### GraficoDistrobucion
### Pelota
### SimulacionGalton
### TableroGalton

## GaltonSpringBoot
### Pelota1
### SimulacionController
### TableroGalton1

## Interfaces
### CrudRepository
### UsuarioRepository

## org.example.parcial1
### Parcial1Application

## Services
### UsuarioService
