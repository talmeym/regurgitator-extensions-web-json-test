package com.emarte.regurgitator.test;

import com.emarte.regurgitator.core.*;
import com.emarte.regurgitator.extensions.web.HttpCallThroughJsonLoader;
import org.junit.Test;

import java.io.IOException;
import java.util.HashSet;

import static junit.framework.Assert.assertEquals;

public class HttpCallThroughJsonLoaderTest extends JsonBaseTest {
	private HttpCallThroughJsonLoader toTest = new HttpCallThroughJsonLoader();

	@Test
	public void testThis() throws IOException, RegurgitatorException {
		assertExpectation("classpath:/HttpCallThrough.json", "com.emarte.regurgitator.extensions.web.HttpCallThrough:['http-call-through-1',com.emarte.regurgitator.extensions.web.HttpMessageProxy:['something.com',1234],null]");
	}

	@Test
	public void testFullLoad() throws IOException, RegurgitatorException {
		ConfigurationFile.loadFile("classpath:/HttpCallThrough_fullLoad.json");
	}

	private void assertExpectation(String filePath, String expected) throws RegurgitatorException, IOException {
		assertEquals(expected, toTest.load(getJsonObject(filePath), new HashSet<Object>()).toString());
	}
}
