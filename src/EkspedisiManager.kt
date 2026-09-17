class EkspedisiManager {
    // MutableList dengan tipe referensi polimorfik Paket
    private val daftarPaket: MutableList<Paket> = mutableListOf()

    // Menambahkan paket ke list
    fun terimaPaket(paket: Paket) {
        daftarPaket.add(paket)
        println("Paket dengan resi ${paket.nomorResi} berhasil ditambahkan.")
    }

    // Mencari paket berdasarkan resi dan menggunakan Smart Casting
    fun lacakPaket(resi: String) {
        val paket = daftarPaket.find { it.nomorResi == resi }

        if (paket != null) {
            println("\n--- HASIL LACAK PAKET [$resi] ---")
            paket.tampilkanInfo()

            // Penerapan Smart Casting menggunakan 'is'
            when (paket) {
                is PaketEkspres -> {
                    // Setelah dicek dengan 'is PaketEkspres', variabel 'paket' otomatis
                    // dikonversi (smart-cast) sehingga kita bisa akses properti biayaAsuransi
                    println("[Catatan Khusus Ekspres] Termasuk biaya asuransi: Rp ${paket.biayaAsuransi}")
                }
                is PaketFragile -> {
                    // Otomatis di-cast ke PaketFragile
                    println("[Catatan Khusus Fragile] Termasuk biaya packing kayu: Rp ${paket.biayaPackingKayu}")
                }
                else -> {
                    println("[Catatan Khusus] Paket Layanan Reguler Standard.")
                }
            }
        } else {
            println("\nPaket dengan resi $resi tidak ditemukan!")
        }
    }

    // Menampilkan seluruh isi daftar paket
    fun tampilkanSemuaPaket() {
        println("\n========================================")
        println("         DAFTAR SELURUH PAKET           ")
        if (daftarPaket.isEmpty()) {
            println("Belum ada data paket.")
            return
        }
        for (paket in daftarPaket) {
            paket.tampilkanInfo()
        }
    }

    // Mengakumulasikan biaya dari seluruh objek Paket
    fun hitungTotalPendapatan(): Double {
        return daftarPaket.sumOf { it.hitungBiaya() }
    }
}
