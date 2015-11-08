package com.optionsim;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public strictfp class crreurocall
{
	public crreurocall(double r, double sigma, double K, double S, double T, int n) {
		r_ = r;
		sigma_ = sigma;
		K_ = K;
		S_ = S;
		T_ = T;
		n_ = n;
	}
	public List<Double> estimatePrice()
	{
		List<Double> results = new ArrayList<Double>();
		List<Double> sprices = new ArrayList<Double>();
		List<Double> cprices = new ArrayList<Double>();

		// Calculations for CRR binomial backstepping
		double steps = (T_) / n_; /* Size of time step delta t */
		double R = Math.exp(r_ * steps); /* Rate */
		double discount_factor = 1 / R; /* Discount */
		double u = Math.exp(sigma_ * Math.sqrt(steps)); /* High boundary */
		double d = 1 / u; /* Low boundary */
		double p_up = (R - d) / (u - d); /* Probability up state */
		double p_down = 1 - p_up; /* Probability down state */

		// Form stock prices on tree
		for (int i=0; i<=n_; i++) {
			sprices.add(i, 0.0d);
		}
		double sDown = S_ * Math.pow(d, n_);
		sprices.set(0, sDown);

		// Calculate the underlying price at each node
		for (int i=1; i<=n_; i++) {
			sprices.set(i, ( (u * u) * sprices.get(i - 1) ) );
		}

		// Calculate call price at each node
		for (int i=0; i<=n_; i++) {
			cprices.add(i, callpayoff(sprices.get(i)) );
		}

		// Form call option's t=0 price
		for (int i=n_; i>0; i--) {
			for (int j=0; j<i; j++) {
				double callV = discount_factor*(p_up * cprices.get(j + 1) + p_down * cprices.get(j));
				cprices.set(j, callV);
			}
		}

		results.add(cprices.get(0));

		return results;
	}

	private double callpayoff( double price ) {
		return Math.max(price - K_, 0);
	}

	private double r_;
	private double sigma_;
	private double K_;
	private double S_;
	private double T_;
	private int n_;
}
