package project1_mobile_service.model.entity;


/**
 * The {@code Client} class represents an entity that uses the services of a mobile operator.
 *
 * @author Alex Naumenko
 * @see Company
 * @version 1.0
 */


public class Client {
    /**
     * Client counter
     */
    private static int counter;
    /**
     * Client id
     */
    private int id = ++counter;
    /**
     * Client tariff
     */
    private Company.Tariff tariff;

    /**
     * Returns client id
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Initializes a newly created Client object.
     */
    public Client() {
    }

    /**
     * Constructs a new Client object with tariff.
     */

    public Client(Company.Tariff tariff) {
        this.tariff = tariff;
    }

    /**
     * Returns client tariff
     * @return tariff
     */
    public Company.Tariff getTariff() {
        return tariff;
    }

    /**
     * Parameter tariff to set one tariff for current client.
     * @param tariff
     * @return  true (if tariff was added successfully) or false (if adding tariff failed)
     */
    public boolean setTariff(Company.Tariff tariff) {
        if (tariff.equals(this.tariff)) {
            return false;
        }
        this.tariff = tariff;
        tariff.addClient(this);
        return true;
    }
    /**
     * Indicates whether some other Client is "equal to" this one.
     * @param o
     * @return true or false
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        return id == client.id;
    }

    /**
     * Returns a hash code value for the Client object
     * @return result
     */

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (tariff != null ? tariff.hashCode() : 0);
        return result;
    }

    /**
     * Returns a string representation of the Client object
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", tariff=" + tariff +
                '}';
    }
}
