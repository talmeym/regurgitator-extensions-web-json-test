package com.emarte.regurgitator.test;

import com.emarte.regurgitator.core.RegurgitatorException;
import com.emarte.regurgitator.extensions.web.HttpCallJsonLoader;
import org.junit.Test;

import java.io.IOException;

import static com.emarte.regurgitator.core.ConfigurationFile.loadFile;

public class HttpCallJsonLoaderTest extends JsonLoaderTest {
	public HttpCallJsonLoaderTest() {
		super(new HttpCallJsonLoader());
	}

	@Test
	public void testThis() throws IOException, RegurgitatorException {
		assertExpectation("classpath:/HttpCall.json", "com.emarte.regurgitator.extensions.web.HttpCall:['http-call-1',com.emarte.regurgitator.extensions.web.HttpMessageProxy:['something.com',1234,null,null],[]]");
	}

	@Test
	public void testMax() throws IOException, RegurgitatorException {
		assertExpectation("classpath:/HttpCall_max.json", "com.emarte.regurgitator.extensions.web.HttpCall:['http-call-1',com.emarte.regurgitator.extensions.web.HttpMessageProxy:['something.com',1234,'username','password'],[com.emarte.regurgitator.test.stuff.TestStep:['test-step-1'], com.emarte.regurgitator.test.stuff.TestStep:['test-step-2']]]");
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
