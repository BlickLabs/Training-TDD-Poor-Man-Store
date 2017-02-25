import mx.blick.training.store.IO.FileManagement
import spock.lang.Specification
import java.lang.Void as Should
/**
 * Created by jresendiz on 25/02/17.
 */
class FileManagementTest extends Specification {
    Should "create a file on a defined path"() {
        setup: "Get an instance of the FileManagement Class"
            FileManagement fileManagement = FileManagement.getInstance()
            String path = "./my-database.csv"
            File createdDatabase = null
        when: "FileManagement class method createDatabaseFile is called"
            createdDatabase = fileManagement.createDatabaseFile(path)
        then:"Expect the file to be created"
            createdDatabase != null
            createdDatabase.getPath() =~ "my-database.csv"
        cleanup: "At the end, delete the file created"
            createdDatabase.delete()
    }

}
