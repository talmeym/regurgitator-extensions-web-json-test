/*
 * Copyright (C) 2017 Miles Talmey.
 * Distributed under the MIT License (license terms are at http://opensource.org/licenses/MIT).
 */
package uk.emarte.regurgitator.test;

import org.junit.Test;
import uk.emarte.regurgitator.core.RegurgitatorException;
import uk.emarte.regurgitator.extensions.web.HttpCallJsonLoader;

import static uk.emarte.regurgitator.core.ConfigurationFile.loadFile;
import static uk.emarte.regurgitator.test.WebExtensionsLoaderTestExpectations.HttpCall;
import static uk.emarte.regurgitator.test.WebExtensionsLoaderTestExpectations.HttpCall_max;

public class HttpCallJsonLoaderTest extends JsonLoaderTest {
    public HttpCallJsonLoaderTest() {
        super(new HttpCallJsonLoader());
    }

    @Test
    public void testLoader() throws Exception {
        assertExpectation("classpath:/HttpCall.json", HttpCall);
    }

    @Test
    public void testMaximum() throws Exception {
        assertExpectation("classpath:/HttpCall_max.json", HttpCall_max);
    }

    @Test(expected = RegurgitatorException.class)
    public void testMissingUsername() throws Exception {
        loadFromFile("classpath:/HttpCall_missingUsername.json");
    }

    @Test(expected = RegurgitatorException.class)
    public void testMissingPassword() throws Exception {
        loadFromFile("classpath:/HttpCall_missingPassword.json");
    }

    @Test
    public void testFullLoad() throws Exception {
        loadFile("classpath:/HttpCall_fullLoad.json");
    }
}
