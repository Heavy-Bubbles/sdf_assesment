package tan.chelsea;

import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

/**
 * Hello world!
 *
 */
public class App 
{

    private static double $last;


    public static void main( String[] args )
    {
        System.out.println( "Welcome." );

        BiFunction<Double, Double, Double> add = (num1, num2) -> num1 + num2;

        BiFunction<Double, Double, Double> subtract = (num1, num2) -> num1 - num2;

        BiFunction<Double, Double, Double> multiply = (num1, num2) -> num1 * num2;

        BiFunction<Double, Double, Double> divide = (num1, num2) -> num1 / num2;

        Console c = System.console();
        String input = "";

        while (!input.equalsIgnoreCase("exit")){

            input = c.readLine();

            Scanner scan = new Scanner(input);

            ArrayList<String> inputs = new ArrayList<>();

            while (scan.hasNext()){
                
                String content = scan.next();
                inputs.add(content);
            }

            try {

                if (inputs.get(0).equalsIgnoreCase("exit")){
                    break;
                }
    
                switch (inputs.get(1)){
                    case "+":
                    if (inputs.get(0).equals("$last") && inputs.get(2).equals("$last")){
                        Double num1 = $last;
                        Double num2 = $last;
                        $last = add.apply(num1, num2);
                        System.out.println($last);  
                    } else if (inputs.get(2).equals("$last")){
                        Double num1 = Double.parseDouble(inputs.get(0));
                        Double num2 = $last;
                        $last = add.apply(num1, num2);
                        System.out.println($last);
                    } else if (inputs.get(0).equals("$last")){
                        Double num1 = $last;
                        Double num2 = Double.parseDouble(inputs.get(2));
                        $last = add.apply(num1, num2);
                        System.out.println($last);
                    } else {
                    double num1 = Double.parseDouble(inputs.get(0));
                    double num2 = Double.parseDouble(inputs.get(2));
                    $last = add.apply(num1, num2);
                    System.out.println($last);
                    }
                    break;
    
                    case "-":
                    if (inputs.get(0).equals("$last") && inputs.get(2).equals("$last")){
                        Double num1 = $last;
                        Double num2 = $last;
                        $last = subtract.apply(num1, num2);
                        System.out.println($last);  
                    } else if (inputs.get(2).equals("$last")){
                        Double num1 = Double.parseDouble(inputs.get(0));
                        Double num2 = $last;
                        $last = subtract.apply(num1, num2);
                        System.out.println($last);
                    } else if (inputs.get(0).equals("$last")){
                        Double num1 = $last;
                        Double num2 = Double.parseDouble(inputs.get(2));
                        $last = subtract.apply(num1, num2);
                        System.out.println($last);
                    } else {
                    double num1 = Double.parseDouble(inputs.get(0));
                    double num2 = Double.parseDouble(inputs.get(2));
                    $last = subtract.apply(num1, num2);
                    System.out.println($last);
                    }
                    break;
    
                    case "x":
                    if (inputs.get(0).equals("$last") && inputs.get(2).equals("$last")){
                        Double num1 = $last;
                        Double num2 = $last;
                        $last = multiply.apply(num1, num2);
                        System.out.println($last);  
                    } else if (inputs.get(2).equals("$last")){
                        Double num1 = Double.parseDouble(inputs.get(0));
                        Double num2 = $last;
                        $last = multiply.apply(num1, num2);
                        System.out.println($last);
                    } else if (inputs.get(0).equals("$last")){
                        Double num1 = $last;
                        Double num2 = Double.parseDouble(inputs.get(2));
                        $last = multiply.apply(num1, num2);
                        System.out.println($last);
                    } else {
                    double num1 = Double.parseDouble(inputs.get(0));
                    double num2 = Double.parseDouble(inputs.get(2));
                    $last = multiply.apply(num1, num2);
                    System.out.println($last);
                    }
                    break;
    
                    case "*":
                    if (inputs.get(0).equals("$last") && inputs.get(2).equals("$last")){
                        Double num1 = $last;
                        Double num2 = $last;
                        $last = multiply.apply(num1, num2);
                        System.out.println($last);  
                    } else if (inputs.get(2).equals("$last")){
                        Double num1 = Double.parseDouble(inputs.get(0));
                        Double num2 = $last;
                        $last = multiply.apply(num1, num2);
                        System.out.println($last);
                    } else if (inputs.get(0).equals("$last")){
                        Double num1 = $last;
                        Double num2 = Double.parseDouble(inputs.get(2));
                        $last = multiply.apply(num1, num2);
                        System.out.println($last);
                    } else {
                    double num1 = Double.parseDouble(inputs.get(0));
                    double num2 = Double.parseDouble(inputs.get(2));
                    $last = multiply.apply(num1, num2);
                    System.out.println($last);
                    }
                    break;
    
                    case "/":
                    if (inputs.get(0).equals("$last") && inputs.get(2).equals("$last")){
                        Double num1 = $last;
                        Double num2 = $last;
                        $last = divide.apply(num1, num2);
                        System.out.println($last);  
                    } else if (inputs.get(2).equals("$last")){
                        Double num1 = Double.parseDouble(inputs.get(0));
                        Double num2 = $last;
                        $last = divide.apply(num1, num2);
                        System.out.println($last);
                    } else if (inputs.get(0).equals("$last")){
                        Double num1 = $last;
                        Double num2 = Double.parseDouble(inputs.get(2));
                        $last = divide.apply(num1, num2);
                        System.out.println($last);
                    } else {
                    double num1 = Double.parseDouble(inputs.get(0));
                    double num2 = Double.parseDouble(inputs.get(2));
                    $last = divide.apply(num1, num2);
                    System.out.println($last);
                    }
                    break;
    
                    default:
                    System.out.println("Invalid input");
                }
                inputs.clear();
            } catch (Exception e){
                System.out.println("Invalid Input");
            }
            
        }

        System.out.println("Bye bye");

    }
}
