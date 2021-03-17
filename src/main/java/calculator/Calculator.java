package calculator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;



//import java.util.Math;

public class Calculator {
    private static final Logger logger = LogManager.getLogger(Calculator.class);

    public Calculator() {
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        double number = 0.0, number1 = 0.0, number2 = 0.0;
        do {
            System.out.println("*****************************************************************");
            System.out.println("Welcome to the devops Calculator....\nPlease select the operation...\n\n");
            System.out.print("Press 1 to Square Root\nPress 2 to Factorial\nPress 3 to Logarithm\nPress 4 to Power\n" +
                    "Press any other key to exit\n\n\nEnter your choice: ");
            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException error) {
                return;
            }
            try {
                if (choice == 1 || choice == 2 || choice == 3) {
                    System.out.print("Enter the number : ");
                    number = scanner.nextDouble();
                } else if (choice == 4) {
                    System.out.print("Enter the first number : ");
                    number1 = scanner.nextDouble();
                    System.out.print("Enter the second number : ");
                    number2 = scanner.nextDouble();
                }


            } catch (InputMismatchException error) {
                logger.error("Invalid input, Entered input is not a number");
                return;
            }
            switch (choice) {
                case 1:
                    // do Square Root
                    System.out.println("Square Root result is : " + calculator.root(number));
                    break;
                case 2:
                    // do Factorial
                    System.out.println("Factorial result is : " + calculator.fact(number));
                    break;
                case 3:
                    // do multiplication
                    System.out.println("Logarithmic result is : " + calculator.logar(number));
                    break;
                case 4:
                    // do division
                    System.out.println("Power result is : " + calculator.power(number1, number2));
                    break;
                default:
                    System.out.println("Exiting....");
                    logger.error("Invalid input, Entered input is not a number");
                    return;
            }
        } while (true);
    }
    /*
    * Square root function - √x
    ● Factorial function - x!
    ● Natural logarithm (base е) - ln(x)
    ● Power function - x
    * */
    public double root(double num) {
        double result = 0;
        try{
            logger.info("Calculating Square root  of number " + num);
            if(num < 0){
                result = Double.NaN;
                throw new ArithmeticException("Case of NaN squareRoot of < 0");
            }
            else{
                result = Math.sqrt(num);
            }
        }catch(ArithmeticException err){
            logger.error("Number cannot be negative " + err.getMessage());
        }finally {
            logger.info("Result of squareRoot is : " + result);
        }
        return result;
    }
    public double fact(double num) {
        double result = 1;
        try{
            if(num < 0) {
                result = Double.NaN;
                throw new ArithmeticException("Case of NaN factorial if < 0");
            }

            if(num == 0 || num == 1) return 1;

            for(int i = 1; i <= num; i++){
                result *= i;
            }
        }
        catch(ArithmeticException err) {
            logger.error("Number cannot be negative " + err.getMessage());
        }
        finally {
            logger.info("Result of factorial is: " + result);
        }

        return result;
    }
    public double power(double num, double num2) {
        double result;
        logger.info("Calculating Power  of two numbers " + num + " and " + num2);
        result = Math.pow(num, num2);
        logger.info("Result of power is : " + result);
        return Math.pow(num, num2);
    }
    public double logar(double num) {
        double result = 0;
        try{
            logger.info("Calculating Natural log of " + num);
            if(num <= 0){
                result = Double.NaN;
                throw new ArithmeticException("Case of NaN log of <= 0");
            }
            else{
                result = Math.log(num);
            }
        }
        catch(ArithmeticException err){
            logger.error("Number cannot be negative " + err.getMessage());
        }
        finally {
            logger.info("Result of naturalLog is : " + result);
        }
        return result;
    }
}

