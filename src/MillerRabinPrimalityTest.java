import java.util.Random;

public class MillerRabinPrimalityTest implements PrimalityTest {
    static String name = "Тест Миллера — Рабина";
    long integer;

    MillerRabinPrimalityTest(long integer) {
        this.integer = integer;
    }

    @Override
    public void getName() {
        System.out.print(this.name + " ");
    }

    long binPow(long integer, long degree) {
        if (degree == 0)
            return 1;
        if (degree % 2 == 0)
            return (binPow(integer, degree / 2) * binPow(integer, degree / 2)) % this.integer;
        else
            return (integer * binPow(integer, degree - 1)) % this.integer;
    }
    long gcd(Long integer1, long integer2){
        if (integer2 == 0)
            return integer1;
        else
            return gcd (integer2, integer1 % integer2);
    }
    @Override
    public void isPrimeTest() {
        boolean result = true;
        for(int i = 0; i < 10000; i++) {
            long d = this.integer - 1;
            long s = 0;
            while (d % 2 == 0) {
                d = d / 2;
                s++;
            }
            Random random = new Random();
            long a = Math.abs(random.nextLong()) % (this.integer - 1) + 1;
            boolean two = false;
            for (int j = 1; j < s; j++) {
                long powa = binPow(2, j) * d;
                if (binPow(a, powa) != this.integer - 1)
                    two = true;
            }
            if (gcd(a, this.integer) == 1 && binPow(a, d) != 1 && two)
                result = false;
        }
        if (result)
            System.out.println("Простое число");
        else
            System.out.println("Составное число");

    }
}
