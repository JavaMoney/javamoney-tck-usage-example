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

import javax.money.CurrencyUnit;
import javax.money.MonetaryAmount;
import javax.money.MonetaryAmountFactory;
import javax.money.MonetaryContext;
import javax.money.MonetaryContextBuilder;
import javax.money.NumberValue;
import java.math.BigDecimal;

/**
 * Created by Anatole on 04.03.2015.
 */
public final class MyMoney implements MonetaryAmount {

    private static final MonetaryContext monetaryContext = MonetaryContextBuilder.of(MyMoney.class)
            .setMaxScale(new BigDecimal(Double.MAX_VALUE).scale()).build();

    @Override
    public MonetaryContext getContext() {
        return monetaryContext;
    }

    @Override
    public MonetaryAmountFactory<? extends MonetaryAmount> getFactory() {
        return null;
    }

    @Override
    public boolean isGreaterThan(MonetaryAmount amount) {
        return false;
    }

    @Override
    public boolean isGreaterThanOrEqualTo(MonetaryAmount amount) {
        return false;
    }

    @Override
    public boolean isLessThan(MonetaryAmount amount) {
        return false;
    }

    @Override
    public boolean isLessThanOrEqualTo(MonetaryAmount amt) {
        return false;
    }

    @Override
    public boolean isEqualTo(MonetaryAmount amount) {
        return false;
    }

    @Override
    public int signum() {
        return 0;
    }

    @Override
    public MonetaryAmount add(MonetaryAmount amount) {
        return null;
    }

    @Override
    public MonetaryAmount subtract(MonetaryAmount amount) {
        return null;
    }

    @Override
    public MonetaryAmount multiply(long multiplicand) {
        return null;
    }

    @Override
    public MonetaryAmount multiply(double multiplicand) {
        return null;
    }

    @Override
    public MonetaryAmount multiply(Number multiplicand) {
        return null;
    }

    @Override
    public MonetaryAmount divide(long divisor) {
        return null;
    }

    @Override
    public MonetaryAmount divide(double divisor) {
        return null;
    }

    @Override
    public MonetaryAmount divide(Number divisor) {
        return null;
    }

    @Override
    public MonetaryAmount remainder(long divisor) {
        return null;
    }

    @Override
    public MonetaryAmount remainder(double divisor) {
        return null;
    }

    @Override
    public MonetaryAmount remainder(Number divisor) {
        return null;
    }

    @Override
    public MonetaryAmount[] divideAndRemainder(long divisor) {
        return new MonetaryAmount[0];
    }

    @Override
    public MonetaryAmount[] divideAndRemainder(double divisor) {
        return new MonetaryAmount[0];
    }

    @Override
    public MonetaryAmount[] divideAndRemainder(Number divisor) {
        return new MonetaryAmount[0];
    }

    @Override
    public MonetaryAmount divideToIntegralValue(long divisor) {
        return null;
    }

    @Override
    public MonetaryAmount divideToIntegralValue(double divisor) {
        return null;
    }

    @Override
    public MonetaryAmount divideToIntegralValue(Number divisor) {
        return null;
    }

    @Override
    public MonetaryAmount scaleByPowerOfTen(int power) {
        return null;
    }

    @Override
    public MonetaryAmount abs() {
        return null;
    }

    @Override
    public MonetaryAmount negate() {
        return null;
    }

    @Override
    public MonetaryAmount plus() {
        return null;
    }

    @Override
    public MonetaryAmount stripTrailingZeros() {
        return null;
    }

    @Override
    public int compareTo(MonetaryAmount o) {
        return 0;
    }

    @Override
    public CurrencyUnit getCurrency() {
        return null;
    }

    @Override
    public NumberValue getNumber() {
        return null;
    }
}
