# 🍲 Sistem Pengelolaan Food Redistribution 🍲
Nama: Regina Jelita Ningsih
<br> NIM: 2509116061
<br> Kelas: B (2025)

## 🍽️ Deskripsi Singkat Program
Masalah **surplus makanan** sering terjadi di hotel, restoran, usaha kuliner, dan juga dalam acara pribadi seperti syukuran. Sementara itu, masih banyak individu dan lembaga sosial seperti panti asuhan atau rumah singgah yang membutuhkan makanan. Program **Sistem Pengelolaan Food Redistribution** dibuat agar pihak terkait dalam melakukan pencatatan yang sederhana dan terstruktur.

Sistem ini mengelola empat entitas utama yang saling berkaitan:
1. **Donatur** adalah pihak yang memberikan donasi makanan. Donatur terbagi menjadi dua jenis:
   * **Donatur Individu** adalah perseorangan yang memberikan donasi dari kegiatan pribadi, seperti syukuran, pernikahan, dan lainnya.
   * **Donatur Instansi** adalah badan usaha seperti hotel, restoran, atau usaha kuliner yang secara rutin menyumbangkan makanan.
2. **Donasi** adalah data makanan yang diberikan oleh donatur, meliputi nama makanan, jumlah porsi, dan status kelayakan konsumsi.
3. **Penerima** adalah pihak yang menerima makanan dari proses penyaluran. Penerima juga terbagi menjadi dua jenis:
   * **Penerima Individu** adalah perseorangan yang membutuhkan bantuan makanan, seperti pemulung, pengamen, dan orang lain yang membutuhkan.
   * **Penerima Lembaga** adalah organisasi sosial seperti panti asuhan atau rumah singgah yang menyalurkan makanan kepada para penghuninya.
4. **Penyaluran** adalah data kegiatan penyaluran makanan yang menghubungkan donasi dengan penerima tertentu. Data ini mencakup tanggal penyaluran, jumlah porsi yang disalurkan, dan petugas yang bertanggung jawab.


```
========================================
               MENU ADMIN
========================================
[1] Donatur
[2] Donasi
[3] Penerima
[4] Penyaluran
[5] Kembali
>>
```

## ⭐ Struktur Program 
Program ini disusun dengan kosep **MVC (Model–View–Controller)** yang dimodifikasi menjadi *layered architecture* sederhana. Struktur program ini dibagi ke beberapa *package* supaya setiap bagian punya tugas yang jelas.


| Package | Fungsi | Isi |
|---|---|---|
| `model` | Berisi class yang merepresentasikan data atau objek yang digunakan dalam sistem. Class di dalamnya menyimpan atribut, constructor, getter, setter, dan juga menerapkan konsep OOP seperti inheritance. | `Donatur`, `DonaturIndividu`, `DonaturInstansi`, `Penerima`, `PenerimaIndividu`, `PenerimaLembaga`, `Donasi`, `Penyaluran` |
| `service` | Package ini berisi class yang menangani proses dan logika pengelolaan data. Package ini menjalankan operasi CRUD dan proses lain yang berkaitan dengan data. | `DonaturService`, `DonasiService`, `PenerimaService`, `PenyaluranService`, `PetugasService` |
| `controller` | Package ini mengatur alur penggunaan program dan menentukan proses atau menu yang bisa dijalankan sesuai peran pengguna. Controller menghubungkan pilihan pengguna ke service yang tepat. | `MenuController`, `AdminController`, `PetugasController` |
| `util` | Package ini berisi class yang menyediakan fungsi bantu untuk beberapa bagian program, terutama dalam membaca dan memvalidasi input dari pengguna. | `InputUtil` |
| `main` |Package ini menjadi titik awal program. Di dalamnya terdapat class utama yang menjalankan program dengan membuat MenuController dan memulai alur sistem. | `SistemPengelolaanFoodRedistributionMain.java` |

Secara umum, program dimulai dari package `main`, lalu dilanjutkan ke `controller` yang menentukan menu dan peran pengguna. Setelah pengguna memilih fitur, `controller` memanggil `service` yang sesuai untuk menjalankan proses atau mengelola data. `service` kemudian memakai class dari package `model` sebagai objek data yang dikelola.

