package mortgage;

public class MortgageInstallmentCalculator {

    public static int monthsInYear = 12;

    /**
     *
     * @param principalAmount principal amount agreed to pay
     * @param termInYears term of mortgage in years
     * @param interestRate rate of interest, cost of borrowing the principal
     * @return monthly payment amount
     */
    public static double calculateMortgagePayment(
            int principalAmount,
            int termInYears,
            double interestRate
    ) {
        if (principalAmount < 0 || termInYears <= 0 || interestRate < 0) {
            throw new RuntimeException("Negative values are not allowed");
        }

        // convert interest rate into a decimal - eg. 6.5% = 0.065
        interestRate /= 100.0;

        // convert term in years to term in months
        double termInMonths = termInYears * monthsInYear;

        if (interestRate == 0) {
            return principalAmount / termInMonths;
        }

        return calculateMonthlyPayment(principalAmount, termInMonths, interestRate);
    }

    private static double calculateMonthlyPayment(
            int principalAmount,
            double termInMonths,
            double interestRate
    ) {
        double interestRateInMonths = interestRate / monthsInYear;
        return (principalAmount * interestRateInMonths) / (1 - Math.pow(1 + interestRateInMonths, -termInMonths));
    }
}
