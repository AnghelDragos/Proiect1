public class Abonati extends Persoana{

    int progresFacut;

    public Abonati(String nume, int varsta){
        super(nume,varsta);

    }

    public void practicareExercitiuFizic(){
        if(progresFacut<10) {
            progresFacut++;
            }
    }

    public int getterProgresFacut(){
        return progresFacut;
    }


}
