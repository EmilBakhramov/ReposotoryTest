open class Elektrogerat(
    geraeteName: String,
    geraetePreis: Int,
    var speicher: Int,
    var imeiNumm: Long) : Produkt(geraeteName, geraetePreis) {

    override fun produkteAnzeige(){
        println("$produktName, Preis: $produktPreis, Speicher: $speicher, imei-Nr. $imeiNumm ")
    }

}