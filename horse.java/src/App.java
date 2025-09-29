public class App {
    public static void main(String[] args) {
    // create a few Horse objects using the constructor that takes a name and birth year
    Horse horse1 = new Horse("Fred", 2018);
    Horse horse2 = new Horse("Bella", 2015);
    Horse horse3 = new Horse("Shadow", 2022);

    // compute current year dynamically
    int currentYear = java.time.Year.now().getValue();

    System.out.println(horse1.getName() + " is " + horse1.getAge(currentYear) + " years old.");
    System.out.println(horse2.getName() + " is " + horse2.getAge(currentYear) + " years old.");
    System.out.println(horse3.getName() + " is " + horse3.getAge(currentYear) + " years old.");

    // print the objects using toString()
    System.out.println(horse1);
    System.out.println(horse2);
    System.out.println(horse3);
    }
}
