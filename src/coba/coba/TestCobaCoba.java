/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coba.coba;

import javax.swing.JOptionPane;
import java.util.Random;

/**
 *
 * @Fivan Velaroni/XR6/Smk Telkom Mlg
 */
public class TestCobaCoba {

    public static int[] data = null;
    public static int awal, tengah, akhir, temp, count, jumlah, cari;

    public static void main(String[] args) {

        //	Input jumlah data
        jumlah = Integer.parseInt(JOptionPane.showInputDialog("Masukkan jumlah angka = "));

        //	Input tiap nilai dan simpan ke array
        data = new int[jumlah];
        for (int x = 0; x < data.length; x++) {
            data[x] = new Random().nextInt(201);
        }

        //	Menampilkan data sebelum di sorting
        System.out.print("\nData    : ");
        for (int x = 0; x < data.length; x++) {
            System.out.print(data[x] + " ");
        }

        //	Proses sorting
        sorting();

        //	Menampilkan Data setelah di sorting
        System.out.println();
        System.out.print("Sorting : ");
        for (int x = 0; x < data.length; x++) {
            System.out.print(data[x] + " ");
        }

        //	Input data yang dicari
        cari = Integer.parseInt(JOptionPane.showInputDialog("Data yang dicari = "));
        System.out.println();
        //	Proses Metode Pencarian Binary Searching
        System.out.println();
        boolean temu = false;
        awal = 0;
        akhir = data.length - 1;
        temp = 0;
        count = 0;
        int iterasi = 0;
        System.out.println("It  Aw  Ak  Te  Ni");
        while (temu != true) {
            tengah = (awal + akhir) / 2;
            iterasi++;

            //	value == cari
            if (data[tengah] == cari) {
                System.out.print(iterasi + "   ");
                System.out.print(awal + "   ");
                System.out.print(akhir + "   ");
                System.out.print(tengah + "   ");
                System.out.print(data[tengah] + "\n");
                temu = true;
                break;
            } //	value < cari
            else if (data[tengah] < cari) {
                System.out.print(iterasi + "   ");
                System.out.print(awal + "   ");
                System.out.print(akhir + "   ");
                System.out.print(tengah + "   ");
                System.out.print(data[tengah] + "\n");
                awal = tengah + 1;

            } //	value > cari
            else if (data[tengah] > cari) {
                System.out.print(iterasi + "   ");
                System.out.print(awal + "   ");
                System.out.print(akhir + "   ");
                System.out.print(tengah + "   ");
                System.out.print(data[tengah] + "\n");
                akhir = tengah - 1;
            }

            //	Cek Worst Case
            if (temp != data[tengah]) {
                temp = data[tengah];
            } else {
                count++;
            }

            //	batasan untuk worst case
            if (count == 3) {
                break;
            }
        }

        //	Output
        if (temu == true) {
            System.out.println("\nData " + cari + " ditemukan pada index ke-" + tengah + "\n"
                    + "dan Iterasi ke-" + iterasi);
        } else {
            System.out.println("\nData " + cari + " tidak ditemukan");
        }

    }

    //	Sorting Ascending
    public static void sorting() {
        int temp = 0;
        for (int x = 0; x < data.length; x++) {
            for (int y = 0; y < data.length; y++) {
                if (x == y) {
                    continue;
                } else {
                    if (data[x] < data[y]) {
                        temp = data[y];
                        data[y] = data[x];
                        data[x] = temp;

                    }
                }
            }
        }
    }
}