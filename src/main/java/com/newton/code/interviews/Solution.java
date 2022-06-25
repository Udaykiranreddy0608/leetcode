package com.newton.code.interviews;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;


class Result {

    /*
     * Complete the 'apiResponseParser' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY inputList
     *  2. INTEGER size
     */


    public static Map<String, Map<String, String>> map = new HashMap<>();

    public static List<Integer> apiResponseParser(List<String> inputList, int size) {

        String usersApi = "https://raw.githubusercontent.com/arcjsonapi/ApiSampleData/master/api/users";
        String userApiResponse = getApiData(usersApi);
        Gson gson = new GsonBuilder().create();
        UserInfo[] userInfos = gson.fromJson(userApiResponse, UserInfo[].class);

        if (size != 3) {
            return Arrays.asList(-1);
        }

        String column = inputList.get(0);
        String op = inputList.get(1);
        String val = inputList.get(2);


        List arrayList = new ArrayList();
        switch (op) {
            case "EQUALS":
                arrayList = (checkIfExists(column, val, userInfos));
                if (arrayList.size() == 0) {
                    arrayList.add(-1);
                }
                break;
            case "IN": {
                String[] strings = val.split(",");
                for (String string : strings) {
                    List res = checkIfExists(column, string, userInfos);
                    for (Object re : res) {
                        arrayList.add(re);
                    }
                }
            }
            break;


        }

        System.out.println("Arrys " + arrayList);
        return arrayList;

    }

    private static List<Integer> checkIfExists(String column, String val, UserInfo[] userInfo) {
        List<Integer> cnt = new ArrayList();
        for (UserInfo info : userInfo) {
            switch (column) {
                case "id":
                    if (info.getId().toString().equals(val)) cnt.add(info.getId());
                    break;
                case "name":
                    if (info.getName().equals(val)) cnt.add(info.getId());
                    break;
                case "username":
                    if (info.getUsername().equals(val)) cnt.add(info.getId());
                    break;
                case "email":
                    if (info.getEmail().equals(val)) cnt.add(info.getId());
                    break;
                case "address.street":
                    if (info.getAddress().getStreet().equals(val)) cnt.add(info.getId());
                    break;
                case "address.suite":
                    if (info.getAddress().getSuite().equals(val)) cnt.add(info.getId());
                    break;
                case "address.city":
                    if (info.getAddress().getCity().equals(val)) cnt.add(info.getId());
                    break;
                case "address.zipcode":
                    if (info.getAddress().getZipcode().equals(val)) cnt.add(info.getId());
                    break;
                case "address.geo.lat":
                    if (info.getAddress().getGeo().getLat().equals(val)) cnt.add(info.getId());
                    break;
                case "address.geo.lng":
                    if (info.getAddress().getGeo().getLng().equals(val)) cnt.add(info.getId());
                    break;
                case "website":
                    if (info.getWebsite().equals(val)) cnt.add(info.getId());
                    break;
                case "company.name":
                    if (info.getCompany().getName().equals(val)) cnt.add(info.getId());
                    break;
                case "company.basename":
                    if (info.getCompany().getBasename().equals(val)) cnt.add(info.getId());
                    break;
                default:
                    cnt.add(-1);
                    return cnt;
            }

        }

        return cnt;
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

    public class UserInfo {

        private Integer id;
        private String name;
        private String username;
        private String email;
        private Address address;
        private String website;
        private Company company;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Address getAddress() {
            return address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }

        public String getWebsite() {
            return website;
        }

        public void setWebsite(String website) {
            this.website = website;
        }

        public Company getCompany() {
            return company;
        }

        public void setCompany(Company company) {
            this.company = company;
        }

        @Override
        public String toString() {
            return "UserInfo{" + "id=" + id + ", name='" + name + '\'' + ", userName='" + username + '\'' + ", email='" + email + '\'' + ", address=" + address + ", website='" + website + '\'' + ", company=" + company + '}';
        }
    }

    public class Company {
        private String name;
        private String basename;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getBasename() {
            return basename;
        }

        public void setBasename(String basename) {
            this.basename = basename;
        }

        @Override
        public String toString() {
            return "Company{" + "name='" + name + '\'' + ", baseName='" + basename + '\'' + '}';
        }
    }

    public class Address {
        private String street;
        private String suite;
        private String city;
        private String zipcode;
        private GeoLocation geo;

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getSuite() {
            return suite;
        }

        public void setSuite(String suite) {
            this.suite = suite;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getZipcode() {
            return zipcode;
        }

        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }

        public GeoLocation getGeo() {
            return geo;
        }

        public void setGeo(GeoLocation geo) {
            this.geo = geo;
        }

        @Override
        public String toString() {
            return "Address{" + "street='" + street + '\'' + ", suite='" + suite + '\'' + ", city='" + city + '\'' + ", zipcode='" + zipcode + '\'' + ", geo=" + geo + '}';
        }
    }

    public class GeoLocation {
        private String lat;
        private String lng;

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getLng() {
            return lng;
        }

        public void setLng(String lng) {
            this.lng = lng;
        }

        @Override
        public String toString() {
            return "GeoLocation{" + "lat='" + lat + '\'' + ", lng='" + lng + '\'' + '}';
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

//        int inputListCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<String> inputList = IntStream.range(0, inputListCount).mapToObj(i -> {
//                    try {
//                        return bufferedReader.readLine();
//                    } catch (IOException ex) {
//                        throw new RuntimeException(ex);
//                    }
//                })
//                .collect(toList());
//
//        int size = Integer.parseInt(bufferedReader.readLine().trim());

        System.out.println(Result.apiResponseParser(Arrays.asList("company.name", "IN", "robert-techgiant,Sanganak"), 3));
//
//        bufferedWriter.write(
//                result.stream()
//                        .map(Object::toString)
//                        .collect(joining("\n"))
//                        + "\n"
//        );

        bufferedReader.close();
        //   bufferedWriter.close();
    }
}

