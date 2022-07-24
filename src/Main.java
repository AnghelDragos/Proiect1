public class Main {
    public static void main(String[] args) {

    Antrenori antrenor1 = new Antrenori("Andrei", 20, 10);
    Abonati abonat1 = new Abonati("George",22);

    SalaFitness salaDeFitness1=new SalaFitness();

    Actiune[] actiuni = {Actiune.DESCHIDE, Actiune.AFISEAZA_PERSOANE, Actiune.ADAUGA_ABONAT, Actiune.ADAUGA_ANTRENOR, Actiune.ADAUGA_ABONAT,
                Actiune.ADAUGA_ANTRENOR, Actiune.AFISEAZA_PERSOANE, Actiune.AFISEAZA_ANTRENORI, Actiune.AFISEAZA_ABONAT_MAX, Actiune.ELIMINA_PERSOANA,
                Actiune.AFISEAZA_PERSOANE, Actiune.ADAUGA_ANTRENOR, Actiune.AFISEAZA_PERSOANE, Actiune.INCHIDE};

    salaDeFitness1.actiune(Actiune.DESCHIDE); // am deschis manual sala, proiectul trebuie terminat.

    }
}
