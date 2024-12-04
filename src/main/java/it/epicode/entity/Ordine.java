package it.epicode.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Ordine {
    private long id;
    private String status;
    private LocalDate ordedDate;
    private List<Prodotto> products = new ArrayList<>();
    private Customer customer;

    @Override
    public String toString() {
        return "Ordine{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", ordedDate=" + ordedDate +
                ", products=" + products +
                ", customer=" + customer +
                '}';
    }
}
