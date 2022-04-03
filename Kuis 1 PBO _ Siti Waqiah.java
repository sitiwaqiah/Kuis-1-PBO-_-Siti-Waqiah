package com.company;

import java.util.Scanner;

class Member{
    String nama, nik, alamat, noHp;
    Buku buku;

    //Consturktur
    Member(String nama, String nik, String alamat, String noHp){
        this.nama = nama;
        this.nik = nik;
        this.alamat = alamat;
        this.noHp = noHp;
    }

    //Menampilkan data member
    void dataMember(){
        System.out.println("Nama    = " + nama);
        System.out.println("NIK     = " + nik);
        System.out.println("Alamat  = " + alamat);
        System.out.println("No.HP   = " + noHp);
        System.out.println("Buku yang dipinjam : ");
        buku.namaBuku();
    }
    //Nama member
    void namaMember(){
        System.out.println(nama);
    }

    void meminjamBuku(Buku buku){
        this.buku = buku;
    }
}

class Buku{
    String nama, jenis, pengarang;

    //Construktur
    Buku(String nama, String jenis, String pengarang){
        this.nama = nama;
        this.jenis = jenis;
        this.pengarang = pengarang;
    }

    //Method
    void dataBuku(){
        System.out.println("Nama    = " + nama);
        System.out.println("Jenis   = " + jenis);
        System.out.println("Pengarang = " + pengarang);
    }

    void namaBuku(){
        System.out.println(nama);
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int x = 0, l = 0, cek = 0, pilihan1, pilihan2, peminjam, pilihBuku;
        String nama, nik, alamat, noHp, jenis, pengarang;
        Member[] member = new Member[1000];
        Buku[] buku = new Buku[1000];

        do {
            System.out.println("\n=== Perpustakaan Indah Membaca ===");
            System.out.println("    1. Meminjam Buku");
            System.out.println("    2. Pendaftaran");
            System.out.println("    3. Data");
            System.out.println("    4. Keluar");
            System.out.print("    Pilih Menu = ");
            pilihan1 = in.nextInt();
            switch (pilihan1) {
                case 1:
                    if (x == 0){
                        System.out.println("\nData Member Masih Kosong");
                        System.out.println("Lakukan Pendaftaran Member\n");
                        continue;
                    } else if (l == 0){
                        System.out.println("\nData Buku Masih Kosong");
                        System.out.println("Lakukan Pendaftaran Buku\n");
                        continue;
                    } else {
                        System.out.println("\n");
                        for (int j = 0; j < x; j++) {
                            System.out.print((j + 1) + ". ");
                            member[j].namaMember();
                        }
                        System.out.print("Pilih Peminjam = ");
                        peminjam = in.nextInt();
                        peminjam -= 1;
                        System.out.println("\n");
                        for (int j = 0; j < l; j++) {
                            System.out.print((j + 1) + ". ");
                            buku[j].namaBuku();
                        }
                        System.out.print("Pilih Buku = ");
                        pilihBuku = in.nextInt();
                        pilihBuku -= 1;
                        member[peminjam].meminjamBuku(buku[pilihBuku]);
                    }
                    break;
                case 2:
                    do {
                        System.out.println("\nPilih Pendaftaran");
                        System.out.println("1. Member");
                        System.out.println("2. Buku");
                        System.out.println("3. Kembali");
                        System.out.print("Pilih = ");
                        pilihan2 = in.nextInt();
                        if (pilihan2 == 1) {
                            System.out.print("\nNama    = ");
                            nama = in.next();
                            System.out.print("NIK     = ");
                            nik = in.next();
                            System.out.print("Alamat  = ");
                            alamat = in.next();
                            System.out.print("No.HP   = ");
                            noHp = in.next();
                            member[x] = new Member(nama, nik, alamat, noHp);
                            x++;
                        } else if (pilihan2 == 2) {
                            System.out.print("\nNama      = ");
                            nama = in.next();
                            System.out.print("Jenis     = ");
                            jenis = in.next();
                            System.out.print("Pengarang = ");
                            pengarang = in.next();
                            buku[l] = new Buku(nama, jenis, pengarang);
                            l++;
                        } else if (pilihan2 == 3){

                        } else {
                            System.out.println("\nInputan Salah\n");
                        }
                    } while(pilihan2 != 3);
                    break;
                case 3:
                    if (x == 0 & l == 0) {
                        System.out.println("\nData Peminjaman/Member/Buku Masih Kosong");
                        System.out.println("Lakukan Pendaftaran dan Peminjaman Buku\n");
                        continue;
                    } else {
                        do {
                            System.out.println("\nPilih Data");
                            System.out.println("1. Peminjaman Buku");
                            System.out.println("2. Buku");
                            System.out.println("3. Kembali");
                            System.out.print("Pilih = ");
                            pilihan2 = in.nextInt();
                            if (pilihan2 == 1) {
                                System.out.println("\n");
                                for (int j = 0; j < x; j++) {
                                    System.out.print((j + 1) + ". ");
                                    member[j].namaMember();
                                }
                                System.out.print("Pilih Peminjam = ");
                                peminjam = in.nextInt();
                                peminjam -= 1;
                                member[peminjam].dataMember();
                            } else if (pilihan2 == 2) {
                                System.out.println("\n");
                                for (int j = 0; j < x; j++) {
                                    System.out.print((j + 1) + ". ");
                                    buku[j].namaBuku();
                                }
                                System.out.print("Pilih Buku = ");
                                pilihBuku = in.nextInt();
                                pilihBuku -= 1;
                                buku[pilihBuku].dataBuku();
                            } else if (pilihan2 == 3) {

                            } else {
                                System.out.println("\nInputan Salah\n");
                            }
                        } while (pilihan2 != 3);
                    }
                    break;
                case 4:
                    System.out.println("\n======= Terima Kasih =======");
                    break;
                default:
                    System.out.println("\nPilihan Salah\n");
                    break;
            }
        } while(pilihan1 != 4);

    }
}