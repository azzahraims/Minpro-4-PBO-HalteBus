# Sistem Manajemen Halte Bus ˚ ༘ 🚍⋆｡˚

Az-Zahra Imsawati Sugianto - 2509116062

---

## Deskripsi Singkat Program

Sistem Manajemen Halte Bus merupakan program berbasis Java yang digunakan oleh admin untuk mengelola data halte bus. Program ini merupakan pengembangan dari Mini Project 2 dengan menerapkan konsep polymorphism, abstraction, serta struktur MVC (Model-View-Controller).

Program menyediakan fitur CRUD (Create, Read, Update, Delete) yang terdiri dari menambah, melihat, mengubah, dan menghapus data halte. Data halte disimpan menggunakan ArrayList.

Pada program terdapat dua jenis halte, yaitu Halte Reguler dan Halte Transit. Halte Reguler memiliki data khusus berupa titik tujuan, sedangkan Halte Transit memiliki data khusus berupa rute penghubung.

ID halte dibuat secara otomatis oleh sistem dengan urutan H001, H002, H003, dan seterusnya sehingga admin tidak perlu memasukkan ID secara manual.

---

## Struktur Package

Program menerapkan struktur MVC dengan memisahkan class ke dalam beberapa package sesuai dengan fungsinya.

<p align="center">
  <img width="220" height="276" alt="image" src="https://github.com/user-attachments/assets/9f448fed-ad31-4170-99c9-707a054d59fc" />
</p>

- **Model** berisi `Halte`, `HalteReguler`, `HalteTransit`, dan `InformasiHalte`. Package ini digunakan untuk membentuk dan menyimpan struktur data halte.
- **View** berisi `HalteView` yang digunakan untuk menampilkan menu serta menerima input dari pengguna.
- **Controller** berisi `HalteController` yang digunakan untuk mengatur proses pengelolaan data halte.
- **Util** berisi `InputValidator` yang digunakan untuk membantu proses validasi input.
- **Main** berisi `Main` yang berdiri sendiri sebagai entry point untuk menjalankan program.

Pemisahan tersebut membuat setiap bagian program memiliki fungsi dan tanggung jawab yang lebih terorganisir.

---

## Alur Program

Saat program dijalankan, `Main` akan menjalankan `HalteView` untuk menampilkan menu utama. Menu utama terdiri dari:

1. **Tambah Halte:** Admin dapat menambahkan data dengan memilih Halte Reguler atau Halte Transit. Sistem akan memeriksa nama dan lokasi halte untuk mencegah data yang sama. ID halte dibuat secara otomatis sebelum data disimpan ke dalam `ArrayList`.
2. **Lihat Data Halte:** Admin dapat melihat seluruh data halte yang tersimpan. Program memiliki dua dummy data awal, yaitu Halte Reguler dan Halte Transit.
3. **Ubah Data Halte:** Admin memasukkan ID halte yang ingin diubah. Sistem akan mencari halte berdasarkan ID tersebut. Jika ditemukan, admin dapat memasukkan data baru.
4. **Hapus Halte:** Admin memasukkan ID halte yang ingin dihapus. Sistem akan mencari data berdasarkan ID dan menghapusnya apabila ditemukan.
5. **Keluar:** Admin dapat memilih menu keluar untuk mengakhiri program.

Setelah proses pada menu selesai dilakukan, program akan kembali menampilkan menu utama sampai admin memilih menu Keluar.

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
</p>

  <img width="272" alt="image" src="https://github.com/user-attachments/assets/3bfd8a96-eb27-460a-998c-e184714ad2f4" />
</p>

Abstract class `Halte` menyimpan atribut dan method umum yang dimiliki oleh Halte Reguler dan Halte Transit. Objek tidak dibuat secara langsung dari class `Halte`, tetapi melalui subclass `HalteReguler` atau `HalteTransit`.

Pada class `Halte` juga terdapat abstract method:

`public abstract void tampilkanJenisHalte();`

