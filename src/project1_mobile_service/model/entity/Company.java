package project1_mobile_service.model.entity;

import java.util.*;

public class Company {
    /**
     * Counter for personal tariff id.
     * */
    private static int counter;
    /**
     *  Name of parent company that owns this company.
     */
    private String parentCompany;

    /**
     * Company location.
     */
    private String location;
    /**
     * Total number of tariffs.
     */
    private List<Tariff> tariffList = new ArrayList<>();

    /**
     * Initializes a newly created Company object.
     */
    public Company() {
    }


    /**
     * Constructs a new Company object with location and name of parent company.
     * @param parentCompany
     * @param location
     */
    public Company(String parentCompany, String location) {
        this.parentCompany = parentCompany;
        this.location = location;
    }

    /**
     * Returns the number of total clients.
     * @return sum
     */
    public int getTotalNumberOfClients() {
        int sum = 0;
        for (Company.Tariff tariff : tariffList) {
            sum += tariff.getClientsList().size();
        }
        return sum;
    }

    /**
     * Sorts this list according to the order induced by the specified Comparator.
     * @param comparator
     * @return sorted list of the tariffs
     */

    public List<Company.Tariff> sort(Comparator<Company.Tariff> comparator) {
        List<Company.Tariff> temp = new ArrayList<>(tariffList);
        Collections.sort(temp, comparator);
        return temp;
    }

    /**
     * Returns the parent company.
     * @return parentCompany
     */
    public String getParentCompany() {
        return parentCompany;
    }

    /**
     * Parameter parent company to set.
     * @param parentCompany
     */
    public void setParentCompany(String parentCompany) {
        this.parentCompany = parentCompany;
    }
    /**
     * Returns the location.
     * @return location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Parameter location company to set.
     * @param location
     */
    public void setLocation(String location) {
        this.location = location;
    }
    /**
     * Returns list of tariffs.
     * @return tariffList
     */
    public List<Tariff> getTariffList() {
        return tariffList;
    }

    /**
     * Parameter list of tariffs of the company to set.
     * @param tariffList
     */

    public void setTariffList(List<Tariff> tariffList) {
        this.tariffList = tariffList;
    }

    /**
     * Parameter tariff to add to tariff list of the company.
     * If such a tariff already exists in the company, then it is not added.
     * @param tariff
     * @return true (if the tariff was added successfully) or false (if adding tariff failed)
     */

    public boolean addTariff(Tariff tariff) {
        if (!tariffList.contains(tariff)) {
            tariffList.add(tariff);
            return true;
        }
        return false;
    }

    /**
     *  Abstract static nested class {@code Toy} is super class of tariff's entity.
     */
    public abstract static class Tariff {

        /**
         * Tariff id.
         */
        private int id = ++counter;
        /**
         * Tariff name.
         */
        private String name;
        /**
         * Subscription fee of the tariff plan.
         */
        private double subscriptionFee; //абонентская плата
        /**
         * List of clients of the tariff plan.
         */
        private Map<Integer, Client> clientsList = new HashMap<Integer, Client>();
        /**
         * SMS object of the tariff plan.
         */
        private SMS sms;
        /**
         * Calls object of the tariff plan.
         */
        private Calls calls;
        /**
         * Internet object of the tariff plan.
         */

        /**
         * Initializes a newly created Tariff object.
         */
        public Tariff() {
        }

        /**
         * Constructs a new Tariff object with name, subscription fee, sms and calls.
         */
        public Tariff(String name, double subscriptionFee, SMS sms,  Calls calls) {
            this.name = name;
            this.subscriptionFee = subscriptionFee;
            this.sms = sms;
            this.calls = calls;
        }

        /**
         * Parameter client to add one client to clients list of the tariff.
         * @param client
         * @return true (if client was added successfully) or false (if adding client failed)
         */
        public boolean addClient(Client client) {
            if (clientsList.containsKey(client.getId())) {
                return false;
            }
            client.setTariff(this);
            clientsList.put(client.getId(), client);
            return true;
        }

        /**
         * Returns tariff id.
         * @return id
         */
        public int getId() {
            return id;
        }

        /**
         * Returns the name of the tariff.
         * @return name
         */

        public String getName() {
            return name;
        }

        /**
         * Parameter name to set.
         * @param name
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * Returns the Subscription Fee of the tariff.
         * @return subscriptionFee
         */
        public double getSubscriptionFee() {
            return subscriptionFee;
        }

        /**
         * Returns list of clients.
         * @return list of clients
         */
        public Collection<Client> getClientsList() {
            return clientsList.values();
        }

        /**
         * Returns the SMS object of the tariff.
         * @return sms
         */
        public SMS getSms() {
            return sms;
        }

        /**
         * Returns the Сalls object of the tariff.
         * @return calls
         */
        public Calls getCalls() {
            return calls;
        }

        /**
         * Parameter subscription fee to set.
         * @param subscriptionFee
         */

        public void setSubscriptionFee(double subscriptionFee) {
            this.subscriptionFee = subscriptionFee;
        }

        /**
         * Parameter list of clients to set.
         * @param clientsList
         */
        public void setClientsList(Map<Integer, Client> clientsList) {
            this.clientsList = clientsList;
        }

        /**
         * Parameter list to add to clients list of the tariff.
         * @param list
         */
        public void addClientsList(List<Client> list) {
            for (Client client : list) {
                addClient(client);
            }
        }

        /**
         * Parameter sms to set.
         * @param sms
         */

