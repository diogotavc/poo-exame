import java.util.Objects;

public class Client {
    private int taxId;
    private String name;
    private String type;
    public Object spaceType;

    public Client() {
    }

    public Client(int taxId, String name, String type) {
        this.taxId = taxId;
        this.name = name;
        this.type = type;
    }

    public int getTaxId() {
        return this.taxId;
    }

    public void setTaxId(int taxId) {
        this.taxId = taxId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Client taxId(int taxId) {
        setTaxId(taxId);
        return this;
    }

    public Client name(String name) {
        setName(name);
        return this;
    }

    public Client type(String type) {
        setType(type);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Client)) {
            return false;
        }
        Client client = (Client) o;
        return taxId == client.taxId && Objects.equals(name, client.name) && Objects.equals(type, client.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taxId, name, type);
    }

    @Override
    public String toString() {
        return "{" +
            " taxId='" + getTaxId() + "'" +
            ", name='" + getName() + "'" +
            ", type='" + getType() + "'" +
            "}";
    }
}