Package util berfungsi sebagai pendukung proses input. Fungsi seperti membaca input angka, membaca teks, validasi input, dan menunggu pengguna menekan Enter bisa digunakan kembali oleh bagian program lain yang membutuhkannya.

Dengan pembagian ini, package `model` digunakan untuk mewakili data, `service` bertugas mengelola proses dan logika data, `controller` mengatur jalannya program, `util` berisi fungsi-fungsi pendukung, dan main adalah titik awal untuk menjalankan sistem.

## 🧩 Access Modifier
Program ini menggunakan _access modifier_ untuk menentukan bagian mana dari class yang bisa diakses dari luar. Pada _class model_, atribut dibuat `private` supaya tidak bisa diakses atau diubah langsung oleh class lain.

- **`private`** digunakan pada atribut (*field*), seperti `idDonatur`, `namaDonatur`, `idPenerima`, dan atribut lainnya. Dengan cara ini, data di dalam class tetap aman dan hanya bisa diakses lewat method yang sudah ada.
- **`public`** digunakan pada *constructor* dan method yang perlu dipanggil dari class lain, seperti *getter*, *setter*, dan method `getJenisDonatur()` atau `getJenisPenerima()`.
- **`final`** di pakai pada beberapa atribut ID yang tidak perlu diubah setelah objek dibuat, misalnya `idDonatur` pada class `Donatur`.

Contoh pada class `Donatur`:
```java
public class Donatur {
    private final int idDonatur;
    private String namaDonatur;

    public Donatur(int idDonatur, String namaDonatur) {
        this.idDonatur = idDonatur;
        this.namaDonatur = namaDonatur;
    }

    public int getIdDonatur() {
        return idDonatur;
    }

    public String getNamaDonatur() {
        return namaDonatur;
    }

    public void setNamaDonatur(String namaDonatur) {
        this.namaDonatur = namaDonatur;
    }

    public String getJenisDonatur() {
        return "Donatur";
    }
}
```
Dengan penggunaan `private`, class lain seperti `service` dan `controller` tidak dapat mengakses atribut secara langsung. Untuk membaca data digunakan _getter_, sedangkan perubahan data yang diizinkan dilakukan lewat _setter_. Dengan cara ini, akses terhadap data menjadi lebih terkontrol.

## 📦 Encapsulation 
Program ini menerapkan **encapsulation** dengan menyimpan atribut di dalam class menggunakan access modifier `private`. Dengan cara ini, data tidak dapat diakses atau diubah secara langsung dari luar class. Akses terhadap data dilakukan melalui method seperti *getter* dan *setter* yang disediakan oleh masing-masing class.

Contoh pada class `Donatur`:
```java
public class Donatur {
    private final int idDonatur;
    private String namaDonatur;

    public Donatur(int idDonatur, String namaDonatur) {
        this.idDonatur = idDonatur;
        this.namaDonatur = namaDonatur;
    }

    public int getIdDonatur() {
        return idDonatur;
    }

    public String getNamaDonatur() {
        return namaDonatur;
    }

    public void setNamaDonatur(String namaDonatur) {
        this.namaDonatur = namaDonatur;
    }

    public String getJenisDonatur() {
        return "Donatur";
    }
}

```
Pada contoh tersebut, getIdDonatur() dan getNamaDonatur() digunakan untuk membaca data. Sementara itu, setNamaDonatur() digunakan untuk mengubah namaDonatur. Atribut idDonatur tidak memiliki setter karena ID sudah dibuat final dan tidak perlu diubah setelah objek dibuat.

Konsep yang sama juga diterapkan pada class `Penerima`, `Donasi`, dan `Penyaluran`, termasuk atribut tambahan di setiap subclass. Misalnya, `jenisKegiatan` pada `DonaturIndividu`, `namaInstans` dan `jenisInstansi` pada `DonaturInstansi`, `deskripsiPenerima` pada `PenerimaIndividu`, serta `namaLembaga`, `jenisLembaga`, dan `namaPengelola` pada `PenerimaLembaga`.


## ⭐ Inheritance
### Donatur (Superclass)
Kelas `Donatur` adalah kelas dasar yang menyimpan atribut dan perilaku umum yang dimiliki semua jenis donatur, yaitu `idDonatur` dan `namaDonatur`. Kelas ini juga punya method `getJenisDonatur()` yang akan di-*override* oleh kelas turunannya.

