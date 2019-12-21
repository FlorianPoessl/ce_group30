package ce.group30.fahrradlenker.objects;

public class Order {

    private String lenkertyp;
    private  String material;
    private String griff;
    private String schaltung;

    public Order() {

    }

    public Order(String lenkertyp, String material, String griff, String schaltung) {
        this.lenkertyp = lenkertyp;
        this.material = material;
        this.griff = griff;
        this.schaltung = schaltung;
    }

    public String getLenkertyp() {
        return lenkertyp;
    }

    public String getMaterial() {
        return material;
    }

    public String getGriff() {
        return griff;
    }

    public String getSchaltung() {
        return schaltung;
    }

    public void setLenkertyp(String lenkertyp) {
        this.lenkertyp = lenkertyp;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setGriff(String griff) {
        this.griff = griff;
    }

    public void setSchaltung(String schaltung) {
        this.schaltung = schaltung;
    }
}
