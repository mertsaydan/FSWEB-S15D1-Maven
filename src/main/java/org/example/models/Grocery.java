package org.example.models;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {


    public static ArrayList<String> groceryList = new ArrayList<>();

    public static void main(String[] args) {
        startGrocery();
    }

    public static void startGrocery() {
        Scanner scanner = new Scanner(String.valueOf(System.class));
        boolean running = true;

        while (running) {
            System.out.println("\n--- Alışveriş Listesi Uygulaması ---");

            printSorted();
            System.out.println("0 - Uygulamayı Durdur");
            System.out.println("1 - Eleman Ekle (Tekli veya virgülle ayırarak çoklu)");
            System.out.println("2 - Eleman Çıkar (Tekli veya virgülle ayırarak çoklu)");
            System.out.print("Seçiminiz: ");

            int choice = -1;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Satır sonu karakterini temizle
            } else {
                System.out.println("Lütfen geçerli bir sayı giriniz!");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 0:
                    System.out.println("Uygulama durduruluyor. İyi günler!");
                    running = false;
                    break;

                case 1:
                    System.out.print("Eklenmesini istediğiniz elemanları giriniz: ");
                    String itemsToAdd = scanner.nextLine();
                    addItems(itemsToAdd);
                    break;

                case 2:
                    System.out.print("Çıkarılmasını istediğiniz elemanları giriniz: ");
                    String itemsToRemove = scanner.nextLine();
                    removeItems(itemsToRemove);
                    break;

                default:
                    System.out.println("Geçersiz bir seçim yaptınız. Lütfen 0, 1 veya 2 giriniz.");
                    break;
            }
        }
        scanner.close();
    }

    public static void addItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String cleanedItem = item.trim();
            if (!cleanedItem.isEmpty()) {

                if (!checkItemIsInList(cleanedItem)) {
                    groceryList.add(cleanedItem);
                    System.out.println(cleanedItem + " listeye eklendi.");
                } else {
                    System.out.println(cleanedItem + " zaten listede var! Tekrar eklenemez.");
                }
            }
        }
        Collections.sort(groceryList);
    }


    public static void removeItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String cleanedItem = item.trim();
            if (!cleanedItem.isEmpty()) {

                if (checkItemIsInList(cleanedItem)) {
                    groceryList.remove(cleanedItem);
                    System.out.println(cleanedItem + " listeden çıkarıldı.");
                } else {
                    System.out.println(cleanedItem + " listede bulunamadığı için çıkarılamadı.");
                }
            }
        }
        Collections.sort(groceryList); // Her operasyon sonrası sıralama
    }


    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }


    public static void printSorted() {

        Collections.sort(groceryList);
        System.out.println("Güncel Sıralı Liste: " + groceryList);
    }
}