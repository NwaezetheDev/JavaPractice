import java.util.Scanner; //import Scanner to read in input

public class StudentGradingSystem {
  //main method
  public static void main(String[]args){
    //declare the scanner object
    Scanner sc = new Scanner(System.in);

    //ask user to input raw/original score
    System.out.print("Enter raw score(0-100): ");
    double rawScore = sc.nextDouble();

    //ask user to input time of submission
    System.out.print("Enter late submission time(in minutes): ");
    int lateSubTime = sc.nextInt();

    //declare variable deduction for giving it value at the start then replacing it later on
    double deduction = rawScore;

    //declare variable value to verify conditions
    boolean valid = true;

    if (lateSubTime <= 10 && lateSubTime >= 1) {
       deduction = rawScore - (rawScore * ((double)5/100));
       System.out.println("Your new score after evaluation is: " + deduction);
    } else if(lateSubTime <= 30 && lateSubTime >= 11){
      deduction = rawScore - (rawScore * ((double)10/100));
       System.out.println("Your new score after evaluation is: " + deduction);
    } else if (lateSubTime > 30) {
        deduction = rawScore - (rawScore * ((double)20/100));
       System.out.println("Your new score after evaluation is: " + deduction);
    } else if(lateSubTime == 0) {
      System.out.println("Your grade remains: " + rawScore);
    } else{
      System.out.println("Enter valid time please");
      valid =false; //print "Enter valid time please" if the input is not the right one e.g negative values
    }

    //if the input is valid then we decide the grade
    if(valid){
    if (deduction >= 80) {
        System.out.println("Your grade is A");
    } else if (deduction >= 70){
        System.out.println("Your grade is B");
    } else if (deduction >=60) {
        System.out.println("Your grade is C");
    } else if (deduction >=50){
        System.out.println("Your grade is D");
    } else {
      System.out.println("Your grade is F");
    }
    }
  }
  }

