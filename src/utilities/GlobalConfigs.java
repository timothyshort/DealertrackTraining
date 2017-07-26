package utilities;


import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Element;
import org.xml.sax.InputSource;

public class GlobalConfigs {
	
	public static String testDataFolder;
	public static String browserType;
	public static String testURL;
	public static String mainURL;
	
	// Dependencies: javax.xml.xpath | org.w3c | org.xml
	// This function reads an XML file to set Global Configurations
	public static void setFramework(String file) {
	    // 1. Prepare Xpath
	    XPathFactory xpf = XPathFactory.newInstance();
	    XPath xPath = xpf.newXPath();

	    try {
	        // 2. Create XML File
	        InputSource inputSource = new InputSource(file);

	        // 3. Use XPath location to find values
	        // System.out.println(xPath.evaluate("/TestFramework/Location/MainURL", inputSource, XPathConstants.STRING));
	        
	        // 4. Assigning values from XML document to public static variables (global variables)
	        mainURL = xPath.evaluate("/TestFramework/Location/MainURL", inputSource, XPathConstants.STRING).toString();
	        testURL = xPath.evaluate("/TestFramework/Location/AMS_URL", inputSource, XPathConstants.STRING).toString();
	        browserType = (((Element) (xPath.evaluate("/TestFramework/Browser", inputSource, XPathConstants.NODE))).getAttribute("Type"));
	        testDataFolder = ((Element) xPath.evaluate("/TestFramework/TestData", inputSource, XPathConstants.NODE)).getAttribute("loc");
	        
	  } catch (XPathExpressionException e) {
	        System.out.println("ERROR: Could not read XPath Expression");
	        System.out.println(e.toString());
	    }
	}

}
