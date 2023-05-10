
open class kundenAccount {
    private val accountRegister: MutableMap<String, MutableMap<String, Double>> = mutableMapOf()
    private val userRegister: MutableMap<String, String> = mutableMapOf()

    open fun neuenKundeErstellen() {
        try {
            print("Name: ")
            val name = readLine()!!

            print("Geburtsdatum: ")
            val geburtsDatum = readLine()!!

            print("Straße und Hausnummer: ")
            val strassehNr = readLine()!!

            print("PLZ: ")
            val plz = readLine()!!

            print("Ort: ")
            val ort = readLine()!!

            print("Passwort: ")
            val passwort = readLine()!!

            val kunde = Kunde(name, geburtsDatum, strassehNr, plz, ort, passwort)
            accountRegister[kunde.name] = mutableMapOf()
            userRegister[kunde.name] = kunde.passwort
            println("Kunde wurde erfolgreich erstellt.")
        } catch (e: Exception) {
            println("Fehlerhafte Eingabe: ${e.message}")
        }
    }

    fun logIn() {
        try {
            print("Benutzername: ")
            val username = readLine()!!

            print("Passwort: ")
            val password = readLine()!!

            if (userRegister.containsKey(username) && userRegister[username] == password) {
                println("Login erfolgreich.")
            } else {
                println("Benutzername oder Passwort falsch.")
            }
        } catch (e: Exception) {
            println("Fehlerhafte Eingabe: ${e.message}")
        }
    }

    fun logOut() {
        println("Logout erfolgreich.")
    }
}
