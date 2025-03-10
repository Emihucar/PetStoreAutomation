package com.everis.base.stepDefinitions;

import com.everis.base.PetStoreStep;
import com.everis.base.models.Order;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PetStoreSD {

    @Steps
    PetStoreStep petStore;

    @Given("dado que estoy en la página")
    public void dadoQueEstoyEnLaPagina() {
        // Aquí puedes inicializar cualquier dato necesario si es requerido
    }

    @When("creo una orden con id {int}, petId {int}, quantity {int}")
    public void creoUnaOrdenConIdIdPetIdPetIdQuantityQuantity(int id, int petId, int quantity) {
        petStore.crearOrden(id, petId, quantity);
    }

    @Then("el código de estado de la respuesta debe ser {int}")
    public void elCodigoDeEstadoDeLaRespuestaDebeSerCodigo(int codigo) {
        petStore.validarCodigoRespuesta(codigo);
    }

    @And("la respuesta debe contener el id {int}, petId {int}, quantity {int}")
    public void laRespuestaDebeContenerElIdIdPetIdPetIdQuantityQuantity(int id, int petId, int quantity) {
        Order order = petStore.obtenerRespuestaOrder();
        assertNotNull(order);
        assertEquals(id, order.getId());
        assertEquals(petId, order.getPetId());
        assertEquals(quantity, order.getQuantity());
    }

    // Step Definition para obtener una orden por ID (GET)
    @When("obtengo la orden con id {int}")
    public void obtengoLaOrdenConId(int id) {
        petStore.obtenerOrdenPorId(id);
    }

    @Then("la orden obtenida debe tener el id {int}, petId {int}, y quantity {int}")
    public void laOrdenObtenidaDebeTenerElIdPetIdYQuantity(int id, int petId, int quantity) {
        Order order = petStore.obtenerRespuestaOrder();
        assertNotNull(order);
        assertEquals(id, order.getId());
        assertEquals(petId, order.getPetId());
        assertEquals(quantity, order.getQuantity());
    }
}
