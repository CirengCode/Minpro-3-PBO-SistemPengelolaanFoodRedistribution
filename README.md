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
---
## ⭐ Struktur Program 
Program ini disusun dengan kosep **MVC (Model–View–Controller)** yang dimodifikasi menjadi *layered architecture* sederhana. Struktur program ini dibagi ke beberapa *package* supaya setiap bagian punya tugas yang jelas.


| Package | Fungsi | Isi |
|---|---|---|
| `main` |Package ini menjadi titik awal program. Di dalamnya terdapat class utama yang menjalankan program dengan membuat MenuController dan memulai alur sistem. | `SistemPengelolaanFoodRedistributionMain.java` |
| `model` | Berisi class yang merepresentasikan data atau objek yang digunakan dalam sistem. Class di dalamnya menyimpan atribut, constructor, getter, setter, dan juga menerapkan konsep OOP seperti inheritance. | `Donatur`, `DonaturIndividu`, `DonaturInstansi`, `Penerima`, `PenerimaIndividu`, `PenerimaLembaga`, `Donasi`, `Penyaluran` |
| `service` | Package ini berisi class yang menangani proses dan logika pengelolaan data. Package ini menjalankan operasi CRUD dan proses lain yang berkaitan dengan data. | `DonaturService`, `DonasiService`, `PenerimaService`, `PenyaluranService`, `PetugasService` |
| `controller` | Package ini mengatur alur penggunaan program dan menentukan proses atau menu yang bisa dijalankan sesuai peran pengguna. Controller menghubungkan pilihan pengguna ke service yang tepat. | `MenuController`, `AdminController`, `PetugasController` |
| `util` | Package ini berisi class yang menyediakan fungsi bantu untuk beberapa bagian program, terutama dalam membaca dan memvalidasi input dari pengguna. | `InputUtil`, `IdGenerator` |
| `view` | Package ini berisi class yang menangani tampilan yang langsung berinteraksi dengan pengguna, seperti menu-menu yang ada pada program, tabel data, pilihan input, informasi data yang akan diperbarui atau dihapus, serta pesan validasi dan hasil operasi. | `MenuView`, `AdminView`, `PetugasView`, `DonaturView`, `DonasiView`, `PenerimaView`, `PenyaluranView`, `MessageView` |

Secara umum, program dimulai dari package `main`, lalu dilanjutkan ke `controller` yang menentukan menu dan peran pengguna. Setelah pengguna memilih fitur, `controller` memanggil `service` yang sesuai untuk menjalankan proses atau mengelola data. `service` kemudian memakai class dari package `model` sebagai objek data yang dikelola.

Package `util` membantu proses input. Fungsi-fungsinya, seperti membaca angka, membaca teks, validasi input, menunggu pengguna menekan Enter, dan ID generator, dapat digunakan kembali oleh bagian program lain yang memerlukannya.

Dengan adanya package `View`, kode yang menampilkan informasi kepada pengguna dapat dipisahkan dan dipakai ulang sesuai kebutuhan. Jadi, kode tampilan yang sama tidak perlu ditulis berulang kali di dalam `Controller` atau `Service`, sehingga program lebih rapi dan efisien.

Dengan pembagian ini, package `model` digunakan untuk mewakili data, `service` bertugas mengelola proses dan logika data, `controller` mengatur jalannya program, `util` berisi fungsi-fungsi pendukung, dan main adalah titik awal untuk menjalankan sistem.

---

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

---

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

---

## 👾 Polymorphism
Program ini menggunakan **polymorphism** dengan cara menerapkan **overriding** dan **overloading**. 

### Overriding
Overriding digunakan ketika subclass membuat implementasi khusus untuk method yang sudah ada di superclass. Implementasinya terlihat pada method `getJenisDonatur()` awalnya dibuat di superclass `Donatur`, lalu diubah sesuai kebutuhan di `DonaturIndividu` dan `DonaturInstansi`.

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

Konsep yang sama juga diterapkan pada `getJenisPenerima()` pada class `Penerima`, `PenerimaIndividu`, dan `PenerimaLembaga`.

Selain menggunakan **overriding** dan **overloading**, program juga memakai **instanceof** untuk memeriksa tipe objek. Cara ini digunakan saat ingin menampilkan atribut tambahan yang berbeda di setiap subclass.

### Overloading
Overloading diterapkan pada method `totalPorsiPenyaluran()` di PenyaluranService. Method ini berfungsi untuk menghitung total porsi yang sudah disalurkan berdasarkan ID donasi. Ada dua method dengan nama yang sama, tetapi jumlah parameternya berbeda.