```java
public class Donatur {
    private final int idDonatur;
    private String namaDonatur;

    public Donatur(int idDonatur, String namaDonatur) {
        this.idDonatur = idDonatur;
        this.namaDonatur = namaDonatur;
    }

    public int getIdDonatur() {
        return idDonatur;
    }

    public String getNamaDonatur() {
        return namaDonatur;
    }

    public void setNamaDonatur(String namaDonatur) {
        this.namaDonatur = namaDonatur;
    }

    public String getJenisDonatur() {
        return "Donatur";
    }
}
```

### DonaturIndividu dan DonaturInstansi (Subclass)
Kedua kelas ini menggunakan `extends` agar bisa mewarisi semua atribut dan method dari `Donatur`. Dengan begitu, tidak perlu menulis ulang `idDonatur`, `namaDonatur`, dan *getter-setter*-nya. Setiap *subclass* hanya perlu menambah atribut khusus miliknya sendiri.

```java
public class DonaturIndividu extends Donatur {
    private String jenisKegiatan;

    public DonaturIndividu(int idDonatur, String namaDonatur, String jenisKegiatan) {
        super(idDonatur, namaDonatur);
        this.jenisKegiatan = jenisKegiatan;
    }

    public String getJenisKegiatan() {
        return jenisKegiatan;
    }

    public void setJenisKegiatan(String jenisKegiatan) {
        this.jenisKegiatan = jenisKegiatan;
    }

    @Override
    public String getJenisDonatur() {
        return "Donatur Individu";
    }
}
```

```java
public class DonaturInstansi extends Donatur {
    private String namaInstansi;
    private String jenisInstansi;

    public DonaturInstansi(
            int idDonatur,
            String namaDonatur,
            String namaInstansi,
            String jenisInstansi) {

        super(idDonatur, namaDonatur);
        this.namaInstansi = namaInstansi;
        this.jenisInstansi = jenisInstansi;
    }

    public String getNamaInstansi() {
        return namaInstansi;
    }

    public void setNamaInstansi(String namaInstansi) {
        this.namaInstansi = namaInstansi;
    }

    public String getJenisInstansi() {
        return jenisInstansi;
    }

    public void setJenisInstansi(String jenisInstansi) {
        this.jenisInstansi = jenisInstansi;
    }

    @Override
    public String getJenisDonatur() {
        return "Donatur Instansi";
    }
}
```

### Penerima (Superclass)
Konsep yang sama seperti pada `Donatur` juga digunakan dalam hierarki `Penerima`. Kelas `Penerima` memiliki atribut dasar yang dimiliki oleh semua jenis penerima, yaitu `idPenerima`, serta method `getJenisPenerima()` yang nantinya akan di-*override* oleh *subclass*-nya.

```java
public class Penerima {
    private final int idPenerima;

    public Penerima(int idPenerima) {
        this.idPenerima = idPenerima;
    }

    public int getIdPenerima() {
        return idPenerima;
    }

    public String getJenisPenerima() {
        return "Penerima";
    }
}
```

### PenerimaIndividu dan PenerimaLembaga (Subclass)
Seperti halnya `DonaturIndividu` dan `DonaturInstansi`, kedua kelas ini memakai `extends` untuk mewarisi `idPenerima` dari `Penerima`. Mereka juga memanggil `super(idPenerima)` di *constructor*, lalu menambahkan atribut khusus masing-masing.

```java
public class PenerimaIndividu extends Penerima {
    private String deskripsiPenerima;

    public PenerimaIndividu(int idPenerima, String deskripsiPenerima) {
        super(idPenerima);
        this.deskripsiPenerima = deskripsiPenerima;
    }

    public String getDeskripsiPenerima() {
        return deskripsiPenerima;
    }

    public void setDeskripsiPenerima(String deskripsiPenerima) {
        this.deskripsiPenerima = deskripsiPenerima;
    }

    @Override
    public String getJenisPenerima() {
        return "Individu";
    }
}
```

