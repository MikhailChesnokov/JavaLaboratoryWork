package Lab_IV;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solver {
    private static final int totalClients = 100, totalThreads = 1000, transfersPerThread = 1000, maxTransferSum = 5000;
    private static Random rnd = new Random();
    private static Bank bank = new Bank();

    public static void main() {
        // Add clients to the bank
        for (int i = 0; i < totalClients; i++) {
            bank.clients.add(new Client("Client " + i));
        }

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

        // Start all
        threads.forEach(Thread::start);

        // Wait for all the threads to finish
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException ignored) { }
        }

        // Print sum of money for all clients (in separated thread)
        Thread sumThread = new Thread(
                () -> System.out.println("Total: " +  bank.getMoneyOfAllClients()));
        sumThread.start();
    }
}