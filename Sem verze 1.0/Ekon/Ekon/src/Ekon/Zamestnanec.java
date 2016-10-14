/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ekon;

import java.io.Serializable;
import java.text.Collator;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author George
 */
public class Zamestnanec implements Comparable,Serializable {

    private String jmeno;
    private String prijmeni;
    private String mesto;
    private String ulice;
    private int psc;
    private String kraj;
    private String titul;
    private String datumNarozeni;
    private String email;
    private int telefoniCislo;
    private int rodneCislo;
    private double pocetHodinMesic;
    private double superHrubaMzda;
    private String narodnost;
    private String pozice;
    private String idZamestnance;
    private final static Collator COL = Collator.getInstance(new Locale("cs", "CZ"));

    public Zamestnanec(String jmeno, String prijmeni, String mesto, String ulice, int psc, String kraj, String titul, String datumNarozeni, String email, int telefoniCislo, int rodneCislo, String narodnost, String pozice) {
        if (jmeno == null || prijmeni == null) {
            throw new NullPointerException();
        }
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.mesto = mesto;
        this.ulice = ulice;
        this.psc = psc;
        this.kraj = kraj;
        this.titul = titul;
        this.datumNarozeni = datumNarozeni;
        this.email = email;
        this.telefoniCislo = telefoniCislo;
        this.rodneCislo = rodneCislo;
        this.narodnost = narodnost;
        this.pozice = pozice;
        this.idZamestnance = idZamestnance;
    }

    public String getNarodnost() {
        return narodnost;
    }

    public void setNarodnost(String narodnost) {
        this.narodnost = narodnost;
    }

    public String getPozice() {
        return pozice;
    }

    public void setPozice(String pozice) {
        this.pozice = pozice;
    }

    public String getIdZamestnance() {
        return idZamestnance;
    }

    public void setIdZamestnance(String idZamestnance) {
        this.idZamestnance = idZamestnance;
    }
    
    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
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

    public String getKraj() {
        return kraj;
    }

    public void setKraj(String kraj) {
        this.kraj = kraj;
    }

    public String getTitul() {
        return titul;
    }

    public void setTitul(String titul) {
        this.titul = titul;
    }

    public String getDatumNarozeni() {
        return datumNarozeni;
    }

    public void setDatumNarozeni(String datumNarozeni) {
        this.datumNarozeni = datumNarozeni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefoniCislo() {
        return telefoniCislo;
    }

    public void setTelefoniCislo(int telefoniCislo) {
        this.telefoniCislo = telefoniCislo;
    }

    public int getRodneCislo() {
        return rodneCislo;
    }

    public void setRodneCislo(int rodneCislo) {
        this.rodneCislo = rodneCislo;
    }

    public double getPocetHodinMesic() {
        return pocetHodinMesic;
    }

    public void setPocetHodinMesic(double pocetHodinMesic) {
        this.pocetHodinMesic = pocetHodinMesic;
    }

    public double getSuperHrubaMzda() {
        return superHrubaMzda;
    }

    public void setSuperHrubaMzda(double superHrubaMzda) {
        this.superHrubaMzda = superHrubaMzda;
    }

    @Override
    public int compareTo(Object t) {
        Zamestnanec z = (Zamestnanec) t;
        int tmpJ = COL.compare(this.jmeno, z.jmeno);
        int tmpP = COL.compare(this.prijmeni, z.prijmeni);
        return (tmpP == 0 ? tmpJ : tmpP);
    }
    public static final Comparator PODLE_PRIJMENI = new Comparator() {

        @Override
        public int compare(Object t, Object t1) {
            Zamestnanec zam1 = (Zamestnanec) t;
            Zamestnanec zam2 = (Zamestnanec) t1;
            int tmpP = COL.compare(zam1.prijmeni, zam2.prijmeni);
            int tmpJ = COL.compare(zam1.jmeno, zam2.jmeno);
            return (tmpP == 0 ? tmpJ : tmpP);
        }
    };
    public static final Comparator PODLE_POZICE = new Comparator() {

        @Override
        public int compare(Object t, Object t1) {
            Zamestnanec zam1 = (Zamestnanec) t;
            Zamestnanec zam2 = (Zamestnanec) t1;
            return COL.compare(zam1.pozice, zam2.pozice);
        }
    };

    @Override
    public String toString() {
        return "Zamestnanec{" + "jmeno=" + jmeno + ", prijmeni=" + prijmeni + ", mesto=" + mesto + ", ulice=" + ulice + ", psc=" + psc + ", kraj=" + kraj + ", titul=" + titul + ", datumNarozeni=" + datumNarozeni + ", email=" + email + ", telefoniCislo=" + telefoniCislo + ", rodneCislo=" + rodneCislo + ", pocetHodinMesic=" + pocetHodinMesic + ", superHrubaMzda=" + superHrubaMzda + ", narodnost=" + narodnost + ", pozice=" + pozice + '}';
    }

}
