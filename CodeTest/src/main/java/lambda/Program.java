package lambda;

import lambda.Inf.LambdaTest;
import lambda.Inf.LambdaTest1;

/**
 * @author 喻浩
 * @create 2019-12-08-0:17
 */
public class Program {
    public static void main(String[] args) {
        LambdaTest lambdaTest = () -> {
            System.out.println("11");
        };

        LambdaTest1 lambdaTest1 = a -> {
            System.out.println(a);
        };
        lambdaTest.test();
        
        lambdaTest1.test(2323);
    }
}
