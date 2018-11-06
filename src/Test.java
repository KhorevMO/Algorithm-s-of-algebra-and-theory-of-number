import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrimalityTest[] primalityTest = new PrimalityTest[5];
        long integer = scanner.nextLong();
        primalityTest[0] = new WilsonPrimalityTest(integer);
        primalityTest[1] = new FermatPrimalityTest(integer);
        primalityTest[2] = new SolovayStrassenPrimalityTest(integer);
        primalityTest[3] = new CarmichaelNumber(integer);
        primalityTest[4] = new MillerRabinPrimalityTest(integer);
        for(int i = 0; i < 5; i++) {
            primalityTest[i].getName();
            primalityTest[i].isPrimeTest();
        }

    }
}
