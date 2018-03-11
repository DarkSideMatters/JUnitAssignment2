
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 *
 * @author eddmond
 */
public class HandlerImpl implements Handler {
    public static final String FILENAME = "numbers.txt.txt";
    
    @Override
    public int[] sortArray(int[] array) {
        Arrays.sort(array);
        return array;
    }

    @Override
    public String readFile(String filename) throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get(filename)));
        return contents;        
    }

    @Override
    public int[] convertToArray(String content) {
        String[] strContent = content.split(" ");
        
        // count number of values
        int numberOfIntValues = 0;
        for (String strNum : strContent) {
            try {
                int num = Integer.parseInt(strNum);
                numberOfIntValues++;
            } catch (Exception ex) {
                
            }
        }
        
        // create array as big as needed
        int[] intArray = new int[numberOfIntValues];
        
        int i = 0;
        for (String strNum : strContent) {
            try {
                int number = Integer.parseInt(strNum);
                intArray[i] = number;
            } catch (Exception e) {
                System.out.println("Caught exception: " + e);
            }
            i++;
        }
        return intArray;
    }

    @Override
    public boolean addsUpTo(int sum, int[] array) {
    		int count = 0;
    		for (int number : array) {
    			count =+ number;
    		}
    		if (sum == count) {
    			return true;
    		} else {
    			return false;
    		}
    }

    @Override
    public boolean isOnlyPrimes(int[] array) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int[] getEvenNumbers(int[] array) {
            int[] evens = new int[array.length];

            int index = 0;
            for (int number : array) {
                if (number % 2 == 0) {
                    evens[index] = number;
                    index++;
                }
            }

            // trim array to remove unused spots - #javaLoveAndHate
            int[] evensTrimmed = new int[index];
            for (int i = 0; i < index; i++) {
                evensTrimmed[i] = evens[i];
            }

            return evensTrimmed;
        }


        @Override
    public int calculateSum(int[] array) {
            int count = 0;
            for (int number : array) {
                count += number;
            }
            return count;
        }

    @Override
    public int[] mergeArrays(int[] array1, int[] array2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int[] reverseArray(int[] array) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int[] removeDuplicates(int[] array) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
