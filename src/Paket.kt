open class Paket (
    val nomorResi: String,
    val pengirim: String,
    val penerima: String,
    val beratKg: Double,
){
    var status: StatusPengiriman = StatusPengiriman.MenungguDiproses
        private set

    open fun hitungBiaya(): Double {
        return beratKg * 10000.0
    }

    open fun updateStatus(statusBaru: StatusPengiriman) {
        this.status = statusBaru
    }

    open fun tampilkanInfo(){
        println("============================")
        println("Nomor Resi : $nomorResi")
        println("Pengirim   : $pengirim")
        println("Penerima   : $penerima")
        println("Berat      : $beratKg kg")


        val teksStatus = when (val s = status) {
            is StatusPengiriman.MenungguDiproses -> "Menunggu Diproses"
            is StatusPengiriman.DalamPerjalanan -> "Dalam Perjalanan (Kurir: ${s.namaKurir})"
            is StatusPengiriman.Terkirim -> "Terkirim ke ${s.namaPenerima} pada ${s.waktuSelesai}"
            is StatusPengiriman.Gagal -> "Gagal Ditransfer (Alasan: ${s.alasan})"
        }
        println("Status     : $teksStatus")
        println("Biaya      : Rp ${hitungBiaya()}")

        println("Status     : $teksStatus")
        println("Biaya      : Rp ${hitungBiaya()}")

    }
}