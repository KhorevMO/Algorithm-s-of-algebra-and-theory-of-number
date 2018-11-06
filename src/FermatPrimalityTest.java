import java.util.Random;

public class FermatPrimalityTest implements PrimalityTest {
    static String name = "Критерий на основе малой теоремы Ферма";
    long integer;
    FermatPrimalityTest(long integer){
        this.integer = integer;
    }
    @Override
    public void getName() {
        System.out.print(this.name + " ");
    }
    long binPow(long integer, long degree){
        if(degree == 0)
            return 1;
        if(degree % 2 == 0)
            return (binPow(integer, degree / 2) * binPow(integer, degree / 2)) % this.integer;
        else
            return (integer * binPow(integer, degree - 1)) % this.integer;

    }
    long pow(long a){
        return binPow(a, this.integer - 1);
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
        for(int i = 0; i < 100; i++)
        {
            Random random = new Random();
            long a = Math.abs(random.nextLong()) % (this.integer - 1) +  1;
            if (gcd(a, this.integer) == 1 && pow(a) != 1) {
                result = false;
                break;
            }
        }
        if (result)
            System.out.println("Простое число");
        else
            System.out.println("Составное число");
    }
}
