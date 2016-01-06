package com.emarte.regurgitator.test;

import com.emarte.regurgitator.core.*;
import com.emarte.regurgitator.extensions.web.HttpCallJsonLoader;
import org.junit.Test;

import java.io.IOException;
import java.util.HashSet;

import static junit.framework.Assert.assertEquals;

public class HttpCallJsonLoaderTest extends JsonBaseTest {
	private HttpCallJsonLoader toTest = new HttpCallJsonLoader();

	@Test
	public void testThis() throws IOException, RegurgitatorException {
		assertExpectation("classpath:/HttpCall.json", "com.emarte.regurgitator.extensions.web.HttpCall:['http-call-1',com.emarte.regurgitator.extensions.web.HttpMessageProxy:['something.com',1234,null,null],null]");
	}

	@Test
	public void testMax() throws IOException, RegurgitatorException {
		assertExpectation("classpath:/HttpCall_max.json", "com.emarte.regurgitator.extensions.web.HttpCall:['http-call-1',com.emarte.regurgitator.extensions.web.HttpMessageProxy:['something.com',1234,'username','password'],null]");
	}

	@Test(expected = RegurgitatorException.class)
	public void testMissingUsername() throws IOException, RegurgitatorException {
		toTest.load(getJsonObject("classpath:/HttpCall_missingUsername.json"), new HashSet<Object>());
	}

	@Test(expected = RegurgitatorException.class)
	public void testMissingPassword() throws IOException, RegurgitatorException {
		toTest.load(getJsonObject("classpath:/HttpCall_missingPassword.json"), new HashSet<Object>());
	}

	@Test
	public void testFullLoad() throws IOException, RegurgitatorException {
		ConfigurationFile.loadFile("classpath:/HttpCall_fullLoad.json");
	}

	private void assertExpectation(String filePath, String expected) throws RegurgitatorException, IOException {
		assertEquals(expected, toTest.load(getJsonObject(filePath), new HashSet<Object>()).toString());
	}
}
