/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consume_rest_api_java8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author Eddy
 */
public class Consume_REST_API_JAVA8 {
    
    public static void main(String[] args) throws IOException {
        
        String apiUrl = "https://api.chucknorris.io/jokes/random";
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Set headers
        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestProperty("User-Agent", "Java"); // Some APIs require a User-Agent header

        // Optional: Add API key or other headers if required
        // connection.setRequestProperty("Authorization", "Bearer YOUR_API_KEY");

        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) {
            // Read response
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Print JSON response
            System.out.println("Response Body: " + response.toString());
        } else {
            // Handle error response
            System.out.println("Error: " + connection.getResponseMessage());
        }

        // Disconnect the connection
        connection.disconnect();
    } 

    
}
