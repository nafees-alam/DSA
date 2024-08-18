class Solution {
    private static final long MOD = 1000000007;

    public int countGoodNumbers(long n) {
        long evenPos = n / 2 + n % 2;
        long oddPos = n / 2;

        long ans1 = modPow(5, evenPos, MOD);
        long ans2 = modPow(4, oddPos, MOD);

        return (int)((ans1 * ans2) % MOD);
    }

    private long modPow(long base, long exp, long mod) {
        long result = 1;
        while (exp > 0) {
            if ((exp % 2) != 0) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }
        return result;
    }
}
