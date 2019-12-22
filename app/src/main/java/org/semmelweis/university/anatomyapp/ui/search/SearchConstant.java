package org.semmelweis.university.anatomyapp.ui.search;

import org.semmelweis.university.anatomyapp.R;

import java.util.Map;
import java.util.TreeMap;

class SearchConstant {

    static String ARROW_UP="up";
    static String ARROW_DOWN="down";

    static Map<String,TreeMap<Integer,SearchDto>> fragmentMap = new TreeMap<>();
    static {
        //example
        addPartsToMap(R.drawable.example, "1", "Frontal bone", R.drawable.example_frontal_bone);
        addPartsToMap(R.drawable.example, "2", "Bregma", R.drawable.example_bregma);
        addPartsToMap(R.drawable.example, "3", "Sagittal suture", R.drawable.example_sagittal_suture);
        addPartsToMap(R.drawable.example, "4", "Parietal foramen", R.drawable.example_parietal_foramen);
        addPartsToMap(R.drawable.example, "5", "Lambda", R.drawable.example_lambda);
        addPartsToMap(R.drawable.example, "6", "Occipital bone", R.drawable.example_occipital_bone);
        addPartsToMap(R.drawable.example, "7", "Lambdoid suture", R.drawable.example_lambdoid_suture);
        addPartsToMap(R.drawable.example, "8", "Parietal bone", R.drawable.example_parietal_bone);
        addPartsToMap(R.drawable.example, "9", "Coronal suture", R.drawable.example_coronal_suture);
        //example_1
        addPartsToMap(R.drawable.example_1, "1", "Sagittal suture", R.drawable.example_1_sagittal_suture);
        addPartsToMap(R.drawable.example_1, "2, 13", "Parietal bone", R.drawable.example_1_parietal_bone);
        addPartsToMap(R.drawable.example_1, "3", "Squamous part of occipital bone", R.drawable.example_1_squamous_part_of_occipital_bone);
        addPartsToMap(R.drawable.example_1, "4", "Occipitomastoid suture", R.drawable.example_1_occipitomastoid_suture);
        addPartsToMap(R.drawable.example_1, "5", "Superior nuchal line", R.drawable.example_1_superior_nuchal_line);
        addPartsToMap(R.drawable.example_1, "6", "Inion", R.drawable.example_1_inion);
        addPartsToMap(R.drawable.example_1, "7", "External occipital crest", R.drawable.example_1_external_occipital_crest);
        addPartsToMap(R.drawable.example_1, "8", "Inferior nuchal line", R.drawable.example_1_inferior_nuchal_line);
        addPartsToMap(R.drawable.example_1, "9", "Mastoid process", R.drawable.example_1_mastoid_process);
        addPartsToMap(R.drawable.example_1, "10", "Mastoid notch", R.drawable.example_1_mastoid_notch);
        addPartsToMap(R.drawable.example_1, "11", "External occipital protuberance", R.drawable.example_1_external_occipital_protuberance);
        addPartsToMap(R.drawable.example_1, "12", "Lambdoid suture", R.drawable.example_1_lambdoid_suture);
        addPartsToMap(R.drawable.example_1, "14", "Sutural bone", R.drawable.example_1_sutural_bone);
    }

    private static void addPartsToMap(Integer imageId, String numbers, String partName, Integer selectorId) {
        TreeMap<Integer,SearchDto> partSubMap= fragmentMap.containsKey(partName) ? fragmentMap.get(partName) : new TreeMap<>();
        partSubMap.put(imageId, new SearchDto(numbers, selectorId));
        fragmentMap.put(partName,partSubMap);
    }
}
