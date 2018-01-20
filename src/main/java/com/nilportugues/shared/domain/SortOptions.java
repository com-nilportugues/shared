package com.nilportugues.shared.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SortOptions {

    public static final String ASC = "ASC";
    public static final String DESC = "DESC";

    private List<String> ascending = new ArrayList<>();
    private List<String> descending = new ArrayList<>();
    private HashMap<String, String> sortOrder = new HashMap<>();

    public void addAscending(String field) {
        ascending.add(field);
        sortOrder.put(field, ASC);
    }

    public void addDescending(String field) {
        descending.add(field);
        sortOrder.put(field, DESC);
    }

    public List<String> getAscending() {
        return ascending;
    }

    public List<String> getDescending() {
        return descending;
    }

    public HashMap<String, String> getSortOrder() {
        return sortOrder;
    }

    public boolean isEmpty() {
        return 0 == descending.size() && 0 == ascending.size();
    }
}