        public void setSms(SMS sms) {
            this.sms = sms;
        }

        /**
         * Parameter calls to set.
         * @param calls
         */
        public void setCalls(Calls calls) {
            this.calls = calls;
        }


        /**
         * Returns a string representation of the Tariff object
         * @return a string representation of the object
         */
        @Override
        public String toString() {
            return String.format(
                    "%-22s {" +
                    "id = %-3d" +
                    "name = %-13s" +
                    "Subscription Fee = %-7s" +
                    "sms = %-12s" +
                    "calls = %-40s" +
                    "number of clients=%-5s"
                    , this.getClass().getSimpleName(),
                    id,
                    name,
                    subscriptionFee,
                    sms,
                    calls,
                    clientsList.values().size()
            );
        }

        /**
         * Indicates whether some other Tariff is "equal to" this one.
         * @param o
         * @return true or false
         */

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Tariff tariff = (Tariff) o;

            if (id != tariff.id) return false;
            if (Double.compare(tariff.subscriptionFee, subscriptionFee) != 0) return false;
            if (name != null ? !name.equals(tariff.name) : tariff.name != null) return false;
            if (sms != tariff.sms) return false;
            return calls != null ? calls.equals(tariff.calls) : tariff.calls == null;
        }

        /**
         * Returns a hash code value for the Tariff object
         * @return result
         */
        @Override
        public int hashCode() {
            int result;
            long temp;
            result = id;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            temp = Double.doubleToLongBits(subscriptionFee);
            result = 31 * result + (int) (temp ^ (temp >>> 32));
            result = 31 * result + (sms != null ? sms.hashCode() : 0);
            result = 31 * result + (calls != null ? calls.hashCode() : 0);
            return result;
        }

        /**
         * Static nested class {@code Calls} is used by tariff class
         * for representing {@code Calls} entity.
         */

        public static class Calls {
            /**
             * Number of minutes for your mobile controller.service
             */
            private Minutes own;
            /**
             * Number of minutes for other mobile services
             */
            private Minutes other;

            /**
             * Constructs a new Calls object with own and other.
             */

            public Calls(Minutes own, Minutes other) {
                this.own = own;
                this.other = other;
            }

            /**
             * Returns a string representation of the Calls object
             * @return
             */
            @Override
            public String toString() {
                return "Calls{" +
                        "own=" + own +
                        ", other=" + other +
                        '}';
            }
        }

        /**
         * Static nested class {@code Internet} is used by tariff class
         * for representing {@code Internet} entity.
         */
        public static class Internet {
            /**
             * Generation of the internet
             */
            private GenerationMobile generation = null;
            /**
             * Number of megabytes of the internet
             */
            private Megabytes megabytes = null;

            /**
             * Constructs a new Internet object with generation and megabytes.
             */
            public Internet(GenerationMobile generation, Megabytes megabytes) {
                this.generation = generation;
                this.megabytes = megabytes;
            }

            /**
             * Returns the generation .
             * @return generation
             */
            public GenerationMobile getGeneration() {
                return generation;
            }

            /**
             * Parameter generation to set.
             * @param generation
             */
            public void setGeneration(GenerationMobile generation) {
                this.generation = generation;
            }
            /**
             * Returns number of megabytes .
             * @return megabytes
             */
            public Megabytes getMegabytes() {
                return megabytes;
            }

            /**
             * Parameter megabytes to set.
             * @param megabytes
             */
            public void setMegabytes(Megabytes megabytes) {
                this.megabytes = megabytes;
            }

            /**
             * Returns a string representation of the Internet object
             * @return a string representation of the Internet
             */
            @Override
            public String toString() {
                return "Internet{" +
                        "generation=" + generation +
                        ", megabytes=" + megabytes +
                        '}';
            }
        }
    }

    /**
     * Static nested class {@code TariffInternet} extends
     * abstract static nested class {@code Tariff}.
     */
    public static class TariffInternet extends Tariff{

        /**
         * Internet tariff
         */
        private Internet internet;

        /**
         * Constructs a new TariffInternet object with name, subscription fee, sms, calls and internet.
         */

        public TariffInternet(String name, double subscriptionFee, SMS sms, Calls calls, Internet internet) {
            super(name, subscriptionFee,sms, calls);
            this.internet = internet;
        }

        /**
         * Returns the Internet object.
         * @return internet
         */
        public Internet getInternet() {
            return internet;
        }
        /**
         * Parameter internet to set.
         * @param internet
         */
        public void setInternet(Internet internet) {
            this.internet = internet;
        }

        /**
         * Returns a string representation of the TariffInternet object
         * @return a string representation of the TariffInternet
         */

        @Override
        public String toString() {
            return super.toString() +String.format("internet = %-30s", internet);
        }
    }

    /**
     * Static nested class {@code TariffWithoutInternet} extends
     * abstract static nested class {@code Tariff}.
     */
    public static class TariffWithoutInternet extends Tariff{
        /**
         * Initializes a newly created TariffWithoutInternet object.
         */
        public TariffWithoutInternet() {
        }

        /**
         * Constructs a new TariffWithoutInternet object with name, subscription fee, sms and calls.
         */
        public TariffWithoutInternet(String name, double subscriptionFee, SMS sms, Calls calls) {
            super(name, subscriptionFee, sms, calls);
        }

        /**
         * Returns a string representation of the TariffWithoutInternet object
         * @return a string representation of the TariffWithoutInternet
         */
        @Override
        public String toString() {
            return super.toString()+'}';
        }
    }

}
