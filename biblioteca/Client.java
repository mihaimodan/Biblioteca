package biblioteca;

public abstract class Client {
    protected long cod;                       //0L
    protected String nume;                    //null
    protected long nrTotalCartiImprumutate;   //0L

    /**
     * zi/luna/an
     */
    String dataRetur;               //null

    public Client(long cod, String nume, long nrTotalCartiImprumutate, String dataRetur) {
        this.cod = cod;
        this.nume = nume;
        this.nrTotalCartiImprumutate = nrTotalCartiImprumutate;
        this.dataRetur = dataRetur;
    }

    public void imprumutatCarte() {
        nrTotalCartiImprumutate++;
    }

    public long getCod() {
        return cod;
    }

    public void setCod(long cod) {
        this.cod = cod;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public long getNrTotalCartiImprumutate() {
        return nrTotalCartiImprumutate;
    }

    public void setNrTotalCartiImprumutate(long nrTotalCartiImprumutate) {
        this.nrTotalCartiImprumutate = nrTotalCartiImprumutate;
    }

    public String getDataRetur() {
        return dataRetur;
    }

    public void setDataRetur(String dataRetur) {
        this.dataRetur = dataRetur;
    }
}
