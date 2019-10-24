import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DB {

    private String fileName;
    private String path;
    private Integer rowLength;

    public DB(String fileName, Integer rowLength) throws IOException {
        this.fileName = fileName;
        this.path = fileNameToPath(this.fileName, System.getProperty("user.dir"));
        this.rowLength = rowLength;

        try { // look for an existing file with that name
            Reader reader = Files.newBufferedReader(Paths.get(this.path));
            CSVReader csvReader = new CSVReader(reader);

            // get all records at once
            List<String[]> records = csvReader.readAll();
            // loop through records

        }
        catch(NoSuchFileException e) { // make a new file, if one doesn't exist in place
            File file = new File(this.path);
            FileWriter outputfile = new FileWriter(file);

            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputfile);

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getPath() {
        return this.path;
    }

    public static String pathToFileName (String Path) {

        String[] splitter = Path.split("/");
        return splitter[splitter.length-1];
    }

    public static String fileNameToPath (String FN, String PWD) {
        return PWD + "/data/" + FN;
    }

    public Integer length() {
        return readAllRows().size();
    }

    public Integer getRowLength() {
        return this.rowLength;
    }

    public void setPath(String fName) {
        this.fileName = fName;
    }

    public Boolean checkIntegrity() {
        ArrayList<String[]> records = readAllRows();

        for (String[] row : records) {
            if (row.length != this.rowLength) {
                return false;
            }
        }
        return true;
    }

    public void addRow(String[] row) {
        try {
            File file = new File(this.path);
            FileWriter outputfile = new FileWriter(file, true);

            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputfile);
            if (row.length == this.rowLength) { // only write if this row is the correct length
                writer.writeNext(row);
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String[]> readAllRows() {
        try { // look for an existing file with that name
            Reader reader = Files.newBufferedReader(Paths.get(this.path));
            CSVReader csvReader = new CSVReader(reader);

            // get all records at once
            List<String[]> records = csvReader.readAll();
            // loop through records
            return new ArrayList<String[]> (records);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    public void printDB() {
        for (String[] row : readAllRows()) {
            System.out.println("");

            for (String field : row) {
                System.out.print(field + "/");
            }
        }
    }

    public void clear() {
        try {
            File file = new File(this.path);
            FileWriter outputfile = new FileWriter(file);

            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputfile);

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
