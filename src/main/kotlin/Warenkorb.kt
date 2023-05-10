// Klasse für den Warenkorb
open class Warenkorb {
    private val items = mutableListOf<Produkt>()

    fun artikelHinzufuegen(item: Produkt) {
        items.add(item)
    }

    fun artikelLoeschen(item: Produkt) {
        items.remove(item)
    }

    fun zwischenSumme(): Double {
        var summe = 0.0
        for (item in items) {
            summe += item.produktPreis
        }
        return summe
    }

    open fun warenKorbAnzeigen() {
        println("Warenkorb:")
        for (item in items) {
            println("${item.produktName} - ${item.produktPreis} €")
        }
        println("Gesamt: ${zwischenSumme()} € zur Bestellung -> j")
        var input = readln()

        if (input == "j"){
            kaufAbschließen()
        }
    }

    open fun kaufAbschließen(){
        for (item in items) {
            println("${item.produktName} - ${item.produktPreis} €")
        }
        println("Gesamt: ${zwischenSumme()} €")
        println("Zur Bestellung: 'j'")
        var bestaetigung = readln()
        if ( bestaetigung == "j") {
            println("Preisübersicht: ${zwischenSumme()} €")
            println("Kauf Abschließen:")
            for (item in items) {
                println("${item.produktName} - ${item.produktPreis} €")

            }
        }else{
            warenKorbAnzeigen()
        }
            println("[ ]* AGB Bestätigung -> 'j'")
            bestaetigung = readln()
            if (bestaetigung == "j") {
                println("[X]* AGB Bestätigung")
                println(
                    """
                    
                    [ kaufen ] -> 'j'
                """.trimIndent()
                )
                bestaetigung = readln()
                if (bestaetigung == "j") {
                    println("Vielen Dank für den Kauf!")
                    println("Sie bekommen eine Bestellbestätigung sowie die rechnung per Email zugesandt!")

                }


            } else {
                warenKorbAnzeigen()
            }
            meineWeltAnsicht()



    }
}




