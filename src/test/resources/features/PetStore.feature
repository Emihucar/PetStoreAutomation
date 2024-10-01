@EjecutarPrueba
Feature: Gestión de órdenes de la tienda



  @CrearOrden
  Scenario Outline: Crear una nueva orden
    Given dado que estoy en la página
    When creo una orden con id <id>, petId <petId>, quantity <quantity>
    Then el código de estado de la respuesta debe ser <codigo>
    And la respuesta debe contener el id <id>, petId <petId>, quantity <quantity>
    Examples:
      | id  | petId | quantity | codigo |
      | 201 | 2     | 3        | 200    |
      | 202 | 3     | 1        | 200    |
      | 203 | 3     | 1        | 200    |
      | 204 | 3     | 1        | 200    |

  @ConsultarOrden
  Scenario: Consultar una orden existente
    Given dado que estoy en la página
    When obtengo la orden con id 201
    Then la orden obtenida debe tener el id 201, petId 2, y quantity 3
