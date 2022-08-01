public class SalaFitness{ //pot fi prezente maxim 3 persoane simultan
    int numarPersoaneIntrate;
    boolean persoanaEsteIntrata;
    boolean salaEsteDeschisa;
    Persoana[] persoaneIntrate = new Abonati[3];// 0,1,2
    int nrPersoane;


    private void intrareInSala(Abonati abonatOarecare) {
        for (Persoana p1 : persoaneIntrate) {
            if (p1 == null) {
                p1 = abonatOarecare;
                System.out.println("A intrat in sala abonatul");
                numarPersoaneIntrate++;
                break;
            } else {
                System.out.println("Din pacate sala este plina și nu se mai poate intra!");
                salaEsteDeschisa = false;
             }
            }
           }

        private void iesireDinSala () {
            if (persoanaEsteIntrata == false) {
                System.out.println("Persoana este deja iesita din sala");
            } else {
                numarPersoaneIntrate--;
                System.out.println("Persoana a iesit din sala");
            }
        }

        private void deschideSala () {
            if (numarPersoaneIntrate < 3) {
                System.out.println("Sala este deschisa");
                salaEsteDeschisa = true;
            } else {
                System.out.println("Sunt deja 3 persoane in sala, deci sala este inchisa");
                salaEsteDeschisa = false;
            }

        }

        private void adaugaAntrenor (String nume,int varsta, int numarDeAbonati){
                    if(numarPersoaneIntrate==3){
                        System.out.println("Din pacate sala este plina și " + nume + " nu mai poate intra!");
                    }
                    else{
                        Antrenori antrenor1 = new Antrenori(nume,varsta,numarDeAbonati);
                        for(int i=0; i<persoaneIntrate.length; i++){
                            if(persoaneIntrate[i]==null){
                                persoaneIntrate[i]=antrenor1;
                                numarPersoaneIntrate++;
                                System.out.println("A intrat în sală antrenorul " + nume);
                                break;
                            }
                        }

                    }
        }

        private void adaugaAbonat (String nume,int varsta, int progres){
            for (Persoana p1 : persoaneIntrate) {
                if (p1 == null) {
                    Abonati abonatnou = new Abonati(nume, varsta);
                    abonatnou.progresFacut = progres;
                    p1 = abonatnou;
                    System.out.println("A intrat un abonatul cu numele: " + nume);
                    numarPersoaneIntrate++;
                    break;
                } else {
                    System.out.println("Din pacate sala este plina și" + nume + " nu mai poate intra!");
                    salaEsteDeschisa = false;
                }
            }
        }

        private void afiseazaPersoane(){
            for (Persoana p1 : persoaneIntrate){
                if(p1!=null){
                    System.out.println(p1.nume+" este in sala");
                }
                else{
                    System.out.println("Sala este libera!");
                    salaEsteDeschisa = true;
                }
            }
        }

        private void afiseazaAntrenori(){
        boolean antrenorGasit=false;
            for (Persoana p1 : persoaneIntrate){
                if(p1 instanceof Antrenori){
                    System.out.println("Antrenorul "+p1.nume+" este prezent in sala");
                    antrenorGasit=true;
                }
            }
            if(antrenorGasit==false){
                System.out.println("Nu este nici un antrenor in sala!");
            }
        }

        private void afiseazaAbonatCuProgresMax(){
        boolean abonatGasit=false;
        int progresMax=0;
        int idAbonatCuProgresMax=-1;

            for (Persoana p1 : persoaneIntrate){
                if(p1!=null && p1 instanceof Abonati){
                    abonatGasit=true;
                    if(((Abonati) p1).progresFacut>progresMax){
                        idAbonatCuProgresMax=p1.getId();
                        progresMax=((Abonati) p1).progresFacut;
                    }
                }
            }
            if(idAbonatCuProgresMax>-1){
                for(Persoana p1 : persoaneIntrate){
                    if(p1.getId()==idAbonatCuProgresMax){
                        System.out.println("Abonatul cu progresul maxim este: "+ p1.nume + " si progresul este: "+progresMax);
                    }
                }

            }
        if(abonatGasit==false){
            System.out.println("Nu este nici un abonat in sala");
        }
        }

        private void eliminaPersoana(Persoana persoanaDeScos){
        int counter=-1;
        boolean persoanaEsteGasita=false;
        for(Persoana p1 : persoaneIntrate){
            counter++;
            if(p1.getId()==persoanaDeScos.getId()){
                persoanaEsteGasita=true;
                System.out.println("Persoana " + p1.nume +" a iesit din sala");
                persoaneIntrate[counter]=null;
            }
        }
        if(persoanaEsteGasita==false){
            System.out.println("Persoana "+ persoanaDeScos.nume +" nu este gasita in sala");
        }
        }

        private void inchide(){
        if(salaEsteDeschisa==false){
            System.out.println("Sala este deja inchisa");
        }
        else{
            salaEsteDeschisa=false;
            for(Persoana p1:persoaneIntrate){
                p1=null;
            }
        }
        }


        void actiune(Actiune actiune){
        switch (actiune){
            case DESCHIDE:{
                System.out.println("Apelare metoda de deschidere a salii");
                deschideSala();
                break;
            }
            default:{
                break;
            }
        }
        }


    }



