import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DataPraktikan {
    private HashMap<String, String> tabelData;
    private String currentUser;

    public DataPraktikan() {
        tabelData = new HashMap<String, String>();
        currentUser = "";
    }

    public void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        if (username.equals("alfa@webmail.umm.ac.id") && password.equals("2021")) {
            currentUser = username;
            System.out.println("Login berhasil.");
        } else {
            System.out.println("Login gagal.");
        }
    }


    public void tambahData(String nim, String namaAsisten) {

        if (tabelData.containsKey(nim)) {
            System.out.println("Data dengan NIM " + nim + " sudah ada.");
            return;
        }
        tabelData.put(nim, namaAsisten);
        System.out.println("Data berhasil ditambahkan.");
    }

    public void hapusData(String nim) {

        if (tabelData.containsKey(nim)) {
            tabelData.remove(nim);
            System.out.println("Data berhasil dihapus.");
        } else {
            System.out.println("Data dengan NIM " + nim + " tidak ditemukan.");
        }
    }

    public void ubahData(String nim, String namaAsisten) {

        if (!tabelData.containsKey(nim)) {
            System.out.println("Data dengan NIM " + nim + " tidak ditemukan.");
            return;
        }
        tabelData.put(nim, namaAsisten);
        System.out.println("Data berhasil diubah.");
    }

    public void tampilkanData() {

        if (tabelData.isEmpty()) {
            System.out.println("Tidak ada data praktikan.");
            return;
        }
        System.out.println("Daftar Data Praktikan:");
        for (Map.Entry<String, String> entry : tabelData.entrySet()) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
    }

    public void searchByAsisten() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan nama asisten: ");
        String namaAsisten = scanner.nextLine();
        boolean found = false;
        System.out.println("Daftar NIM Praktikan dengan Nama Asisten " + namaAsisten + ":");
        for (Map.Entry<String, String> entry : tabelData.entrySet()) {
            if (entry.getValue().equals(namaAsisten)) {
                System.out.println(entry.getKey());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Tidak ditemukan NIM praktikan dengan Nama Asisten " + namaAsisten + ".");
        }
    }

    public static void main(String[] args) {
        DataPraktikan dataPraktikan = new DataPraktikan();
        Scanner scanner = new Scanner(System.in);
        int pilihan = 0;
        while (pilihan != 8) {
            System.out.println("Menu:");
            System.out.println("1. Login");
            System.out.println("2. Logout");
            System.out.println("3. Tambah Data Praktikan");
            System.out.println("4. Hapus Data Praktikan");
            System.out.println("5. Ubah Data Praktikan");
            System.out.println("6. Tampilkan Data Praktikan");
            System.out.println("7. Search NIM Praktikan by Nama Asisten");
            System.out.println("8. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();
            switch (pilihan) {
                case 1:
                    dataPraktikan.login();
                    break;
                case 3:
                    System.out.print("Masukkan NIM\t\t  : ");
                    String nim = scanner.nextLine();
                    System.out.print("Masukkan Nama Asisten : ");
                    String namaAsisten = scanner.nextLine();
                    dataPraktikan.tambahData(nim, namaAsisten);
                    break;
                case 4:
                    System.out.print("Masukkan NIM : ");
                    nim = scanner.nextLine();
                    dataPraktikan.hapusData(nim);
                    break;
                case 5:
                    System.out.print("Masukkan NIM\t: ");
                    nim = scanner.nextLine();
                    System.out.print("Masukkan Nama Asisten: ");
                    namaAsisten = scanner.nextLine();
                    dataPraktikan.ubahData(nim, namaAsisten);
                    break;
                case 6:
                    dataPraktikan.tampilkanData();
                    break;
                case 7:
                    dataPraktikan.searchByAsisten();
                    break;
                case 8:
                    System.out.println("Terima kasih.");
                    break;
                default:
                    System.out.println("Menu tidak tersedia.");
                    break;
            }
            System.out.println();
        }
    }
}
