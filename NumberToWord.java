import java.util.Scanner;       //importing the Scanner class

public class NumberToWord //creating a Main class
{
    static String[] wordbank = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    //declaring, creating, and initializing an array
    static String[] wordbank2 = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    //declaring, creating, and initializing an array
    static String[] wordbank3 = {"twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    //declaring, creating, and initializing an array
    static String[] wordbank4 = {"", "thousand", "million"};
    //declaring, creating, and initializing an array
    public static int input()   //defining input method
    {
        Scanner scanner = new Scanner(System.in);   //creates a Scanner object
        return scanner.nextInt();       //Reads and returns numerical user input
    }   //end of input method
    public static boolean response()    //defining response method
    {
        Scanner scanner = new Scanner(System.in);   //creates a Scanner object
        return !scanner.next().equals("N");     //Reads user string input and returns a boolean
    }   //end of response method
    public static void print(String str)    //defining print method with a string parameter
    {
        System.out.println(str);    //prints the string from parameter
    }   //end of print method
    public static String toWord(int a)      //defining toWord method with an integer parameter
    {
        int[]array = new int[4];    //declaring and initializing an array
        int i = 0;      //declaring and initializing a variable
        do      //do while loop to separate the number to every 3 digits while the number is greater than 0
        {
            array[i] = a%1000;  //populates array with the digits
            a = a/1000;      //updating the variable
            i++;    //move to the next index
        }while (a > 0);         //end of do while loop
        String word = "";   //declaring and initializing a String class
        for (int j = i-1; j >= 0; j--)  //for loop to convert every 3 place values into words
        {
            if (array[j] != 0)  //if all 3 place values are not equal to 0
            {
                int hundreds = array[j]/100;    //calculating value of hundreds
                int tens = (array[j]/10)%10;    //calculating value of tens
                int ones = array[j]%10;         //calculating value of ones
                if (hundreds != 0)  //if the hundreds place is not equal to 0
                {
                    word = word + wordbank[hundreds - 1] + " hundred ";     //reassigning variable (word + digit + hundred)
                }   //end of if statement
                if (tens == 1)  //if the tens place is equal to 1
                {
                    word = word + wordbank2[ones] + " " + wordbank4[j] + " ";   //reassigning variable (word +[ten to nineteen] + [nothing, thousand, or million])
                }   //end of if statement
                else    //if the tens place is not equal to 1
                {
                    if (tens != 0)      //if the tens place is not equal to 0
                    {
                        word = word + wordbank3[tens - 2] + " ";    //reassigning variable (word + [twenty, thirty, ..., ninety])
                    }   //end of if statement
                    if (ones != 0)      //if ones place is not equal to 0
                    {
                        word = word + wordbank[ones - 1] + " " + wordbank4[j] + " ";    //reassigning variable (word + digit + [nothing, thousand, or million])
                    }   //end of if statement
                    else    //if tens place or ones place are equal to 0
                    {
                        word = word + wordbank4[j] + " ";   //reassigning variable (word + [nothing, thousand, or million])
                    }   //end of else statement
                }   //end of else statement
            }   //end of if statement
        }   //end of for loop
        return word;    //returns the word
    }   //end of toWord method

    public static void main(String[] args) {    //defining a main method
        boolean yes = true; //declaring and initializing a variable
        do     //do while loop to run the program while the user wants to continue
        {
            print("Please insert a number from 0 to 999999999 to convert into words."); //asking user for an input
            int num = input();  //declaring a variable and initializing the variable for input method
            if (num == 0)   //if the number is equal to 0
            {
                print("zero");      //outputting zero if the input is zero
                print("Do you want to continue? Y for yes and N for no.");  //asking user if they want to continue
                yes = response();   //reassigning variable (no = false, yes = true)
            }   //end of if statement
            else if (num > 0 && num < 1000000000)   //else if the number is between 1 and 999999999 inclusively
            {
                print(toWord(num));     //outputting number in words
                print("Do you want to continue? Y for yes and N for no.");  //asking user if the want to continue
                yes = response();   //reassigning variable (no = false, yes = true)
            }
            else    //if the number is not within the conditions
            {
                print("Something went wrong.");     //outputting error message if the number is not within bounds
            }
        } while (yes); //end of while loop
    }   //end of main method
}   //end of class
