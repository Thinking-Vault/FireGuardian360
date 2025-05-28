package com.fireguardian.fireguardian360;

import com.fireguardian.fireguardian360.checklist.domain.model.ChecklistItem;
import com.fireguardian.fireguardian360.forecast.domain.model.Alert;
import com.fireguardian.fireguardian360.shelter.domain.model.Shelter;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Criar e testar Alert
        System.out.print("Nível do alerta: ");
        int level = sc.nextInt();
        Alert a = new Alert();
        a.setLevel(level);
        System.out.println("HighRisk? " + a.isHighRisk());

        // Criar e testar Shelter
        System.out.print("Nome do abrigo: ");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.print("Capacidade total: ");
        int cap = sc.nextInt();
        System.out.print("Disponível: ");
        int avail = sc.nextInt();
        Shelter s = new Shelter();
        s.setName(name);
        s.setCapacity(cap);
        s.setAvailable(avail);
        System.out.printf("Ocupação: %.2f%%\n", s.getOccupancyRate());

        // Criar e testar ChecklistItem
        ChecklistItem item = new ChecklistItem();
        item.setLabel("Máscara");
        item.setStatus('P');
        System.out.println(item + " | Pendente? " + item.isPending());

        sc.close();
    }
}