```java
public class PenerimaLembaga extends Penerima {
    private String namaLembaga;
    private String jenisLembaga;
    private String namaPengelola;

    public PenerimaLembaga(
            int idPenerima,
            String namaLembaga,
            String jenisLembaga,
            String namaPengelola) {

        super(idPenerima);
        this.namaLembaga = namaLembaga;
        this.jenisLembaga = jenisLembaga;
        this.namaPengelola = namaPengelola;
    }

    public String getNamaLembaga() {
        return namaLembaga;
    }

    public void setNamaLembaga(String namaLembaga) {
        this.namaLembaga = namaLembaga;
    }

    public String getJenisLembaga() {
        return jenisLembaga;
    }

    public void setJenisLembaga(String jenisLembaga) {
        this.jenisLembaga = jenisLembaga;
    }

    public String getNamaPengelola() {
        return namaPengelola;
    }

    public void setNamaPengelola(String namaPengelola) {
        this.namaPengelola = namaPengelola;
    }

    @Override
    public String getJenisPenerima() {
        return "Lembaga";
    }
}
```

## 👾 Polymorphism
Program ini menggunakan **polymorphism** dengan cara menerapkan **overriding**. Implementasinya terlihat pada method `getJenisDonatur()` awalnya dibuat di superclass `Donatur`, lalu diubah sesuai kebutuhan di `DonaturIndividu` dan `DonaturInstansi`.

Pada superclass `Donatur`, method tersebut memiliki nilai awal:

```java
public String getJenisDonatur() {
    return "Donatur";
}
```
Masing-masing subclass memberikan implementasi yang berbeda:

```
    @Override
    public String getJenisDonatur() {
        return "Donatur Individu";
    }
```

```
    @Override
    public String getJenisDonatur() {
        return "Donatur Instansi";
    }
```

Dengan cara ini, _method_ yang sama dapat menghasilkan nilai berbeda sesuai dengan objek yang digunakan. Contohnya saat data disimpan dalam `ArrayList<Donatur>`:

```
...
        for (Donatur d : dataDonatur) {
            System.out.println("ID Donatur: " + d.getIdDonatur());
            System.out.println("Nama Donatur: " + d.getNamaDonatur());
            System.out.println("Jenis Donatur: " + d.getJenisDonatur());

            if (d instanceof DonaturIndividu individu) {
                System.out.println("Jenis Kegiatan: " + individu.getJenisKegiatan());
            } else if (d instanceof DonaturInstansi instansi) {
                System.out.println("Nama Instansi: " + instansi.getNamaInstansi());
                System.out.println("Jenis Instansi: " + instansi.getJenisInstansi());
            }
            System.out.println("------------------------------------");
        }
...
```
Jika objek yang digunakan adalah `DonaturIndividu`, maka program menjalankan `getJenisDonatur()` milik `DonaturIndividu`. Jika objeknya `DonaturInstansi`, maka yang dijalankan adalah milik `DonaturInstansi`.

Konsep yang sama juga diterapkan pada `getJenisPenerima()` pada kelas `Penerima`, `PenerimaIndividu`, dan `PenerimaLembaga`.

Selain menggunakan **overriding**, program juga memakai **instanceof** untuk memeriksa tipe objek. Cara ini digunakan saat ingin menampilkan atribut tambahan yang berbeda di setiap subclass.

## 🍱 Alur Program
Program Food Redistribution System dibuat untuk mengelola proses redistribusi makanan, mulai dari pencatatan data donatur, data makanan yang didonasikan, penerima, hingga pencatatan penyaluran. Sistem ini membagi akses berdasarkan dua peran, yaitu `Admin` dan `Petugas`. Admin bertanggung jawab utama dalam pengelolaan data, sementara Petugas memiliki akses terbatas dan fokus pada data yang dibutuhkan untuk penyaluran. Dengan pembagian ini, setiap pengguna menjalankan fungsi yang berbeda sesuai proses di sistem.

**1. Tampilan Menu Utama**
<br> Saat program pertama kali dijalankan, pengguna akan melihat tampilan awal Food Redistribution System dan diminta menentukan role yang ingin digunakan. Terdapat tiga pilihan pada menu awal, yaitu Admin, Petugas, dan Keluar. Jika memilih Admin, pengguna akan masuk ke Menu Admin. Jika memilih Petugas, pengguna akan masuk ke Menu Petugas. Pilihan Keluar akan menghentikan perulangan pada menu utama sehingga program selesai dijalankan. Dengan demikian, MenuController berfungsi sebagai pengatur awal alur program sesuai peran pengguna, sedangkan pengelolaan data dilakukan oleh controller dan service masing-masing.

