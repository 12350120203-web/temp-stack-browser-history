package com.github.affandes.kuliah.pm;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
    public class FileTeks {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.print("Masukkan nama file (misal: data.txt): ");
                String fileName = scanner.nextLine();
                BufferedReader reader = new BufferedReader(new FileReader(fileName));
                Queue<String> queue = new LinkedList<>();
                String line;
                while ((line = reader.readLine()) != null) {
                    queue.add(line);
                }
                reader.close();
                System.out.println("✔ File berhasil dibaca. Total baris: " + queue.size());
                System.out.print("Masukkan jumlah baris per potongan: ");
                int chunkSize = scanner.nextInt();
                int fileCount = 1;
                while (!queue.isEmpty()) {
                    String outputFileName = "output_" + fileCount + ".txt";
                    BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));
                    int count = 0;
                    while (count < chunkSize && !queue.isEmpty()) {
                        writer.write(queue.poll());
                        writer.newLine();
                        count++;
                    }
                    writer.close();
                    System.out.println("✔ File dibuat: " + outputFileName);
                    fileCount++;
                }
                System.out.println("\n=== Proses pemotongan selesai! ===");
            } catch (IOException e) {
                System.out.println("❌ Terjadi kesalahan: " + e.getMessage());
            }
        }
    }
