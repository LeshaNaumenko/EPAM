package project1_mobile_service.model.entity;

public class Client {
    private static int counter;
    private int id = ++counter;
    private Company.Tariff tariff;

    public int getId() {
        return id;
    }

    public Client() {
    }

    public Client(Company.Tariff tariff) {
        this.tariff = tariff;
    }

    public Company.Tariff getTariff() {
        return tariff;
    }

    public boolean setTariff(Company.Tariff tariff) {
        if (tariff.equals(this.tariff)) {
            return false;
        }
        tariff.addClient(this);
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        return id == client.id;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (tariff != null ? tariff.hashCode() : 0);
        return result;
    }
}
