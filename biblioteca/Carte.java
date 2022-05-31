package biblioteca;

public class Carte {

    private long id;
    private String titlu;
    private String autor;
    private String gen;
    private int nrPagini;
    private boolean imprumutata;

    public Carte(long id, String titlu, String autor, String gen, int nrPagini, boolean imprumutata) {
        this.id = id;
        this.titlu = titlu;
        this.autor = autor;
        this.gen = gen;
        this.nrPagini = nrPagini;
        this.imprumutata = imprumutata;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public int getNrPagini() {
        return nrPagini;
    }

    public void setNrPagini(int nrPagini) {
        this.nrPagini = nrPagini;
    }

    public boolean isImprumutata() {
        return imprumutata;
    }

    public void setImprumutata(boolean imprumutata) {
        this.imprumutata = imprumutata;
    }
}
