package Week01.lesson01;

import java.util.stream.Stream;

/**
 * Created by ZHOUTM2 on 11/15/2017.
 */
public class Lesson01 {

    private final static char[] NUMBER_ARRAY = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
            .toCharArray();
    private final static String NUMBER_STRING = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) {
        System.out.println(oct2Bin(17));
        System.out.println(n2Oct(oct2Bin(17),2));
        System.out.println(oct2n(n2Oct(oct2Bin(17),2),2));
        System.out.println(transform("11001", 2, 3));
    }

    public static String oct2Bin(int input){
        final StringBuilder result = new StringBuilder();
        boolean negative = false;
        if(input < 0){
            input = Math.abs(input + 1);
            negative = true;
        }
        do{
            int remainder = negative? (input % 2 == 0? 1 : 0) : input % 2;
            result.append(remainder);
            input = input/2;

        }while(input != 0);

        if(negative)
            Stream.iterate(1,n -> n).limit(4 * 8 - result.length()).forEach(x -> result.append(x));

        return result.reverse().toString();
    }


    public static long n2Oct(String number, int n){
        if(n == 10) return Long.valueOf(number);
        final long[] result = {0};
        final long[] base = {1};
        char numChar[] = number.toCharArray();
        Stream.iterate(number.length() - 1,i -> i - 1).
                limit(number.length()).
                forEach(x -> {
                    result[0] += NUMBER_STRING.indexOf(numChar[x]) * base[0];
                    base[0] = base[0] * n;
        });
        return result[0];
    }

    public static String oct2n(long number, int n){
        StringBuilder result = new StringBuilder();
        long quotient = number;
        do{
            result.append(NUMBER_ARRAY[(int)(quotient % n)]);
            quotient = quotient / n;
        }while(quotient != 0);

        return result.reverse().toString();
    }

    public static String transform(String number, int from, int to){
        return oct2n(n2Oct(number,from),to);
    }
}
