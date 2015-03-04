import javax.money.CurrencyContext;
import javax.money.CurrencyContextBuilder;
import javax.money.CurrencyUnit;

/**
 * Test implk class for currencies.
 */
public final class MyCurrency implements CurrencyUnit {
    @Override
    public String getCurrencyCode() {
        return "N/A";
    }

    @Override
    public int getNumericCode() {
        return 0;
    }

    @Override
    public int getDefaultFractionDigits() {
        return 0;
    }

    @Override
    public CurrencyContext getContext() {
        return CurrencyContextBuilder.of("MyCurrency").build();
    }

    @Override
    public int compareTo(CurrencyUnit o) {
        return 0;
    }
}
