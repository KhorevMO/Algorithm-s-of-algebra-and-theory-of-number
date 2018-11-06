import java.util.Random;

public class CarmichaelNumber implements PrimalityTest {
    static String name = "Число Кармайкла";
    long integer;

    CarmichaelNumber(long integer) {
        this.integer = integer;
    }

    @Override
    public void getName() {
        System.out.print(this.name + " ");
    }

    long gcd(Long integer1, long integer2){
        if (integer2 == 0)
            return integer1;
        else
            return gcd (integer2, integer1 % integer2);
    }

    long binPow(long integer, long degree) {
        if (degree == 0)
            return 1;
        if (degree % 2 == 0)
            return (binPow(integer, degree / 2) * binPow(integer, degree / 2)) % this.integer;
        else
            return (integer * binPow(integer, degree - 1)) % this.integer;
    }

    @Override
    public void isPrimeTest() {
        boolean result = true;
        for (int i = 0; i < 10000; i++) {
            Random random = new Random();
            long b = Math.abs(random.nextLong()) % (this.integer - 1) + 1;
            if (gcd(b, this.integer) == 1 && binPow(b, this.integer - 1) != 1) {
                result = false;
            }

        }
        if (result)
            System.out.println("Является");
        else
            System.out.println("Не является");
    }
}