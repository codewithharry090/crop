package com.test.crop.enums;

public enum TaxonomyClass {

    GENUS("Genus"),
    SPECIES("Species"),
    NONTAXONOMIC("Non-taxonomic"),
    FAMILY("Family");
    private String value;

    TaxonomyClass(String value) {
        this.value = value;
    }
}
