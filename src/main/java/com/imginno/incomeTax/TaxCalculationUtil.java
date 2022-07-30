package com.imginno.incomeTax;

import com.imginno.incomeTax.model.TaxDetail;

public abstract class TaxCalculationUtil {
	
	protected TaxDetail calculateTax(int sal,TaxDetail txd) {
		double tax = 0.0;
		long yearlySal = sal * 12;
		if (yearlySal <= 250000) {
			return txd;
		} else {
			long taxableSum = yearlySal - 250000;
			if (taxableSum > 250000 && taxableSum <= 500000) {
				tax = (taxableSum - 250000) * 0.05;
				if (taxableSum <= 500000)
					tax = tax > 12500 ? tax - 12500 : 0; // No tax for this slab
			} else if (taxableSum > 500000 && taxableSum <= 1000000)
				tax = (taxableSum - 500000) * 0.2 + 250000 * 0.05;
			else if (taxableSum > 1000000) {
				tax = (taxableSum - 1000000) * 0.3 + 250000 * 0.2 + 250000 * 0.05;
			}
		}
		if (yearlySal > 2500000) {
			double extraAmt = yearlySal - 2500000;
			tax += extraAmt * 0.02;
		}
		txd.setTaxAmount(tax);
		txd.setCessamount(sal);

		return txd;

	}
}
