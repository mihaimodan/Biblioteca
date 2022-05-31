package biblioteca;

public class Profesor extends Client {

    String materiePredata;

    public Profesor(long cod,
                    String nume,
                    long nrTotalCartiImprumutate,
                    String dataRetur,
                    String materiePredata) {
        super(cod, nume, nrTotalCartiImprumutate, dataRetur);
        this.materiePredata = materiePredata;
    }
}
