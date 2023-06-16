import java.time.LocalDate
import kotlin.system.exitProcess

fun main() {

    fun checkMindestalter(alter: Short): Boolean {
        val mindestalter = 12
        return alter >= mindestalter
    }
    println("Bitte Alter eingeben:")
    var alter: Short = readln().toShort()
    if (!checkMindestalter(alter)) {
        // Der Benutzer hat kein Zugang zu den Funktionen des Stores
        println("Zugang berechtigt für personen ab 12 jahren")
        exitProcess(-1)

    } else {
        println("Loading...")
        println("__________________________________________________________________________________________________")
        print("|||||")
        Thread.sleep(1000)
        print("|||||||||")
        Thread.sleep(100)
        print("|")
        Thread.sleep(80)
        print("|")
        Thread.sleep(80)
        print("|")
        Thread.sleep(80)
        print("|")
        Thread.sleep(80)
        print("|")
        Thread.sleep(100)
        print("|")
        Thread.sleep(100)
        print("|")
        Thread.sleep(50)
        print("|")
        Thread.sleep(50)
        print("|")
        Thread.sleep(50)
        print("|")
        Thread.sleep(50)
        print("|")
        Thread.sleep(40)
        print("|")
        Thread.sleep(40)
        print("|")
        Thread.sleep(40)
        print("|")
        Thread.sleep(40)
        print("|")
        Thread.sleep(50)
        print("|")
        Thread.sleep(80)
        print("|")
        Thread.sleep(70)
        print("|")
        Thread.sleep(60)
        print("|")
        Thread.sleep(50)
        print("|")
        Thread.sleep(100)
        print("|")
        Thread.sleep(40)
        print("|")
        Thread.sleep(40)
        print("|")
        Thread.sleep(30)
        print("|")
        Thread.sleep(30)
        print("|")
        Thread.sleep(50)
        print("|")
        Thread.sleep(30)
        print("|")
        Thread.sleep(40)
        print("|")
        Thread.sleep(40)
        print("|")
        Thread.sleep(200)
        print("|||||||||")
        Thread.sleep(500)
        print("|||||||||||||||||")
        Thread.sleep(1000)
        println("|||||||||||||||||||||||||||")
        println()
        println()



        // Der Benutzer hat Zugang zu den Funktionen des Stores
        println("                       Herzlich Willkommen!")
        Thread.sleep(2000)


    }

       test()



    }

