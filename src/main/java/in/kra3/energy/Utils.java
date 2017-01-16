package in.kra3.energy;

import java.util.HashMap;

/**
 * Created by kra3 on 1/15/17.
 */
public class Utils {
    private static Utils utils;
    private HashMap<String, String> mLookup = null;

    public Utils() {
        mLookup = new HashMap<>();
        mLookup.put("JAN","");
        mLookup.put("FEB","JAN");
        mLookup.put("MAR","FEB");
        mLookup.put("APR","MAR");
        mLookup.put("MAY","APR");
        mLookup.put("JUN","MAY");
        mLookup.put("JUL","JUN");
        mLookup.put("AUG","JUL");
        mLookup.put("SEP","AUG");
        mLookup.put("OCT","SEP");
        mLookup.put("NOV","OCT");
        mLookup.put("DEC","NOV");
    }

    public static Utils getInstance(){
        if(utils == null){
            utils = new Utils();
        }

        return utils;
    }

    public Boolean isValidMonth(String month){
        return mLookup.containsKey(month.toUpperCase());
    }

    public String previousMonth(String month){
        return mLookup.get(month.toUpperCase());
    }
}
