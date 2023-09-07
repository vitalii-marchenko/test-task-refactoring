package mortagage;

import org.junit.Assert;
import org.junit.Test;

import static mortgage.MortgageInstallmentCalculator.calculateMonthlyPayment;

public class MortgageInstallmentCalculatorTest {

    @Test
    public void shouldCalculateMonthlyPaymentWhenAmountsAreSmall() {
        double monthlyPaymentAmount = calculateMonthlyPayment(1_000, 1, 12);
        Assert.assertEquals(88.84d, monthlyPaymentAmount, 0.01d);
    }

    @Test
    public void shouldCalculateMonthlyPaymentWhenAmountIsLarge() {
        double monthlyPaymentAmount = calculateMonthlyPayment(10_000_000, 1, 12);
        Assert.assertEquals(888487.88d, monthlyPaymentAmount, 0.01d);
    }

    @Test
    public void shouldCalculateMonthlyPaymentWhenPrincipalIsZero() {
        double monthlyPaymentAmount = calculateMonthlyPayment(0, 1, 12);
        Assert.assertEquals(0, monthlyPaymentAmount, 0.01d);
    }

    @Test
    public void shouldCalculateMonthlyPaymentWhenInterestRateIsZero() {
        double monthlyPaymentAmount = calculateMonthlyPayment(1000, 1, 0);
        Assert.assertEquals(83.33, monthlyPaymentAmount, 0.01d);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowInvalidInputExceptionOnNegativeTenure() {
        calculateMonthlyPayment(20, -10, 14.5);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowInvalidInputExceptionOnNegativeInterestRate() {
        calculateMonthlyPayment(20, 1, -12);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowInvalidInputExceptionOnNegativePrincipalAmount() {
        calculateMonthlyPayment(-20, 10, 14.5);
    }
}
