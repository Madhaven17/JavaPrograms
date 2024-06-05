package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.parser.JSONParser;
import org.apache.commons.lang3.StringUtils;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception{
            FileReader reader = new FileReader("/home/msuser1/RECALL ALL LANGUAGES/CurrencyChanger/src/main/java/Currency/CurrencyDatas.json");
            ObjectMapper mapper = new ObjectMapper();
            Object obj = mapper.readValue(reader,Object.class);
            String currency_code = obj.toString();
            String[] strings = StringUtils.split(currency_code,"[{}],");
            List<String> arrayList = new ArrayList<>();
            List<String> listOfCountryCodes = new ArrayList<>();
            for (int i = 0; i < strings.length; i++) {
                strings[i] = strings[i].trim();
                arrayList.add(strings[i]);
            }
            for (String listOfCountry: arrayList){
                if (listOfCountry.matches("currency_code=[a-zA-Z]+")){
                    int indexOfEquals = listOfCountry.indexOf("=");
                    if (indexOfEquals != -1){
                        String code = listOfCountry.substring(indexOfEquals+1).trim();
                        listOfCountryCodes.add(code);
                    }
                }
            }
            for (String code : listOfCountryCodes){
                System.out.println(code);
            }

    }
}
