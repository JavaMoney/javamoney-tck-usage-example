/**
 * Copyright (c) 2012, 2014, Credit Suisse (Anatole Tresch), Werner Keil and others by the @author tag.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.javamoney.text.tck;

import javax.money.CurrencyContext;
import javax.money.CurrencyContextBuilder;
import javax.money.CurrencyUnit;
import javax.money.MonetaryException;
import java.util.Objects;

/**
 * Test implk class for currencies.
 */
public final class MyCurrency implements CurrencyUnit {

    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = -2389580389919492220L;
    /**
     * The unique currency code.
     */
    private String currencyCode;
    /**
     * The (optional) numeric code.
     */
    private int numericCode;
    /**
     * The default fraction digits.
     */
    private int defaultFractionDigits;
    /**
     * THe currency's context.
     */
    private static final javax.money.CurrencyContext currencyContext =
            CurrencyContextBuilder.of("org.javamoney.text.tck.MyCurrency").build();


    /**
     * Constructor, called from the Builder.
     *
     * @param code the code, never null.
     */
    MyCurrency(String code) {
        this.defaultFractionDigits = 2;
        this.numericCode = -1;
        this.currencyCode = Objects.requireNonNull(code, "currencyCode required");
    }

    @Override
    public CurrencyContext getContext() {
        return currencyContext;
    }

    @Override
    public String getCurrencyCode() {
        return currencyCode;
    }

    @Override
    public int getNumericCode() {
        return numericCode;
    }

    @Override
    public int getDefaultFractionDigits() {
        return defaultFractionDigits;
    }

    @Override
    public int compareTo(@SuppressWarnings("NullableProblems") CurrencyUnit o) {
        Objects.requireNonNull(o);
        return this.currencyCode.compareTo(o.getCurrencyCode());
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(currencyCode);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MyCurrency) {
            MyCurrency other = (MyCurrency) obj;
            return Objects.equals(currencyCode, other.currencyCode);
        }
        return false;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "MyCurrency(currencyCode=" + currencyCode + ", numericCode=" + numericCode +
                ", defaultFractionDigits=" + defaultFractionDigits + ", context=" + this.currencyContext + ')';
    }

}