<img width="588" height="277" alt="image" src="https://github.com/user-attachments/assets/7624fa95-7bdd-4e03-9ff2-45b36638df4e" />


<br> **2. Menu Admin**
<br> Setelah memilih role Admin, pengguna diarahkan ke AdminController yang menampilkan menu pengelolaan data. Menu Admin terdiri dari `Donatur`, `Donasi`, `Penerima`, `Penyaluran`, dan `Kembali`. Admin memiliki akses paling luas karena bertanggung jawab atas pengelolaan data utama yang digunakan oleh sistem. Setiap pilihan pada menu tidak langsung mengolah data di dalam controller, tetapi diteruskan kepada Service yang sesuai. Misalnya, ketika memilih Donasi, AdminController akan memanggil DonasiService untuk menjalankan proses pengelolaan data donasi. Pembagian tersebut membuat AdminController lebih berfokus pada pengaturan alur menu, sedangkan proses CRUD ditangani oleh masing-masing service.

<img width="427" height="408" alt="image" src="https://github.com/user-attachments/assets/1e191ba0-cb41-4796-ac5a-ff173f06e2d9" />


<br> **3. Menu Petugas**
<br> Jika pengguna memilih role Petugas, sistem menjalankan `PetugasController`. Berbeda dengan Admin, Petugas tidak bisa mengelola semua data karena tugasnya fokus pada informasi yang dibutuhkan untuk redistribusi makanan. Menu Petugas terdiri dari `Lihat Data Donasi`, `Lihat Data Penerima`, `Lihat Data Penyaluran`, dan `Kembali`. Petugas hanya bisa melihat data Donasi, Penerima, dan penyaluran saja agar tahu makanan yang tersedia, siapa penerimanya, dan kemana makanan disalurkan. Pada menu Penyaluran, ada fitur tambahan untuk memperbarui status penyaluran. Ini menunjukkan bahwa Petugas tidak hanya membaca data, tapi juga bertanggung jawab atas perkembangan proses penyaluran.

<img width="431" height="385" alt="image" src="https://github.com/user-attachments/assets/8cd86f1e-f724-4918-a5c8-fa4927058ce8" />
<br> <img width="432" height="835" alt="image" src="https://github.com/user-attachments/assets/084e3dd0-40c1-46af-b87c-9a007893bc7c" />
<br> <img width="413" height="896" alt="image" src="https://github.com/user-attachments/assets/54f71957-dddb-4485-8689-203fbe220224" />


<br> **4. Menu Data Donatur**
<br> Menu Donatur digunakan oleh Admin untuk mencatat dan mengelola pihak yang memberikan makanan atau donasi. Data yang disimpan meliputi `ID Donatur`, `nama donatur`, dan `jenis donatur`. Program membedakan donatur menjadi `Donatur Individu` dan `Donatur Instansi`. Donatur Individu memiliki atribut tambahan `Jenis Kegiatan`, sedangkan Donatur Instansi memiliki atribut tambahan berupa `Nama Instansi` dan `Jenis Instansi`. Perbedaan ini diterapkan dengan _inheritance_, sehingga kedua class turunan tetap memiliki data dasar dari class Donatur, tapi juga bisa punya karakteristik tambahan. Dengan cara ini, sistem bisa menyimpan berbagai jenis donatur dalam satu `ArrayList<Donatur>` tanpa perlu mekanisme penyimpanan terpisah.

<img width="380" height="696" alt="image" src="https://github.com/user-attachments/assets/bb92bb76-2308-4c66-b3d5-72903cbfbafe" />


<br> **5. Menambah Data Donatur Baru**
<br> Ketika Admin memilih menu Donatur dan menambah data, sistem akan meminta ID dan nama donatur terlebih dahulu. Setelah itu, Admin memilih jenis donatur, apakah `individu` atau `instansi`. Jika memilih Individu, sistem meminta `Jenis Kegiatan`, sedangkan jika memilih Instansi, sistem meminta `Nama Instansi` dan `Jenis Instansi`. Setelah semua data diisi, program membuat objek sesuai jenis yang dipilih dan menyimpannya ke dalam `ArrayList<Donatur>`. Proses ini menunjukkan penggunaan _inheritance_ karena satu tipe data induk bisa menampung beberapa objek class turunan dengan karakteristik berbeda.

