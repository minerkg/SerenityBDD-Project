package org.csiszer.steps.serenity;

import org.csiszer.pages.EvoMagHomePage;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class EndUserSteps {

    EvoMagHomePage evoMagHomePage;

    @Step
    public void enters(String keyword) {
        evoMagHomePage.enter_keywords(keyword);
    }

    @Step
    public void starts_search() {
        evoMagHomePage.lookup_terms();
    }

    @Step
    public void should_see_definition(String definition) {
        assertThat(evoMagHomePage.getDefinitions(), hasItem(containsString(definition)));
    }

    @Step
    public void is_the_home_page() {
        evoMagHomePage.open();
    }

    @Step
    public void looks_for(String term) {
        enters(term);
        starts_search();
    }
}