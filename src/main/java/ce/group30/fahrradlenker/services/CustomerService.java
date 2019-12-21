package ce.group30.fahrradlenker.services;

import ce.group30.fahrradlenker.objects.Customer;
import org.json.JSONObject;

public class CustomerService {

    Customer customer;

    public void addNewCustomer(String vorname, String nachname) {
        customer = new Customer(vorname, nachname);
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setLenkertyp(String handlebar) {
        this.customer.getBestellungen().setLenkertyp(handlebar);
    }

    public void setMaterial(String material) {
        this.customer.getBestellungen().setMaterial(material);
    }

    public void setGriff(String griff) {
        this.customer.getBestellungen().setGriff(griff);
    }

    public void setSchaltung(String schaltung) {
        this.customer.getBestellungen().setSchaltung(schaltung);
    }

    public String getOrderInfoJson() {
        String jsonString = new JSONObject()
                .put("vorname", customer.getVorname())
                .put("nachname", customer.getNachname())
                .put("bestellung", new JSONObject()
                        .put("lenkertyp", customer.getBestellungen().getLenkertyp())
                        .put("material", customer.getBestellungen().getMaterial())
                        .put("schaltung", customer.getBestellungen().getSchaltung())
                        .put("griff", customer.getBestellungen().getGriff())).toString();
        System.out.println(jsonString);
        return jsonString;
    }
}
