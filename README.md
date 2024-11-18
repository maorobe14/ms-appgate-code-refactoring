
# Proyecto Code Refactoring

## Descripción

El objetivo del proyecto es lograr refactorizar un código de ejemplo identificando las malas prácticas de programación.

---

## 1. Identificación malas practicas.

Las malas prácticas en el desarrollo de software afectan la calidad, mantenibilidad y escalabilidad del código. Identificarlas es crucial para evitar problemas a largo plazo y mejorar el rendimiento del equipo. Detectar estas prácticas permite adoptar mejores métodos y garantizar un software más robusto. Este proceso es clave para crear soluciones sostenibles y de alta calidad. En el código de ejemplo, se identifican las siguientes:

---

## 1.1. Clase SocialMention.

```
class SocialMention {
private String message;
private String facebookAccount;
private String tweeterAccount;
private String creationDate;
private String tweeterUrl;
private List<String> facebookComments;
}
```
### 1.1.1. Encapsulación incompleta

Sin setters, getters ni constructores ni otro tipo de estructuras como bloques de instancia o staticos, no hay un control explícito sobre cómo se accede o modifica el estado de los atributos de la clase al estos ser privados.

- **Mala mantenibilidad**: Si en el futuro necesitas añadir validaciones al asignar valores (como evitar que creationDate sea nulo o verificar el formato de las cuentas), será más difícil hacerlo sin los setters o un constructor controlado.

- **Falta de flexibilidad**: Sin un constructor ni otro tipo de estructuras como bloques de instancia o staticos no seria posible inicializar los atributos de la clase. Sin getters, recuperar valores específicos desde instancias de la clase también será un desafío.

- **Incompatibilidad con frameworks**: Muchos frameworks como Spring, Hibernate o Jackson esperan que las clases sigan ciertas convenciones, como tener un constructor sin argumentos o con los argumentos necesarios, y métodos de acceso getters y setters para manejar datos. Si esta clase no sigue esas convenciones, puede no funcionar bien con estos frameworks.

### 1.1.2. Falta de validaciones en las propiedades

La falta de validaciones en las propiedades de una clase puede generar varios problemas serios en el desarrollo de una aplicación, afectando la fiabilidad, seguridad y mantenibilidad del código. Cuando no se implementan validaciones adecuadas, los datos dentro de la clase pueden ser incorrectos, inconsistentes o, en el peor de los casos, provocar fallos en la ejecución.

- **Datos inconsistentes**: La falta de validaciones permite que los atributos de la clase contengan valores inválidos o no esperados, lo que puede afectar la coherencia y precisión de la información procesada en la aplicación. Por Ejemplo
    
    - Si facebookAccount contiene una cadena vacía o mal formateada, el sistema podría intentar usarla de manera incorrecta (por ejemplo, generando URLs incorrectas).
    - Si creationDate no sigue el formato esperado (por ejemplo, "dd/MM/yyyy"), puede fallar al intentar formatearla o compararla con otras fechas.

-  **Excepciones inesperadas y errores en tiempo de ejecución**: La falta de validaciones puede resultar en excepciones que podrían haberse evitado. Los errores pueden aparecer en cualquier parte de la ejecución del programa y, en algunos casos, ser difíciles de detectar. Ejemplo:
    - Si no se valida que el tweeterUrl sea un enlace URL válido (con http o https), podria almacenas datos incorrecto en las persistencias e incluso en procimas implementaciones, al intentar acceder a esta URL, el código podría lanzar una excepción de tipo MalformedURLException. Esto puede producir fallos en la aplicación, afectando la experiencia del usuario o incluso bloqueando procesos críticos.

- **Dificultades para mantener el código**: La ausencia de validaciones puede llevar a un código más difícil de mantener y depurar, ya que los desarrolladores pueden no tener claro qué valores son aceptables para las propiedades. Los errores podrían no ser evidentes hasta que el sistema esté en producción.

- **Problemas de seguridad**: Validaciones insuficientes pueden exponer la aplicación a vulnerabilidades de seguridad, como inyección de código o ataques de falsificación. Si las propiedades como facebookAccount o tweeterAccount no son validadas correctamente, un atacante podría intentar inyectar valores maliciosos, lo que podría resultar en Inyección SQL o Cross-Site Scripting.

