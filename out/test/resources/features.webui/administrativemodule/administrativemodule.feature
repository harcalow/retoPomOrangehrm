Feature: Yo como usuario cuando ingrese a la página deseo ir a usuarios y buscar por status.
  Scenario: Buscar usuarios del sistema mediante el Status
    Given El empleado ingresa a la página principal donde se le solicita usuario y contraseña este los ingresa luego de esto ira a Admin luego a User management y users
    When El empleado seleccionara status y ecogera la opción deseada y finalizara dando clic en Search donde se hará la búsqueda
    Then Se buscaran los usuarios dependiendo su status
