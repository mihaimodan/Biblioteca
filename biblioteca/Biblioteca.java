package biblioteca;

import biblioteca.erori.CarteIndisponibilaException;
import biblioteca.erori.NumeDejaExistentException;

import java.util.*;

public class Biblioteca {

    private int codClient = 0;
    private long codCarte = 0;
    private Map<Long, Carte> carti;

    private Map<String, Client> clienti;

    private Map<Client, Carte> cartiImprumutate;

    Carte getCarteImprumutataDe(Client client) {
        return cartiImprumutate.get(client);
    }

    void addStudent(
            String nume,
            long nrTotalCartiImprumutate,
            String dataRetur,
            String facultate,
            int anStudiu
    ) {
        if (clienti.containsKey(nume)) {
            throw new NumeDejaExistentException();
        }
        codClient++;
        Student student = new Student(
                codClient,
                nume,
                nrTotalCartiImprumutate,
                dataRetur,
                facultate,
                anStudiu
        );
        clienti.put(nume, student);
    }

    void addProfesor(
            String nume,
            long nrTotalCartiImprumutate,
            String dataRetur,
            String materiePredata
    ) {
        if (clienti.containsKey(nume)) {
            throw new NumeDejaExistentException();
        }
        codClient++;
        Profesor profesor = new Profesor(
                codClient,
                nume,
                nrTotalCartiImprumutate,
                dataRetur,
                materiePredata
        );
        clienti.put(nume, profesor);
    }

    void afiseazaClienti() {
        List<Client> listaClient = new ArrayList<>();

        for (Client client : clienti.values()) {
            listaClient.add(client);
        }

        Collections.sort(listaClient, new Comparator<Client>() {
            @Override
            public int compare(Client c1, Client c2) {
                return (int) (c1.getCod() - c2.getCod());
            }
        });

        for (Client client : listaClient) {
            System.out.println(client.toString());
        }
    }

    void afiseazaStudenti() {
        List<Student> listaClient = new ArrayList<>();

        for (Client client : clienti.values()) {
            if (client instanceof Student) {
                listaClient.add((Student) client);
            }
        }

        Collections.sort(listaClient, new Comparator<Student>() {
            @Override
            public int compare(Student c1, Student c2) {
                return (int) (c1.getCod() - c2.getCod());
            }
        });

        for (Student client : listaClient) {
            System.out.println(client.toString());
        }
    }

    void adaugaCarte(
            String titlu,
            String autor,
            String gen,
            int nrPagini
    ) {
        codCarte++;
        Carte carte = new Carte(
                codCarte,
                titlu,
                autor,
                gen,
                nrPagini,
                false
        );
        carti.put(codCarte, carte);
    }

    void afiseazaCarti() {
        for (Carte carte : carti.values()) {
            System.out.println(carte.toString());
        }
    }

    void afiseazaCartiDisponibile() {
        for (Carte carte : carti.values()) {
            if (!carte.isImprumutata())
                System.out.println(carte);
        }
    }

    Carte cautaCarte(String titlu) {
        for (Carte carte : carti.values()) {
            if (carte.getTitlu() == titlu) {
                return carte;
            }
        }
        return null;
    }

    void filtreazaCartiDupaGen(String gen) {
        List<Carte> rezultat = new ArrayList<>();
        for (Carte carte : carti.values()) {
            if (carte.getGen().equals(gen)) {
                rezultat.add(carte);
            }
        }
        for (Carte carte : rezultat) {
            System.out.println(carte);
        }
    }

    void sorteazaCarti() {
        //nrpagini crescator
        List<Carte> rezultat = new ArrayList<>();
        for (Carte carte : carti.values()) {
            rezultat.add(carte);
        }
        Collections.sort(rezultat, new Comparator<Carte>() {
            @Override
            public int compare(Carte c1, Carte c2) {
                return Integer.compare(c1.getNrPagini(), c2.getNrPagini());
            }
        });
    }

    void sorteazaClienti() {
        //nrpagini crescator
        List<Client> rezultat = new ArrayList<>();
        for (Client client : clienti.values()) {
            rezultat.add(client);
        }
        Collections.sort(rezultat, new Comparator<Client>() {
            @Override
            public int compare(Client c1, Client c2) {
                return c1.getNume().compareTo(c2.getNume());
            }
        });
    }

    void celMaiFidelCititor() {
        long max = -1;
        Client fidelul = null;
        for (Client client : clienti.values()) {
            if (client.getNrTotalCartiImprumutate() > max) {
                fidelul = client;
                max = client.getNrTotalCartiImprumutate();
            }
        }
        if (fidelul == null) {
            System.out.println("N-avem clienti :(");
        } else {
            System.out.println(fidelul);
        }
    }

    void imprumutaCarte(Client client, Carte carte) {
        if (carte.isImprumutata()) throw new CarteIndisponibilaException();

        carte.setImprumutata(true);
        client.imprumutatCarte();
        cartiImprumutate.put(client, carte);
    }


    void returneazaCarte(Client client, Carte carte) {
        carte.setImprumutata(false);
        cartiImprumutate.remove(client);
    }

    void stergeCarte(long id) {
        carti.remove(id);
    }

    void stergeClient(String nume) {
        clienti.remove(nume);
    }

}
