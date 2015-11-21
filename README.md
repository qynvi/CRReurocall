# CRReurocall
## An OptionSim quant package


Note: Does not include OptionSim testbench, but a main function is provided to
demo the plugin's original purpose.


Black Scholes Approximation of European Call Option Price by CRR

William Fan

02/24/2010 - Updated comments

02/22/2010 - Initial revision

Prices a European call option by modeling the price of the asset as a
binomial stochastic tree. A classic no-arbitrage assumption can bound the
price of an option in terms of its underlying asset, but the fair option
price is furthermore a function of the distribution of returns earned by
the underlying asset. Therefore, a unique option price can be predicted by
modeling a complete market vis-à-vis the underlying asset's risk.

There are several option pricing models on Wall Street but OptionSim uses
a simple binomial tree which can accurately compute the price of a complex
option. The underlying assumption is that the price of an asset can be
approximated as one of two states - proportionally up or proportionally down -
per period. Given a long enough traversal period along a stochastic process
modeling this pattern of price changes, CRReurocall allows OptionSim to
price a simple European style option written on a non-dividend paying stock.

When the model is run under test vector with K=0, we expect output ~S(0).
The CRR model converges to Black Scholes dependent on n. For example, with
n=5000 outputs converge to Black Scholes up to 6 sigfigs.
