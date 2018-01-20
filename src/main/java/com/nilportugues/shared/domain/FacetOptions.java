package com.nilportugues.shared.domain;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FacetOptions {

    private HashMap<String, HashMap<String, AbstractMap.SimpleEntry<String, FilterOptions>>> facetsFromFilteredValues = new HashMap<>();
    private HashMap<String, String> facetsFromField = new HashMap<>();
    private List<String> facetKeys = new ArrayList<>();
    private List<String> stopWords = new ArrayList<>();
    private HashMap<String, Long> fieldBoost = new HashMap<>();
    private HashMap<String, List<Object>> positiveBoost = new HashMap<>();
    private HashMap<String, List<Object>> negativeBoost = new HashMap<>();

    public FacetOptions() {
    }

    public HashMap<String, Long> getFieldBoost() {
        return fieldBoost;
    }

    public void setFieldBoost(HashMap<String, Long> fieldBoost) {
        this.fieldBoost = fieldBoost;
    }

    public void addFieldBoost(String fieldName, Long boostValue) {
        if (null == this.fieldBoost) {
            this.fieldBoost = new HashMap<>();
        }
        this.fieldBoost.put(fieldName, boostValue);
    }

    private void addFacetKey(String facetName) {
        if (!facetKeys.contains(facetName)) {
            facetKeys.add(facetName);
        }
    }

    public List<String> getFacetKeys() {
        return facetKeys;
    }

    public void setFacetKeys(final List<String> facetKeys) {
        this.facetKeys = facetKeys;
    }

    public HashMap<String, String> getFacetsFromField() {
        return facetsFromField;
    }

    public void setFacetsFromField(final HashMap<String, String> facetsFromField) {
        this.facetsFromField = facetsFromField;
        facetsFromField.forEach((facetName, value) -> addFacetKey(facetName));
    }

    public void addFacetForField(final String facetName, final String fieldName) {
        if (null == facetsFromField) {
            facetsFromField = new HashMap<>();
        }

        facetsFromField.put(facetName, fieldName);
        addFacetKey(facetName);
    }

    public List<String> getStopWords() {
        return stopWords;
    }

    public void setStopWords(final List<String> stopWords) {
        this.stopWords = stopWords;
    }

    public void addStopWord(final String stopWords) {
        if (null == this.stopWords) {
            this.stopWords = new ArrayList<>();
        }

        this.stopWords.add(stopWords);
    }

    public HashMap<String, List<Object>> getPositiveBoost() {
        return positiveBoost;
    }

    public void setPositiveBoost(final HashMap<String, List<Object>> positiveBoost) {
        this.positiveBoost = positiveBoost;
    }

    public void addPositiveBoost(final String name, final Object value) {
        if (null == positiveBoost) {
            positiveBoost = new HashMap<>();
        }

        positiveBoost.computeIfAbsent(name, k -> new ArrayList<>());
        positiveBoost.get(name).add(value);
    }

    public HashMap<String, List<Object>> getNegativeBoost() {
        return negativeBoost;
    }

    public void setNegativeBoost(final HashMap<String, List<Object>> negativeBoost) {
        this.negativeBoost = negativeBoost;
    }

    public void addNegativeBoost(final String name, final Object value) {
        if (null == negativeBoost) {
            negativeBoost = new HashMap<>();
        }

        negativeBoost.computeIfAbsent(name, k -> new ArrayList<>());
        negativeBoost.get(name).add(value);
    }

    // BUILD FACETS WITH FILTERS!

    public HashMap<String, HashMap<String, AbstractMap.SimpleEntry<String, FilterOptions>>> getFacetsFromFilteredValues() {
        return facetsFromFilteredValues;
    }

    public void setFacetsFromFilteredValues(final HashMap<String, HashMap<String, AbstractMap.SimpleEntry<String, FilterOptions>>> facetsFromFilteredValues) {
        this.facetsFromFilteredValues = facetsFromFilteredValues;
    }

    public void addFacetsFromFilteredValue(final String facetName, final String fieldName, final String fieldLabel, final FilterOptions filterOptions) {
        if (!facetsFromFilteredValues.containsKey(facetName)) {
            facetsFromFilteredValues.put(facetName, new HashMap<>());
        }

        facetsFromFilteredValues.get(facetName).put(fieldName, new AbstractMap.SimpleEntry<>(fieldLabel, filterOptions));
        addFacetKey(facetName);
    }
    // END: BUILD FACETS WITH FILTERS.
}
