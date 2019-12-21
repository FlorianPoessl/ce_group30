package ce.group30.fahrradlenker.services;

import ce.group30.fahrradlenker.objects.Customer;

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
}
