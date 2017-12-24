
/*
ID: angusjy1
LANG: JAVA
TASK: combo
*/
import java.io.*;
import java.util.*;

class combo {
  public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader reader = new BufferedReader(new FileReader("combo.in"));
                                                  // input file name goes above
    PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));
    // Use StringTokenizer vs. readLine/split -- lots faster
    StringTokenizer st = new StringTokenizer(reader.readLine());
						  // Get line, break into tokens
    int numOfNumbers = Integer.parseInt(st.nextToken());
    if(numOfNumbers<=5){
    	writer.println((int)Math.pow(numOfNumbers, 3));
    	writer.close();
    	return;
    }
    st = new StringTokenizer(reader.readLine());
    int[] farmerCombination = new int[3];
    int[] masterCombination = new int[3];
    for(int ind = 0; ind < 3; ind++){
    	farmerCombination[ind] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(reader.readLine());
    for(int ind = 0; ind < 3; ind++){
    	masterCombination[ind] = Integer.parseInt(st.nextToken());
    }
    ArrayList<Integer[]> listOfGoodCombinations = new ArrayList<Integer[]>();
    int digit1 = farmerCombination[0];
    int digit2 = farmerCombination[1];
    int digit3 = farmerCombination[2];
    int digitA = masterCombination[0];
    int digitB = masterCombination[1];
    int digitC = masterCombination[2];
    for(int digits1 = digit1 - 2; digits1 <= digit1 + 2; digits1++){
    	for(int digits2 = digit2 - 2; digits2 <= digit2 + 2; digits2++){
    		for(int digits3 = digit3 - 2; digits3 <= digit3 + 2; digits3++){
    			int digits11 = digits1;
    			int digits22 = digits2;
    			int digits33 = digits3;
    			if(digits11 > numOfNumbers){
    				digits11 = digits1 - numOfNumbers;
    			}
    			if(digits22 > numOfNumbers){
    				digits22 = digits2 - numOfNumbers;
    			}
    			if(digits33 > numOfNumbers){
    				digits33 = digits3 - numOfNumbers;
    			}
    			if(digits11 <= 0){
    				digits11 = numOfNumbers + digits1;
    			}
    			if(digits22 <= 0){
    				digits22 = numOfNumbers + digits2;
    			}
    			if(digits33 <= 0){
    				digits33 = numOfNumbers + digits3;
    			}
    			Integer[] digits = {digits11, digits22, digits33};
    	    	if(arrayAlreadyExists(digits, listOfGoodCombinations)==false){
    	    		listOfGoodCombinations.add(digits);
    	    	}
    	    }
        }
    }
    for(int digitsA = digitA - 2; digitsA <= digitA + 2; digitsA++){
    	for(int digitsB = digitB - 2; digitsB <= digitB + 2; digitsB++){
    		for(int digitsC = digitC - 2; digitsC <= digitC + 2; digitsC++){
    			int digitsAA = digitsA;
    			int digitsBB = digitsB;
    			int digitsCC = digitsC;
    			if(digitsAA > numOfNumbers){
    				digitsAA = digitsA - numOfNumbers;
    			}
    			if(digitsBB > numOfNumbers){
    				digitsBB = digitsB - numOfNumbers;
    			}
    			if(digitsCC > numOfNumbers){
    				digitsCC = digitsC - numOfNumbers;
    			}
    			if(digitsAA <= 0){
    				digitsAA = numOfNumbers + digitsA;
    			}
    			if(digitsBB <= 0){
    				digitsBB = numOfNumbers + digitsB;
    			}
    			if(digitsCC <= 0){
    				digitsCC = numOfNumbers + digitsC;
    			}
    			Integer[] digits = {digitsAA, digitsBB, digitsCC};
    	    	if(arrayAlreadyExists(digits, listOfGoodCombinations)==false){
    	    		listOfGoodCombinations.add(digits);
    	    	}
    	    }
        }
    }
    writer.println(listOfGoodCombinations.size());
    writer.close();                                  // close the output file
  }
  
  public static boolean arrayAlreadyExists(Integer[] digits, ArrayList<Integer[]> list){
	  for(int ind = 0; ind < list.size(); ind++){
		  boolean numberMatches = true;
		  for(int ind2 = 0; ind2 < digits.length; ind2++){
			  Integer[] listNum = list.get(ind);
			  if(digits[ind2]!=listNum[ind2]){
				  numberMatches = false;
			  }
		  }
		  if(numberMatches==true){
			  return true;
		  }
	  }
	  return false;
  }
}