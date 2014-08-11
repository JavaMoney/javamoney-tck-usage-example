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

import org.javamoney.moneta.FastMoney;
import org.javamoney.moneta.function.MonetaryFunctions;
import org.javamoney.tck.JSR354TestConfiguration;

import javax.money.MonetaryOperator;
import javax.money.MonetaryRoundings;
import javax.money.convert.MonetaryConversions;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * JSR354TestConfiguration setup class. This is an example TCK setup class, that has to be written by
 * implementors to setup the JSR 354 TCK for running with their implementations.
 * <p>
 * Created by Anatole Tresch on 14.06.2014.
 */
public final class MonetaTCKSetup implements JSR354TestConfiguration {

    /**
     * Provide the MonetaryAmount implementation classes to be tested for immutability and other
     * implementation requirements.
     *
     * @return the monetary amount classes to be tested, not null and not empty.
     */
    @Override
    public Collection<Class> getAmountClasses() {
        return Arrays
                .asList(new Class[]{FastMoney.class, FastMoney.class});
    }

    /**
     * Provide the CurrencyUnit implementation classes to be tested for immutability and other
     * implementation requirements.
     *
     * @return the currency unit classes to be tested, not null and not empty.
     */
    @Override
    public Collection<Class> getCurrencyClasses() {
        try {
            return Arrays
                    .asList(new Class[]{Class.forName("org.javamoney.moneta.internal.JDKCurrencyAdapter")});
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Currency class not lodable: org.javamoney.moneta.internal.JDKCurrencyAdapter");
        }
    }

    /**
     * Provide the MonetaryOperator implementation classes to be tested for immutability and other
     * implementation requirements.
     *
     * @return the monetary operator classes to be tested, not null and not empty.
     */
    @Override
    public Collection<MonetaryOperator> getMonetaryOperators4Test() {
        List<MonetaryOperator> ops = new ArrayList<>();
        ops.add(MonetaryFunctions.majorPart());
        ops.add(MonetaryFunctions.minorPart());
        ops.add(MonetaryFunctions.percent(BigDecimal.ONE));
        ops.add(MonetaryFunctions.percent(3.5));
        ops.add(MonetaryFunctions.permil(10.3));
        ops.add(MonetaryFunctions.permil(BigDecimal.ONE));
        ops.add(MonetaryFunctions.permil(10.5, MathContext.DECIMAL32));
        ops.add(MonetaryFunctions.reciprocal());
        ops.add(MonetaryRoundings.getDefaultRounding());
        ops.add(MonetaryConversions.getConversion("EUR"));
        return ops;
    }

}