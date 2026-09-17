class PaketFragile(
    nomorResi: String,
    pengirim: String,
    penerima: String,
    beratKg: Double,
    val biayaPackingKayu: Double
) : Paket(nomorResi, pengirim, penerima, beratKg) {

    // Overriding perhitungan biaya sesuai rumus PaketFragile
    override fun hitungBiaya(): Double {
        return (beratKg * 12000.0) + biayaPackingKayu
    }
}
