public class WilsonPrimalityTest implements PrimalityTest {
    static String name = "Критерий Вильсона";
    long integer;
    WilsonPrimalityTest(long integer){
        this.integer = integer;
    }
    @Override
    public void getName() {
        System.out.print(this.name +" ");
    }
    long factorial(){
        long integer = 1;
        for(int i = 2; i < this.integer; i++)
        {
            integer = integer * i;
            integer = integer % this.integer;
        }
        return integer;
    }
    @Override
    public void isPrimeTest() {
        if(factorial() == this.integer - 1)
            System.out.println("Простое число");
        else
            System.out.println("Составное число");

    }
}