```
    private int totalPorsiPenyaluran(String idDonasi) {
        int total = 0;

        for (Penyaluran p : dataPenyaluran) {
            if (p.getIdDonasi().equalsIgnoreCase(idDonasi)) {
                total += p.getJumlahPorsi();
            }
        }

        return total;
    }
    
    private int totalPorsiPenyaluran(String idDonasi, Penyaluran penyaluran) {
        int total = 0;

        for (Penyaluran p : dataPenyaluran) {
            if (p.getIdDonasi().equalsIgnoreCase(idDonasi) && p != penyaluran) {
                total += p.getJumlahPorsi();
            }
        }
        return total;
    }
```

Pada method pertama, hanya `idDonasi` yang digunakan sebagai parameter. Method ini akan memeriksa seluruh data pada dataPenyaluran dan mencari data dengan idDonasi yang sama. Setiap jumlahPorsi dari data yang ditemukan akan dijumlahkan ke variabel total. Cara ini digunakan untuk mendapatkan total porsi penyaluran dari suatu donasi.

```
private int totalPorsiPenyaluran(String idDonasi) {
  ..
}
```

Method kedua menerima dua parameter, yaitu `idDonasi` dan objek `Penyaluran`. Method ini digunakan ketika melakukan update data penyaluran. Objek Penyaluran yang sedang diperbarui diberikan sebagai parameter agar data tersebut tidak ikut dihitung dalam total.

Ini penting karena saat data penyaluran diperbarui, jumlah porsi yang sudah tercatat sebelumnya tidak boleh dihitung lagi sebagai penyaluran tambahan. Dengan mengecualikan objek yang sedang diperbarui, sistem dapat menghitung total porsi penyaluran dari data lain terlebih dahulu, lalu membandingkannya dengan jumlah porsi baru yang akan dimasukkan. Contohnya, jika sebuah donasi memiliki 20 porsi dan sebelumnya sudah ada penyaluran 10 porsi, lalu data penyaluran tersebut ingin diubah menjadi 15 porsi, maka 10 porsi dari data yang diperbarui tidak perlu dihitung lagi. Sistem hanya menghitung penyaluran lainnya, lalu menambahkan 15 porsi baru agar totalnya tetap sesuai batas donasi.

```
private int totalPorsiPenyaluran(String idDonasi, Penyaluran penyaluran) {
  ..
}
```

Kedua method ini saling berkaitan, tetapi dipakai dalam situasi yang berbeda. Method pertama untuk menghitung semua penyaluran, sedangkan method kedua dipakai saat memperbarui data dengan mengecualikan objek yang sedang diperbarui. 

---
## 😶‍🌫️ Abstraction
Abstraction diterapkan dengan menggunakan **abstract class** dan **abstract method** pada hierarki class `Donatur` dan `Penerima`. Penerapan ini digunakan untuk membuat struktur umum sebuah objek tanpa harus menentukan semua detail implementasinya di superclass.

### Abstract Class

```
public abstract class Donatur {
    private final String idDonatur;
    private String namaDonatur;

    public Donatur(String namaDonatur) {
        this.idDonatur = IdGenerator.generateId("DT0");
        this.namaDonatur = namaDonatur;
    }

    public String getIdDonatur() {
        return idDonatur;
    }

    public String getNamaDonatur() {
        return namaDonatur;
    }

    public void setNamaDonatur(String namaDonatur) {
        this.namaDonatur = namaDonatur;
    }

    public abstract String getJenisDonatur();
}
```

Class `Donatur` berfungsi sebagai gambaran umum donatur dalam sistem. Pada class `Donatur` ada karakteristik yang dimiliki setiap donatur, seperti `idDonatur` dan `namaDonatur`. Karena Donatur adalah konsep umum, class ini tidak digunakan langsung untuk membuat objek. Sebaliknya, `Donatur` menjadi dasar bagi class turunannya, yaitu `DonaturIndividu` dan `DonaturInstansi`.

### Abstract Method

```
...

  public abstract String getJenisDonatur();

...
```

Method ini tidak memiliki isi atau implementasi di superclass `Donatur`. Class `Donatur` hanya menetapkan bahwa setiap subclass harus memiliki method `getJenisDonatur()`. Nilai yang dikembalikan oleh method tersebut kemudian ditentukan oleh masing-masing subclass.

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

