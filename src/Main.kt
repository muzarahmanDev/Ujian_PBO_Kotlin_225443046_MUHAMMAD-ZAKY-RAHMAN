fun main() {
    // 1. Inisialisasi EkspedisiManager
    val manager = EkspedisiManager()

    // 2. Buat objek paket (minimal 4 paket sesuai spesifikasi)
    val paket1 = PaketReguler("REG001", "Andi", "Budi", 2.0)
    val paket2 = PaketReguler("REG002", "Citra", "Dewi", 1.5)
    val paket3 = PaketEkspres("EKS001", "Eko", "Fani", 3.0, 15000.0)
    val paket4 = PaketFragile("FRG001", "Gita", "Hadi", 2.5, 25000.0)

    // Masukkan paket ke dalam manajer
    println("=== PROSES PENERIMAAN PAKET ===")
    manager.terimaPaket(paket1)
    manager.terimaPaket(paket2)
    manager.terimaPaket(paket3)
    manager.terimaPaket(paket4)

    // 3. Ubah status paket-paket tersebut
    paket1.updateStatus(StatusPengiriman.DalamPerjalanan("Rudi"))
    paket3.updateStatus(StatusPengiriman.Terkirim("Fani", "14:30 WIB"))
    paket4.updateStatus(StatusPengiriman.Gagal("Alamat penerima tidak ditemukan/kosong"))

    // 4. Tampilkan semua data paket
    manager.tampilkanSemuaPaket()

    // 5. Uji fitur Lacak Paket & Smart Casting
    println("\n========================================")
    println("         PENGUJIAN LACAK PAKET          ")
    manager.lacakPaket("EKS001")
    manager.lacakPaket("FRG001")
    manager.lacakPaket("REG001")

    // 6. Tampilkan Total Pendapatan
    println("\n========================================")
    val totalPendapatan = manager.hitungTotalPendapatan()
    println("TOTAL PENDAPATAN EKSPEDISI: Rp $totalPendapatan")
    println("========================================")
}
