# 🏥 Salud Al Día - Automation Framework

![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=java)
![Selenium](https://img.shields.io/badge/Selenium-4.x-green?style=for-the-badge&logo=selenium)
![Cucumber](https://img.shields.io/badge/Cucumber-BDD-brightgreen?style=for-the-badge&logo=cucumber)
![JUnit](https://img.shields.io/badge/JUnit-5-red?style=for-the-badge&logo=junit5)

Este repositorio contiene la suite de pruebas automatizadas para el portal **Salud Al Día**, una plataforma de monitoreo de salud para pacientes, administradores y especialistas.

## 🚀 Descripción del Proyecto
El framework está diseñado bajo el patrón de diseño **Page Object Model (POM)** y utiliza **Cucumber** para la definición de pruebas en lenguaje natural (Gherkin). El objetivo es garantizar la estabilidad de los flujos críticos en el entorno de producción.

---

## 🛠️ Stack Tecnológico
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
