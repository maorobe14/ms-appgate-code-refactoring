
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

- **Regla KISS**: la simplicidad debe ser la meta, y las soluciones complejas deben evitarse a menos que realmente sean necesarias.

