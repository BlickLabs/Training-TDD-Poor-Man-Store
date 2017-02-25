import mx.blick.training.store.beans.Product
import spock.lang.Specification
import java.lang.Void as Should

/**
 * Created by jresendiz on 25/02/17.
 */
class CreateProductTest extends Specification {
    def setup() {
        println "Before Class"
    }

    def cleanup() {
        println "after Class"
    }

    Should "create a product"() {
        setup: // lo que necesito para crear un producto
        def parametros = [
                uniqueId:"1",
                name: "Refregco del Ale",
                quantity: 2,
                creationDate: new Date(),
                storeName: "La tienda del Ale en Coatepec"
        ]
        when: // Accion (carnita/core)
        //
        Product newProduct = new Product()
        newProduct.uniqueId = parametros.uniqueId
        newProduct.name = parametros.name
        newProduct.quantity = parametros.quantity
        newProduct.creationDate = parametros.creationDate
        newProduct.storeName = parametros.storeName

        then: // resultados esperados.
        newProduct != null
        parametros == newProduct.properties.findAll{ it.key != "class"}
    }
}