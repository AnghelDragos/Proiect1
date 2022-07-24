public abstract class Persoana {

    String nume;
    int varsta;
    static int id;

    public Persoana(String nume, int varsta){
        this.nume=nume;
        this.varsta=varsta;
        id++;
    }

    public String getNume(){
        return nume;
    }

    public int getVarsta(){
       return varsta;
    }

    public int getId(){
        return id;
    }
}
