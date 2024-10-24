package config;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SeriesDataset {
    @DataProvider(name = "SeriesCSVData")
    public Object[][] getCSVData() throws IOException {
        String filepath = "./src/test/resources/data.csv";  // Your CSV file path
        List<Object[]> data = new ArrayList<>();
        CSVParser csvParser = new CSVParser(new FileReader(filepath), CSVFormat.DEFAULT.withFirstRecordAsHeader());

        for (CSVRecord csvRecord : csvParser) {
            String expression = csvRecord.get("expression");
            String expected = csvRecord.get("expected");
            data.add(new Object[]{expression, expected});
        }

        return data.toArray(new Object[0][]);
    }
}


