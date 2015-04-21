package pl.com.bottega.ecommerce.sharedkernel;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MoneyTest {

    @Test
    public void shouldAddMoneyOfTheSameCurrency() {
        Money money = new Money(22.33, "USD");
        Money moneyToAdd = new Money(11.22, "USD");

        Money result = money.add(moneyToAdd);

        Money expected = new Money(33.55, "USD");
        assertThat(result, is(expected));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowWhenAddingDifferentCurrency() {
        Money money = new Money(11.99, "USD");
        Money moneyToAdd = new Money(2.99, "PLN");

        money.add(moneyToAdd);
    }

    @Test
    public void shouldSubtractMoneyOfTheSameCurrency() {
        Money money = new Money(9.29, "USD");
        Money moneyToSubtract = new Money(1.29, "USD");

        Money result = money.subtract(moneyToSubtract);

        Money expected = new Money(8.00, "USD");
        assertThat(result, is(expected));
    }



}