open class Produkt( var produktName: String,  var produktPreis: Int) {
    fun printTest() {
        println(produktName)
    }

    open fun produkteAnzeige() {
        println("$produktName, Preis: $produktPreis")
    }

}




