package com.github.affandes.kuliah.pm;

import java.util.Scanner;
import java.util.Stack;
public class UndoRedo {
        private static String text = "";
        private static Stack<String> undoStack = new Stack<>();
        private static Stack<String> redoStack = new Stack<>();
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int pilihan;
            do {
                System.out.println("\n===== TEXT EDITOR MENU =====");
                System.out.println("1. Write (Tambah Teks)");
                System.out.println("2. Undo");
                System.out.println("3. Redo");
                System.out.println("4. Show");
                System.out.println("5. Exit");
                System.out.print("Pilih: ");
                pilihan = scanner.nextInt();
                scanner.nextLine(); // clear buffer
                switch (pilihan) {
                    case 1:
                        write(scanner);
                        break;
                    case 2:
                        undo();
                        break;
                    case 3:
                        redo();
                        break;
                    case 4:
                        show();
                        break;
                    case 5:
                        System.out.println("Keluar program...");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid!");
                }

            } while (pilihan != 5);
        }

        private static void write(Scanner scanner) {
            System.out.print("Masukkan teks: ");
            String newText = scanner.nextLine();

            undoStack.push(text);  // simpan history sebelum berubah
            text += newText;       // tambahkan teks baru
            redoStack.clear();     // ketika write, redo harus hilang

            System.out.println("✔ Teks berhasil ditambah.");
        }
        private static void undo() {
            if (undoStack.isEmpty()) {
                System.out.println("⚠ Tidak ada aksi yang bisa di-undo!");
                return;
            }

            redoStack.push(text); // simpan keadaan sekarang
            text = undoStack.pop(); // kembali ke keadaan sebelumnya

            System.out.println("↩ Undo berhasil.");
        }
        private static void redo() {
            if (redoStack.isEmpty()) {
                System.out.println("⚠ Tidak ada aksi yang bisa di-redo!");
                return;
            }
            undoStack.push(text);  // simpan history sebelum redo
            text = redoStack.pop(); // pulihkan keadaan yang lebih baru

            System.out.println("↪ Redo berhasil.");
        }
        private static void show() {
            System.out.println("\n=== isi Teks Editor ===");
            if (text.isEmpty()) {
                System.out.println("(kosong)");
            } else {
                System.out.println(text);
            }
        }
}
