# Tutorial APAP
## Authors
* **Ryan Dirga Aidil Hakim** - *1906306741* - *A*


---
## Tutorial 7

### Jelaskan apa yang Anda lakukan di latihan dalam satu paragraf per-soal. Berikan screenshot sebagai ilustrasi dari apa yang Anda jelaskan.
Soal 1 bertujuan untuk melakukan delete item dari cart. Sebenarnya cara mengerjakannya sama seperti ketika kita menghandle dalam menambahkan item ke cart, yaitu handleAddItemToCart. Perbedaannya terdapat pada if statement yang mana pada handleDeleteItemFromCart condition-nya adalah targetInd >= 0. Selain itu, kita juga perlu mengubah nilai newItem.inCart menjadi false. Kemudian dilanjutkan dengan melakukan splice (newItems.splice(newItem)).
![Question1](https://user-images.githubusercontent.com/90308675/143254640-a00c85c0-fa7c-4b99-90d8-e97e9a69ead1.png)
![Question1Func](https://user-images.githubusercontent.com/90308675/143254789-41f69276-0995-4626-ab2b-206b17588fb8.png)

Soal 2 bertujuan untuk menyesuaikan balance ketika menambahkan item ke cart maupun menghapus item dari cart. Hal tersebut dilakukan hanya melakukan set terhadap nilai balance. Jika menambahkan item ke dalam cart, maka balance dikurang dengan harga item yang ditambahkan. Sedangkan jika menghapus item dari cart, maka balance ditambah dengan harga item yang ingin dihapus.
![Question2](https://user-images.githubusercontent.com/90308675/143256079-2387775f-e000-4a50-826a-b9c90f55630f.PNG)
![Question2Func](https://user-images.githubusercontent.com/90308675/143256120-5d1b8543-c303-432e-b472-47d6d6a9fdb1.PNG)

Soal 3 bertujuan untuk memberi notifikasi tidak dapat menambahkan item ke dalam cart apabila balance yang dimiliki ternyata tidak cukup. Caranya adalah hanya memodifikasi bagian handleAddItemToCart yang mana kita hanya menambahkan if statement dengan condition harga item yang ditambahkan lebih dari nilai balance saat itu. Jika tidak memenuhi kondisi tersebut, maka akan muncul notifikasi. Cara membuatnya notifikasi adalah dengan menggunakan alert.
![Question3](https://user-images.githubusercontent.com/90308675/143255052-b1774764-f0d1-4f23-9155-44c27ef72e8c.png)

### Menurut pemahaman kamu selama pengerjaan tutorial ini, apa perbedaan antara state dan props?
Dari penggunaannya, sebenarnya state dan props dapat digunakan sekaligus pada component yang sama, tergantung dengan kondisinya saja kapan salah satu tersebut tepat untuk digunakan. State digunakan ketika kita ingin mengolah data yang bersifat internet yang mana hanya berada di dalam component itu sendiri. Sedangkan props digunakan ketika ingin berkomunikasi (melempar data) dengan component lainnya.

### Menurut kamu, apakah sebaiknya kita menggunakan component (e.g. List, Item) dalam React? sebutkan alasannya.
Menurut saya, ada baiknya jika kita menggunakan component karena secara peran, component memiliki peran yang penting dalam pembentukan suatu aplikasi. Selain itu, component juga bersifat re-usable agar ui terpisah menjadi bagian-bagian kecil serta di satukan untuk di render menjadi kode HTML.

### Apa perbedaan class component dan functional component?
Secara struktur kode, functional component terlihat lebih sederhana dibandingkan dengan class component sehingga membuat kita lebih efektif dan efisien dalam implementasi kode. Selain itu, functional component hanya dapat menggunakan props karena functional component biasa digunakan sebagai UI component, sedangkan class component dapat menggunakan state dan props.

### Dalam react, apakah perbedaan component dan element?
Komponen memiliki konsep seperti function pada yang mana ia menerima input yang disebut props serta mengembalikan react element yang menggambarkan apa yang ditampilkan di layer. Sedangkan elemen hanyalah blok bangunan terkecil pada react yang mana menggambarkan apa yang dilihat oleh user di layer mereka.


---
## Tutorial 6

### Jelaskan secara singkat perbedaan Otentikasi dan Otorisasi! Di bagian mana (dalam kode yang telah anda buat) konsep tersebut diimplementasi?
Otentikasi merupakan proses verifikasi pengguna ketika akan mengakses ke suatu sistem. Otentikasi terjadi ketika user memasukkan username dan password. Contoh pada lab ini, yaitu pada file UserDetailService.java serta PageController.java. Sedangkan otorisasi merupakan proses pemberian izin untuk menggunakan resource dengan tujuan keamanan informasi serta keamanan komputer. Hal ini diimplementasikan dengan pembatasan konten yang ingin ditampilkan berdasarkan role atau profil user. Contoh pada lab ini, yaitu pada file WebSecurityConfig.java yang mana berfungsi untuk memjadikan konten tidak ditampilkan untuk semua role.

### Apa itu BCryptPasswordEncoder? Jelaskan secara singkat cara kerja dan tujuannya.
BCryptPasswordEncoder merupakan implementasi dari password encoder menggunakan algoritma BCrypt (one-way hashing). Tujuan dari implementasi tersebut adalah untuk meningkatkan keamanan password. Ketika kode disimpan ke dalam database, kode tersebut akan dibalikkan kepada semula saat melakukan signup yang nanti akan dibandingkan dengan password yang dimasukkan ketika log in apakah sama atau tidak.

### Apakah penyimpanan password sebaiknya menggunakan encryption atau hashing? Mengapa demikian?
Penyimpanan password sebaiknya menggunakan hashing. Hal tersebut dikarenakan hashing bisa dikatakan lebih aman karena kita akan sulit untuk meraih bentuk password semula ketika kita telah mengubah bentuk password ke dalam hash. Lain hal dengan encryption yang mana kita dapat lebih mudah meraih password ke bentuk semula karena encryption menerapkan two-way.

### Jelaskan secara singkat apa itu UUID beserta penggunaannya!
UUID merupakan kumpulan dari 32 character yang disusun secara acak dengan tujuan menjamin bahwa setiap data bersifat unik yang mana sangat kecil kemungkinan terdapat UUID yang sama dengan UUID yang telah di-generate. 

### Apa kegunaan class UserDetailsServiceImpl.java? Mengapa harus ada class tersebut?
Adanya class UserDetailServiceImpl.java bertujuan untuk authentication yang mana username dan password yang dimasukkan oleh user dicek apakah cocok dengan username dan password yang telah tersimpan di database. 



---
## Tutorial 5

### Apa itu Postman? Apa kegunaannya?
Postman merupakan suatu aplikasi yang digunakan untuk melakukan testing terhadap API. Aplikasi ini tentu sangat berguna bagi developer, terutama bagian backend dalam menguji apakah REST API yang telah dibuat sudah sesuai atau belum.

### Jelaskan fungsi dari anotasi @JsonIgnoreProperties dan @JsonProperty.
@JsonIgnoreProperties digunakan dengan tujuan agar data yang ada pada suatu variable tidak dapat dimasukan secara manual. @JsonProperty digunakan dengan tujuan agar ketika objek diserialisasi dengan menggunakan library Jackson, bidang akan memiliki nama tertentu.

### Apa kegunaan atribut WebClient?
Atribut WebClient pada SpringBoot merupakan klien web non-pemblokiran dan reaktif yang mana digunakan untuk melakukan permintaan HTTP dengan menggunakan fitur pada webflux library.

### Apa itu ResponseEntity dan BindingResult? Apa kegunaannya?
ResponseEntity merupakan extention dari HttpEntity yang mewakili HTTP response, termasuk status, header, serta isinya. ResponseEntity memungkinkan kita untuk megubah mengubah respons dengan optional header dan status code. BindingResult adalah suatu interface yang dapat menentukan menentukan bagaimana suatu objek yang menyimpan hasil validasi harus menyimpan serta mengambil hasil validasi tersebut yang mana berisi kesalahan yang mungkin terjadi.



---
## Tutorial 4

### Jelaskan perbedaan th:include dan th:replace!
Secara garis besar th:include dan th:replace mempunyai tugas yang sama. Namun, yang membedakan di antara keduanya adalah th:include menyertakan fragmen ke dalam tag hostnya, sedangkan th:replace mengganti tag host serta menghapus tag host tersebut yang mana akan menambahkan fragmen yang telah ditentukan.

### Jelaskan apa fungsi dari th:object!
th:object berfungsi untuk menampung suatu object yang berasal dari controller.

### Jelaskan perbedaan dari * dan $ pada saat penggunaan th:object! Kapan harus dipakai?
*{} digunakan untuk mendeklarasikan variabel dari controller yang mana hanya akan dieksekusi pada objek yang telah dipilih sebelumnya. Sedangkan ${...} digunakan untuk mendeklarasikan sebuah variable tanpa harus objek tersebut telah dipilih sebelumnya untuk bisa dieksekusi



---
## Tutorial 3

### Tolong jelaskan secara singkat apa kegunaan dari anotasi-anotasi yang ada pada model (@AllArgsConstructor, @NoArgsConstructor, @Setter, @Getter, @Entity, @Table)
@AllArgsConstructor digunakan untuk menghasilkan constructor yang memerlukan argumen pada tiap bidang di annotated class. @NoArgsConstructor digunakan untuk menghasilkan constructor tanpa parameter. @Setter dan @Getter digunakan untuk menghasilkan setter dan getter pada model class sehingga kita tidak perlu lagi mengimplementasikan method mutator dan accessor secara manual. @Entity digunakan untuk menjelaskan bahwa sebuah kelas adalah satu entity dan dipetakan ke dalam database. Sedangkan @Table digunakan untuk sebagai spesifikasi nama tabel di sebuah database yang mana akan dipakai untuk pemetaan.

### Pada class CabangDB, terdapat method findByNoCabang, apakah kegunaan dari method tersebut?
Method tersebut digunakan untuk menyeleksi pencarian entity cabang berdasarkan nomor cabang.  

### Jelaskan perbedaan kegunaan dari anotasi @JoinTable dan @JoinColumn
1. @JoinTable digunakan ketika kita sedang mengelola hubungan antara entity dengan entity di tabel lain, sedangkan @JoinColumn digunakan ketika kita suatu entity memiliki hubungan foreign key dengan entity lainnya.
2. @JoinTable cocok digunakan ketika kita memerlukan database yang dinormalisasi guna mengurangi redundant, sedangkan @JoinColumn cocok digunakan ketika tidak ada keperluan untuk join ke tabel tambahan.

### Pada class PegawaiModel, digunakan anotasi @JoinColumn pada atribut cabang, apa kegunaan dari name, referencedColumnName, dan nullable dalam anotasi tersebut? dan apa perbedaan nullable dan penggunaan anotasi @NotNull
Name merupakan nama dari column. referencedColumnName merupakan nama kolom dari referensi kolom yang memiliki anotasi @JoinColumn. Sedangkan nullable merupakan bisa atau tidaknya null diinput ke dalam kolom yang mana bernilai true atau false. Yang membedakan antara nullable dengan NotNull adalah not null merupakan validasi bean validation yang berperan dalam tidak adanya batas pada null constraint pada entity, sedangkan nullable menyatakan null constraint yang ditaruh di suatu kolom dan adanya batas pada null constraint.

### Jelaskan kegunaan FetchType.LAZY, CascadeType.ALL, dan FetchType.EAGER
Pada FetchType.LAZY, hibernate tidak load semua data, melainkan hanya me-load data yang ada pada child entity sehingga dapat mengurangi kebutuhan memori. Pada CascadeType.ALL, aktivitas PERSIST, REMOVE, REFRESH, MERGE, DETACH dapat dilakukan dan dapat diteruskan kepada child entity. Sedangkan pada FetchType.EAGER, hibernate me-load semua data, termasuk entity induknya sehingga menyebabkan memakan lebih banyak memori dibandingkan dengan LAZY.



---
## Tutorial 2

### Pertanyaan 1: Cobalah untuk menambahkan sebuah Kebun dengan mengakses link berikut setelah menjalankan program: http://localhost:8080/kebun-safari/add?id=1&nama=Papa%20APAP&alamat=Maung%20Fasilkom&noTelepon=081xxx, Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi
Terjadi Whitetable Error Page dengan tipe Internal Server Error dan status=500. Hal tersebut dikarenakan baru me-return add-kebun-safari.html di method addKebunSafari, namun file tersebut belum ada.

### Pertanyaan 2: Menurut kamu anotasi @Autowired pada class Controller tersebut merupakan implementasi dari konsep apa? Dan jelaskan secara singkat cara kerja @Autowired tersebut dalam konteks service dan controller yang telah kamu buat
Autowriting merupakan salah satu implementasi dari spring dependency injection. Autowriting dilakukan dengan anotasi @Autowired sehingga kita tidak perlu lagi menambahkan setter method atau menambahkan parameter pada constructor.

### Pertanyaan 3: Cobalah untuk menambahkan sebuah Kebun dengan mengakses link berikut: http://localhost:8080/kebun-safari/add?id=1&nama=Papa%20APAP&alamat=Maung%20Fasilkom, Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.
Terjadi Whitetable Error Page dengan tipe Bad Request dan status=400. Hal ini disebabkan path yang dijalankan tidak sesuai dengan parameter yang perlu dimasukkan, yaitu user tidak memasukan parameter noTelepon padahal parameter tersebut perlu diisi.

### Pertanyaan 4: Jika Papa APAP ingin melihat Kebun Safari dengan nama Papa APAP, link apa yang harus diakses?
http://localhost:8080/kebun-safari?id=1 karena Papa APAP memiliki id 1.

### Pertanyaan 5: Tambahkan 1 contoh Kebun Safari lainnya sesukamu. Lalu cobalah untuk mengakses http://localhost:8080/ , apa yang akan ditampilkan? Sertakan juga bukti screenshotmu.
Untuk kali ini, saya menambah kebun safari yang mana id=2, nama=Pacil, alamat=Depok, dan noTelepon=01234567890 yang mana saya mengakses :
http://localhost:8080/kebun-safari/add?id=2&nama=Pacil&alamat=Depok&noTelepon=01234567890
![addkebunsafari](https://user-images.githubusercontent.com/90308675/133452835-e0496a88-24d9-43c6-bb13-331261d4fbcf.png)
Sehingga nanti menjadi ada dua kebun safari jika sudah mengakses http://localhost:8080/
![kebunsafarilist](https://user-images.githubusercontent.com/90308675/133452762-a1850a13-11c7-4df3-93fa-57bdf08e2cec.png)



---
## Tutorial 1


# What I have learned today 

Yang telah saya pelajari hari ini adalah mempelajari bagaimana cara membuat repository. Selain itu, di sini juga mengembangkan pengetahuan saya terkait perintah-perintah git seperti git add, git commit, git push, git branch, git checkout, dan lain-lain yang tentu akan sangat bermanfaat untuk ke depannya. Saya juga mempelajari penggunaan IntellijIDEA karena saya baru kali ini menggunakan IDE tersebut. Tak hanya itu, lab ini sekaligus bisa mengingat kembali memori saya terkait Spring Boot yang mana secara dasar telah dipelajari di DDP2.


# Github

### Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?

Issue Tracker merupakan alat pelacak yang telah terintegrasi dengan repository kita yang mana berfokus untuk menyelesaikan tugas-tugas penting agar proyek dapat terselesaikan. Tujuan adanya issue tracker adalah agar memudahkan para collabolator dalam membagi bagian-bagian yang menjadi fokus menjadi tiap-tiap issue sehingga membuat proyek menjadi rapi. Masalah yang dapat diselesaikan dengan issue tracker adalah masalah bug, documentation, enhancement, dan lain-lain.

### Apa perbedaan dari git merge dan git merge --squash?

Git merge dan git merge --squash sebenarnya sama-sama menggabungkan antar beberapa commit ke dalam satu branch. Namun, yang membedakan di antara keduanya adalah pada git merge, branch tetap akan mempertahankan commit tereakhirnya dan hanya merge commit yang muncul. Sedangkan, pada git merge --squash, tidak ada merge commit yang muncul yang mana seluruh perubahan yang ada di main branch dikelompokkan menjadi 1 commit yang bernama squash.

### Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan suatu aplikasi?
- VSC tentu akan membantu para developer dalam mengelola perubahan-perubahan yang terjadi pada software yang dikerjakan
- VSC menyimpan riwayat perubahan-perubahan pada source code sehingga memudahkan para developer untuk mengetahui kesalahan program yang mereka kerjakan
- VSC dapat mencegah terjadinya kerusakan pada source code akibat terjadinya konflik ketika developer ingin push program yang telah dibuat atau diubah


# Spring

### Apa itu library & dependency?
Pada Spring, library merupakan kumpulan dari fungsi dan program yang dapat langsung digunakan oleh programmer dalam mengembangkan aplikasi. Selain itu, dependency merupakan aspek dasar dari Spring yang mana wadah Spring menyunt mendasar dari kerangka Spring , di mana wadah Spring "menyuntikkan" dari objek menuju objek lainnya. 

### Apa itu Maven? Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven?
Maven merupakan salah satu build tool yang biasa digunakan dalam mengembangkan aplikasi dengan bahasa Java yang mana menggunakan konsep Project Object Model (POM). Ada beberapa alasan mengapa kita menggunakan Maven. Pertama, maven dapat digunakan di IDE mana saja dikarenakan maven membuat struktur proyek sendiri. Selain itu, maven juga mudah digunakan dalam hal mengelola dependency yang mana kita dapat hanya definisikan saja di POM.xml sehingga file-file jar yang dibutuhkan akan otomatis terunduh. Untuk proyek aplikasi berbasis Java, sebenarnya bisa menggunakan selain maven, yaitu gradle dan ant.

### Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring framework?
Spring framework tentu tidak hanya dapat digunakan untuk mengembangkan web, namun juga dapat digunakan untuk mengembangkan aplikasi keamanan, big data, game, dan masih banyak lagi.

### Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya menggunakan @RequestParam atau @PathVariable?
Pada dasarnya, @RequestParam dan @PathVariable sama-sama digunakan untuk megekstrak nilai dari HTTP Request. Yang menyebabkan perbedaan serta kapan masing-masing anotasi tersebut digunakan adalah @RequestParam digunakan untuk mendapat parameter request URL, sedangkan @PathVariable digunakan untuk mengekstrak request URI. 


# What I did not understand

Saya sebenarnya masih belum terlalu mengerti terkait anotasi-anotasi yang digunakan serta beberapa hal di html file seperti th:text, th:if dan lainnya. Mungkin karena saya belum terlalu familiar dengan proyek web yang menggunakan bahasa Java. Selain itu, saya sudah memahami materi lainnya, termasuk yang telah dibahas di kelas.
