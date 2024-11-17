import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Main {

    public static void fizzBuzz(int number){
        int[] array= IntStream.range(1,number).toArray();
        String fizzBuzz;
        BiFunction<Integer,Integer,String> divide=(x,y)->(x%y==0)?(y==3)?"Fizz":"Buzz":"";
        Predicate<String> nonFizzBuzz= String::isBlank;
        for (int value:array){
            fizzBuzz=divide.apply(value,3);
            fizzBuzz+=divide.apply(value,5);
            if(nonFizzBuzz.test(fizzBuzz)){
                fizzBuzz=String.valueOf(value);
            }
            System.out.println(fizzBuzz);
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        fizzBuzz(Integer.parseInt(sc.nextLine()));
    }
}