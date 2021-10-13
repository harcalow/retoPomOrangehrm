# new feature
# Tags: optional

Feature: Yo como usuario quiero ingresar a la página con mi usuario y contraseña.

  Scenario: Inicio de sesión exitoso
    Given El empleado ingresa a la página principal donde solicita usuario y contraseña
    When El empleado introduce en el campo usuario el usuario correcto y el campo password la contraseña correcta y dará clic en el botón login
    Then El sistema le dará acceso y lo llevara al home de la página.