<img width="375" height="580" alt="image" src="https://github.com/user-attachments/assets/0fa65aa7-7866-4b1d-80e5-24881ce7e084" />
<br> <img width="376" height="243" alt="image" src="https://github.com/user-attachments/assets/a2817bc7-fbeb-47f8-8e99-eef19618b99f" />


<br> **6. Menu Data Donasi**
<br> Menu Donasi digunakan untuk mencatat makanan yang diberikan oleh donatur. Setiap data donasi berisi `ID Donasi`, `ID Donatur`, `Nama Makanan,` `Jumlah Porsi`, dan `Status Kelayakan`. ID Donatur menghubungkan data makanan dengan donaturnya. Saat Admin menambah atau memperbarui data donasi, sistem akan mencari ID Donatur lewat DonaturService. Jika ID belum terdaftar, pengguna diminta memasukkan ID Donatur yang valid. Dengan cara ini, data donasi tidak bisa sembarangan mengacu pada donatur yang tidak ada di sistem. Admin bisa melakukan CRUD pada data donasi, sedangkan Petugas hanya bisa melihat data ini sebagai informasi pendukung dalam proses penyaluran.

<img width="373" height="717" alt="image" src="https://github.com/user-attachments/assets/68f978be-a154-44f6-9ce9-14c0ee35f326" />


<br> **7. Menu Data Penerima**
<br> Menu Penerima digunakan untuk mengelola pihak yang akan menerima makanan hasil redistribusi. Seperti Donatur, penerima dibedakan menjadi dua jenis, yaitu `Penerima Individu` dan `Penerima Lembaga`. Penerima Individu memiliki atribut tambahan `Deskripsi Penerima`, sedangkan Penerima Lembaga memiliki informasi seperti `Nama Lembaga`, `Jenis Lembaga`, dan `Nama Pengelola`. Kedua jenis ini adalah turunan dari class Penerima, sehingga bisa disimpan dalam satu ArrayList<Penerima>. Ketika Admin menambah data, program menentukan jenis objek sesuai pilihan pengguna lalu menyimpannya ke data penerima. Admin bisa mengelola data penerima sepenuhnya, sedangkan Petugas hanya melihatnya untuk mengetahui siapa yang akan menerima makanan.

<img width="485" height="787" alt="image" src="https://github.com/user-attachments/assets/6d73eb5a-1447-4874-8eaa-a9895a663a7d" />


<br> **8. Menu Data Penyaluran**
<br> Menu Penyaluran menghubungkan data donasi dengan data penerima dalam kegiatan redistribusi makanan. Setiap data penyaluran berisi `ID Penyaluran`, `ID Donasi`, `ID Penerima`, `Nama Kegiatan`, `Tanggal Penyaluran`, `Status Penyaluran`, `Jumlah Porsi`, dan `Petugas`. Ketika Admin membuat data penyaluran, sistem terlebih dahulu memastikan bahwa ID Donasi dan ID Penerima sudah ada di sistem. Jadi, penyaluran tidak bisa dibuat jika donasi atau penerima belum terdaftar. Setelah data berhasil dibuat,**status penyaluran otomatis menjadi `Belum Disalurkan`**, artinya data sudah dibuat dan direncanakan, tapi penyaluran belum selesai. Pembuatan data penyaluran tidak berarti makanan sudah diberikan. Setelah kegiatan berjalan, Petugas bisa memperbarui status penyaluran sesuai kondisi. Status ini digunakan untuk menggambarkan perkembangan kegiatan, mulai dari belum disalurkan, dalam proses, hingga sudah disalurkan.

<img width="420" height="937" alt="image" src="https://github.com/user-attachments/assets/83acc83f-6622-440f-979e-75e1ab2c6f93" />
<br> <img width="422" height="577" alt="image" src="https://github.com/user-attachments/assets/a2ec2de3-9edc-4681-8e3f-029f66c54a6f" />


