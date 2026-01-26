Feature: Pruebas de funcionalidad del portal privado paciente de Salud Al Día

  @smoke
  Scenario: Paciente ingresa a su cuenta registrando sus mediciones exitosamente y obtiene su reporte PDF
    Given que el usuario navega a "https://front-salud-al-dia-production.up.railway.app/"
    And ingreso con mis credenciales al portal privado paciente
    And deberia ver el panel de control del paciente
    When registro una nueva toma de datos
    And valido que la toma de datos se haya registrado correctamente
    Then valido descarga de archivo PDF con mi historial

    @Registro
    Scenario: Paciente ingresa a su cuenta registrando sus mediciones exitosamente y obtiene su reporte PDF
      Given que el usuario navega a "https://front-salud-al-dia-production.up.railway.app/"
      When completo registro nuevo usuario
      And completo ficha medica de usuario paciente
      Then deberia ver el panel de control del paciente


