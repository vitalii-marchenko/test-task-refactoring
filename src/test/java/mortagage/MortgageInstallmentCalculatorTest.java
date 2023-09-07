package mortagage;

import org.junit.Test;

import static mortgage.MortgageInstallmentCalculator.calculateMortgagePayment;
import static org.junit.Assert.assertEquals;

public class MortgageInstallmentCalculatorTest {

    @Test
    public void shouldCalculateMonthlyPaymentWhenAmountsAreSmall() {
        double monthlyPaymentAmount = calculateMortgagePayment(1_000, 1, 12);
        assertEquals(88.84d, monthlyPaymentAmount, 0.01d);
    }

    @Test
    public void shouldCalculateMonthlyPaymentWhenAmountIsLarge() {
        double monthlyPaymentAmount = calculateMortgagePayment(10_000_000, 1, 12);
        assertEquals(888487.88d, monthlyPaymentAmount, 0.01d);
    }

    @Test
    public void shouldCalculateMonthlyPaymentWhenPrincipalIsZero() {
        double monthlyPaymentAmount = calculateMortgagePayment(0, 1, 12);
        assertEquals(0, monthlyPaymentAmount, 0.01d);
    }

    @Test
    public void shouldCalculateMonthlyPaymentWhenInterestRateIsZero() {
        double monthlyPaymentAmount = calculateMortgagePayment(1000, 1, 0);
        assertEquals(83.33, monthlyPaymentAmount, 0.01d);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowInvalidInputExceptionOnNegativeTenure() {
        calculateMortgagePayment(20, -10, 14.5);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowInvalidInputExceptionOnNegativeInterestRate() {
        calculateMortgagePayment(20, 1, -12);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowInvalidInputExceptionOnNegativePrincipalAmount() {
        calculateMortgagePayment(-20, 10, 14.5);
    }
}
