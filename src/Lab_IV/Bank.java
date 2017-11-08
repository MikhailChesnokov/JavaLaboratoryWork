package Lab_IV;

import java.util.ArrayList;
import java.util.List;

class Bank {
    List<Client> clients = new ArrayList<>();

    void transferMoney(String senderName, String receiverName, Integer amount) {
        Client sender = findClientByName(senderName);
        Client receiver = findClientByName(receiverName);

        boolean withdrawn = false;
        synchronized (sender) {
            if (sender.deposit >= amount) {
                sender.deposit -= amount;
                withdrawn = true;
            } else {
                System.out.println("Cannot withdraw from " + senderName);
            }
        }
        if (withdrawn)
            synchronized (receiver) {
                receiver.deposit += amount;
            }
    }

    int getMoneyOfAllClients() {
        int sum = 0;
        for(Client client : clients) {
            sum += client.deposit;
        }
        return sum;
    }

    private Client findClientByName(String name) {
        Client wantedClient = null;
        for(Client client : clients) {
            if (client.name.compareTo(name) == 0)
                wantedClient = client;
        }
        return wantedClient;
    }
}