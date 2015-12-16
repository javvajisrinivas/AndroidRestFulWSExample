package loginAction;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by Srinivas Javvaji on 12/15/2015.
 */
public class GenerateObjectsList {



    public static List<DueDetails> getDueDetailsList()
    {
            List<DueDetails> dueDetailsliList = new ArrayList<DueDetails>();

        for(int i =0 ; i < 50; i++)
        {
            DueDetails dueDetails = new DueDetails();

            dueDetails.setParty_name("Party_" + i);
            dueDetails.setParty_id("" + i);
            dueDetails.setPending_amt(new Random().nextDouble() * 86);
            dueDetails.setCompany_name(i+"company_name");

            dueDetailsliList.add(dueDetails);
        }
        return dueDetailsliList;
    }


    public static Map<String,String> objectToMap(Object obj)
    {

        Gson gson = new Gson();

        Type stringStringMap = new TypeToken<Map<String, String>>(){}.getType();
        Map<String,String> map = gson.fromJson(gson.toJson(obj), stringStringMap);

        return  map;
    }



    public static Map<String,String> jsonToMap(String json)
    {

        Gson gson = new Gson();
        Type stringStringMap = new TypeToken<Map<String, String>>(){}.getType();
        Map<String,String> map = gson.fromJson(json, stringStringMap);

        return  map;
    }

    public static Map<String, Object> jsonToMap(JSONObject json) throws JSONException {
        Map<String, Object> retMap = new HashMap<String, Object>();

        if(json != JSONObject.NULL) {
            retMap = toMap(json);
        }
        return retMap;
    }

    public static Map<String, Object> toMap(JSONObject object) throws JSONException {
        Map<String, Object> map = new HashMap<String, Object>();

        Iterator<String> keysItr = object.keys();
        while(keysItr.hasNext()) {
            String key = keysItr.next();
            Object value = object.get(key);

            if(value instanceof JSONArray) {
                value = toList((JSONArray) value);
            }

            else if(value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            map.put(key, value);
        }
        return map;
    }

    public static List<Object> toList(JSONArray array) throws JSONException {
        List<Object> list = new ArrayList<Object>();
        for(int i = 0; i < array.length(); i++) {
            Object value = array.get(i);
            if(value instanceof JSONArray) {
                value = toList((JSONArray) value);
            }

            else if(value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            list.add(value);
        }
        return list;
    }




}
