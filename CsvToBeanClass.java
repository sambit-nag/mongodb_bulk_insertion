package com.sam.jsonApp;

import com.google.gson.Gson;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;


public class CsvToBeanClass {
        public static void main(String[] args)
        {


            Map<String, String> mapping = new HashMap<String, String>();
            mapping.put("Avg_Visits_Duration", "Avg_Visits_Duration");
            mapping.put("Frequency", "Frequency");
            mapping.put("Visitors", "Visitors");
            mapping.put("cluster", "cluster");
            mapping.put("Customer", "Customer");

            // HeaderColumnNameTranslateMappingStrategy
            // for MongoDBPojo class
            HeaderColumnNameTranslateMappingStrategy<MongoDbPojo> strategy =
                    new HeaderColumnNameTranslateMappingStrategy<MongoDbPojo>();
            strategy.setType(MongoDbPojo.class);
            strategy.setColumnMapping(mapping);

            CSVReader csvReader = null;
            try {
                String fileName= args[0];
                csvReader = new CSVReader(new FileReader (fileName));
            }
            catch (FileNotFoundException e) {

                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            CsvToBean csvToBean = new CsvToBean();


            List<MongoDbPojo> list = csvToBean.parse(strategy, csvReader);
            Map<String, JsonObjects> map =new HashMap<String,JsonObjects>();


            // print details of Bean object
            for (MongoDbPojo e : list) {
                List<JsonObjects> jsonObject = new ArrayList<JsonObjects>();
                if (map.containsKey(e.Customer)) {
                    JsonObjects obj = map.get(e.Customer);
                    if (e.cluster.equals("Non-Visitor2")) {
                        Float arr[] = new Float[2];
                        arr[1] = e.Avg_Visits_Duration;
                        arr[0] = e.Frequency;
                        obj.setVcModelNonVisitor2(arr);

                    } else if (e.cluster.equals("Non-Visitor1")) {
                        Float arr[] = new Float[2];
                        arr[1] = e.Avg_Visits_Duration;
                        arr[0] = e.Frequency;
                        obj.setVcModelNonVisitor1(arr);

                    }else if (e.cluster.equals("Visitor")) {
                        Float arr[] = new Float[2];
                        arr[1] = e.Avg_Visits_Duration;
                        arr[0] = e.Frequency;
                        obj.setVcModelVisitor(arr);

                    }

                    map.put(e.Customer,obj);

                } else {
                    JsonObjects obj =new JsonObjects();
                    Float arr[] = new Float[2];
                    arr[1] = e.Avg_Visits_Duration;
                    arr[0] = e.Frequency;
                    if(e.cluster.equals("Visitor")) {
                        obj.setVcModelVisitor(arr);
                    }else if(e.cluster.equals("Non-Visitor1")){
                        obj.setVcModelNonVisitor1(arr);
                    }else{
                        obj.setVcModelNonVisitor2(arr);
                    }
                    obj.set_id(e.Customer);
                    obj.setCreatedOn(LocalDateTime.now().toString());
                    obj.setUpdatedOn(LocalDateTime.now().toString());

                    map.put(e.Customer,obj);

                }




            }

            Collection<JsonObjects> jsonObjList= map.values();
            Gson gson = new Gson();

            String jsonStr =gson.toJson(jsonObjList);
            String outputFile = args[1];

            BufferedWriter writer = null;
            try
            {
                writer = new BufferedWriter( new FileWriter(outputFile));
                writer.write(jsonStr);
                writer.close( );
            }
            catch ( IOException e)
            {
            }
        }
    }