Dengan demikian, superclass `Donatur` hanya menetapkan bahwa subclass harus punya method `getJenisDonatur()`, tanpa menentukan hasilnya secara langsung. Setiap subclass kemudian memberikan implementasinya sendiri sesuai dengan jenis donatur.

Penggunaan abstraction pada Donatur membuat program bisa memisahkan karakteristik umum donatur dari detail khusus tiap jenis donatur. Donatur menjadi dasar, sedangkan DonaturIndividu dan DonaturInstansi memberikan implementasi yang lebih spesifik.

---
## ✅ Validasi Input
Untuk mencegah kesalahan saat pengguna memasukkan data, program melakukan validasi input dengan `InputUtil` dan juga validasi tambahan di bagian service dan model. Jika ada input yang tidak sesuai, program akan menampilkan pesan kesalahan dan meminta pengguna untuk mengisi ulang data.

Berikut beberapa jenis validasi yang digunakan:

* Input angka seperti jumlah porsi dan pilihan menu harus benar-benar berupa angka.
* Input teks seperti nama donatur dan nama makanan tidak boleh dibiarkan kosong.
* ID yang digunakan saat menambah, mengubah, atau menghapus data harus sesuai dengan data yang sudah ada. Misalnya, idDonatur pada data Donasi harus sudah terdaftar sebelumnya.
* Input angka tidak boleh bernilai 0 atau negatif.
* Input konfirmasi seperti `y`/`n`hanya menerima pilihan yang benar.
* Input nama donatur dan pengelola hanya boleh berupa huruf dan spasi, jadi angka atau karakter khusus tidak dapat digunakan sebagai nama.
* Input tanggal menggunakan harus menggunakan format dd-MM-yyyy. Selain memeriksa format penulisan, sistem juga memastikan tanggal yang dimasukkan benar dan valid.
* Input jumlah porsi penyaluran memastikan makanan yang disalurkan tidak melebihi jumlah porsi yang tersedia pada donasi. Misalnya, jika donasi memiliki 15 porsi, total porsi yang disalurkan tidak boleh lebih dari 15. Validasi ini juga berlaku saat memperbarui data penyaluran.

<img width="530" height="310" alt="image" src="https://github.com/user-attachments/assets/8f6b172c-6a79-4df6-aa42-2a0c550b2cb7" />
<br> <img width="598" height="567" alt="image" src="https://github.com/user-attachments/assets/b543af2c-2cb8-43a9-9fcd-ed9da3f4879e" />
<br> <img width="537" height="187" alt="image" src="https://github.com/user-attachments/assets/b188bee8-6fb7-4074-ab2a-240fc27b96cf" />
<br> <img width="532" height="471" alt="image" src="https://github.com/user-attachments/assets/99c8b61a-9778-40a9-bce6-847df5e06f70" />
<br> <img width="577" height="560" alt="image" src="https://github.com/user-attachments/assets/f30ec9e3-5bd3-4281-8e0b-3d0f11cc3eec" />
<br> <img width="642" height="720" alt="image" src="https://github.com/user-attachments/assets/98650de8-a06f-46bd-95ce-a478cb131bfa" />
<br> <img width="651" height="187" alt="image" src="https://github.com/user-attachments/assets/57ff2e99-cde7-444a-b00e-77e6584a38a6" />
<br> <img width="525" height="846" alt="image" src="https://github.com/user-attachments/assets/43bcc8ca-37bb-4d6d-85cc-3b5c46eaacbe" />

Dengan validasi ini, jika ada kesalahan input, pengguna akan diminta untuk mengulangi input. Program pun tidak akan langsung berhenti atau crash saat menerima input yang salah.

---

## 🍱 Alur Program
Program Food Redistribution System dibuat untuk mengelola proses redistribusi makanan, mulai dari pencatatan data donatur, data makanan yang didonasikan, penerima, hingga pencatatan penyaluran. Sistem ini membagi akses berdasarkan dua peran, yaitu `Admin` dan `Petugas`. Admin bertanggung jawab utama dalam pengelolaan data, sementara Petugas memiliki akses terbatas dan fokus pada data yang dibutuhkan untuk penyaluran. Dengan pembagian ini, setiap pengguna menjalankan fungsi yang berbeda sesuai proses di sistem.

