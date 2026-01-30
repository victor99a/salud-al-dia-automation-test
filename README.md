# Salud Al Día - Automation Framework

![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=java)
![Selenium](https://img.shields.io/badge/Selenium-4.x-green?style=for-the-badge&logo=selenium)
![Cucumber](https://img.shields.io/badge/Cucumber-BDD-brightgreen?style=for-the-badge&logo=cucumber)
![JUnit](https://img.shields.io/badge/JUnit-5-red?style=for-the-badge&logo=junit5)

Este repositorio contiene la suite de pruebas automatizadas para el portal **Salud Al Día**, una plataforma de monitoreo de salud para pacientes, administradores y especialistas.

## Descripción del Proyecto
El framework está diseñado bajo el patrón de diseño **Page Object Model (POM)** y utiliza **Cucumber** para la definición de pruebas en lenguaje natural (Gherkin). El objetivo es garantizar la estabilidad de los flujos críticos en el entorno de producción.

## Guía de Aprendizaje
Si quieres aprender a automatizar casos de prueba y estás explorando este repositorio, aquí te explicamos cómo entender la arquitectura de este proyecto de automatización. El framework está dividido en 3 capas principales para que sea mantenible y profesional:

### 1. Capa de Comportamiento (`.feature`)
Ubicada en `src/test/resources/features`. Aquí escribimos el **paso a paso** en lenguaje Gherkin. 
* **El objetivo:** Que cualquier persona (aunque no sepa programar) entienda qué estamos probando.
* **Concepto clave:** Describe el **QUÉ** hace el usuario.

### 2. Capa de Traducción (`StepDefinition`)
Ubicada en `src/test/java/com/SaludAlDia/StepDefinition`. Es el puente entre el texto del feature y el código Java.
* **El objetivo:** Escuchar los pasos del feature y llamar a las acciones de la página. Aquí es donde usamos los `Assert` para validar que la prueba pasó o falló.
* **Concepto clave:** Conecta el lenguaje humano con la automatización.

### 3. Capa de Interfaz de Usuario (`Page`)
Ubicada en `src/test/java/com/SaludAlDia/Page`. Aquí aplicamos el patrón **Page Object Model (POM)**.
* **El objetivo:** Centralizar todos los selectores (IDs, XPaths, CSS Selectors) y las interacciones físicas (hacer clic, escribir, limpiar). 
* **Concepto clave:** Describe el **CÓMO** y **DÓNDE** interactuar con la web. Si un botón cambia de ID en el HTML, solo lo arreglamos aquí una vez.



---

##  Buenas Prácticas Aplicadas
Para tu aprendizaje, fíjate en cómo este proyecto maneja los siguientes puntos:

* **Independencia:** Cada escenario busca ser independiente para no depender del éxito del anterior (aunque en flujos largos como Salud Al Día, el orden lógico ayuda a la regresión).
* **Hooks:** Revisa la clase en `Utils`. Ahí verás cómo el navegador se abre y se cierra automáticamente usando `@Before` y `@After`.

---

## Stack Tecnológico
* **Lenguaje:** Java 17
* **Framework de Pruebas:** Cucumber con JUnit 4
* **Automatización Web:** Selenium WebDriver
* **Gestión de Dependencias:** Gradle / Maven
* **Reportabilidad:** Cucumber HTML Reports

---

## 📂 Estructura del Proyecto
```text
src/test/
├── java/com/SaludAlDia/
│   ├── Page/            # Definición de localizadores y acciones (POM)
│   ├── Runnners/        # Clases para ejecutar las pruebas
│   ├── StepDefinition/  # Implementación de los pasos de Gherkin
│   └── Utils/           # Clases de soporte (Hooks, Drivers)
└── resources/features/  # Archivos .feature con los escenarios de prueba

##Escenarios Validados
La suite @RegresionSaludAlDia cubre los siguientes procesos:

Módulo Paciente: Login, registro de glucosa/presión y descarga de historial médico en PDF.

Registro de Usuario: Proceso completo de alta de nuevo paciente y creación de ficha médica.

Módulo Administrador: Gestión de especialistas y visualización de usuarios globales.

Módulo Especialista: Consulta de fichas médicas de pacientes asignados.
