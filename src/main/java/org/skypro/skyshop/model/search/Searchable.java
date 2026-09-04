package org.skypro.skyshop.model.search;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

public interface Searchable {

    @JsonIgnore
    String getSearchTerm();
    String getType();
    String getName();
    UUID getId();

    default String getStringRepresentation() {
        return getName() + " — " + getType();
    }
}