**1. Tampilan Menu Utama**
<br> Saat program pertama kali dijalankan, pengguna akan melihat tampilan awal Food Redistribution System dan diminta menentukan role yang ingin digunakan. Terdapat tiga pilihan pada menu awal, yaitu Admin, Petugas, dan Keluar. Jika memilih Admin, pengguna akan masuk ke Menu Admin. Jika memilih Petugas, pengguna akan masuk ke Menu Petugas. Pilihan Keluar akan menghentikan perulangan pada menu utama sehingga program selesai dijalankan. Dengan demikian, MenuController berfungsi sebagai pengatur awal alur program sesuai peran pengguna, sedangkan pengelolaan data dilakukan oleh controller dan service masing-masing.

<img width="606" height="272" alt="image" src="https://github.com/user-attachments/assets/a6b2485b-4b29-46f2-b51b-fa59690e7c20" />


<br> **2. Menu Admin**
<br> Setelah memilih role Admin, pengguna diarahkan ke AdminController yang menampilkan menu pengelolaan data. Menu Admin terdiri dari `Donatur`, `Donasi`, `Penerima`, `Penyaluran`, dan `Kembali`. Admin memiliki akses paling luas karena bertanggung jawab atas pengelolaan data utama yang digunakan oleh sistem. Setiap pilihan pada menu tidak langsung mengolah data di dalam controller, tetapi diteruskan kepada Service yang sesuai. Misalnya, ketika memilih Donasi, AdminController akan memanggil DonasiService untuk menjalankan proses pengelolaan data donasi. Pembagian tersebut membuat AdminController lebih berfokus pada pengaturan alur menu, sedangkan proses CRUD ditangani oleh masing-masing service.

<img width="608" height="317" alt="image" src="https://github.com/user-attachments/assets/c729c388-ea4a-4d6c-8023-0c79d64c325e" />


<br> **3. Menu Petugas**
<br> Jika pengguna memilih role Petugas, sistem menjalankan `PetugasController`. Berbeda dengan Admin, Petugas tidak bisa mengelola semua data karena tugasnya fokus pada informasi yang dibutuhkan untuk redistribusi makanan. Menu Petugas terdiri dari `Lihat Data Donasi`, `Lihat Data Penerima`, `Lihat Data Penyaluran`, dan `Kembali`. Petugas hanya bisa melihat data Donasi, Penerima, dan penyaluran saja agar tahu makanan yang tersedia, siapa penerimanya, dan kemana makanan disalurkan. Pada menu Penyaluran, ada fitur tambahan untuk memperbarui status penyaluran. Ini menunjukkan bahwa Petugas tidak hanya membaca data, tapi juga bertanggung jawab atas perkembangan proses penyaluran.

<img width="600" height="256" alt="image" src="https://github.com/user-attachments/assets/8330e223-cac0-488a-8620-29f7069cfa2e" />
<br> <img width="432" height="842" alt="image" src="https://github.com/user-attachments/assets/030f0ef6-03f2-4138-a8a8-f1c43c967b2b" />
<br> <img width="445" height="800" alt="image" src="https://github.com/user-attachments/assets/932c51ef-8152-4bef-814c-1a3173eb1645" />
<br> <img width="430" height="895" alt="image" src="https://github.com/user-attachments/assets/506051b6-be0c-41f0-9feb-1856ca023ba7" />


<br> **4. Menu Data Donatur**
<br> Menu Donatur digunakan oleh Admin untuk mencatat dan mengelola pihak yang memberikan makanan atau donasi. Data yang disimpan meliputi `ID Donatur`, `nama donatur`, dan `jenis donatur`. ID Donatur akan otomatis dibuat oleh sistem setiap kali data donatur baru ditambahkan. Dengan cara ini, pengguna tidak perlu mengisi ID secara manual, sehingga proses penambahan data lebih mudah dan konsisten. 

Program membedakan donatur menjadi `Donatur Individu` dan `Donatur Instansi`. Donatur Individu memiliki atribut tambahan `Jenis Kegiatan`, sedangkan Donatur Instansi memiliki atribut tambahan berupa `Nama Instansi` dan `Jenis Instansi`. Perbedaan ini diterapkan dengan _inheritance_, sehingga kedua class turunan tetap memiliki data dasar dari class Donatur, tapi juga bisa punya karakteristik tambahan. Dengan cara ini, sistem bisa menyimpan berbagai jenis donatur dalam satu `ArrayList<Donatur>` tanpa perlu mekanisme penyimpanan terpisah. 

<img width="458" height="855" alt="image" src="https://github.com/user-attachments/assets/c65af571-4ccb-4640-aba8-48017a081cb7" />


