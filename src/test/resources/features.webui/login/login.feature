# new feature
# Tags: optional

Feature: Yo como usuario quiero ingresar a la página con mi usuario y contraseña.

  Background:
    Given El empleado ingresa a la página principal donde se le solicita usuario y contraseña

  Scenario: Inicio de sesión exitoso
    When El empleado introduce en el campo usuario el usuario correcto y el campo password la contraseña correcta y dará clic en el botón login
    Then El sistema le dará acceso y lo llevara al home de la página.

    Scenario: Inicio  de sesión donde el password es inválido
      When  El empleado introduce en el campo usuario un usuario valido y en el campo de password introduce una contraseña incorrecta y dará clic en el botón login
      Then El sistema mostrara un mensaje de error y no podra ingresar

  Scenario: Inicio  de sesión donde el usuario es inválido
    When  El empleado introduce en el campo usuario un usuario no valido y en el campo de password introduce una contraseña valida y dará clic en el botón login
    Then El sistema mostrara un mensaje de error y no podra ingresar

  Scenario: Inicio  de sesión donde no se introducen credenciales
    When  El empleado no introduce ningun usuario y tampoco un password y esta da clic en el botón login
    Then El sistema mostrara un mensaje de error y no podra ingresar