import mx.blick.training.store.IO.FileManagement
import mx.blick.training.store.beans.Product
import mx.blick.training.store.in.memory.InMemoryDatabase
import spock.lang.Specification
import java.lang.Void as Should
/**
 * Created by jresendiz on 25/02/17.
 */
class InMemoryDatabaseTest extends Specification{
    File testDatabase;
    def setup() {
        testDatabase = FileManagement.getInstance().createDatabaseFile("./test-database.csv")
        (1..10).each { index ->
            def partialProduct = new Product()
            partialProduct.with { product ->
                uniqueId = "$index"
                name = "Refregco del Ale v.$index"
                creationDate = new Date()
                quantity = index
                storeName = "Tienda del Ale ${index == 5 ? "Matriz: Coatepec" : "Suc: $index" }"
            }
            testDatabase.append(partialProduct.getCSVLine(FileManagement.instance.CSV_HEADER))
        }
    }

    def cleanup() {
        testDatabase.delete()
    }
    Should "get in-memory database from file"(){
        setup: "Read the current database from file"
            println "Database has been read!"
        when:// logica que yo estoy creando
            def inMemoryDatabase = InMemoryDatabase.instance.retrieveInMemoryDatabase(testDatabase)
        then:
            inMemoryDatabase.each{ product ->
                assert product instanceof Product
            }
    }
}
