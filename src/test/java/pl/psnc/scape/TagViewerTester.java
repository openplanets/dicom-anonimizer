package pl.psnc.scape;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pl.psnc.scape.dicom.anonymization.config.Configuration;
import pl.psnc.scape.dicom.file.TagViewer;


public class TagViewerTester {
    private static String configFilePath = "src/test/resources/config.properties";
    private static String filePath = "src/test/resources/sample.dcm";
    
	@Test
	public void getTagTest() {
    	Configuration conf = new Configuration();
        if(conf.configFileExist(configFilePath)){
	        conf.load(configFilePath);
	        String tagValue = TagViewer.getTag(filePath, conf.getConfigurationElement("PatientsName(0010,0010)").getDicomTag());
	        assertEquals("VOLUMEMERGE", tagValue.trim());
        
		}
	    else {
	        System.out.println("No config file: " + configFilePath);
			System.out.println();
	    }
	}
}