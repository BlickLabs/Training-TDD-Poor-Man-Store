package mx.blick.training.store.IO

/**
 * Created by jresendiz on 25/02/17.
 */
@Singleton
class FileManagement {
    final String DATABASE_NAME = "database.csv"
    final String PATH = "/home/jresendiz/Desktop/"
    final List CSV_HEADER = ["uniqueId","name", "quantity", "creationDate", "storeName"]
    File createDatabaseFile(String path = "$PATH$DATABASE_NAME", List header = CSV_HEADER) throws Exception {
        def database = new File(path)
        if(!database.exists()) {
            this.createFileAndAddHeader(database, header)
        }
        return database
    }

    File createFileAndAddHeader(File database, List header) {
        database.createNewFile()
        database.write(header.join(", ") + "\n")
        return database
    }
}
