package com.fireguardian.fireguardian360;

import com.fireguardian.fireguardian360.checklist.domain.model.ChecklistItem;
import com.fireguardian.fireguardian360.forecast.domain.model.Alert;
import com.fireguardian.fireguardian360.shelter.domain.model.Shelter;

import java.util.Scanner;

/**
 * A classe MainApp.
 */
public class MainApp {
    /**
     * Ponto de entrada da aplicação FireGuardian360.
     * <p>
     * Este método demonstra o uso das classes Alert, Shelter e ChecklistItem.
     * Ele interage com o usuário via console para:
     * <ul>
     *   <li>Receber e definir o nível de alerta, exibindo se é de alto risco.</li>
     *   <li>Receber informações do abrigo (nome, capacidade, disponibilidade) e exibir a taxa de ocupação.</li>
     *   <li>Criar um item da checklist, definir seu rótulo e status, e exibir se está pendente.</li>
     * </ul>
     * O método utiliza um {@link Scanner} para entrada do usuário e o fecha antes de sair.
     *
     * @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Nível do alerta: ");
        int level = sc.nextInt();
        Alert a = new Alert();
        a.setLevel(level);
        System.out.println("HighRisk? " + a.isHighRisk());

        
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

        
        ChecklistItem item = new ChecklistItem();
        item.setLabel("Máscara");
        item.setStatus('P');
        System.out.println(item + " | Pendente? " + item.isPending());

        sc.close();
    }
}
