package project1_mobile_service.data;

import project1_mobile_service.model.entity.*;

import java.util.Arrays;
import java.util.Random;

public class DataSource {

    public static Client getNewClient() {
        return new Client();
    }

    public static Company getTariff(Company company) {
        company.setTariffList(Arrays.asList(
                new Company.TariffWithoutInternet(
                        "Льготный",
                        25,
                        SMS.MB_100,
                        new Company.Tariff.Calls(Minutes.M_500, Minutes.M_100)),
                new Company.TariffInternet(
                        "VIP 3G",
                        250,
                        SMS.MB_100,
                        new Company.Tariff.Calls(Minutes.UNLIMITED, Minutes.M_100),
                        new Company.Tariff.Internet(GenerationMobile.GENERATION_3G, Megabytes.MB_1000)),
                new Company.TariffInternet(
                        "Бомба",
                        150,
                        SMS.MB_100,
                        new Company.Tariff.Calls(Minutes.UNLIMITED, Minutes.M_100),
                        new Company.Tariff.Internet(GenerationMobile.GENERATION_4G, Megabytes.MB_2000)),
                new Company.TariffWithoutInternet(
                        "Дети",
                        100,
                        SMS.UNLIMITED,
                        new Company.Tariff.Calls(Minutes.UNLIMITED, Minutes.M_500)),
                new Company.TariffInternet(
                        "Звонки всем",
                        50,
                        SMS.MB_500,
                        new Company.Tariff.Calls(Minutes.UNLIMITED, Minutes.M_100),
                        new Company.Tariff.Internet(GenerationMobile.GENERATION_3G, Megabytes.MB_100)),
                new Company.TariffInternet(
                        "VIP 6G",
                        300,
                        SMS.UNLIMITED,
                        new Company.Tariff.Calls(Minutes.UNLIMITED, Minutes.UNLIMITED),
                        new Company.Tariff.Internet(GenerationMobile.GENERATION_6G, Megabytes.UNLIMITED))

        ));
        return company;
    }

    public static void getRandomClients(Company company) {
        Random random = new Random();
        int numberOfClient;
        for (Company.Tariff tariff : company.getTariffList()) {
            numberOfClient = random.nextInt(100);
            for (int i = 0; i < numberOfClient; i++) {
                tariff.addClient(getNewClient());
            }
        }
    }
}
