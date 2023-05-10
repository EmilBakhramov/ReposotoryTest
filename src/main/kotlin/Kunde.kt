data class Kunde(var name: String,
                  var geburtsDatum: String,
                  var strassehNr: String,
                  var plz: String,
                  var ort: String,
                  var passwort: String) {
}


    var kundenListe: MutableList<Kunde> = mutableListOf()

    private val accountRegister: MutableMap<String, MutableMap<String, Double>> = mutableMapOf()
    private val userRegister: MutableMap<String, String> = mutableMapOf() // Benutzername -> Passwort

    // Map Kunden
    // val kundenLoginMap: MutableMap<String, String> = mutableMapOf(
    //     "Max Muster" to "Max1000",
    //     "Moritz Müller" to "Moritz2002",)

    /**
     * Neues Konto hinzufügen
     */
    fun neuenKundeErstellen(): MutableList<Kunde> {
        var q = true
        while (q) {
            println("Sie möchten ein neues Kundenaccount anlegen...")
            Thread.sleep(800)
            println("Bitte geben Sie Ihre vollständigen Daten ein ('q' -> Beenden):")
            println("Name:")
            try {
                var eingabeName = readln()

                if (eingabeName == "q") {
                    break
                }

                println("Geburtsgatum tt.mm.jjjj:")
                var geburtsDatumEingabe = readln()

                // Überprüfen, ob Kunde bereits existiert
                var kundeExistiert = false

                for (kunde in kundenListe) {
                    if (kunde.name == eingabeName && kunde.geburtsDatum == geburtsDatumEingabe) {
                        kundeExistiert = true
                        println("Kunde mit diesem Namen bereits vorhanden!")
                        break
                        hauptmenu()
                    }

                }

                if (kundeExistiert) {
                    continue
                }

                println(" Straße + HausNr.")
                var strassehNr = readLine()

                print("Postleitzahl: ")
                var plz = readLine()

                print("Ort: ")
                var ort = readLine()

                print("Passwort: ")
                var passwort = readLine()


                var neuerKunde =
                    Kunde(eingabeName!!, geburtsDatumEingabe!!, strassehNr!!, plz!!, ort!!, passwort!!)

                kundenListe.add(neuerKunde)


                accountRegister[neuerKunde.name] = mutableMapOf()
                userRegister[neuerKunde.name] = neuerKunde.passwort
            } catch (e: Exception) {
            println("Fehlerhafte Eingabe: ${e.message}")

        }
                println("Kunde wurde erfolgreich erstellt.")
                q = false
                hauptmenu()
            }


        return kundenListe
    }





                    /*

                throw Exception("Es exestiert bereits Ein Konto mit diesem Namen")
                neuenKundeErstellen()

            }catch (ex: Exception) {
                println(ex.message)
                hauptmenu()
            }*/

    fun logIn() {
        try {
            print("Benutzername: ")
            var username = readLine()!!

            print("Passwort: ")
            var password = readLine()!!

            if (userRegister.containsKey(username) && userRegister[username] == password) {
                println("Login erfolgreich.")
                println("Willkommen ${accountRegister}")
                meineWeltAnsicht()

            } else {
                println("Benutzername oder Passwort falsch.")
            }

        } catch (e: Exception) {
            println("Fehlerhafte Eingabe: ${e.message}")
        }
    }

fun meineWeltAnsicht() {
    var meineKaufe: MutableList<Produkt> = mutableListOf()
    println(
        """
                                                    ${accountRegister} Eingeloggt:  'q'->Logout
                1 -> Mein Warenkorb
                2 -> Meine Käufe
                3 -> Meine Verträge
                4 -> Angebote
            """.trimIndent()
    )
    var eingabe = readln()
    if (eingabe == "1") {
        //Funktionsaufruf
        var korb = Warenkorb()
        korb.warenKorbAnzeigen()
        meineWeltAnsicht()
    } else if (eingabe == "2") {
        meineKaufe = mutableListOf()

        meineWeltAnsicht()
    } else if (eingabe == "3") {

        meineWeltAnsicht()
    } else if (eingabe == "4") {
        test()
        meineWeltAnsicht()
    } else if (eingabe == "q"){
        logOut()
        meineWeltAnsicht()
    }
}

    fun logOut() {
        println("Sie wurden ausgeloggt.")
        hauptmenu()
    }


    fun hauptmenu() {

            println(
                        """
                +++++++++++++++++++++++++++++++++++++++++++++++++++
                NEU!!! EXKLUSIVANGEBOT! iPhone23s für nur 1999.00€ nur heute
                +++++++++++++++++++++++++++++++++++++++++++++++++++
                
                Hauptmenü:
                1 -> Login
                2 -> Neuen Kundenaccount anlegen
                3 -> Kategorien
                4 -> Angebote
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

                hauptmenu()
            } else if (eingabe == "4") {

                hauptmenu()
            } else {
                kundenListe
                hauptmenu()
            }
        }







