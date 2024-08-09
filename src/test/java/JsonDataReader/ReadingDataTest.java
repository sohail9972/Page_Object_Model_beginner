package JsonDataReader;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import org.openqa.selenium.json.Json;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReadingDataTest {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader reader = new FileReader("src/test/DataFiles/JsonDataTestFile.json");
        JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
        String fnmae= String.valueOf(jsonObject.get("firstName"));
        String lname = String.valueOf(jsonObject.get("lastName"));
//        System.out.println(fnmae + lname);

        JsonArray array = jsonObject.getAsJsonArray("address");
//        System.out.println(array);

    for (int i=0;i<array.size();i++){
        JsonObject addressElement = (JsonObject) array.get(i);
        String street = String.valueOf(addressElement.get("street"));
        String city = String.valueOf(addressElement.get("city"));
        String state = String.valueOf(addressElement.get("state"));
        String id = String.valueOf(addressElement.get("id"));
//        System.out.println(i + street +city + state + id);

        int newId = addressElement.get("id").getAsInt();
        System.out.println(newId);

    }
    }

}
