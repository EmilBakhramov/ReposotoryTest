import java.time.LocalDate
import java.time.format.DateTimeParseException

// Liste "Angebote"
// var auswahl: Produkt? = artikelAuswaehlen()
var angebote = mutableListOf(
    Smartphones("Xiaomi Poco X4    ", 289, 256),
    Smartphones("Galaxy Note 7     ", 500, 500),
    Smartwatches("appleWhatch 20 pro    ", 1300, 256,),
    Smartwatches("Samsung 20 pro    ", 1300, 256,),
    InternetVertraege("Giga Zuhause200   ", 25, 47834725, 200),
    Smartphones("iPhone 12 pro     ", 1200, 256,),
    InternetVertraege("Internet DSL100  ", 25, 3483948, 100),
    Versicherungen("KOMPLETT-SCHUTZ ", 10, 2, 29839)
)
var kundeDef: Kunde = Kunde("Max", LocalDate.now(), "Musterstr.  2", "098722", "xxxxx", "1234")
var kundenListe: MutableList<Kunde> = mutableListOf(kundeDef)




/**
 * Neues Konto hinzufügen
 */
fun neuenKundeErstellen(): MutableList<Kunde> {
    var q = true
    while (q) {
        println("Neues Kundenaccount anlegen...")
        Thread.sleep(800)
        println("Bitte geben Sie Ihre vollständigen Daten ein ('q' -> Beenden):")
        println("Name:")
        try {
            var eingabeName = readln()

            if (eingabeName == "q") {
                break
            }

            println("Geburtsgatum tt.mm.jjjj:")
            var geburtsDatumEingabe: LocalDate? = null

            while (geburtsDatumEingabe == null) {
                try {
                    val eingabe = readLine()
                    geburtsDatumEingabe = LocalDate.parse(eingabe, java.time.format.DateTimeFormatter.ofPattern("dd.MM.yyyy"))
                } catch (e: DateTimeParseException) {
                    println("Ungültiges Format! Bitte geben Sie das Geburtsdatum im Format 'tt.mm.jjjj' ein:")
                }
            }
            // Überprüfen, ob Kunde bereits existiert
            var kundeExistiert = false

            for (kunde in kundenListe) {


                if (kunde.name == eingabeName && kunde.geburtsDatum == geburtsDatumEingabe) {
                    try {
                        kundeExistiert = true

                    }catch (e: IllegalAccessError){
                            println("Konto existiert bereits! -> LogIn -> Eingabe '2'")
                        }
                    println("Kunde mit diesem Namen bereits vorhanden!")
                    break
                    //hauptmenu()
                }

            }

            if (kundeExistiert) {
                continue
            }

            println(" Straße + HausNr.")
            var strassehNr = readLine()

            println("Postleitzahl: ")
            var plz = readLine()

            println("Ort: ")
            var ort = readLine()

            println("Passwort: ")
            var passwort = readLine()

            println("Passwort Wiederholen: ")
            try {

            var passwortCheck = readLine()
            if (passwort != passwortCheck){
                throw Exception("Keine Übereinstimmung!")
            }


                }catch (ex: java.lang.Exception) {
                    println("Passwörter stimmen nicht überein")
                    continue
                }

            var neuerKunde =
                Kunde(eingabeName!!, geburtsDatumEingabe!!, strassehNr!!, plz!!, ort!!, passwort!!)

            kundenListe.add(neuerKunde)



        } catch (e: Exception) {
            println("Fehlerhafte Eingabe: ${e.message}")

        }
        println("Kunde wurde erfolgreich erstellt.")
        q = false
        hauptmenu()
    }


    return kundenListe
}



fun logIn() {
    try {
        print("Benutzername: ")
        var username = readLine()!!

        print("Passwort: ")
        var password = readLine()!!

        for (kunden in kundenListe ) {
            if (kunden.name == username && kunden.passwort ==password) {
                println("Login erfolgreich.")
                println("Willkommen ${kunden.name}")
                logInBereich()

            }
         else {
            println("Benutzername oder Passwort falsch.")
        }
        }

    } catch (e: Exception) {
        println("Fehlerhafte Eingabe: ${e.message}")
    }
}

