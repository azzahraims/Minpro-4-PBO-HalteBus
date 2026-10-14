
# Sistem Manajemen Halte Bus ˚ ༘ 🚍⋆｡˚

Az-Zahra Imsawati Sugianto - 2509116062

---

## Deskripsi Singkat Program

Sistem Manajemen Halte Bus merupakan program berbasis Java yang digunakan oleh admin untuk mengelola data halte bus. Program ini merupakan pengembangan dari Mini Project 3 dengan mempertahankan konsep polymorphism, abstraction, serta struktur MVC (Model-View-Controller), dan menambahkan integrasi database menggunakan JDBC, PreparedStatement, serta DAO.

Program menyediakan fitur CRUD (Create, Read, Update, Delete) yang terdiri dari menambah, melihat, mengubah, dan menghapus data halte. Pada Mini Project 4, data halte disimpan menggunakan database MySQL, sedangkan `ArrayList` digunakan untuk menampung hasil pembacaan data sementara.

Pada program terdapat dua jenis halte, yaitu Halte Reguler dan Halte Transit. Halte Reguler memiliki data khusus berupa titik tujuan, sedangkan Halte Transit memiliki data khusus berupa rute penghubung.

ID halte dibuat secara otomatis oleh sistem dengan urutan H001, H002, H003, dan seterusnya sehingga admin tidak perlu memasukkan ID secara manual.

Program juga menyediakan tiga dummy data awal yang dimasukkan melalui file SQL, sehingga data dapat langsung ditampilkan tanpa perlu melakukan input terlebih dahulu.

---

## Struktur Package

Program menerapkan struktur MVC dengan memisahkan class ke dalam beberapa package sesuai dengan fungsinya. Pada Mini Project 4 ditambahkan package `config` dan `dao` untuk mendukung integrasi database.

<img width="240" height="275" alt="image" src="https://github.com/user-attachments/assets/fada6e39-36b6-4e61-b1e6-6c3427100f60" />

- **Model** berisi `Halte`, `HalteReguler`, `HalteTransit`, dan `InformasiHalte`. Package ini digunakan untuk membentuk dan menyimpan struktur data halte.
- **View** berisi `HalteView` yang digunakan untuk menampilkan menu serta menerima input dari pengguna.
- **Controller** berisi `HalteController` yang digunakan untuk mengatur proses pengelolaan data halte dan memanggil DAO.
- **Util** berisi `InputValidator` yang digunakan untuk membantu proses validasi input.
- **Main** berisi `Main` yang berdiri sendiri sebagai entry point untuk menjalankan program.
- **Config** berisi `KoneksiDatabase` untuk menghubungkan program Java dengan database MySQL dan `TestKoneksi` untuk menguji koneksi database.
- **DAO** berisi `HalteDAO` yang digunakan untuk menjalankan operasi CRUD menggunakan JDBC dan PreparedStatement.

Pemisahan tersebut membuat setiap bagian program memiliki fungsi dan tanggung jawab yang lebih terorganisir.

---

## Alur Program

Saat program dijalankan, `Main` akan menjalankan `HalteView` untuk menampilkan menu utama. Menu utama terdiri dari:

1. **Tambah Halte:** Admin dapat menambahkan data dengan memilih Halte Reguler atau Halte Transit. Sistem akan memeriksa nama dan lokasi halte untuk mencegah data yang sama. ID halte dibuat secara otomatis sebelum data disimpan ke dalam database MySQL.
2. **Lihat Data Halte:** Admin dapat melihat seluruh data halte yang tersimpan di database. Program memiliki tiga dummy data awal yang terdiri dari dua Halte Reguler dan satu Halte Transit.
3. **Ubah Data Halte:** Admin memasukkan ID halte yang ingin diubah. Sistem akan mencari halte berdasarkan ID tersebut. Jika ditemukan, admin dapat memasukkan data baru yang kemudian diperbarui di database.
4. **Hapus Halte:** Admin memasukkan ID halte yang ingin dihapus. Sistem akan mencari data berdasarkan ID dan menghapusnya dari database apabila ditemukan.
5. **Keluar:** Admin dapat memilih menu keluar untuk mengakhiri program.

Setelah proses pada menu selesai dilakukan, program akan kembali menampilkan menu utama sampai admin memilih menu Keluar.

Pada Mini Project 4, alur pengelolaan data melibatkan DAO sebagai penghubung antara Controller dengan database MySQL.

**Main → View → Controller → DAO → Database MySQL**

<img width="239" height="103" alt="image" src="https://github.com/user-attachments/assets/a8719c68-515a-42de-9e54-606cfd36ba3c" />


---

## Penerapan Encapsulation

