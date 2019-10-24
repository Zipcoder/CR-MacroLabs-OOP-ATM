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
    private Boolean deleted;

    public DB(String fileName, Integer rowLength) throws IOException {
        this.fileName = fileName;
        this.path = fileNameToPath(this.fileName, System.getProperty("user.dir"));
        this.rowLength = rowLength;
        this.deleted = false;

        try { // look for an existing file with that name
            Reader reader = Files.newBufferedReader(Paths.get(this.path));
            CSVReader csvReader = new CSVReader(reader);

            // get all records at once, use that rowLength to override given one, if nec.
            List<String[]> records = csvReader.readAll();
            if (records.size() > 0) {
                 this.rowLength = records.get(0).length;
            }

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
        if (!this.deleted) {
            return this.fileName;
        } else {
            return null;
        }
    }

    public Boolean isDeleted() {
        return deleted;
    }

    public static String pathToFileName (String Path) {
        String[] splitter = Path.split("/");
        return splitter[splitter.length - 1];
    }

    public static String fileNameToPath (String FN, String PWD) {
        return PWD + "/data/" + FN;
    }

    public Integer length() {
        if (!this.deleted) {
            return readAllRows().size();
        } else {
            return null;
        }
    }

    public Integer getRowLength() {
        if (!this.deleted) {
            return this.rowLength;
        } else {
            return null;
        }
    }

    public Boolean checkIntegrity() {
        if (!this.deleted) {
            ArrayList<String[]> records = readAllRows();

            for (String[] row : records) {
                if (row.length != this.rowLength) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public void addRow(String[] row) {
        if (!this.deleted) {
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
    }

    public void replaceRow(Integer rowNum, String[] replacement) {
        ArrayList<String[]> records = null;
        if (!this.deleted && rowNum < length() && replacement.length == this.rowLength) {
            records = readAllRows();
            records.set(rowNum, replacement);
        }
        clear();
        for (String[] row : records) {
            addRow(row);
        }
    }

    public ArrayList<String[]> readAllRows() {
        if (!this.deleted) {
            try { // look for an existing file with that name
                Reader reader = Files.newBufferedReader(Paths.get(this.path));
                CSVReader csvReader = new CSVReader(reader);

                // get all records at once
                List<String[]> records = csvReader.readAll();
                // loop through records
                return new ArrayList<String[]>(records);

            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }

    }

    public void printDB() {
        if (!this.deleted) {
            for (String[] row : readAllRows()) {
                System.out.println("");

                for (String field : row) {
                    System.out.print(field + "/");
                }
            }
        }
    }

    public void clear() {
        if (!this.deleted) {
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

    public void delete() {

        File file = new File(this.path);
        file.delete();
        this.deleted = true;

    }


}
