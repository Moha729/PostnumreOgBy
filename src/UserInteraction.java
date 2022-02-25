import java.io.FileNotFoundException;
import java.util.*;

public class UserInteraction {

    //Denne klasse står for kommunikationen mellem system og bruger

    private Scanner input;

    static Buttons knapper = new Buttons("","","");

    ByAndPostnummer byAndPostnummer = new ByAndPostnummer();


    //runApp metoden står for at kører hele programmet

    public void runApp() throws FileNotFoundException {

        byAndPostnummer.readFile();

        int userAnswer1 = getAnswer1();

        switch (userAnswer1){

            case 1 :
                int postNumer = getZipCode();
                System.out.println(knapper.smallButton("The city in "+postNumer+" is: "+ byAndPostnummer.machWithZip(postNumer)));
                break;

            case 2 :
                String by = getCity();
                System.out.println(knapper.smallButton("The zip-code of "+by+" is: "+byAndPostnummer.machWithCity(by)));
                break;

            default:

        }

    }


    //Når vi vil prompte for en by
    //for at bruge svaret til at kende postnumret
    public String getCity(){
        input = new Scanner(System.in);
        System.out.println(knapper.smallButton("Enter City"));
        String city = input.next();
        return city;
    }

    //Når vi vil prompte for et postnummer
    //vi bruger nummeret til at kende byen
    public int getZipCode() {
        input = new Scanner(System.in);
        System.out.println(knapper.smallButton("Enter Zip-Code"));
        int postNummer = input.nextInt();
        return postNummer;
    }

    //prompter brugeren om vi skal søge igennem et postnummer eller en by
    //Vi bruger svaret i vores switch case for at afgøre hvilke efterfølgende metode der skal køres
    public int getAnswer1 (){
        input = new Scanner(System.in);
        System.out.println(knapper.dobbleButton("Press 1 to enter Zip-code", "Press 2 to enter City"));

        while(!input.hasNextInt()){
            System.out.println();
            System.out.println(knapper.bigButton("Not valid try again"));
            System.out.println(knapper.dobbleButton("Press 1 to enter Zip-code", "Press 2 to enter City"));
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