Encapsulation diterapkan pada class `Halte`, `HalteReguler`, dan `HalteTransit`. Atribut pada setiap class menggunakan access modifier `private` sehingga tidak dapat diakses secara langsung dari luar class.

Akses dan perubahan nilai atribut dilakukan melalui method getter dan setter. Setter pada program juga dilengkapi dengan validasi terhadap nilai yang diberikan.

<table align="center">
  <tr>
    <td align="center" valign="middle">
      <img width="380" alt="image" src="https://github.com/user-attachments/assets/5c3753f1-8975-49d1-b6d2-d576dec49867" />
    </td>
    <td align="center" valign="middle">
      <img width="380" alt="image" src="https://github.com/user-attachments/assets/d325eaaf-8939-459a-9519-bb09f7cfbd14" />
    </td>
  </tr>
</table>

Pada class `Halte`, atribut `idHalte` juga menggunakan keyword `final`.

`final` digunakan agar ID halte tidak dapat diubah setelah objek dibuat. Oleh karena itu, `idHalte` hanya memiliki getter dan tidak memiliki setter.

---

## Penerapan Inheritance

Inheritance diterapkan dengan menjadikan abstract class `Halte` sebagai superclass, sedangkan `HalteReguler` dan `HalteTransit` sebagai subclass.

Class `HalteReguler` dan `HalteTransit` menggunakan `extends Halte` sehingga dapat mewarisi atribut dan method yang dimiliki oleh superclass.

<table align="center">
  <tr>
    <td align="center"><b>Halte Reguler</b></td>
    <td align="center"><b>Halte Transit</b></td>
  </tr>
  <tr>
    <td align="center" valign="middle">
      <img width="442" alt="Halte Reguler" src="https://github.com/user-attachments/assets/7010916f-63fa-4999-8c0d-03b4c8e73e92" />
    </td>
    <td align="center" valign="middle">
      <img width="437" alt="Halte Transit" src="https://github.com/user-attachments/assets/0b58dc66-4b8d-42a8-8468-b407e03a5d9c" />
    </td>
  </tr>
</table>

`HalteReguler` memiliki atribut tambahan `titikTujuan`, sedangkan `HalteTransit` memiliki atribut tambahan `rutePenghubung`.

Constructor pada kedua subclass menggunakan `super()` untuk memanggil constructor dari superclass `Halte`.

---

## Penerapan Polymorphism

Polymorphism pada program diterapkan melalui method overriding dan method overloading.

### Method Overriding

Method overriding diterapkan pada method `tampilkanInfo()` dan `tampilkanJenisHalte()`.

Method tersebut diterapkan kembali pada `HalteReguler` dan `HalteTransit` sehingga masing-masing jenis halte dapat menampilkan informasi sesuai dengan karakteristiknya.

<img width="343" height="153" alt="image" src="https://github.com/user-attachments/assets/ed791b04-e241-48a7-8adc-deb84d18cccc" />

Pada `HalteReguler`, method `tampilkanInfo()` menampilkan informasi tambahan berupa titik tujuan.

<img width="374" height="142" alt="image" src="https://github.com/user-attachments/assets/69e26512-0718-456d-acab-a1f9f0645d31" />

Pada `HalteTransit`, method `tampilkanInfo()` menampilkan informasi tambahan berupa rute penghubung.

Dengan method overriding, pemanggilan method yang sama dapat menghasilkan informasi yang berbeda sesuai dengan jenis objek halte.

### Method Overloading

Method overloading diterapkan pada method `cariHalte()` di dalam `HalteController`.

<img width="404" height="278" alt="image" src="https://github.com/user-attachments/assets/b039a843-e91f-4f06-b07a-93b4d8761db6" />

Method `cariHalte()` pertama menerima satu parameter berupa ID halte dan digunakan pada proses ubah serta hapus data.

Method `cariHalte()` kedua menerima dua parameter berupa nama dan lokasi halte. Method ini digunakan pada proses penambahan data untuk memeriksa apakah halte dengan nama dan lokasi yang sama sudah tersedia.

Kedua method memiliki nama yang sama tetapi menggunakan parameter yang berbeda sehingga merupakan penerapan method overloading.

---

## Penerapan Abstraction

Abstraction diterapkan dengan menjadikan class `Halte` sebagai abstract class.

<img width="344" alt="image" src="https://github.com/user-attachments/assets/bfba3a01-9f46-42cd-984e-7929aa390a06" />

<img width="272" alt="image" src="https://github.com/user-attachments/assets/3bfd8a96-eb27-460a-998c-e184714ad2f4" />

Abstract class `Halte` menyimpan atribut dan method umum yang dimiliki oleh Halte Reguler dan Halte Transit. Objek tidak dibuat secara langsung dari class `Halte`, tetapi melalui subclass `HalteReguler` atau `HalteTransit`.

