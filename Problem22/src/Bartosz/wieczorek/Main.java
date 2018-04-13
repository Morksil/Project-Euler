package Bartosz.wieczorek;

import java.io.*;
import java.util.ArrayList;

import java.util.Collections;
import java.util.Iterator;

public class Main {

    private static ArrayList<String> NameList = new ArrayList<String>();

    private static void buildList(String s) {
        long BuildListBegin = System.currentTimeMillis();
        String temp = "";
        boolean IsName = false;
        int i = 0;
        while (i < s.length()) {
            if(s.charAt(i)=='\"'){
                IsName=!IsName;
                i++;
            }
            if(IsName) {
                temp+= s.charAt(i);
            }
            else {
                if(temp =="") {
                    break;
                }
                else {
                    NameList.add(temp);
                    temp="";
                }
            }
            i++;
        }
        long SortBegin = System.currentTimeMillis();
        Collections.sort(NameList);
        long SortEnd = System.currentTimeMillis();
        long BuildListEnd=System.currentTimeMillis();
        System.out.println(NameList.size() + " items sorted in " + (SortEnd-SortBegin) + "ms");
        System.out.println("buildList() executed in " + (BuildListEnd-BuildListBegin) + "ms");

    }

    private static String readFile(String filename) {
        long begin = System.currentTimeMillis();
        File f = new File(filename);
        BufferedReader reader;
        String list="";
        try {
            StringBuffer contents = new StringBuffer();
            String text = null;
            reader = new BufferedReader(new FileReader(f));
            while((text=reader.readLine()) !=null){
                contents.append(text).append(System.getProperty("line.separator"));
            }
            list = contents.toString();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("File IO: " + (System.currentTimeMillis()-begin)+ "ms");
        return list;
    }
    private static long calcValue() {
        long GrandTotal = 0;
        int i=1;
        Iterator<String> itr = NameList.iterator();
        while(itr.hasNext()){
            String tmp = itr.next().toString();
            int LocalSum=0;

            for(int j=0; j<tmp.length();j++){
                if (tmp.charAt(j) == 'A')
                    LocalSum += 1;
                else if (tmp.charAt(j) == 'B')
                    LocalSum += 2;
                else if (tmp.charAt(j) == 'C')
                    LocalSum += 3;
                else if (tmp.charAt(j) == 'D')
                    LocalSum += 4;
                else if (tmp.charAt(j) == 'E')
                    LocalSum += 5;
                else if (tmp.charAt(j) == 'F')
                    LocalSum += 6;
                else if (tmp.charAt(j) == 'G')
                    LocalSum += 7;
                else if (tmp.charAt(j) == 'H')
                    LocalSum += 8;
                else if (tmp.charAt(j) == 'I')
                    LocalSum += 9;
                else if (tmp.charAt(j) == 'J')
                    LocalSum += 10;
                else if (tmp.charAt(j) == 'K')
                    LocalSum += 11;
                else if (tmp.charAt(j) == 'L')
                    LocalSum += 12;
                else if (tmp.charAt(j) == 'M')
                    LocalSum += 13;
                else if (tmp.charAt(j) == 'N')
                    LocalSum += 14;
                else if (tmp.charAt(j) == 'O')
                    LocalSum += 15;
                else if (tmp.charAt(j) == 'P')
                    LocalSum += 16;
                else if (tmp.charAt(j) == 'Q')
                    LocalSum += 17;
                else if (tmp.charAt(j) == 'R')
                    LocalSum += 18;
                else if (tmp.charAt(j) == 'S')
                    LocalSum += 19;
                else if (tmp.charAt(j) == 'T')
                    LocalSum += 20;
                else if (tmp.charAt(j) == 'U')
                    LocalSum += 21;
                else if (tmp.charAt(j) == 'V')
                    LocalSum += 22;
                else if (tmp.charAt(j) == 'W')
                    LocalSum += 23;
                else if (tmp.charAt(j) == 'X')
                    LocalSum += 24;
                else if (tmp.charAt(j) == 'Y')
                    LocalSum += 25;
                else if (tmp.charAt(j) == 'Z')
                    LocalSum += 26;
            }
            LocalSum*=(i);
            GrandTotal += LocalSum;
            i++;
            }
            return GrandTotal;

    }


    public static void main(String[] args) {


    /*    Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.

                For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.

        What is the total of all the name scores in the file?*/


    long begin=System.currentTimeMillis();

    buildList(readFile("names.txt"));
        System.out.println(calcValue());
        long end = System.currentTimeMillis();
        System.out.println("Total execution time: " + (end-begin) + "ms");
    }
}
