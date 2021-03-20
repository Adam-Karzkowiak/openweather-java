import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

class OpenWeatherService {


    public Map<String, Object> jsonToMap(String str) {
        return new Gson()
                .fromJson(str, new TypeToken<HashMap<String, Object>>() {
                }
                        .getType());
    }


    public String connectAndFetchWindSpeed() {
        String result = null;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            URL url = new URL(Constants.URL_ADDRESS);
            URLConnection connection = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            bufferedReader.close();
            Map<String, Object> responseMap = jsonToMap(stringBuilder.toString());
            Map<String, Object> windMap = jsonToMap(responseMap.get("wind").toString());
            result = windMap.get("speed").toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
