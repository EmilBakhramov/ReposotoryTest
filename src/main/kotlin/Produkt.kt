open class Produkt( var produktName: String,  var produktPreis: Int) {
    fun printTest() {
        println(produktName)
    }

    open var produktListe: MutableList<Produkt> = mutableListOf()

    open fun produkteAnzeige() {
        for (produkte in produktListe) {
            //produktListe.add(produkte)


            println("$produktName, Preis: $produktPreis")
        }

    }

}