Abstract method tersebut belum memiliki implementasi pada class `Halte`. Implementasinya diberikan oleh `HalteReguler` dan `HalteTransit` sesuai dengan jenis haltenya.

---

## ⭐ Penerapan Nilai Tambah

### Interface

Nilai tambah pada program diterapkan menggunakan interface `InformasiHalte`.

<img width="217" height="46" alt="image" src="https://github.com/user-attachments/assets/73b86d9c-d900-40d7-93a8-0a605ad889d2" />

Interface `InformasiHalte` memiliki method `tampilkanInfo()` dan digunakan sebagai kontrak untuk menampilkan informasi halte.

Interface tersebut diterapkan pada abstract class `Halte` menggunakan `implements InformasiHalte`.

<img width="348" height="20" alt="image" src="https://github.com/user-attachments/assets/952846a4-e4ed-481b-99a4-47d6f6ed6535" />

Method `tampilkanInfo()` kemudian dapat digunakan dan di-override kembali oleh `HalteReguler` dan `HalteTransit` untuk menampilkan informasi sesuai dengan jenis haltenya.

---

## Dokumentasi Program

### Menu Utama

<img width="199" height="131" alt="Screenshot 2026-10-08 005821" src="https://github.com/user-attachments/assets/5169711a-7c74-41f7-8d28-ff66a4eb4897" />

Menu Utama menampilkan lima pilihan yang dapat digunakan admin untuk mengelola data halte, yaitu tambah, lihat, ubah, hapus data halte, serta keluar dari program.

### Tambah Halte

Pada menu Tambah Halte, admin dapat memilih dua jenis halte, yaitu Halte Reguler dan Halte Transit.

#### Halte Reguler

<img width="221" height="179" alt="image" src="https://github.com/user-attachments/assets/317df7c7-87a6-49bc-a66c-281a51ef0ef2" />

Halte Reguler dipilih dengan memasukkan pilihan 1. Admin mengisi nama halte, lokasi, kapasitas, rute bus, serta titik tujuan. ID halte dibuat secara otomatis oleh sistem setelah data berhasil ditambahkan.

#### Halte Transit

<img width="235" height="178" alt="image" src="https://github.com/user-attachments/assets/71fc1c64-5455-43f3-9656-2d430fe8172b" />

Halte Transit dipilih dengan memasukkan pilihan 2. Admin mengisi nama halte, lokasi, kapasitas, rute bus, serta rute penghubung. ID halte juga dibuat secara otomatis oleh sistem.

### Lihat Data Halte

<img width="217" height="346" alt="image" src="https://github.com/user-attachments/assets/f2f7c987-36e8-4ac8-b717-d8508fb03361" />

Menu Lihat Data Halte menampilkan seluruh data halte yang tersimpan di dalam `ArrayList`. Informasi yang ditampilkan menyesuaikan jenis halte, termasuk titik tujuan pada Halte Reguler dan rute penghubung pada Halte Transit.

### Ubah Data Halte

<img width="236" height="236" alt="image" src="https://github.com/user-attachments/assets/faf8b7f5-6bcc-41ab-8ef7-a4648052fd5d" />

Menu Ubah Data Halte digunakan untuk memperbarui data berdasarkan ID halte. Setelah data ditemukan, admin dapat memasukkan data baru untuk memperbarui informasi halte.

### Hapus Halte

<img width="163" height="73" alt="image" src="https://github.com/user-attachments/assets/dc2e9319-c2ad-4532-98ff-a8aefe49f584" />

Menu Hapus Halte digunakan untuk menghapus data berdasarkan ID halte. Jika data dengan ID tersebut ditemukan, data akan dihapus dari `ArrayList`.

### Keluar

<img width="325" height="44" alt="image" src="https://github.com/user-attachments/assets/90020c80-fff5-40f5-b37e-55e2fe0da21f" />


Menu Keluar digunakan untuk mengakhiri program. Setelah menu dipilih, sistem menampilkan pesan penutup dan program berhenti.
