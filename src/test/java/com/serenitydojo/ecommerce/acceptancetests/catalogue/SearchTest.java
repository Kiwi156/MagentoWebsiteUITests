package com.serenitydojo.ecommerce.acceptancetests.catalogue;

import com.serenitydojo.ecommerce.actions.NavigationActions;
import com.serenitydojo.ecommerce.actions.SearchActions;
import com.serenitydojo.ecommerce.actions.SearchResultsPage;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.steps.UIInteractions;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class SearchTest extends UIInteractions {
    @Steps

    NavigationActions navigate;

    @Steps
    SearchActions search;

    SearchResultsPage searchResultsPage;

    @Test
    void shouldDisplayTheSearchResults(){
        navigate.openTheApplication();

        search.forProduct("Hero Hoodie");

        String resultTitle = searchResultsPage.getSearchResultsTitle();

        Assertions.assertThat(resultTitle).isEqualTo("Search results for: 'Hero Hoodie'");
    }
}

