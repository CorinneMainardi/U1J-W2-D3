package it.epicode;

import it.epicode.entity.Customer;
import it.epicode.entity.Ordine;
import it.epicode.entity.Prodotto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {
    es1();
    }



    public static void es1(){
        List<Prodotto> prodotti = new ArrayList<>();
        Prodotto p = new Prodotto(25,"libro1", "books", 15.20);
        Prodotto p2 = new Prodotto(23,"libro2", "books", 13.20);
        Prodotto p3 = new Prodotto(21,"boh", "boys", 10.20);
        prodotti.addAll(Arrays.asList(p, p2, p3));
        Customer c = new Customer(2, "francesca", 2);
        Customer c2 = new Customer(3, "francesco", 5);
        Ordine o  = new Ordine(1,"ordinato", LocalDate.now(), prodotti, c );
        Ordine o1 = new Ordine(1, "ordinato", LocalDate.now(), prodotti, c);
        Ordine o2 = new Ordine(2, "spedito", LocalDate.now(), Arrays.asList(p, p3), c2);
        Ordine o3 = new Ordine(3, "consegnato", LocalDate.now(), Arrays.asList(p2, p3), c);

        List<Ordine> ordini = Arrays.asList(o1, o2, o3);
        System.out.println(o);


// Raggruppamento degli ordini per cliente e raccolta dei prodotti
        Map<Customer, List<Prodotto>> ordiniPerCliente = ordini.stream()
                .collect(Collectors.groupingBy(
                        Ordine::getCustomer,                 // Chiave: Cliente
                        Collectors.flatMapping(               // Valore: Lista di Prodotti
                                ordine -> ordine.getProducts().stream(),
                                Collectors.toList())
                ));

        // Stampa dei risultati
        ordiniPerCliente.forEach((cliente, listaProdotti) -> {
            System.out.println("Cliente: " + cliente.getName());
            listaProdotti.forEach(prodotto -> System.out.println("  Prodotto: " + prodotto.getName()));
        });

    }
}
