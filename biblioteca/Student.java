package biblioteca;

public class Student extends Client {

    private String facultate;
    private int anStudiu;

    public Student(long cod,
                   String nume,
                   long nrTotalCartiImprumutate,
                   String dataRetur,
                   String facultate,
                   int anStudiu) {
        super(cod, nume, nrTotalCartiImprumutate, dataRetur);
        this.facultate = facultate;
        this.anStudiu = anStudiu;
    }

    @Override
    public String toString() {
        return "Student{" +
                "facultate='" + facultate + '\'' +
                ", anStudiu=" + anStudiu +
                ", cod=" + cod +
                ", nume='" + nume + '\'' +
                ", nrTotalCartiImprumutate=" + nrTotalCartiImprumutate +
                ", dataRetur='" + dataRetur + '\'' +
                '}';
    }
}
