package lesson5;

class Exponentiation {

    static long exp(long base, long exp) {
        return (exp == 0) ? 1 : exp(base, exp - 1) * base;
    }

    static long expOptimized(long base, long exp) {
        if (exp == 0) {
            return 1;
        }
        return (exp % 2 == 0) ? expOptimized(base, exp / 2) * expOptimized(base, exp / 2) : expOptimized(base, exp - 1) * base;
    }

}
