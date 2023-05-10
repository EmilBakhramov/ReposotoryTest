fun test(){
    var note7: Produkt = Produkt("Note 7", 500)
    note7.produkteAnzeige()

    var xiaomi: Produkt = Produkt("Xiaomi Poco X4", 289)

    var produktListe: MutableList<Produkt> = mutableListOf(note7, xiaomi)

    var iPhone12: Elektrogerat = Elektrogerat("I-Phone 12 pro", 1300, 256, 789877789909876)
    produktListe.add(iPhone12)
    //neuenKundeErstellen()

    var testVertrag: Vertrage = Vertrage("Giga Zuhause DSL100", 25, 47834725)
    produktListe.add(testVertrag)



    // Erstelle ein paar Produkte
    val iphone12pro = Elektrogerat("I-Phone 12 pro", 1300, 256, 7688987778807906 )
    val dsl100 = InternetVertraege("Internet DSL100", 25, 3483948, 100)
    val handyVersicherung = Versicherungen("KOMPLETT-SCHUTZ", 10, 2, 29839)

    for (produkte in produktListe){
        produkte.produkteAnzeige()
    }

    // Erstelle einen Warenkorb und füge Produkte hinzu
    val korb = Warenkorb()

    korb.artikelHinzufuegen(iphone12pro)
    korb.artikelHinzufuegen(dsl100)
    korb.artikelHinzufuegen(handyVersicherung)

    // Gib den Warenkorb aus
    korb.warenKorbAnzeigen()

    // Entferne ein Produkt und gib den aktualisierten Warenkorb aus
    korb.artikelLoeschen(handyVersicherung)
    korb.warenKorbAnzeigen()
}

    //var kunde1: Kunde = Kunde("Maxi Bauer", "12.08.1987", "Musterstr. 2", "08736", "Testort", "0000" )
   // var neuerKunde =neuenKundeErstellen()



    //kunde1.vertragZuordnen(testVertrag)
   // kunde1.vertragsliste
