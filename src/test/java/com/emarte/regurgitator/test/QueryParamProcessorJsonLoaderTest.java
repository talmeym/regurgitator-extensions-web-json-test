package com.emarte.regurgitator.test;

import com.emarte.regurgitator.core.*;
import com.emarte.regurgitator.extensions.web.QueryParamProcessorJsonLoader;
import org.junit.Test;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.HashSet;

import static junit.framework.Assert.assertEquals;

public class QueryParamProcessorJsonLoaderTest extends JsonBaseTest {
	private final QueryParamProcessorJsonLoader toTest = new QueryParamProcessorJsonLoader();

	@Test
	public void testThis() throws Exception {
		assertExpectation("classpath:/QueryParamProcessor.json", "com.emarte.regurgitator.extensions.web.QueryParamProcessor:['value']");
	}

	@Test
	public void testFullLoad() throws Exception {
		ConfigurationFile.loadFile("classpath:/QueryParamProcessor_FullLoad.json");
	}

	private void assertExpectation(String filePath, String expected) throws RegurgitatorException, SAXException, IOException {
		assertEquals(expected, toTest.load(getJsonObject(filePath), new HashSet<Object>()).toString());
	}
}