fun logInBereich() {
    var meineKaufe: MutableList<Produkt> = mutableListOf()
    println(
        """
                0 -> Meine Daten                                    ${kundeDef.name} Eingeloggt:  'q'->Logout
                1 -> Mein Warenkorb
                2 -> Meine Käufe
                3 -> Meine Verträge
                4 -> Angebote
                5 -> Sortiment & Tariefe
            """.trimIndent()
    )
    var eingabe = readln()

    if (eingabe == "0"){
    println("$kundenListe ")
    }
    if (eingabe == "1") {
        //Funktionsaufruf
        //var korb = Warenkorb()

        logInBereich()
    } else if (eingabe == "2") {
        meineKaufe = mutableListOf()

        logInBereich()
    } else if (eingabe == "3") {

        logInBereich()
    } else if (eingabe == "4") {
        test()
        logInBereich()
    } else if (eingabe == "q"){
        logOut()
        hauptmenu()
    }
}

fun logOut() {
    println("Sie wurden ausgeloggt.")
    hauptmenu()
}


 fun produkteSortiert(){
   // for (items in angebote){
      //  items.produktListe.subList(2, 4)
      //  items.produktListe.subList(4,6)
        angebote.sortBy { it.produktName }

        val kategorien = angebote.groupBy { it.javaClass.simpleName }
        var i = 0
        for (kategorie in kategorien) {
            println(kategorie.key)
            for (element in kategorie.value) {
                i++
                println("["+"${i}}"+"]->" +" ${element.produktName}")
            }
        }
    }


fun angeboteAufruf() {

    println("TOP-ANGEBOTE DIESER WOCHE")

        var rabatt = 10
        var faktor = (100 - rabatt)
    var i = 0
    for (produkte in angebote) {
        i++
        var sonderpreis = produkte.produktPreis * faktor / 100

        println("["+"$i"+"]->" +"   ${produkte.produktName}        statt      ${produkte.produktPreis}       für nur $sonderpreis €!")
    }
    }


fun hauptmenu() {

    var addListe: MutableList<String> = mutableListOf("NEU!!! EXKLUSIVANGEBOT! iPhone23s für nur 1999.00€ nur heute",
                                                        "NEU!!! EXKLUSIVANGEBOT! LTE 140 GB für nur 19.99€ Mntl. nur heute\"",)
    var add = addListe.random()
    println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")
    println("$add")
    println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")

    println(""" Hauptmenü:
                1 -> Login
                2 -> Neuen Kundenaccount anlegen
                3 -> Kategorien
                4 -> Angebote
                5 -> Produkt gleich Wählen
            """.trimIndent()
    )
    var eingabe = readln()
    if (eingabe == "1") {
        //Funktionsaufruf
        logIn()
        hauptmenu()
    } else if (eingabe == "2") {
        neuenKundeErstellen()
        hauptmenu()
    } else if (eingabe == "3") {
    produkteSortiert()
        artikelAuswaehlen()
    } else if (eingabe == "4") {
        angeboteAufruf()
        artikelAuswaehlen()
    } else if (eingabe == "5") {
        println("Geben Sie Ihre auswahl ein:")
        artikelAuswaehlen()
    } else {
        angebote
        hauptmenu()
    }
}

     fun artikelAuswaehlen(): MutableList<Produkt >? {
        println("Bitte geben Sie die Nummer des Artikels ein, (oder 'q' zum Beenden):")
        val eingabe = readLine()

        if (eingabe == "q") {
            return null
        }

        val index = eingabe?.toIntOrNull()

        if (index != null && index in 0 until angebote.size) {
println("")
            return angebote[index].produktListe
        }


        println("Ungültige Eingabe. Bitte versuchen Sie es erneut.")
        return artikelAuswaehlen()
    }
/*

*/




