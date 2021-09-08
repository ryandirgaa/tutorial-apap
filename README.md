# Tutorial APAP
## Authors
* **Ryan Dirga Aidil Hakim** - *1906306741* - *A*

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
