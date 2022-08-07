package com.newton.code.interview;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Result {

    public static Map<String, Map<String, HoldingData>> holdingsMap;

    public static double calculateNAV(String date) {
        Double navValue = 0.0;
        if (holdingsMap == null || holdingsMap.isEmpty()) {
            holdingsMap = new HashMap<>();

            String holdingAllApi = "https://raw.githubusercontent.com/arcjsonapi/HoldingValueCalculator/master/api/holding";
            String holdingResponse = getApiData(holdingAllApi);
            updateHoldingsToResponse(holdingResponse);

            String allPriceAPi = "https://raw.githubusercontent.com/arcjsonapi/HoldingValueCalculator/master/api/pricing";
            String priceResponse = getApiData(allPriceAPi);
            updatePriceToResponse(priceResponse);
        }

        String dateKey = date.replaceAll("[\\s\\-()]", "");

        if (holdingsMap.containsKey(dateKey)) {
            Map<String, HoldingData> map = holdingsMap.get(dateKey);
            for (Map.Entry<String, HoldingData> e : map.entrySet()) {
                navValue += e.getValue().getQuantity() * e.getValue().getPrice();
            }
        }


        return navValue;
    }

    public static void updatePriceToResponse(String priceResponse) {
        try {
            Gson gson = new GsonBuilder().create();
            PriceData[] r = gson.fromJson(priceResponse, PriceData[].class);

            for (PriceData priceData : r) {
                if (holdingsMap.containsKey(priceData.getDate()) &&
                        holdingsMap.get(priceData.getDate()).containsKey(priceData.getSecurity())) {
                    holdingsMap.get(priceData.getDate()).get(priceData.getSecurity()).setPrice(priceData.getPrice());
                }
            }

        } catch (Exception ex) {
            System.out.println("error in price gson parding =[" + ex + "]");
        }
    }

    public static void updateHoldingsToResponse(String holdingResponse) {
        try {
            Gson gson = new GsonBuilder().create();
            HoldingData[] r = gson.fromJson(holdingResponse, HoldingData[].class);

            for (HoldingData holdingData : r) {
                if (holdingsMap.containsKey(holdingData.getDate())) {
                    holdingsMap.get(holdingData.getDate()).put(holdingData.getSecurity(), holdingData);

                } else {
                    Map<String, HoldingData> map = new HashMap<>();
                    map.put(holdingData.getSecurity(), holdingData);
                    holdingsMap.put(holdingData.getDate(), map);

                }
            }

        } catch (Exception ex) {
            System.out.println("error in holding gson parding =[" + ex + "]");
        }
    }

    public static String getApiData(String urll) {
        try {
            URL url = new URL(urll);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();

            String inline = "";
            Scanner scanner = new Scanner(url.openStream());

            while (scanner.hasNext()) {
                inline += scanner.nextLine();
            }

            scanner.close();

            return inline;

        } catch (Exception e) {
            System.out.println("exception code =" + e);
        }
        return "";
    }

    public class PriceData {

        private String date;
        private String security;
        private Double price;


        @Override
        public String toString() {
            return this.date;
        }


        public String getDate() {
            return date;
        }

        public void setDate(String data) {
            this.date = data;
        }

        public String getSecurity() {
            return security;
        }

        public void setSecurity(String security) {
            this.security = security;
        }


        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }
    }


    public class HoldingData {

        private String date;
        private String security;
        private Integer quantity;
        private Double price;
        private String portfolio;

        @Override
        public String toString() {
            return this.date;
        }


        public String getDate() {
            return date;
        }

        public void setDate(String data) {
            this.date = data;
        }

        public String getSecurity() {
            return security;
        }

        public void setSecurity(String security) {
            this.security = security;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public String getPortfolio() {
            return portfolio;
        }

        public void getPortfolio(String portfolio) {
            this.portfolio = portfolio;
        }


        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }


    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String date = bufferedReader.readLine();

        double result = Result.calculateNAV(date);
        System.out.println("Result is : " + result);
        // bufferedWriter.write(String.valueOf(result));
        // bufferedWriter.newLine();

        bufferedReader.close();
        //  bufferedWriter.close();
    }
}