Pada class `Halte` juga terdapat abstract method:

`public abstract void tampilkanJenisHalte();`

Abstract method tersebut belum memiliki implementasi pada class `Halte`. Implementasinya diberikan oleh `HalteReguler` dan `HalteTransit` sesuai dengan jenis haltenya.

### Penerapan Interface

Interface `InformasiHalte` juga digunakan sebagai bagian dari penerapan abstraction pada program.

<img width="217" height="46" alt="image" src="https://github.com/user-attachments/assets/73b86d9c-d900-40d7-93a8-0a605ad889d2" />

Interface `InformasiHalte` memiliki method `tampilkanInfo()` dan digunakan sebagai kontrak untuk menampilkan informasi halte.

Interface tersebut diterapkan pada abstract class `Halte` menggunakan `implements InformasiHalte`.

<img width="348" height="20" alt="image" src="https://github.com/user-attachments/assets/952846a4-e4ed-481b-99a4-47d6f6ed6535" />

Method `tampilkanInfo()` kemudian dapat digunakan dan di-override kembali oleh `HalteReguler` dan `HalteTransit` untuk menampilkan informasi sesuai dengan jenis haltenya.

---

## Penerapan JDBC

Pada Mini Project 4, program dikembangkan dengan menghubungkan Java ke database MySQL menggunakan JDBC (Java Database Connectivity). Implementasi JDBC terdapat pada package `config` dan `dao`.

### 1. Koneksi Database

Class `KoneksiDatabase.java` digunakan untuk menghubungkan program Java dengan database MySQL melalui JDBC.

Class ini menggunakan `Connection`, `DriverManager`, dan `SQLException`. Koneksi dibuat melalui method `getConnection()` dengan menggunakan URL database, username, dan password MySQL.

<img width="427" height="158" alt="image" src="https://github.com/user-attachments/assets/537c9b5e-8d77-438b-bed6-cfe418de9d8d" />


### 2. PreparedStatement

PreparedStatement digunakan untuk menjalankan perintah SQL dengan parameter `?` yang kemudian diisi melalui method `setString()` dan `setInt()`.

Penerapannya terdapat pada `HalteDAO.java`, salah satunya dalam method `tambahHalte()` yang menjalankan query `INSERT INTO` untuk menyimpan data halte.

<img width="746" height="306" alt="image" src="https://github.com/user-attachments/assets/e9cd0d4a-4045-44a5-b766-d928464e6f76" />


Penggunaan PreparedStatement memisahkan data input pengguna dari perintah SQL sehingga membantu mengurangi risiko SQL Injection.

### 3. Data Access Object (DAO)

DAO diterapkan melalui class `HalteDAO.java` yang digunakan untuk memisahkan proses pengelolaan database dari View dan Controller.

Class `HalteDAO` menangani operasi CRUD menggunakan JDBC dan PreparedStatement, yaitu:

- **CREATE:** Method `tambahHalte()` digunakan untuk menambahkan data halte ke database menggunakan query INSERT INTO.
- **READ:** Method `ambilSemuaHalte()` digunakan untuk mengambil seluruh data halte, sedangkan `cariHalte()` digunakan untuk mencari data berdasarkan ID atau nama dan lokasi.
- **UPDATE:** Method `ubahHalte()` digunakan untuk memperbarui data halte berdasarkan ID menggunakan query UPDATE.
- **DELETE:** Method `hapusHalte()` digunakan untuk menghapus data halte berdasarkan ID menggunakan query DELETE.

Selain itu, terdapat method `nomorIdBerikutnya()` untuk menentukan nomor ID halte berikutnya dan `buatObjekHalte()` untuk mengubah hasil pembacaan database menjadi objek Halte Reguler atau Halte Transit.


### 4. Tes Koneksi Database

Class `TesKoneksi.java` digunakan untuk menguji apakah program Java berhasil terhubung dengan database MySQL.

Pengujian dilakukan secara terpisah melalui method `main()` pada `TestKoneksi`, tanpa harus menjalankan menu utama Sistem Manajemen Halte Bus.

<img width="496" height="278" alt="image" src="https://github.com/user-attachments/assets/e3ce5a31-d7c3-4b81-8bd3-5252795d7f3e" />


<img width="542" height="282" alt="image" src="https://github.com/user-attachments/assets/3e28bb5c-6f80-46b4-8460-6b209d2ba18b" />


Hasil pengujian menunjukkan bahwa koneksi antara program Java dengan database MySQL telah berhasil.

---

## Database dan Dummy Data

Program menggunakan database MySQL melalui Laragon dengan nama `manajemen_halte_bus`.

