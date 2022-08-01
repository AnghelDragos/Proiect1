Proiect - Sală de fitness 
Se va crea o aplicație ce are ca scop gestiunea oamenilor ce se antrenează într-o sală de fitness.
Există două tipuri de persoane ce pot intra în sală: 
- antrenori și
- abonați.
Pentru orice persoană se reține numele, vârsta și un id de tip int, unic. Pentru un antrenor se mai salvează numărul de abonați pe care îi are, iar pentru un abonat se reține progresul făcut, sub forma unei valori din intervalul [0,10]. 
Pentru ca oamenii sa aibă mai mult loc, se impun niște restricții și se anunța ca în sală pot fi prezenți, la orice moment de timp, maximum 3 persoane. Aplicația va crea o singură sală de fitness care trebuie să implementeze următoarele funcționalități:
    • Intrarea unei persoane în sală
    • Ieșirea unei persoane din sală
    • Afișarea tuturor persoanelor din sală
    • Afișarea antrenorilor
    • Afișarea abonatului cu cel mai mare progres
Dacă se încearcă scoaterea din sală a unei persoane care nu există, se va arunca o excepție de tip checked numită PersoanaNuExista, care va fi tratată, afișându-se un mesaj corespunzător, astfel încât aplicația să poată continua. 
Pentru început, implementati o clasa abstractă Persoana care contine toate campurile de mai sus (nume, varsta, id). Aceasta clasa va fi mostenita de clasa Antrenor care adaugă nrAbonati și de clasa Abonat care adauga progres (număr cuprins între [0, 10]). De asemenea, adaugati cate un constructor care sa primească și sa seteze aceste campuri, mai puțin campul id care va fi setat din clasa Persoana (cu ajutorul unui contor static, care crește la fiecare instanțiere).
Sala de fitness este reprezentată de o clasa SalaFitness care are un array de persoane reprezentand persoanele care sunt la un moment dat în sală și un camp care indica dacă sala este deschisa sau nu. Aceasta clasa are următoarele comportamente private:
    • deschideSala - afișează un mesaj corespunzător și seteaza campul potrivit (care indica dacă este sau nu deschisa)
    • adaugaAntrenor - care primește un nume, varsta, numărul de abonați -  marchează intrarea unui antrenor în sală. Dacă locurile sunt ocupate, se va afișa: “Din păcate, sala este plină și ” + nume “ nu mai poate intra”, altfel se va afișa “A intrat în sală antrenorul ” + nume. Aceasta metodă adăuga un obiect de tip Antrenor în array-ul de persoane pe prima poziție care are null (dacă există) și incrementeaza numărul de persoane
    • adaugaAbonat - care primește un nume, varsta, progresul -  marchează intrarea unui abonat în sală. Dacă locurile sunt ocupate, se va afișa: “Din păcate, sala este plină și ” + nume “ nu mai poate intra”, altfel se va afișa “A intrat în sală abonatul ” + nume. Aceasta metodă adăuga un obiect de tip Abonat în array-ul de persoane pe prima poziție care are null (dacă există) și incrementeaza numărul de persoane
    • afiseazaPersoane - afișează toate persoanele din sală. Dacă nu există nici o persoană, se va afișa mesajul: ”Sala este liberă!”
    • afiseazaAntrenori - afișează toți antrenorii din sală (din array). Dacă nu există, se va afișa mesajul: ”Nu există niciun antrenor în sală!”
    • afiseazaAbonatCuProgresMax - afișează abonatul care are cel mai mare progres, dacă nu există se va afișa “Nu există niciun abonat în sală!”
    • eliminaPersoana - scoate persoane cu id-ul primit din sala dacă aceasta există (pune null în array pe poziția pe care se afla persoana)
    • inchide() - afișează un mesaj corespunzător și seteaza campul potrivit care indica dacă sala este deschisa sau nu
În acest proiect există și un enum Acțiune cu toate acțiunile descrise mai sus: DESCHIDE, ADAUGA_ANTRENOR, ADAUGA_ABONAT, AFISEAZA_PERSOANE, AFISEAZA_ANTRENORI, AFISEAZA_ABONAT_MAX, ELIMINA_PERSOANA, INCHIDE.
SalaFitness are o metodă acțiune(Acțiune acțiune) care primește o constanta din enum-ul de mai sus și pentru fiecare apelează metoda corespunzătoare cu parametrii corespunzători. Dacă acțiunea primită este ADAUGA_ANTRENOR, atunci se apeleaza adaugaAntrenor() și pentru parametrii puteți sa folosiți ClasaUtilitara (care se afla în folderul proiect, unde este și acest document). Aceasta ClasaUtilitara are 5 metode statice care genereaza un număr random (pentru varsta, progres, număr abonați sau id) și un nume random (folosit pentru numele Persoanelor). 
Hint: ClasaUtilitara poate fi folosită:
adaugaAntrenor(ClasaUtilitara.genereazaNume(), ClasaUtilitara.genereazaVarsta(), ClasaUtilitara.genereazaNrAbonati());

