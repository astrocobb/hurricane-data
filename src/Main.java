import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        // instantiate a new scanner with the first file as the argument
        Scanner scanner = new Scanner(new File(args[0]));

        // create an ArrayList of HurricaneRowData objects
        ArrayList<HurricaneRowData> hurricaneData = new ArrayList<>();

        // skip the first line
        scanner.nextLine();

        // while there's a next line, scan it
        while (scanner.hasNextLine()) {

            // set the current row to a string array, splitting it at the commas and removing leading and trailing spaces
            String[] rowData = scanner.nextLine().trim().split(",");

            // parse this row's data into integers
            int year = Integer.parseInt(rowData[0]);
            int aceIndex = Integer.parseInt(rowData[1]);
            int storms = Integer.parseInt(rowData[2]);
            int hurricanes = Integer.parseInt(rowData[3]);
            int majorHurricanes = Integer.parseInt(rowData[4]);

            // add the data to the ArrayList
            hurricaneData.add(new HurricaneRowData(year, aceIndex, storms, hurricanes, majorHurricanes));
        }

        scanner.close();

        // get the row with the max ACE value
        HurricaneRowData maxRow = getMaxAce(hurricaneData);

        // print the max ACE and its corresponding year
        System.out.println("The year of the greatest ACE index (" + maxRow.getAceIndex() + ") was " + maxRow.getYear());

        // write the max ACE and its corresponding year to a text file
        FileWriter fileWriter = new FileWriter("max-ace.txt");
        fileWriter.write("The year of the greatest ACE index (" + maxRow.getAceIndex() + ") was " + maxRow.getYear());
        fileWriter.close();
    }

    /**
     * method to get the max ACE index from an ArrayList of hurricane data
     * @param hurricaneData ArrayList of hurricane data
     * @return the year the max ACE index was the highest
     */
    public static HurricaneRowData getMaxAce(ArrayList<HurricaneRowData> hurricaneData) {

        // instantiate and set maxRow to the first row in hurricaneData
        HurricaneRowData maxRow = hurricaneData.getFirst();

        // for each row in hurricaneData...
        for (HurricaneRowData row : hurricaneData) {

            // if the current row's ACE index is greater than maxRow's, set maxRow equal to the current row
            if (row.getAceIndex() > maxRow.getAceIndex()) {
                maxRow = row;
            }
        }
        
        return maxRow;
    }
}