Database memiliki tabel `halte` yang terdiri dari beberapa kolom:

<img width="594" height="174" alt="image" src="https://github.com/user-attachments/assets/613b7194-710a-4669-abd9-3abff3f10de1" />

Kolom `detail_halte` digunakan untuk menyimpan titik tujuan bagi Halte Reguler atau rute penghubung bagi Halte Transit.

### Dummy Data Awal

Data awal program dimasukkan melalui file `database_halte.sql`, bukan melalui kode Java.

Program memiliki tiga dummy data awal:

<img width="650" height="95" alt="Screenshot 2026-10-15 055939" src="https://github.com/user-attachments/assets/b6b89a35-5515-44e7-843b-121ed82a49bb" />


Dengan adanya data awal tersebut, menu Lihat Data Halte dapat langsung menampilkan informasi halte tanpa harus melakukan input dari awal.

Data disimpan dalam MySQL sehingga tetap tersedia meskipun program ditutup dan dijalankan kembali.

---

## Cara Menjalankan Program

1. Jalankan Laragon dan aktifkan MySQL.
2. Jalankan file `database_halte.sql` melalui HeidiSQL untuk membuat database, tabel, dan tiga dummy data awal.
3. Buka project melalui Apache NetBeans.
4. Pastikan dependency MySQL Connector/J tersedia pada file `pom.xml`.
5. Sesuaikan pengaturan koneksi di `KoneksiDatabase.java` jika diperlukan.
6. Jalankan `TestKoneksi.java` melalui Run File untuk menguji koneksi database.
7. Jalankan `Main.java` untuk membuka Sistem Manajemen Halte Bus.
8. Pilih menu yang tersedia untuk mengelola data halte.

---

## Dokumentasi Program

### Menu Utama

<img width="199" height="131" alt="Screenshot 2026-10-08 005821" src="https://github.com/user-attachments/assets/5169711a-7c74-41f7-8d28-ff66a4eb4897" />

Menu Utama menampilkan lima pilihan yang dapat digunakan admin untuk mengelola data halte, yaitu tambah, lihat, ubah, hapus data halte, serta keluar dari program.

### Tambah Halte

Pada menu Tambah Halte, admin dapat memilih dua jenis halte, yaitu Halte Reguler dan Halte Transit.

#### Halte Reguler

<img width="233" height="189" alt="image" src="https://github.com/user-attachments/assets/d3e24673-85a6-4e94-8abc-2724c358e871" />


Halte Reguler dipilih dengan memasukkan pilihan 1. Admin mengisi nama halte, lokasi, kapasitas, rute bus, serta titik tujuan. ID halte dibuat secara otomatis oleh sistem setelah data berhasil ditambahkan.

#### Halte Transit

<img width="214" height="179" alt="image" src="https://github.com/user-attachments/assets/6f00decb-47be-43ec-bb6b-2eb488315ff8" />


Halte Transit dipilih dengan memasukkan pilihan 2. Admin mengisi nama halte, lokasi, kapasitas, rute bus, serta rute penghubung. ID halte juga dibuat secara otomatis oleh sistem.

### Lihat Data Halte

<img width="124" height="354" alt="image" src="https://github.com/user-attachments/assets/6e784de8-156a-488a-b19d-56db59477128" />

Menu Lihat Data Halte menampilkan seluruh data halte yang diperoleh dari database MySQL dan ditampung sementara dalam `ArrayList`. Informasi yang ditampilkan menyesuaikan jenis halte, termasuk titik tujuan pada Halte Reguler dan rute penghubung pada Halte Transit.

### Ubah Data Halte

<img width="200" height="243" alt="image" src="https://github.com/user-attachments/assets/f6601655-4e78-4674-a4b6-9edc130b090d" />

Menu Ubah Data Halte digunakan untuk memperbarui data berdasarkan ID halte. Setelah data ditemukan, admin dapat memasukkan data baru untuk memperbarui informasi halte. Pada Mini Project 4, perubahan data disimpan melalui DAO ke database MySQL.

### Hapus Halte

<img width="188" height="69" alt="image" src="https://github.com/user-attachments/assets/c048bc0e-4b0a-4fbb-a287-57e1032d9dae" />

Menu Hapus Halte digunakan untuk menghapus data berdasarkan ID halte. Jika data dengan ID tersebut ditemukan, data akan dihapus dari database menggunakan DAO.

### Keluar

<img width="305" height="113" alt="image" src="https://github.com/user-attachments/assets/1180a5e1-f34d-4da0-8c8e-a6d2ba4d6210" />

Menu Keluar digunakan untuk mengakhiri program. Setelah menu dipilih, sistem menampilkan pesan penutup dan program berhenti.

---
