package project1_mobile_service.model.comparator;

import project1_mobile_service.model.entity.Company;

import java.util.Comparator;

public class sortBySubscriptFeeComparator implements Comparator<Company.Tariff> {
    @Override
    public int compare(Company.Tariff o1, Company.Tariff o2) {
        return Double.compare(o1.getSubscriptionFee(), o2.getSubscriptionFee());
    }
}
