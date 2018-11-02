package project1_mobile_service.model.comparator;

import project1_mobile_service.model.entity.Company;

import java.util.Comparator;


/**
 * Comparator class {@code SortBySubscriptFeeComparator} compares tariffs by price.
 * This class implements {@code Comparator} interface.
 *
 * @author Alex Naumenko
 * @see Comparator
 * @version 1.0
 */
public class SortBySubscriptFeeComparator implements Comparator<Company.Tariff> {

    /**
     * Compares its two arguments for order.  Returns a negative integer,
     * zero, or a positive integer as the first argument is less than, equal
     * to, or greater than the second.<p>
     *
     * @param o1 the first tariff to be compared.
     * @param o2 the second tariff to be compared.
     * @return a negative integer, zero, or a positive integer as the
     *         first argument is less than, equal to, or greater than the
     *         second.
     */
    @Override
    public int compare(Company.Tariff o1, Company.Tariff o2) {
        return Double.compare(o1.getSubscriptionFee(), o2.getSubscriptionFee());
    }
}
