package modul4;

import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

class DataPraktikan {
    static HashMap<String, String> TabelData = new HashMap<>();
    static HashMap<String, String> TabelSesiLogin = new HashMap<>();
    static HashSet<String> DataAsisten = new HashSet<>();
    static Scanner input = new Scanner(System.in);
    static int cek;
    static boolean error, loop;

    public static void main(String[] args) {
        String inputEmail, inputPass;
        TabelSesiLogin.put("alfa@umm.ac.id","alfa");
        System.out.print("\n");

        do {
            error = false;
            System.out.println();
            System.out.print("Email\t\t: ");
            inputEmail = input.nextLine();
            System.out.print("Password\t: ");
            inputPass = input.nextLine();

            login(inputEmail,inputPass);

        } while (error);
        System.err.println("Data tidak ada");
        input.close();
    }

    public static void menu(){
        while (true){
            String Nim = null, Asisten;
            System.out.print("Menu\n"
                    + "1. Tambahkan Data\n"
                    + "2. List Semua Data\n"
                    + "3. List NIM Terdaftar\n"
                    + "4. List Nama Asisten\n"
                    + "5. Total Data\n"
                    + "6. Hapus Data\n"
                    + "7. Edit Data\n"
                    + "8. Search Data\n"
                    + "9. Keluar\n"
                    + "Pilih\t: \n");

            cek = input.nextInt();
            input.nextLine();
            System.out.println();

            if (cek == 1){
                System.out.println("Tambah Data");
                System.out.println("Masukkan NIM Praktikan : ");
                Nim = input.nextLine();
                System.out.println("Masukkan Nama Asisten : ");
                Asisten = input.nextLine();
                System.out.println();
                TambahData(Nim, Asisten);
            } else if (cek == 2){
                Tampil();
            } else if (cek == 3){
                listNimPraktikum();
            } else if (cek == 4){
                listNamaAsisten();
            } else if (cek == 5){
                System.out.println("Total Data Yang Tersimpan : " + TotalEmail() + "\n");
            } else if (cek == 6){
                System.out.println("Hapus Data");
                System.out.println("Masukkan Nim Praktikan : ");
                Nim = input.nextLine();
                System.out.println("Masukkan Nama Asisten : ");
                Asisten = input.nextLine();
                HapusData(Nim, Asisten);
            } else if (cek == 7){
                System.out.println("Edit Data");
                System.out.println("Masukkan Nim Praktikan : ");
                Nim = input.nextLine();
                System.out.println("Masukkan Nama Asisten : ");
                Asisten = input.nextLine();
                EditData(Nim, Asisten);
            } else if (cek == 8){
                System.out.println("Search Data");
                System.out.println("Mencari NIM Praktikan Dengan Asisten Yang Sama : ");
                Asisten = input.nextLine();
                SearchData(Nim, Asisten);
            } else if (cek == 9){
                System.out.println("Selesai");
                System.exit(0);
                return;
            } else {
                System.err.println("Menu Tidak Ada");
            }

        }
    }

    private static boolean TambahData(String NimPraktikum, String NamaAsisten) {
        boolean d = false;
        if (!(NimPraktikum.contains("IF"))) {
            System.err.println("Data Harus Ada IF \n");
            d = false;
        } else if (TabelData.containsKey(NimPraktikum)){

        }else {
            TabelData.put(NimPraktikum, NamaAsisten);
            System.out.println("Data Sukses Ditambahkan\n");
            return true;
        }
        return d;
    }

    private static void Tampil(){
        System.out.println("List Data");
        System.out.println("Total Data : " + TotalEmail());
        System.out.println("No.\t NIM Praktikan.\t\t Nama Asisten. ");

        int i = 1;
        for (String s : TabelData.keySet()) { //mengambil kunci dari HashMap
            System.out.println(i + ".\t\t" + s + "\t\t" + TabelData.get(s));
            i++;
        }
        System.out.println();
    }

    private static void listNimPraktikum(){
        System.out.println("List NIM Praktikan");
        int i = 1;
        for (String s : TabelData.keySet()){
            System.out.println(i + ". " + s);
            i++;
        }
        System.out.println();
    }

    private static void listNamaAsisten(){
        DataAsisten.addAll(TabelData.values());
        System.out.println("List Nama Asisten");
        int i = 1;
        for (String s : TabelData.values()){
            System.out.println(i + ". " + s);
            i++;
        }
        System.out.println();
    }

    private static int TotalEmail()  { return TabelData.size(); }

    private static boolean HapusData(String NimPraktikum, String NamaAsisten){
        boolean d;
        if (!TabelData.containsKey(NimPraktikum) || !TabelData.get(NimPraktikum).equals(NamaAsisten)){
            System.out.println("Data Tidak Terdaftar\n");
            d = false;
        } else {
            TabelData.remove(NimPraktikum, NamaAsisten);
            System.out.println("Data Sukses Dihapus\n");
            d = true;
        }
        return d;
    }

    private static void EditData(String NimPraktikum, String NamaAsisten){

        if (!TabelData.containsKey(NimPraktikum)) {
            System.out.println("Data dengan NIM " + NimPraktikum + " tidak ditemukan.");
            return;
        }
        TabelData.put(NimPraktikum, NamaAsisten);
        System.out.println("Data berhasil diubah.");
    }

    private static void SearchData(String NamaAsisten, String asisten){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan nama asisten : ");
        String namaAsisten = scanner.nextLine();
        boolean found = false;
        System.out.println("Daftar NIM Praktikan dengan Nama Asisten " + namaAsisten);
        for (Map.Entry<String, String> entry : TabelData.entrySet()) {
            if (entry.getValue().equals(namaAsisten)) {
                System.out.println(entry.getKey());
                System.out.println("\n");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Tidak ditemukan NIM praktikan dengan Nama Asisten " + namaAsisten + ".");
        }
    }

    public static void login(String inputEmail, String inputPass){
        if(TabelSesiLogin.containsKey(inputEmail) && TabelSesiLogin.get(inputEmail).equals(inputPass)){
            if (inputEmail.contains("umm.ac.id")){
                error = false;
                char[] Nama = inputEmail.toCharArray();
                System.out.println("Selamat Datang");
                for (int i = 0; Nama[i] != '@'; i++){
                    System.out.print(Nama[i]);
                }
                System.out.println("!!\n\n");
                menu();
            } else {
                System.out.println("Email Harus Mggunakan @umm.ac.id");
                error = true;
            }
        }
    }
}
