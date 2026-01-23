Feature: Pruebas de funcionalidad del portal privado paciente de Salud Al Día

  @smoke
  Scenario: Ingreso al portal privado paciente y registro de toma de datos
    Given que el usuario navega a "https://front-salud-al-dia-production.up.railway.app/"
    And ingreso con mis credenciales al portal privado paciente
    And deberia ver el panel de control del paciente
    Then registro una nueva toma de datos


