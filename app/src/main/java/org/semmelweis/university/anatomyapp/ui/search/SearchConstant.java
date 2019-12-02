package org.semmelweis.university.anatomyapp.ui.search;

import org.semmelweis.university.anatomyapp.R;

import java.util.Map;
import java.util.TreeMap;

class SearchConstant {

    static String ARROW_UP="up";
    static String ARROW_DOWN="down";

    static Map<String,TreeMap<Integer,String>> fragmentMap = new TreeMap<>();
    static {
        //example
        addPartsToMap(R.drawable.example, "1", "Frontal bone");
        addPartsToMap(R.drawable.example, "2", "Bregma");
        addPartsToMap(R.drawable.example, "3", "Sagittal suture");
        addPartsToMap(R.drawable.example, "4", "Parietal foramen");
        addPartsToMap(R.drawable.example, "5", "Lambda");
        addPartsToMap(R.drawable.example, "6", "Occipital bone");
        addPartsToMap(R.drawable.example, "7", "Lambdoid suture");
        addPartsToMap(R.drawable.example, "8", "Parietal bone");
        addPartsToMap(R.drawable.example, "9", "Coronal suture");
        //example_1
        addPartsToMap(R.drawable.example_1, "1", "Sagittal suture");
        addPartsToMap(R.drawable.example_1, "2, 13", "Parietal bone");
        addPartsToMap(R.drawable.example_1, "3", "Squamous part of occipital bone");
        addPartsToMap(R.drawable.example_1, "4", "Occipitomastoid suture");
        addPartsToMap(R.drawable.example_1, "5", "Superior nuchal line");
        addPartsToMap(R.drawable.example_1, "6", "Inion");
        addPartsToMap(R.drawable.example_1, "7", "External occipital crest");
        addPartsToMap(R.drawable.example_1, "8", "Inferior nuchal line");
        addPartsToMap(R.drawable.example_1, "9", "Mastoid process");
        addPartsToMap(R.drawable.example_1, "10", "Mastoid notch");
        addPartsToMap(R.drawable.example_1, "11", "External occipital protuberance");
        addPartsToMap(R.drawable.example_1, "12", "Lambdoid suture");
        addPartsToMap(R.drawable.example_1, "14", "Sutural bone");
    }


    private static void addPartsToMap(Integer imageId, String numbers, String partName) {
        TreeMap<Integer,String> partSubMap= fragmentMap.containsKey(partName) ? fragmentMap.get(partName) : new TreeMap<>();
        partSubMap.put(imageId, numbers);
        fragmentMap.put(partName,partSubMap);
    }
}
