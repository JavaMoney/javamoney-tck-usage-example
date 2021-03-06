/**
 * Copyright (c) 2012, 2020, Anatole Tresch, Werner Keil and others by the @author tag.
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
package org.javamoney.test.tck;

import org.javamoney.moneta.FastMoney;
import org.javamoney.moneta.Money;
import org.javamoney.moneta.spi.JDKCurrencyAdapter;
import org.javamoney.tck.JSR354TestConfiguration;

import javax.money.Monetary;
import javax.money.MonetaryOperator;
import javax.money.convert.MonetaryConversions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * JSR354TestConfiguration setup class. This is an example TCK setup class, that
 * has to be written by implementors to setup the JSR 354 TCK for running with
 * their implementations.
 * <p>
 * Created by Anatole Tresch on 14.06.2014.
 */
public final class TCKTestSetup implements JSR354TestConfiguration {

	/**
	 * Provide the MonetaryAmount implementation classes to be tested for
	 * immutability and other implementation requirements.
	 *
	 * @return the monetary amount classes to be tested, not null and not empty.
	 */
	@Override
	public Collection<Class> getAmountClasses() {
		return Arrays.asList(new Class[] { Money.class, FastMoney.class });
	}

	/**
	 * Provide the CurrencyUnit implementation classes to be tested for
	 * immutability and other implementation requirements.
	 *
	 * @return the currency unit classes to be tested, not null and not empty.
	 */
	@Override
	public Collection<Class> getCurrencyClasses() {
		try {
			return Arrays.asList(new Class[] { JDKCurrencyAdapter.class });
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(
					"Currency class not loadable: "
							+ org.javamoney.moneta.spi.JDKCurrencyAdapter.class
									.getName());
		}
	}

	/**
	 * Provide the MonetaryOperator implementation classes to be tested for
	 * immutability and other implementation requirements.
	 *
	 * @return the monetary operator classes to be tested, not null and not
	 *         empty.
	 */
	@Override
	public Collection<MonetaryOperator> getMonetaryOperators4Test() {
		List<MonetaryOperator> ops = new ArrayList<>();
		ops.add(Monetary.getDefaultRounding());
		ops.add(MonetaryConversions.getConversion("EUR"));
		return ops;
	}
}