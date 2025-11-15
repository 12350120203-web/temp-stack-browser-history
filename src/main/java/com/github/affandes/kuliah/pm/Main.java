package com.github.affandes.kuliah.pm;

import java.util.Scanner;
import java.util.Stack;
public class BrowserHistory {
    private static Stack<String> history = new Stack<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== MENU BROWSER HISTORY =====");
            System.out.println("1. Browse (Tambah Website)");
            System.out.println("2. Back (Kembali ke halaman sebelumnya)");
            System.out.println("3. View History");
            System.out.println("4. Keluar");
            System.out.print("Pilihan: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // membersihkan buffer
            switch (choice) {
                case 1:
                    browse();
                    break;
                case 2:
                    back();
                    break;
                case 3:
                    view();
                    break;
                case 4:
                    System.out.println("Keluar program...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (choice != 4);
    }

    private static void browse() {
        System.out.print("Masukkan nama website: ");
        String site = scanner.nextLine();
        history.push(site);
        System.out.println("📌 Browsing ke: " + site);
    }
    private static void back() {
        if (history.isEmpty()) {
            System.out.println("⚠️ History kosong, tidak bisa kembali!");
        } else {
            String removed = history.pop();
            System.out.println("⬅️ Kembali dari: " + removed);

            if (!history.isEmpty()) {
                System.out.println("👉 Sekarang berada di: " + history.peek());
            } else {
                System.out.println("👉 Tidak ada halaman lagi dalam history.");
            }
        }
    }
    private static void view() {
        if (history.isEmpty()) {
            System.out.println("📭 History masih kosong.");
        } else {
            System.out.println("\n📜 HISTORY (dari yang terbaru):");
            Stack<String> temp = new Stack<>();
            temp.addAll(history);
            while (!temp.isEmpty()) {
                System.out.println("- " + temp.pop());
            }
        }
    }
}
