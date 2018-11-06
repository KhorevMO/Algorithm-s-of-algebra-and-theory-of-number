import java.util.Random;

public class SolovayStrassenPrimalityTest implements PrimalityTest {
    static String name = "Тест Соловея — Штрассена";
    long integer;
    SolovayStrassenPrimalityTest(long integer){
        this.integer = integer;
    }

    @Override
    public void getName() {
        System.out.print(this.name +" ");
    }
    long binPow(long integer, long degree){
        if(degree == 0)
            return (1);
        if(degree % 2 == 0)
            return (binPow(integer, degree / 2) * binPow(integer, degree / 2)) % this.integer;
        else
            return (integer * binPow(integer, degree - 1)) % this.integer;

    }
    long Jacobi(long integer1, long integer2)
    {
        if (integer2 <= 0 || integer2 % 2 == 0)
            return 0;
        long j = 1;
        if (integer1 < 0)
        {
            integer1 = -integer1;
            if (integer2 % 4 == 3)
                j = -j;
        }
        while (integer1 != 0)
        {
            while (integer1 % 2 == 0)
            {
                integer1 /= 2;
                if (integer2 % 8 == 3 || integer2 % 8 == 5)
                    j = -j;
            }

            long temp = integer1;
            integer1 = integer2;
            integer2 = temp;

            if (integer1 % 4 == 3 && integer2 % 4 == 3)
                j = -j;
            integer1 %= integer2;
        }
        if (integer2 == 1)
            return j;
        return 0;
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
        for(int i = 0; i < 1000; i++)
        {
            Random random = new Random();
            long a = Math.abs(random.nextLong()) % (this.integer - 1) +  1;
            long jacobian = (this.integer + Jacobi(a, this.integer)) % this.integer;
            if(gcd(a,this.integer) > 1)
            {
                result = false;
                break;
            }
            if (jacobian == 0 || binPow(a, (this.integer - 1)/2) != jacobian) {
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
