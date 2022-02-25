import java.io.FileNotFoundException;
import java.util.*;

public class UserInteraction {

    private Scanner input;
    static Buttons knapper = new Buttons("","","");

    ByAndPostnummer byAndPostnummer = new ByAndPostnummer();

    public void runApp() throws FileNotFoundException {

        byAndPostnummer.readFile();

        int userAnswer1 = getAnswer1();

        switch (userAnswer1){

            case 1 :
                int postNumer = getZipCode();
                System.out.println(byAndPostnummer.machWithZip(postNumer));
                break;

            case 2 :
                String by = getCity();
                System.out.println(byAndPostnummer.machWithCity(by));
                break;

            default:

        }

    }

    public String getCity(){
        input = new Scanner(System.in);
        System.out.println("Enter City");
        String city = input.next();
        return city;

    }

    public int getZipCode() {
        input = new Scanner(System.in);
        System.out.println("Enter Zip-Code");
        int postNummer = input.nextInt();
        return postNummer;
    }

    public int getAnswer1 (){
        input = new Scanner(System.in);
        knapper.smallButton("Press 1 to enter Zip-code");
        System.out.println("\nor\n Press 2 if you want to enter City");
        while(!input.hasNextInt()){
            System.out.println("Not valid try again");
            System.out.println("Press 1 if you want to enter Zip-code\nor Press 2 if you want to enter City");
        }
        int ans = input.nextInt();
        if(ans == 1){
            return 1;
        } else if (ans == 2){
            return 2;
        }else {
            System.out.println("Not valid - try again!");
            getAnswer1();
        }
        return 0;
    }
}
