package mx.blick.training.store.in.memory

import mx.blick.training.store.beans.Product


/**
 * Created by jresendiz on 25/02/17.
 */
@Singleton
class InMemoryDatabase {
    List retrieveInMemoryDatabase(File databaseFromFile) {
        def lines = databaseFromFile.readLines()
        def header = lines[0].split(",")
        lines = lines.subList(1, lines.size() - 1)
        List<Product> productList = []
        lines.each{ row ->
            def partialProduct = new Product()
            row.split(",").eachWithIndex{ value, index ->
                def fieldName = header[index].trim()
                switch (fieldName) {
                    case partialProduct["${fieldName}"] instanceof Integer:
                        partialProduct["${fieldName}"] = Integer.parseInt(value.trim())
                        break;
                    case partialProduct["${fieldName}"] instanceof Date:
                        partialProduct["${fieldName}"] = new Date()
                        break;
                    default:
                        partialProduct["${fieldName}"] = value.trim()
                }
            }
            productList.add(partialProduct)
        }
        return productList
    }
}