<br> **5. Menambah Data Donatur Baru**
<br> Ketika Admin memilih menu Donatur dan menambah data, program akan membuat ID Donatur secara otomatis, sehingga pengguna tidak perlu memasukkan ID secara manual. Setelah itu, Admin akan mengisi nama donatur dan memilih jenis donatur, apakah `individu` atau `instansi`. Jika memilih Individu, sistem meminta `Jenis Kegiatan`, sedangkan jika memilih Instansi, sistem meminta `Nama Instansi` dan `Jenis Instansi`. Setelah semua data diisi, program membuat objek sesuai jenis yang dipilih dan menyimpannya ke dalam `ArrayList<Donatur>`. Proses ini menunjukkan penggunaan _inheritance_ karena satu tipe data induk bisa menampung beberapa objek class turunan dengan karakteristik berbeda.

<img width="472" height="643" alt="image" src="https://github.com/user-attachments/assets/7af33584-0534-4d17-97fa-04c05d43e4d3" />
<br> <img width="443" height="297" alt="image" src="https://github.com/user-attachments/assets/f378c000-080c-4d68-a3ed-5f2925fbb308" />


<br> **6. Menu Data Donasi**
<br> Menu Donasi digunakan untuk mencatat makanan yang diberikan oleh donatur. Setiap data donasi berisi `ID Donasi`, `ID Donatur`, `Nama Makanan,` `Jumlah Porsi`, dan `Status Kelayakan`. ID Donasi akan dibuat secara otomatis setiap kali data donasi ditambahkan. Saat Admin menambah atau memperbarui data donasi, sistem akan mencari ID Donatur lewat DonaturService. Jika ID belum terdaftar, pengguna diminta memasukkan ID Donatur yang valid. Dengan cara ini, data donasi tidak bisa sembarangan mengacu pada donatur yang tidak ada di sistem. 

Pada proses pengelolaan data, status kelayakan donasi bisa ditentukan saat proses penambahan dan juga _update_ data donasi. Status kelayakan ini digunakan untuk menentukan apakah makanan yang didonasikan memenuhi kondisi untuk diproses lebih lanjut dalam sistem redistribusi.

<img width="455" height="882" alt="image" src="https://github.com/user-attachments/assets/a301327a-8d1f-48f9-8275-82eeff918395" />


<br> **7. Menu Data Penerima**
<br> Menu Penerima digunakan untuk mengelola pihak yang akan menerima makanan hasil redistribusi. Ketika Admin menambah data, ID Penerima akan dibuat secara otomatis oleh sistem ketika data penerima baru ditambahkan. Pengguna tidak perlu memasukkan ID secara manual, sehingga setiap penerima langsung memiliki identitas dari sistem. Seperti Donatur, penerima dibedakan menjadi dua jenis, yaitu `Penerima Individu` dan `Penerima Lembaga`. Penerima Individu memiliki atribut tambahan `Deskripsi Penerima`, sedangkan Penerima Lembaga memiliki informasi seperti `Nama Lembaga`, `Jenis Lembaga`, dan `Nama Pengelola`. Kedua jenis ini adalah turunan dari class Penerima, sehingga bisa disimpan dalam satu `ArrayList<Penerima>`. 

<img width="525" height="822" alt="image" src="https://github.com/user-attachments/assets/69ff2a6a-9a82-4200-8ff8-4f2ac9c4fc9c" />


<br> **8. Menu Data Penyaluran**
<br> Menu Penyaluran menghubungkan data donasi dengan data penerima dalam kegiatan redistribusi makanan. Setiap data penyaluran berisi `ID Penyaluran`, `ID Donasi`, `ID Penerima`, `Nama Kegiatan`, `Tanggal Penyaluran`, `Status Penyaluran`, `Jumlah Porsi`, dan `Petugas`. Saat data penyaluran ditambahkan, sistem akan otomatis membuat ID Penyaluran. Pengguna tidak perlu memasukkan ID secara manual, sehingga setiap data penyaluran memiliki identitas yang dihasilkan oleh sistem. Ketika Admin membuat data penyaluran, sistem terlebih dahulu memastikan bahwa ID Donasi dan ID Penerima sudah ada di sistem. Jadi, penyaluran tidak bisa dibuat jika donasi atau penerima belum tersedia. Setelah data berhasil dibuat, status penyaluran otomatis menjadi `Belum Disalurkan`, artinya data sudah dibuat dan direncanakan, tapi penyaluran belum selesai. Pembuatan data penyaluran tidak berarti makanan sudah diberikan. Setelah kegiatan berjalan, Petugas bisa memperbarui status penyaluran sesuai kondisi. Status ini digunakan untuk menggambarkan perkembangan kegiatan, mulai dari belum disalurkan, dalam proses, hingga sudah disalurkan.

