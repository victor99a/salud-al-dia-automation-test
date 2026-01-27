Feature: Pruebas de funcionalidad del portal privado paciente de Salud Al Día

  @LoginYReportePDF @RegresionSaludAlDia
  Scenario: Validar flujo paciente ingresa a su cuenta registrando sus mediciones exitosamente y obtiene su reporte PDF
    Given que el usuario navega a "https://front-salud-al-dia-production.up.railway.app/"
    And ingreso con mis credenciales al portal privado paciente
    And deberia ver el panel de control del paciente
    When registro una nueva toma de datos
    And valido que la toma de datos se haya registrado correctamente
    Then valido descarga de archivo PDF con mi historial

  @Registro @RegresionSaludAlDia
  Scenario: Validar registro de nuevo usuario paciente y completado de ficha médica
    Given que el usuario navega a "https://front-salud-al-dia-production.up.railway.app/"
    When completo registro nuevo usuario
    And completo ficha medica de usuario paciente
    Then deberia ver el panel de control del paciente

  @Admin @RegresionSaludAlDia
  Scenario: Valdiar acceso a panel de administrador y listado de pacientes
    Given que el usuario navega a "https://front-salud-al-dia-production.up.railway.app/"
    And ingreso con mis credenciales de administrador al portal privado paciente
    When valido que accede al panel de control de administrador
    And valido que el administrador tenga acceso a agregar un especialista
    Then valido que el administrador tenga acceso a la lista de usuarios registrados

  @Especialista @RegresionSaludAlDia
  Scenario: Validar acceso a panel de especialista y validar estado de pacientes asignados
    Given que el usuario navega a "https://front-salud-al-dia-production.up.railway.app/"
    And ingreso con mis credenciales de especialista al portal privado paciente
    When valido que el especialista tenga acceso al panel de pacientes asignados
    Then valido que al hacer click en ver ficha medica de un paciente se despliegue la informacion correctamente