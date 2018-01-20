package com.nilportugues.shared.domain;

import java.util.HashMap;
import java.util.List;

public class Faceted<T> extends Paginated<T> {
    private SortOptions sortOptions;
    private FilterOptions filterOptions;
    private FacetOptions facetOptions;
    private HashMap<String, HashMap<String, Object>> facets = new HashMap<>();

    public Faceted(List<T> content,
        int totalPages,
        long totalElements,
        int number,
        int size,
        HashMap<String, HashMap<String, Object>> facets,
        SortOptions sortOptions,
        FilterOptions filterOptions,
        FacetOptions facetOptions) {

        super(content, totalPages, totalElements, number, size);
        this.facets = facets;
        this.sortOptions = sortOptions;
        this.filterOptions = filterOptions;
        this.facetOptions = facetOptions;
    }

    public HashMap<String, HashMap<String, Object>> getFacets() {
        return facets;
    }

    public SortOptions getSortOptions() {
        return sortOptions;
    }

    public FilterOptions getFilterOptions() {
        return filterOptions;
    }

    public FacetOptions getFacetOptions() {
        return facetOptions;
    }
}
