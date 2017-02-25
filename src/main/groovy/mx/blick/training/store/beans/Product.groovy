package mx.blick.training.store.beans


/**
 * Created by jresendiz on 25/02/17.
 */
//import groovy.transform.Canonical
//import groovy.transform.ToString
//@ToString(includePackage = false)
//@Canonical(includes = "uniqueId, name")
class Product {
    String uniqueId
    String name
    Integer quantity
    String storeName
    Date creationDate

    String getCSVString(List header) { //uniqueId, algo
        List columns = []
        header.each { value ->
            if(this["$value"] instanceof String) {
                columns.add("\"${this["$value"]}\"")
            } else {
                columns.add(this["$value"])
            }
        }
        return columns.join(", ")
    }
}