Dacă se încearcă folosirea oricărui comportament (exceptand deschide()) în metodă acțiune() și sala nu este deschisa atunci se arunca excepția de tip unchecked - SalaInchisa.
Implementați o clasa care sa aiba metodă main și array-ul:
Actiune[] actiuni = {Actiune.DESCHIDE, Actiune.AFISEAZA_PERSOANE, Actiune.ADAUGA_ABONAT, Actiune.ADAUGA_ANTRENOR, Actiune.ADAUGA_ABONAT,
   Actiune.ADAUGA_ANTRENOR, Actiune.AFISEAZA_PERSOANE, Actiune.AFISEAZA_ANTRENORI, Actiune.AFISEAZA_ABONAT_MAX, Actiune.ELIMINA_PERSOANA,
       Actiune.AFISEAZA_PERSOANE, Actiune.ADAUGA_ANTRENOR, Actiune.AFISEAZA_PERSOANE, Actiune.INCHIDE};

Parcurgeți array-ul cu un for-each și apelați pe un obiect de tipul SalaFitness toate acțiunile.
Un alt array cu ajutorul căruia puteți sa testați că nu se executa nicio acțiune fără ca sala sa fie deschisa: Actiune[] actiuni = {Actiune.AFISEAZA_PERSOANE};
Mai jos aveți diagrama cu cele 3 clase din structura aplicației:




Detalii implementare
Va recomand sa va ganditi la soluție singuri, dar dacă aveți nevoie de îndrumare în dezvoltarea acesteia, mai jos găsiți niște pași pe care puteți sa îi urmați:
    1. Implementați clasa abstractă Persoana, care contine:
        a. String nume
        b. int varsta
        c. int id
        d. Static int nrPersoane
        e. constructor care primește numele și vârsta, le seteaza și apoi seteaza id-ul cu valoarea numărului nrPersoane care crește apoi
        f. Metodă void afiseazaInformatii - afișează String-ul “Persoane se numește “ + nume “ + “ și are varsta “ + varsta
    2. Implementați clasa Antrenor care mosteneste Persoana și contine:
        a. int nrAbonati
        b. constructor care primește nume, varsta și nrAbonati, trimite mai departe numele și vârsta și seteaza nrAbonati
        c. Suprascrie metoda afiseazaInformatii și afișează “Antrenorul se numește “ + nume + “, are varsta “ + varsta + “ și “ + nrAbonati + “ abonati”
    3. Implementați clasa Abonat care mosteneste Persoana și contine:
        a. int progres
        b. constructor care primește nume, varsta și progres, trimite mai departe numele și vârsta și seteaza progresul
        c. Suprascrie metodă afiseazaInformatii și afișează “Abonatul se numește “ + nume + “, are varsta “ + varsta + “ și are progresul egal cu  “ + progres
    4. Introduceți ClasaUtilitara în proiect (puteti sa o copiati, dar aveți grija la numele proiectului)
    5. Implementati clasa SalaFitness care contine:
        a. Un array Persoane[] persoane = new persoane[3]
        b. int nrPersoane
        c. boolean esteDeschisa
        d. private void deschide() - metodă care seteaza esteDeschisa = true și afișează “Sala s-a deschis”
        e. private void adaugaAntrenor(String nume, int varsta, int nrAbonati)
            i. verifica dacă nrPersoane este egal cu 3 -> dacă da, atunci afișează “Din pacate sala este plina și “ + nume + “ nu mai poate intra!”.
            ii. Dacă mai este loc, atunci face un obiect de tipul Antrenor cu parametrii primiți
            iii. parcurge cu un for array-ul de persoane și cand a gasit persoane[i] egal cu null, pune un obiect de mai sus pe acea poziție
            iv. Incrementare nrPersoane
            v. Afișează “A intrat în sală antrenorul “ + nume
        f. private void adaugaAbonat(String nume, int varsta, int progres)
            i. verifica dacă nrPersoane este egal cu 3 -> dacă da, atunci afișează “Din pacate sala este plina și “ + nume + “ nu mai poate intra!”.
            ii. Dacă mai este loc, atunci face un obiect de tipul Abonat cu parametrii primiți
            iii. parcurge cu un for array-ul de persoane și cand a gasit persoane[i] egal cu null, pune un obiect de mai sus pe acea poziție
            iv. Incrementare nrPersoane
            v. Afișează “A intrat în sală abonatul “ + nume
        g. private void afiseazaPersoane() - verifica dacă există persoane în sală (nrPersoane > 0), dacă nu exista atunci afișează “Sala este liberă!”. Dacă sunt persoane, se afișează “Persoanele din sala sunt:” și se parcurge cu un for-each array-ul persoane. Se verifica dacă elementul curent este null, dacă nu este atunci se apelează metodă afiseazaInformatii pe obiect.
        h. private void afiseazaAntrenori() - pentru început luăm un boolean existaAntrenori setat pe false (considerăm că nu există antrenori în sală). Se parcurge cu un for each array-ul de persoane și dacă persoane e de tipul Antrenor (persoane instanceOf Antrenor) atunci se apelează afiseazaInformatii pentru acel obiect și se seteaza existaAntrenori = true. După ce s-a ieșit din for, se verifica dacă existaAntrenori este true sau false. Dacă e false atunci se afișează “nu există niciun antrenor în sală”
        i. private void afiseazaAbonatCuProgresMax()
            i. Pentru început luăm un int max = -1 (progresul poate sa fie între 0 și 10, deci dacă nu găsim niciun abonat, atunci max va ramane -1 și nu va fi actualizat)
            ii. Pastram și un obiect persoanaCuProgresMax de tip Persoana care sa fie inițializat cu null
            iii. Parcurgem cu un for array-ul de persoane și dacă am găsit un abonat (elementArray instanceOf Abonat), putem sa verificam dacă max este mai mic decat progresul acestui element și sa îl actualizăm dacă e cazul
            iv. Dacă am găsit un element în array care are progresul mai mare decat max, atunci persoanaCuProgresMax va fi egal cu elementul găsit (persoanaCuProgresMax = elementArray)
            v. La sfarsit, verificăm dacă max e diferit de -1 (dacă am găsit un abonat sau nu) dacă max e -1, afisam “Nu există niciun abonat în sală!”, dacă max e diferit atunci apelăm afiseazaInformatii pe obiectul persoanaCuProgresMax
        j. private void eliminaPersoana(int id)
            i. Luăm un camp care sa ne spună dacă există o persoana cu id-ul primit în array sau nu (boolean anGasitPersoana = false)
            ii. Parcurgem array-ul cu un for și verificăm dacă elementul de la poziția curentă (persoane[i]) este diferit de null și dacă atributul id este egal cu id-ul primit (persoane[i] != null && persoane[i].id == id)
            iii. Dacă am găsit persoana, atunci punem null pe poziția curentă din array (persoane[i] = null), trebuie sa scadem 1 din numărul de persoane (nrPersoane–) și sa setam amGasitPersoana = true
            iv. La sfarsit verificăm dacă am găsit sau nu persoana (dacă variabila amGasitPersoana este false sau nu) și dacă e false atunci aruncăm o excepție
        k. private void inchide() - seteaza esteDeschisa = false și afișează “Sala s-a închis”
    6. Scrieți o clasa PersoanaNuExista care sa extindă Exception (aruncati aceasta excepție mai sus, în metodă eliminaPersoana și marcați că metodă poate arunca o astfel de excepție 
    7. Scrieți o clasa SalaInchisa care sa extindă runtimeException
    8. Scrieți un enum Acțiune care sa aiba constantele DESCHIDE, ADAUGA_ANTRENOR, ADAUGA_ABONAT, AFISEAZA_PERSOANE, AFISEAZA_ANTRENORI, AFISEAZA_ABONAT_MAX, ELIMINA_PERSOANA, INCHIDE
    9. În clasa SalaFitness, adaugati o metodă void acțiune(Acțiune acțiune) care face următoarele lucruri:
        a. Verifica dacă sala este închisă (!salaDeschisa) și dacă acțiunea este diferită de Acțiune.DESCHIDERE - dacă se intampla asta (adică dacă sala nu este deschisa și se încearcă orice acțiune mai puțin deschiderea salii, atunci avem o problema), aruncați o excepție de tipul SalaInchisa
        b. Cu un switch puneți câte un caz pentru fiecare constanta din enum
            i. dacă acțiunea primită este DESCHIDE atunci se apelează metoda deschide() și se da break;
            ii. Dacă acțiunea este ADAUGA_ANTRENOR atunci se apelează metodă adaugaAntrenor(ClasaUtilitara.genereazaNume(), ClasaUtilitara.genereazaVarsta(), ClasaUtilitara.genereazaNrAbonati()) - folosim aceste metode pentru a genera numere diferite de fiecare data, că programul sa nu fie mereu la fel
            iii. Dacă acțiunea este ADAUGA_ABONAT atunci se apelează metodă adaugaAbonat(ClasaUtilitara.genereazaNume(), ClasaUtilitara.genereazaVarsta(), ClasaUtilitara.genereazaProgres())
            iv. Daca actiunea este AFISEAZA_PERSOANE se apelează afiseazaPersoane() și se da break;
            v. Daca actiunea este AFISEAZA_ANTRENORI se apelează afiseazaAntrenori() și se da break;
            vi. Daca actiunea este AFISEAZA_ABONAT_MAX se apelează afiseazaAbonatCuProgresMax(ClasaUtilitara.genereazaId()) și se da break;
            vii. Daca actiunea este ÎNCHIDE se apelează închide() și se da break;
    10. Scrieți o clasă Program cu o metodă main în care sa definiti un array cu diverse Acțiuni din enum (ex: Actiune[] actiuni = {Acțiune.DESCHIDE, Acțiune.AFISEAZA_PERSOANE}; ). Adaugati și un obiect de tipul salaFitness, parcurgeți array-ul de mai sus cu un for-each și apelați metodă acțiune pe obiectul SalaFitness cu elementul curent din array.
    11. Rulati programul, modificați array-ul astfel incat sa fie aruncata o excepție.