<br> **9. Proses Update Data**
<br> Proses Update digunakan saat Admin ingin mengubah informasi yang sudah tersimpan. Admin terlebih dahulu memasukkan ID dari data yang ingin diperbarui, lalu program mencari data tersebut lewat method pencarian di service. Jika data ditemukan, sistem menampilkan informasi yang akan diubah dan meminta konfirmasi Admin sebelum perubahan dilakukan. Jika Admin memilih `y`, sistem meminta data baru dan memasukkan perubahan ke objek terkait lewat setter. Jika Admin memilih selain `y`, perubahan dibatalkan. Konfirmasi sebelum update ini bertujuan mengurangi risiko perubahan tidak sengaja. Untuk data Penyaluran, Admin mengelola informasi kegiatan seperti donasi, penerima, nama kegiatan, tanggal, jumlah porsi, dan petugas. Perubahan status penyaluran hanya bisa dilakukan oleh Petugas.

<img width="402" height="582" alt="image" src="https://github.com/user-attachments/assets/6732c5ca-4f0b-4ba8-beac-7214165bfc8b" />
<br> <img width="377" height="247" alt="image" src="https://github.com/user-attachments/assets/02237781-49af-4ef8-9d16-0c6259211617" />


<br> **10. Proses Update Status Penyaluran oleh Petugas**
<br> Pada data Penyaluran, ada proses khusus yang hanya bisa dilakukan lewat Menu Petugas, yaitu `Update Status Penyaluran`. Saat Petugas memilih menu Lihat Data Penyaluran, program menampilkan semua data penyaluran beserta statusnya. Petugas bisa memilih fitur `Update Status` dan memasukkan ID Penyaluran yang ingin diubah. Program mencari data tersebut lewat PenyaluranService. Jika data ditemukan, sistem menampilkan ID Penyaluran, nama kegiatan, dan status saat ini sebelum meminta konfirmasi. Setelah Petugas mengonfirmasi, sistem meminta status penyaluran baru dan menyimpannya ke objek Penyaluran. Pembagian fungsi ini dibuat karena Admin bertanggung jawab membuat dan mengelola informasi kegiatan, sedangkan Petugas yang terlibat langsung dalam penyaluran berwenang mencatat perkembangan statusnya. Jadi, status penyaluran tidak hanya sebagai atribut, tapi juga menggambarkan perkembangan kegiatan di sistem.

<img width="422" height="618" alt="image" src="https://github.com/user-attachments/assets/f86644d4-6bc9-45bc-8edb-2f4a2c087372" />


<br> **11. Proses Hapus Data**
<br> Proses Hapus digunakan Admin saat data tidak lagi dibutuhkan di sistem. Admin memasukkan ID data yang ingin dihapus, lalu program mencari objek berdasarkan ID itu. Jika data ditemukan, program menampilkan detail data dan meminta konfirmasi dengan pertanyaan **Yakin ingin menghapus data? `(y/n)`**. Data hanya dihapus dari `ArrayList` jika Admin mengonfirmasi dengan `y`. Jika Admin memilih jawaban lain, proses dibatalkan dan data tetap ada. Mekanisme ini memberi lapisan konfirmasi sebelum data dihapus, sehingga pengguna bisa memastikan bahwa data yang dipilih memang merupakan data yang ingin dihapus.

<img width="380" height="537" alt="image" src="https://github.com/user-attachments/assets/1cf08b41-4f75-47a6-be0e-455588fdf2b8" />
<br> <img width="387" height="243" alt="image" src="https://github.com/user-attachments/assets/6c22e429-65ba-460e-99d1-81c26f37f585" />


<br> **12. Kembali dan Keluar dari Program**
<br> Setiap menu di program memiliki pilihan Kembali agar pengguna bisa berpindah ke menu sebelumnya tanpa menutup program. Ketika Admin memilih Kembali, perulangan pada `menuAdmin()` berhenti dan kontrol kembali ke `MenuController`. Hal yang sama berlaku di Menu Petugas. Dengan mekanisme perulangan _while_ dan variabel penanda seperti `berjalan`, setiap menu bisa terus digunakan sampai pengguna memilih kembali. Setelah kembali ke Menu Utama, pengguna bisa memilih peran lain atau memilih Keluar. Jika memilih Keluar, perulangan utama di `MenuController` berhenti dan program menampilkan **pesan penutup**.

<img width="527" height="303" alt="image" src="https://github.com/user-attachments/assets/c56402e6-16a3-4fa8-82ad-9fd348b55d4a" />