- **Desviación de las reglas de negocio**: Las validaciones son un medio para garantizar que los datos sigan las reglas del negocio y las expectativas del sistema. Al no validar correctamente los datos, es fácil que se violan las reglas de negocio, lo que puede generar comportamientos no deseados o resultados incorrectos.

- **Problemas en la integración con otros sistemas**:  Cuando se interactuan con otros sistemas, servicios o bases de datos, es posible que esos sistemas tengan expectativas específicas sobre el formato de los datos. Si no validas las propiedades antes de enviarlas, los servicios o bases de datos externos pueden rechazar los datos.

- **Impacto en el rendimiento**: Si se permite que los datos erróneos se filtren a través de la aplicación, el sistema podría terminar realizando más operaciones para corregir los errores en lugar de hacer las tareas de manera eficiente adicional podria no cumplir ninguna de las reglas de las estructuras de control de flujo y realizar procesamientos inecesarios.


### 1.1.3. Uso incorrecto de tipos de objetos ciertas propiedades

- La propiedad creationDate está tipada como String, lo cual es un tipo inapropiado para manejar fechas. Este tipo de dato no ofrece ninguna funcionalidad para realizar comparaciones de fechas, ordenamientos o validaciones, lo cual podría derivar en errores más adelante cuando el sistema intente trabajar con fecha.

- Principio ACID: Impacto en la Persistencia: El principio ACID (Atomicidad, Consistencia, Aislamiento y Durabilidad) es fundamental cuando se trabaja con bases de datos, especialmente en sistemas que manejan transacciones. Utilizar tipos incorrectos también puede afectar las propiedades ACID de las transacciones.

    - Atomicidad: Si los datos se representan incorrectamente, las operaciones de base de datos pueden no ser atómicas. Por ejemplo, si intentas guardar una fecha incorrecta o mal formateada, la transacción puede fallar, y podrías acabar con un estado inconsistente.

    - Consistencia: La falta de validación de los tipos y valores puede resultar en datos inconsistentes. Si los valores no son del tipo correcto, como en el caso de creationDate, el sistema podría permitir que se almacenen fechas inválidas, lo que rompe las reglas de consistencia de la base de datos.

    - Aislamiento: Aunque los problemas de tipos incorrectos no afectan directamente al aislamiento, los errores de concurrencia pueden surgir cuando múltiples transacciones intentan acceder y modificar los mismos datos con tipos incorrectos.

    - Durabilidad: Si los datos están mal representados o mal validados, la durabilidad de las transacciones podría estar en riesgo. Los tipos incorrectos pueden hacer que los datos no se persistan correctamente, lo que puede llevar a pérdida de datos o corrupción de la base de datos. 


---

## 1.2. Controlador clase SocialMentionController .

Este código genera una violación de algunos **principios SOLID** y **CLEAN CODE**, esto implica varios problemas en el desarrollo que pueden afectar la calidad, mantenibilidad, escalabilidad y flexibilidad del código. Cada principio está diseñado para fomentar una programación más limpia, modular y flexible, por lo que al violarlos, el código se vuelve más difícil de gestionar y modificar a largo plazo.

### 1.2.1. Violación de Principios SOLID 


- **Responsabilidad Única**: El controlador SocialMentionController tiene demasiadas responsabilidades: maneja la lógica de la solicitud HTTP, realiza cálculos de puntuaciones, maneja el análisis de los comentarios de Facebook y Twitter, y se encarga de interactuar con la base de datos.

- **inversión de dependencias**: DBService está directamente instanciado en el controlador con valores de configuración rígidos (localhost y puerto 5432). Esto hace que el código sea difícil de mantener y no sea flexible.

- **Abierto/Cerrado**: El controlador SocialMentionController contiene la lógica de análisis tanto para Facebook como para Twitter en un solo lugar, y la forma de calcular la puntuación de cada red social está ligada directamente al controlador. Si más adelante se agrega una nueva red social o se necesita modificar el análisis de las existentes, necesitaríamos cambiar directamente el código del controlador, lo que contraviene el principio de abierto/cerrado.

### 1.2.2. Violación de Clean Code

- **Responsabilidad Única (SRP)**: Todo el análisis de los comentarios de Facebook y Twitter, así como la lógica de interacción con base de datos entre otras, está implementada directamente en el controlador. Esto crea un controlador muy grande y difícil de probar.

