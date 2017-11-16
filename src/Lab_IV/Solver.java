package Lab_IV;

import java.util.*;

public class Solver {
    private static final int totalClients = 100, totalThreads = 1000, transfersPerThread = 1000, maxTransferSum = 5000;
    private static Random rnd = new Random();
    private static Bank bank = new Bank();

    public static void main() {
        // Add clients to the bank
        for (int i = 0; i < totalClients; i++) {
            bank.clients.add(new Client("Client " + i));
        }

        // Print total amount of money of all clients before transfers
        System.out.println("Total amount of money of all clients (before transfers): " + bank.getMoneyOfAllClients());

        // Create threads
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < totalThreads; i++)
            threads.add(new Thread(
                    () ->
                    {
                        // For each thread do few transfers
                        for (int j = 0; j < transfersPerThread; j++) {
                            bank.transferMoney("Client " + rnd.nextInt(totalClients), "Client " + rnd.nextInt(totalClients), rnd.nextInt(maxTransferSum));
                        }
                    }
            ));

        // Start all the threads
        for (Thread thread : threads) {
            thread.start();
        }

        // Wait for all the threads to finish
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Cannot join the thread because it's interrupted: " + e.getMessage());
            }
        }

        // Print total amount of money of all clients after transfers
        System.out.println("Total amount of money of all clients (after transfers): " +  bank.getMoneyOfAllClients());
    }
}