<img width="375" height="877" alt="image" src="https://github.com/user-attachments/assets/25d2ddea-2bf1-42f5-8027-771618fe776c" />


<br> **9. Proses Update Data**
<br> Proses Update digunakan saat Admin ingin mengubah informasi yang sudah tersimpan. Admin terlebih dahulu memasukkan ID dari data yang ingin diperbarui, lalu program mencari data tersebut lewat method pencarian di service. Jika data ditemukan, sistem menampilkan informasi yang akan diubah dan meminta konfirmasi Admin sebelum perubahan dilakukan. Jika Admin memilih `y`, sistem meminta data baru dan memasukkan perubahan ke objek terkait. Jika Admin memilih selain `y`, perubahan dibatalkan. Konfirmasi sebelum update ini bertujuan mengurangi risiko perubahan tidak sengaja. 

<img width="437" height="692" alt="image" src="https://github.com/user-attachments/assets/cbf2addc-fb2b-4fd9-9040-2e3d20a8f736" />
<br> <img width="418" height="295" alt="image" src="https://github.com/user-attachments/assets/45f12736-0267-4717-a638-88e99a71481d" />


<br> **10. Proses Update Status Penyaluran oleh Petugas**
<br> Pada data Penyaluran, ada proses khusus yang hanya bisa dilakukan lewat Menu Petugas, yaitu `Update Status Penyaluran`. Saat Petugas memilih menu `Lihat Data Penyaluran`, program menampilkan semua data penyaluran beserta statusnya. Petugas bisa memilih fitur `Update Status` dan memasukkan ID Penyaluran yang ingin diubah. Program mencari data tersebut lewat PenyaluranService. Jika data ditemukan, sistem menampilkan ID Penyaluran, nama kegiatan, dan status saat ini sebelum meminta konfirmasi. Setelah Petugas mengonfirmasi, sistem meminta status penyaluran baru dan menyimpannya ke objek Penyaluran. Pembagian fungsi ini dibuat karena Admin bertanggung jawab membuat dan mengelola informasi kegiatan, sedangkan Petugas yang terlibat langsung dalam penyaluran berwenang mencatat perkembangan statusnya. Jadi, status penyaluran tidak hanya sebagai atribut, tapi juga menggambarkan perkembangan kegiatan di sistem.

<img width="465" height="866" alt="image" src="https://github.com/user-attachments/assets/7bf1dd39-cc5d-4d3d-a049-ab5c1af3b577" />


<br> **11. Proses Hapus Data**
<br> Proses Hapus digunakan Admin saat data tidak lagi dibutuhkan di sistem. Admin memasukkan ID data yang ingin dihapus, lalu program mencari objek berdasarkan ID itu. Jika data ditemukan, program menampilkan detail data dan meminta konfirmasi, sehingga data hanya akan dihapus dari `ArrayList` jika Admin mengonfirmasi dengan `y`. Namun, jika Admin memilih jawaban lain, proses dibatalkan dan data tetap ada. Mekanisme ini memberi lapisan konfirmasi sebelum data dihapus, sehingga pengguna bisa memastikan bahwa data yang dipilih memang merupakan data yang ingin dihapus.

<img width="423" height="792" alt="image" src="https://github.com/user-attachments/assets/1e05ca17-e942-448a-8994-ad6b07a5c845" />
<br> <img width="412" height="288" alt="image" src="https://github.com/user-attachments/assets/b0a3294a-7586-433d-8a2f-2f0528a391e5" />


<br> **12. Kembali dan Keluar dari Program**
<br> Setiap menu di program memiliki pilihan Kembali agar pengguna bisa berpindah ke menu sebelumnya tanpa menutup program. Ketika Admin memilih Kembali, perulangan pada `menuAdmin()` berhenti dan kontrol kembali ke `MenuController`. Hal yang sama berlaku di Menu Petugas. Setelah kembali ke Menu Utama, pengguna bisa memilih peran lain atau memilih Keluar. Jika memilih Keluar, perulangan utama di `MenuController` berhenti dan program menampilkan **pesan penutup**.

<img width="455" height="586" alt="image" src="https://github.com/user-attachments/assets/3c1845af-7604-40e2-9dea-c252202ae540" />

