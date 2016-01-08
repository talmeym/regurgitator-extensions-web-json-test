package com.emarte.regurgitator.test;

import com.emarte.regurgitator.core.*;
import com.emarte.regurgitator.extensions.web.HttpCallJsonLoader;
import org.junit.Test;

import java.io.IOException;
import java.util.HashSet;

import static com.emarte.regurgitator.core.ConfigurationFile.loadFile;
import static junit.framework.Assert.assertEquals;

public class HttpCallJsonLoaderTest extends JsonLoaderTest {
	public HttpCallJsonLoaderTest() {
		super(new HttpCallJsonLoader());
	}

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
		loadFromFile("classpath:/HttpCall_missingUsername.json");
	}

	@Test(expected = RegurgitatorException.class)
	public void testMissingPassword() throws IOException, RegurgitatorException {
		loadFromFile("classpath:/HttpCall_missingPassword.json");
	}

	@Test
	public void testFullLoad() throws IOException, RegurgitatorException {
		loadFile("classpath:/HttpCall_fullLoad.json");
	}
}
