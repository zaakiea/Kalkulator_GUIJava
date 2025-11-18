# Kalkulator GUI Java (Modern Design)

Repositori ini berisi *source code* aplikasi Kalkulator sederhana dengan antarmuka pengguna grafis (GUI) yang modern. Aplikasi ini dibangun menggunakan bahasa pemrograman **Java** dan library **Swing**.

Proyek ini dibuat untuk memenuhi tugas mata kuliah Pemrograman Berorientasi Objek (PBO) / Pemrograman Java.

## 👥 Anggota Kelompok

| No | Nama Anggota | NIM | Kelas |
| :---: | :--- | :---: | :---: |
| 1 | **Bimo Kusumo Putro Wicaksono** | 21120123120029 | C |
| 2 | **Dzaki Eka Atmaja** | 21120123130068 | C |
| 3 | **Redista Rakha Izza** | 21120123130085 | C |
| 4 | **Adnan** | 21120123130079 | C |
---

## ✨ Fitur Aplikasi

Aplikasi kalkulator ini dirancang dengan tampilan yang bersih (tema terang) dan fungsionalitas yang mirip dengan kalkulator pada *smartphone* modern.

* **Operasi Dasar:** Penjumlahan (+), Pengurangan (-), Perkalian (×), Pembagian (÷), dan Modulo (%).
* **Desain Modern:** Menggunakan tombol berbentuk bulat (*Rounded Buttons*) dan tata letak yang responsif.
* **Riwayat Perhitungan:** Menampilkan proses perhitungan (history) kecil di atas angka utama (contoh: `7 x 7 =`).
* **Input Desimal:** Mendukung angka berkoma (otomatis konversi format `,` menjadi `.`).
* **Fitur Koreksi:**
    * `AC` (All Clear): Menghapus semua input dan mereset kalkulator.
    * `⌫` (Backspace): Menghapus satu digit terakhir.

## 🛠️ Teknologi yang Digunakan

* **Bahasa:** Java (JDK 8 atau lebih baru)
* **GUI Toolkit:** Java Swing (JFrame, JPanel, JButton, JTextField)
* **IDE:** NetBeans (Dapat juga dijalankan di IntelliJ IDEA atau Eclipse)
* **Konsep PBO:** Inheritance (Pewarisan `JFrame`, `JButton`), Encapsulation, dan Polymorphism.

## 🚀 Cara Menjalankan (Run)

### Menggunakan NetBeans IDE
1.  Pastikan **NetBeans** dan **JDK** sudah terinstal di komputer Anda.
2.  *Clone* repositori ini atau unduh sebagai ZIP.
    ```bash
    git clone [https://github.com/username-anda/nama-repo.git](https://github.com/username-anda/nama-repo.git)
    ```
3.  Buka NetBeans, pilih **File > Open Project**.
4.  Arahkan ke folder proyek yang baru saja diunduh.
5.  Klik kanan pada nama proyek, lalu pilih **Run** (atau tekan `F6`).

### Menggunakan Terminal / Command Line
1.  Masuk ke direktori `src`.
2.  Compile file Java:
    ```bash
    javac Calculator/CalculatorGUI.java
    ```
3.  Jalankan aplikasi:
    ```bash
    java Calculator.CalculatorGUI
    ```
