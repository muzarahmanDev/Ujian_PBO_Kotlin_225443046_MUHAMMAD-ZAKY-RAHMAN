sealed class StatusPengiriman {
    // Objek tunggal karena tidak membutuhkan properti/data tambahan
    object MenungguDiproses : StatusPengiriman()

    // Data class karena perlu menyimpan informasi kurir
    data class DalamPerjalanan(val namaKurir: String) : StatusPengiriman()

    // Data class karena perlu menyimpan penerima dan waktu
    data class Terkirim(val namaPenerima: String, val waktuSelesai: String) : StatusPengiriman()

    // Data class karena perlu menyimpan alasan kegagalan
    data class Gagal(val alasan: String) : StatusPengiriman()
}
