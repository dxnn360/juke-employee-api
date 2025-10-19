# Employee API

RESTful API untuk manajemen data karyawan yang dibuild menggunakan Java Spring Boot.

## Software dan Tools yang diperlukan

Berikut adalah tools dan minimum versi yang digunakan dalam API ini:

| Tool         | Versi Minimum | Keterangan                    |
|--------------|---------------|-------------------------------|
| **Java JDK** | 17+           | Untuk menjalankan Spring Boot |
| **Maven**    | 3.8+          | Untuk build project           |
| **Docker**   | 28.5.1        | Untuk menjalankan container   |

---

## Cara Menjalankan Project
### 1. Clone Repository

```bash
git clone https://github.com/dxnn360/juke-employee-api
cd employee-api
```

### 2. Build Program

Pastikan file `pom.xml` sudah tersedia, lalu jalankan:

```bash
mvn clean package -DskipTests
```

command ini akan menghasilkan file:
```
target/employee-api-0.0.1-SNAPSHOT.jar
```

### 3. Jalankan Menggunakan Docker Compose

```bash
docker compose up --build -d
```

Docker akan membuild dan menjalankan 2 container yakni:
- MySQL container
- employee-api-container

### 4. Cek Container yang Berjalan

```bash
docker ps
```

Pastikan hasilnya seperti ini untuk melihat apakah container sudah benar-benar berjalan:
```
CONTAINER ID   IMAGE                       PORTS
xxxxxx         employee-api-employee-api   0.0.0.0:8080->8080/tcp
xxxxxx         mysql:latest                0.0.0.0:3307->3306/tcp
```

### 5. Akses API

Setelah semua berjalan, buka [browser](http://localhost:8080/swagger-ui/index.html) atau Postman untuk mengujicoba API:

| Endpoint                                   | Method  | Deskripsi                 |
|--------------------------------------------|---------|---------------------------|
| `http://localhost:8080/api/employees`      | GET     | Ambil semua data karyawan |
| `http://localhost:8080/api/employees/{id}` | GET     | Ambil data berdasarkan ID |
| `http://localhost:8080/api/employees`      | POST    | Tambah data karyawan      | 
| `http://localhost:8080/api/employees/{id}` | PUT     | Ubah data karyawan        |
| `http://localhost:8080/api/employees/{id}` | DELETE  | Hapus data karyawan       |

---

### 6. Melihat Log

Untuk melihat log container API:
```bash
docker logs -f employee-api-container
```

Atau simpan log ke file untuk mempermudah debugging:
```bash
docker logs employee-api-container > logs.txt
```


### 7. Menghentikan Container

```bash
docker compose down
```

command ini akan menghentikan semua container yang sedang berjalan.

Untuk mengecek apakah container benar-benar sudah berhenti atau belum gunakan command:

```bash
docker ps
```
Jika tidak ada container yang muncul berarti container sudah berhasil dihentikan


## Author

Dxnn – 2025  


