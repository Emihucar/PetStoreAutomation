package com.everis.base;

import com.everis.base.models.Order;
import static io.restassured.RestAssured.given;

public class PetStoreStep {

    private String URL_BASE = "https://petstore.swagger.io/v2";
    private int codigoRespuesta;
    private Order respuestaOrder;

    // Método para crear una orden (POST)
    public void crearOrden(int id, int petId, int quantity) {
        Order nuevaOrden = new Order(id, petId, quantity);

        codigoRespuesta = given()
                .baseUri(URL_BASE)
                .contentType("application/json")
                .body(nuevaOrden)
                .when()
                .post("/store/order")
                .then()
                .statusCode(200) // Código de estado esperado para creación exitosa
                .extract()
                .statusCode();

        // Guardar la orden creada para validación
        respuestaOrder = given()
                .baseUri(URL_BASE)
                .when()
                .get("/store/order/" + id)
                .as(Order.class);
    }

    // Método para validar el código de respuesta
    public void validarCodigoRespuesta(int codigoEsperado) {
        if (codigoRespuesta != codigoEsperado) {
            throw new AssertionError("Código esperado: " + codigoEsperado + ", Código obtenido: " + codigoRespuesta);
        }
    }

    // Método para obtener la orden creada (GET)
    public void obtenerOrdenPorId(int id) {
        respuestaOrder = given()
                .baseUri(URL_BASE)
                .when()
                .get("/store/order/" + id)
                .then()
                .statusCode(200) // Validación del código de respuesta esperado
                .extract()
                .as(Order.class);
    }

    // Obtener la respuesta de la orden para validaciones posteriores
    public Order obtenerRespuestaOrder() {
        return respuestaOrder;
    }
}