- **Códigos Mágicos y Valores Hardcodeados**: El controlador tiene valores mágicos como -100d, 50d, 0.7d, y -0.5d que no tienen un significado claro ni son fáciles de modificar o configurar. 

- **Metodos cortos (Small Methods)**: El método analyze es largo y realiza demasiadas tareas (análisis de Facebook, Twitter, interacción con la base de datos, generación de respuestas). Esto hace que sea difícil de leer y mantener.

- **Definición y Nombres Inadecuados**: El nombre del método analyze es demasiado genérico y no describe claramente lo que está haciendo el código. Además, algunas variables no tienen nombres suficientemente descriptivos dificultando entender su proposito mejor el propósito.

- **Comentarios Innecesarios**: En Clean Code, uno de los principios clave es evitar comentarios innecesarios. La idea es que el código debe ser lo suficientemente claro y expresivo por sí mismo, de modo que los comentarios solo sean necesarios en casos excepcionales. Si se escriben comentarios sobre lo que hace el código, es una señal de que el código no está lo suficientemente claro o legible.

- **Lógica Compleja y Duplicada (Avoid Duplication)**: Hay bloques de código repetidos, como los condicionales que calculan las puntuaciones para Facebook y Twitter. Esto puede generar dificultades para mantener el código en el futuro

- **Uso Incorrecto de Condiciones (Avoid Nested Conditionals)**: Hay condiciones anidadas y múltiples bloques if y else que dificultan la legibilidad y la comprensión del flujo del código. Especialmente cuando se maneja la puntuación de facebookScore y tweeterScore en diferentes rangos.

- **Regla KISS**: la simplicidad debe ser la meta, y las soluciones complejas deben evitarse a menos que realmente sean necesarias.

---
## 2. Solución de malas practicas.
---

## 2.1. Clase SocialMention.

### 2.1.1. Encapsulación incompleta:
Para abordar la falta de encapsulación, se implementaron los siguientes cambios:

- **Getters y Setters**: Se añadieron métodos de acceso (getters) y modificación (setters) para cada uno de los atributos de la clase. Esto asegura un control adecuado sobre el acceso y modificación de los datos encapsulados, permitiendo en el futuro integrar lógica adicional (como validaciones) si es necesario.

- **Constructores parametrizados y sin argumentos**: Se añadieron un constructor sin argumentos (necesario para frameworks como Hibernate y Jackson, ambos empleados en este proeycto) y otro parametrizado, que facilita la creación de instancias con valores iniciales. Esto mejora la mantenibilidad y permite una inicialización consistente.

- **Anotaciones de Lombok**: Se usaron las anotaciones @Getter, @Setter, @NoArgsConstructor y @AllArgsConstructor de Lombok para reducir el código repetitivo, manteniendo la clase limpia y legible.

### 2.1.2. Validaciones en las propiedades:

Las validaciones en los atributos se manejaron con las siguientes estrategias:

- **Validaciones mediante anotaciones de Jakarta Validation**:Para creationDate, se añadió la anotación @NotNull con un mensaje personalizado que asegura que este campo no pueda ser nulo. Esto previene errores en tiempo de ejecución derivados de valores faltantes. Validaciones similares se pueden extender a otros campos, como message, facebookAccount y tweeterAccount, para garantizar que contengan valores adecuados.

- **Validaciones personalizadas (si fuera necesario)**: Las anotaciones de validación pueden complementarse con lógica específica en los setters para casos más complejos, como validar el formato de URLs o verificar la estructura de las cuentas de redes sociales.

### 2.1.3. Uso correcto de tipos para las propiedades:

Se corrigió el tipo de dato de la propiedad creationDate de String a LocalDate. Este cambio ofrece los siguientes beneficios:

- **Manipulación adecuada de fechas**: LocalDate proporciona métodos nativos para comparar, formatear y realizar operaciones con fechas, eliminando errores comunes al trabajar con cadenas que representan fechas.

- **Mejor integración con bases de datos**: Al usar un tipo específico de fecha, frameworks como JPA pueden mapear correctamente esta propiedad a un tipo de dato de fecha en la base de datos, cumpliendo con las reglas del principio ACID y mejorando la consistencia de los datos.

---

## 2.2. Controlador clase SocialMentionController .

