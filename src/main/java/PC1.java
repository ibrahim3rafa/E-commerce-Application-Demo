import org.junit.Test;

public class PC1 extends PC{

    @Test
    public void tryTest(){
        int a=5;
        PC2 pc2 = new PC2(a);
        doThis();
        System.out.println(pc2.increment());
        System.out.println(pc2.decrement());
        System.out.println(pc2.multiplytwo());
        System.out.println(pc2.multiplythree());

    }
}
