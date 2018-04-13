package Bartosz.wieczorek;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// project euler problem 21


       /* Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
                If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.

                For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

        Evaluate the sum of all the amicable numbers under 10000.*/

        int sumasumarum=0;
        for(int i=2;i<=10000;i++) {
            List<Integer> first = new ArrayList<Integer>();
            for(int k=1;k<i;k++) {
                int inumber=i%k;

                if(k==1) {
                    first.add(Integer.valueOf(k));
                }
                if(inumber==0){
                    System.out.println("The divider of " + i + " is: " + k);
                    if(first.contains(Integer.valueOf(k))) {

                    }else if(!first.contains(Integer.valueOf(k))) {
                        first.add(Integer.valueOf(k));
                    }
                }
            }
            System.out.println(first);
            int sum=0;
            for(int k=0;k<first.size();k++){
                sum += first.get(k);
            }
            System.out.println("suma dzielników to: " + sum);

            List<Integer> second = new ArrayList<Integer>();
            for(int k=1;k<sum;k++) {
                int inumber=sum%k;

                if(k==1) {
                    second.add(Integer.valueOf(k));
                }
                if(inumber==0){
                    System.out.println("The divider of " + sum + " is: " + k);
                    if(second.contains(Integer.valueOf(k))) {

                    }else if(!second.contains(Integer.valueOf(k))) {
                        second.add(Integer.valueOf(k));
                    }
                }
            }

            System.out.println(second);
            int sum2=0;
            for(int k=0;k<second.size();k++){
                sum2 += second.get(k);
            }
            System.out.println("suma dzielników2 to: " + sum2);

            if(sum2==i && i<sum) {
                System.out.println("Działa, para liczb zaprzyjaznionych to: " + i + " oraz " + sum);
                sumasumarum+=i;
                sumasumarum+=sum;
            }
        }

        System.out.println("Suma wszystkich liczb zaprzyjaznionych mniejszych od 10000: " + sumasumarum);


    }
}