### 2.2.1. Violación de Principios SOLID 

- **Responsabilidad Única**: se hizo una refactorización integral utilizando un enfoque orientado al dominio y patrones de diseño, lo que mejora significativamente la claridad, la mantenibilidad y la escalabilidad del código.

    - El uso de un enfoque orientado al dominio permite modelar las funcionalidades clave del sistema en clases que representen los conceptos y comportamientos del dominio de negocio. En lugar de tener una clase controladora masiva que hace todo, el código ahora está organizado en entidades, servicios de dominio y repositorios, lo que permite una mejor representación de la lógica de negocio.

    - Se empleo el patrón de diseño creacional Factory para crear objetos diferentes dependiendo de la red social con la que se esté interactuando (por ejemplo, un analizador de comentarios de Facebook o Twitter). En lugar de crear instancias de clases concretas directamente en el controlador, se delega en una fábrica que se encarga de instanciar el objeto adecuado según el tipo de red social que se esté analizando, Esto desacopla la lógica de creación de instancias del controlador, lo que hace que el código sea más flexible y fácil de extender si se agregan más redes sociales en el futuro.

    - Se crearon las clases con responsabilidad única, de igual forma los metodos e interfaces.

    
- **inversión de dependencias**: Para la solución em apoye en el modulo de spring Spring Data JPA, lo que implica la creación de un repositorio que gestiona la interacción con la base de datos. Este enfoque resuelve el problema de Inversión de Dependencias (DIP) ya que logra el desacoplamiento entre los modulos alto nivel con los de bajo nivel, ademas mejora la flexibilidad, escalabilidad y mantenibilidad del código.

- **Abierto/Cerrado**: Para seguir el principio de Abierto/Cerrado, se separó la lógica de análisis de los comentarios de Facebook y Twitter en clases independientes que implementan una interfaz común. Cada clase representa el comportamiento específico de análisis de cada red social. De este modo, si en el futuro se agrega una nueva red social (por ejemplo, Instagram o LinkedIn), solo será necesario crear una nueva clase que implemente la interfaz sin necesidad de modificar el controlador o las clases existentes.


### 2.2.2. Violación de Clean Code

- **Responsabilidad Única (SRP)**: Se aplicó el principio de Responsabilidad Única (SRP) dividiendo la lógica del controlador en servicios especializados, como se explico anteriormente.

- **Códigos Mágicos y Valores Hardcodeados**: Estos valores fueron reemplazados por constantes descriptivas en una clase transversal o en las clases donde se encontraban implementados. 

- **Metodos cortos (Small Methods)**: Se desglosaron las tareas del método analyze en métodos pequeños con nombres descriptivos. Evitando que sobrepasaran las 20 lineas de código.

- **Definición y Nombres Inadecuados**: Se renombraron clases, métodos y variables para que su propósito fuera claro. y así mismo se llevo a cabo una definición clara de cada elemento del software creado.

- **Comentarios Innecesarios**: Se eliminaron comentarios redundantes que explicaban lo que hacía el código. Estos comentarios no agregaban valor y solo llenaban de texto el código.

- **Lógica Compleja y Duplicada (Avoid Duplication)**: Se reorganizaron las condiciones para reducir la anidación y hacer que el flujo fuera más claro. Se utilizaron sentencias switch o polimorfismo cuando era adecuado, eliminando las condiciones anidadas innecesarias. Adicionalmente, se emplearon patrones de diseño como **Facade** para mejorar la legibilidad y encapsular la complejidad. El patrón Facade simplifica la interacción con sistemas complejos al proporcionar una interfaz única y coherente, evitando que el cliente tenga que gestionar múltiples interacciones con clases o servicios internos.

- **Uso Incorrecto de Condiciones (Avoid Nested Conditionals)**: Se utilizaron sentencias switch y polimorfismo, eliminando las condiciones anidadas innecesarias. Ademas con el desacoplamiento de las redes sociales tambien se logro disminuir el numero de condicionales necesarios, facilitando la comprensión y mantenimiento del código.

- **Regla KISS**: Se aplicaron principios de diseño más simples, eliminando lógica innecesaria y mejorando la estructura general del código. Se usaron patrones de diseño y arquitectura adecuados para organizar mejor la lógica sin hacer el sistema más complejo.
