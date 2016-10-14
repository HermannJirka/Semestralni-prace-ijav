/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ekon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author George
 */
public class VytvoreniFirmy implements Serializable {

    private ArrayList<Firma> listFirem = new ArrayList<>();
    private Firma aktulaniFirma;
    private Zamestnanec aktualniZamestnanec;

    public void pridejFirmu(Firma firma) {
        listFirem.add(firma);

    }

    public Firma vyhledejFirmu(String nazev) {
        Firma firma = null;
        if (!listFirem.isEmpty()) {
            for (int i = 0; i < listFirem.size(); i++) {
                if (nazev.equals(listFirem.get(i).getNazevFirmy())) {
                    firma = listFirem.get(i);
                }
            }
        }
        aktulaniFirma = firma;
        return firma;
    }

    public Firma smazFirmu(String nazev) {
        Firma firma = null;
        if (!listFirem.isEmpty()) {
            for (int i = 0; i < listFirem.size(); i++) {
                if (nazev.equals(listFirem.get(i).getNazevFirmy())) {
                    firma = listFirem.get(i);
                    listFirem.remove(i);
                }
            }
        }
        return firma;
    }

    public Iterator dejIterator() {
        if (!listFirem.isEmpty()) {
            Iterator it = listFirem.iterator();
            return it;
        } else {
            return null;
        }
    }

    public void smazFirmy() {
        if (listFirem.isEmpty()) {
            listFirem.removeAll(listFirem);
        }
    }

    public ArrayList<Firma> getListFirem() {
        return listFirem;
    }

    public void setListFirem(ArrayList<Firma> listFirem) {
        this.listFirem = listFirem;
    }

}
