package ce.group30.fahrradlenker.objects;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    String vorname;
    String nachname;

    static int id = 1;

    Order bestellungen;

    public Customer(String vorname, String nachname) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.bestellungen = null;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public Order getBestellungen() {
        return bestellungen;
    }

    public void setBestellungen(Order bestellungen) {
        this.bestellungen = bestellungen;
    }

    public void setLenkertyp(String handlebar) {
        this.bestellungen.setLenkertyp(handlebar);
    }
}
