# CRReurocall
# An OptionSim package

Black Scholes Approximation of European Call Option Price by CRR

qynvi

02/24/2010 - Updated comments
02/22/2010 - Initial revision

Prices a European call option by modeling the price of the asset as a
binomial stochastic tree. A classic no-arbitrage assumption can bound the
price of an option in terms of its underlying asset, but the fair option
price is furthermore a function of the distribution of returns earned by
the underlying asset. Therefore, a unique option price can be predicted by
modeling a complete market vis-a-vis the underlying asset's risk.

There are several option pricing models on Wall Street but OptionSim uses
a simple binomial tree which can accurately compute the price of a complex
option. The underlying assumption is that the price of an asset can be
approximated as one of two states - proportionally up and proportionally down -
per period. Given a long enough traversal period along a stochastic process
modeling this pattern of price changes, CRReurocall allows OptionSim to
price a simple European style option written on a non-dividend paying stock.

When the model is run under test vector with K=0, we expect output ~S(0).
The CRR model converges to Black Scholes dependent on n. For example, with
n=5000 outputs converge to the Black Scholes Formula up to 6 sigfigs.

Iterates for the price of a European call option by using the Cox,
Ross, and Rubinstein model based on the following inputs:
r - annual interest rate
sigma - sigma
K - K price
S(0) - current T=0 price of the S
T - time to maturity in years
n - number of iterations

Todo:
- Mathmatical proof that Cox-Ross_Rubinstein converges to Black-Scholes-Merton
