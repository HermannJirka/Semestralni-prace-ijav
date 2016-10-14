/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ekon;

import java.io.Serializable;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

/**
 *
 * @author George
 */
public class Firma implements Comparable, Serializable {

    private String nazevFirmy;
    private String mesto;
    private String ulice;
    private String kraj;
    private int psc;
    private String kontakt;
    private String email;
    private int ico;
    private int dico;
    private int pocetZamestnancu;
    private double rocniObrat;
    private double rocniNaklady;
    private double rocniVydelek;
    private double mesicniObrat;
    private double mesicniVydelek;
    private double mesicniNaklady;
    private ArrayList<Zamestnanec> listZamestanancu = new ArrayList<Zamestnanec>();
    private final static Collator COL = Collator.getInstance(new Locale("cs", "CZ"));

    public Firma(String nazevFirmy, String mesto, String ulice, String kontakt, String email, int ico, int dico, String kraj, int psc) {
        this.nazevFirmy = nazevFirmy;
        this.mesto = mesto;
        this.ulice = ulice;
        this.kontakt = kontakt;
        this.email = email;
        this.ico = ico;
        this.dico = dico;
        this.kraj = kraj;
        this.psc = psc;
    }

    public ArrayList<Zamestnanec> getListZamestanancu() {
        return listZamestanancu;
    }

    public void setListZamestanancu(ArrayList<Zamestnanec> listZamestanancu) {
        this.listZamestanancu = listZamestanancu;
    }

    public String getKraj() {
        return kraj;
    }

    public void setKraj(String kraj) {
        this.kraj = kraj;
    }

    public String getKontakt() {
        return kontakt;
    }

    public void setKontakt(String kontakt) {
        this.kontakt = kontakt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNazevFirmy() {
        return nazevFirmy;
    }

    public void setNazevFirmy(String nazevFirmy) {
        this.nazevFirmy = nazevFirmy;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public String getUlice() {
        return ulice;
    }

    public void setUlice(String ulice) {
        this.ulice = ulice;
    }

    public int getPsc() {
        return psc;
    }

    public void setPsc(int psc) {
        this.psc = psc;
    }

    public int getIco() {
        return ico;
    }

    public void setIco(int ico) {
        this.ico = ico;
    }

    public int getDico() {
        return dico;
    }

    public void setDico(int dico) {
        this.dico = dico;
    }

    public int getPocetZamestnancu() {
        return pocetZamestnancu;
    }

    public void setPocetZamestnancu(int pocetZamestnancu) {
        this.pocetZamestnancu = pocetZamestnancu;
    }

    public double getRocniObrat() {
        return rocniObrat;
    }

    public void setRocniObrat(double rocniObrat) {
        this.rocniObrat = rocniObrat;
    }

    public double getRocniNaklady() {
        return rocniNaklady;
    }

    public void setRocniNaklady(double rocniNaklady) {
        this.rocniNaklady = rocniNaklady;
    }

    public double getRocniVydelek() {
        return rocniVydelek;
    }

    public void setRocniVydelek(double rocniVydelek) {
        this.rocniVydelek = rocniVydelek;
    }

    public double getMesicniObrat() {
        return mesicniObrat;
    }

    public void setMesicniObrat(double mesicniObrat) {
        this.mesicniObrat = mesicniObrat;
    }

    public double getMesicniVydelek() {
        return mesicniVydelek;
    }

    public void setMesicniVydelek(double mesicniVydelek) {
        this.mesicniVydelek = mesicniVydelek;
    }

    public double getMesicniNaklady() {
        return mesicniNaklady;
    }

    public void setMesicniNaklady(double mesicniNaklady) {
        this.mesicniNaklady = mesicniNaklady;
    }

    public void pridejZamestnance(Zamestnanec zamestnanec) {
        if (zamestnanec != null) {
            listZamestanancu.add(zamestnanec);
        }
    }

    public Zamestnanec vyhledejZamestnancePodleJmena(String prijmeni) {
        Zamestnanec zamestnanec = null;
        for (int i = 0; i < listZamestanancu.size(); i++) {
            if (listZamestanancu.get(i).getPrijmeni().equals(prijmeni)) {
                zamestnanec = listZamestanancu.get(i);
            }
        }

        return zamestnanec;
    }

    public Zamestnanec vyhledejZamestnancePodleID(String id) {
        Zamestnanec zamestnanec = null;
        for (int i = 0; i < listZamestanancu.size(); i++) {
            if (listZamestanancu.get(i).getIdZamestnance().equals(id)) {
                zamestnanec = listZamestanancu.get(i);
            }
        }

        return zamestnanec;
    }

    public Zamestnanec smazZamestnance(String idZamestnance) {
        Zamestnanec zam = null;
        for (int i = 0; i < listZamestanancu.size(); i++) {
            if (idZamestnance == listZamestanancu.get(i).getIdZamestnance()) {
                zam = listZamestanancu.get(i);
                listZamestanancu.remove(i).getIdZamestnance();
            }
        }
        return zam;
    }

    public Zamestnanec smazZamestnanceDlePrijmeni(String prijmeni) {
        Zamestnanec zam = null;
        for (int i = 0; i < listZamestanancu.size(); i++) {
            if (prijmeni.equals(listZamestanancu.get(i).getIdZamestnance())) {
                zam = listZamestanancu.get(i);
                listZamestanancu.remove(i).getIdZamestnance();
            }
        }
        return zam;
    }
    public Iterator dejIteratorZamestnancu(){
        return listZamestanancu.iterator();
    }
    @Override
    public int compareTo(Object t) {
        Firma f = (Firma) t;
        return COL.compare(this.nazevFirmy, f.nazevFirmy);
    }

    public static final Comparator PODLE_NAZVUFIRMY = new Comparator() {

        @Override
        public int compare(Object t, Object t1) {
            Firma f1 = (Firma) t;
            Firma f2 = (Firma) t1;
            return COL.compare(f1.nazevFirmy, f2.nazevFirmy);
        }
    };

    @Override
    public String toString() {
        return "Firma{" + "nazevFirmy=" + nazevFirmy + ", mesto=" + mesto + ", ulice=" + ulice + ", kraj=" + kraj + ", psc=" + psc + ", kontakt=" + kontakt + ", email=" + email + ", ico=" + ico + ", dico=" + dico + ", pocetZamestnancu=" + pocetZamestnancu + ", rocniObrat=" + rocniObrat + ", rocniNaklady=" + rocniNaklady + ", rocniVydelek=" + rocniVydelek + ", mesicniObrat=" + mesicniObrat + ", mesicniVydelek=" + mesicniVydelek + ", mesicniNaklady=" + mesicniNaklady + '}';
    }

}
