/*
Name: Yash Patel
Program Name: Random Celebrity Partners
Date: 10/1/21
Wouldn't it be great if our favorite celebrities got to meet each other?
*/
import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) {

    //initialize variables
    int celeb1i = 0;
    int celeb1j = 0;
    int celeb1k = 0;

    String[] celeb11 = new String[16];
    String[] celeb21 = new String[16]; //group 1
    String[] celeb12 = new String[16];
    String[] celeb22 = new String[16]; //group 2
    String[] celeb13 = new String[32];
    String[] celeb23 = new String[32]; //for full list

    Scanner fileScanner;
    File Names;

    String name; //variable will hold value of each name from the file

    try {
      Names = new File("Names.txt");
      fileScanner = new Scanner(Names);
      while(fileScanner.hasNextLine()) {
        name = fileScanner.nextLine(); //scan file
        celeb13[celeb1i] =  name; //add name to celeb1
        celeb23[celeb1i] = name; //add name to celeb2
        celeb1i += 1; //increase by 1 for next value
        if(name.charAt(0) == '1') {
          celeb11[celeb1j] =  name;
          celeb21[celeb1j] = name;
          celeb1j += 1;
        }
        else if(name.charAt(0) == '2') {
          celeb12[celeb1k] =  name;
          celeb22[celeb1k] = name;
          celeb1k += 1;
        }
      }
    fileScanner.close(); //close file scanner
    }
    catch(FileNotFoundException e) {
      System.out.println(e.getMessage());
    }

    System.out.println("\n\nWelcome to the Random Celebrity Duo Generator!\nEvery celeb on this top-tier list will get to meet two other\ntop-tier celebrities!");
    String run = "y";
    do {
      int group = 0;
      do{
        Scanner input = new Scanner(System.in);
        System.out.println("\nWould you like to sort by Group 1, 2, or everybody? (1, 2, 3)");
        group = input.nextInt();
        if(group < 1 || group > 3) {
          System.out.println("\nEnter a valid option.");
        }
      }while(group < 1 || group > 3);

      if(group == 1) {
        pair(celeb11, celeb21); //sort first group if user picks 1
      }
      if(group == 2) {
        pair(celeb12, celeb22); //sort second group if user picks 2
      }
      if(group == 3) {
        pair(celeb13, celeb23); //sort whole class if user picks 3
      }
      
      Scanner input2 = new Scanner(System.in);
      System.out.println("\nWould you like to run the program again? (y or n)");
      run = input2.nextLine();
    }while(run.equalsIgnoreCase("Y")); //do while loop in case program wants to be run again

    System.out.println("\nThank you for running the random celebrity duo generator program.");

  }

public static void pair(String[] arr1, String[] arr2) {
  alphabetize(arr1, arr2); //calls method for alphabetizing names
  int shift = (int)(Math.random() * (arr1.length - 2) + 1); //shifting one of our arrays by a random number between 1 and the array's length - 2 to partner up celeb1 and celeb2
  for(int i = 0; i < shift; i++) { //shift the array by 1 in a for loop
    String temp1 = arr2[0];
    String temp2 = arr2[1]; //temporary values for shifting arrays
    for(int j = 0; j < arr2.length; j++) {
      if(j != arr2.length - 1) { //if it isn't the last value
        arr2[j + 1] = temp1; //shift by 1
        temp1 = temp2;
        if(j < arr2.length - 2) { //if it isn't the second to last value
          temp2 = arr2[j + 2]; 
        }
        else {
          temp2 = arr2[0];
        }
      }
      else {
        arr2[0] = temp1; //first value equals last value
      }
    }
  }
  //celeb 1:
  System.out.println("\n(formatted alphabetically by celeb 1)");
  System.out.printf("%-10s %-20s %-10s %-20s\n" , "Group:" , "Celeb 1:" , "Group:" , "Celeb 2:");
  System.out.println("---------------------------------------------------------------"); //format heading

  for(int i = 0; i < arr1.length; i++) {
    System.out.printf("%-10s %-20s %-10s %-20s\n" , arr1[i].charAt(0) , arr1[i].substring(2) , arr2[i].charAt(0) , arr2[i].substring(2));
  }


}

public static void alphabetize(String[] arr1, String[] arr2) {
  String temp1;
  String temp2;
  String value1;
  String value2;
  for(int i = 0; i < arr1.length - 1; i++) {
    for(int j = i + 1; j < arr1.length; j++) {
      if((arr1[i].substring(2)).compareToIgnoreCase((arr1[j].substring(2))) > 0) {
        temp1 = arr1[i];
        arr1[i] = arr1[j];
        arr1[j] = temp1; //exchange sort for alphabetizing

        temp2 = arr2[i];
        arr2[i] = arr2[j];
        arr2[j] = temp2;
      }
    }
  }
}

}