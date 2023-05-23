package BO;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import Bean.Corpus;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class CorpusBO {
    public static String callApiAndGetResponse(String query) throws IOException {
        // Create the URL object with the API endpoint
        String[] queryStrings = query.split(" ");
        String queryString = String.join("%20", queryStrings);
        String urlString = String.format("http://localhost:8000/search/%s", queryString);
        URL url = new URL(urlString);

        // Open a connection to the API URL
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Set the request method
        connection.setRequestMethod("GET");

        // Get the response code
        int responseCode = connection.getResponseCode();

        // Read the response from the API
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        StringBuilder responseBuilder = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            responseBuilder.append(line);
        }

        reader.close();

        // Close the connection
        connection.disconnect();

        // Return the API response
        return responseBuilder.toString();
    }

    public static ArrayList<Corpus> getValueAndReturn(String query) throws IOException {
        String responseValue = callApiAndGetResponse(query);
        ArrayList<Corpus> returnedCorpus = new ArrayList<Corpus>();
        try {
            JSONArray jsonArray = new JSONArray(responseValue);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int id = jsonObject.getInt("id");
                String title = jsonObject.getString("title");
                String content = jsonObject.getString("content");
                Corpus corpus = new Corpus(id, title, content);
                returnedCorpus.add(corpus);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return returnedCorpus;
    }
    public static String callApiAndGetResponseById(int query) throws IOException {
        // Create the URL object with the API endpoint
        String urlString = String.format("http://localhost:8000/corpus/%d", query);
        URL url = new URL(urlString);

        // Open a connection to the API URL
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Set the request method
        connection.setRequestMethod("GET");

        // Get the response code
        int responseCode = connection.getResponseCode();

        // Read the response from the API
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        StringBuilder responseBuilder = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            responseBuilder.append(line);
        }

        reader.close();

        // Close the connection
        connection.disconnect();

        // Return the API response
        return responseBuilder.toString();
    }
    public static Corpus getCorpusById(int query) throws IOException {
        String responseValue = callApiAndGetResponseById(query);
        JSONObject jsonObject = new JSONObject(responseValue);
        String title = jsonObject.getString("title");
        String content = jsonObject.getString("article");
        Corpus corpus = new Corpus(query, title, content);
//        System.out.println(responseValue.toString());
        return corpus;
    }

    public static void main(String[] args) throws IOException {
//        ArrayList<Corpus> corpusList = getValueAndReturn("Alpinia Galanga");
//        System.out.println(corpusList.get(0).getTitle());
        Corpus returnCorpus = getCorpusById(506);
//
        System.out.println(returnCorpus.getTitle());
//        System.out.println(callApiAndGetResponseById(506));
    }
}
