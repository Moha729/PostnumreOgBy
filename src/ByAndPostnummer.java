import java.io.*;
import java.util.*;

public class ByAndPostnummer {

    //Jeg opretter et TreeMap for at sætte postnumre og byer sammen
    //I denne klasse bliver Map håndteringen udført

    Map<Integer, String> postNumre = new TreeMap<>();

    public String machWithZip(int zipCode){
        return postNumre.get(zipCode);
    }

    public int machWithCity(String city){

        Set<Map.Entry<Integer, String>> entries = postNumre.entrySet();
        for( Map.Entry<Integer, String> entry : entries ){

            if(entry.getValue().equals(city)){
                //System.out.println("Key for value " + city + " is: " + entry.getKey());
                return entry.getKey();
            }
        } return 0;
    }

    public void readFile() throws FileNotFoundException {

        Scanner fileScan = new Scanner(new File("PostnumreDK"));
        while (fileScan.hasNextLine()){
            String line = fileScan.nextLine();

            Scanner lineScan = new Scanner (line);
            if (lineScan.hasNext()) {
                int postnummer = lineScan.nextInt();

                String by = lineScan.next();
                String byBy = by;
                while (lineScan.hasNext()) {
                    byBy = by + lineScan.next();
                }
                postNumre.put(postnummer, byBy);
            }
        }
    }
}
