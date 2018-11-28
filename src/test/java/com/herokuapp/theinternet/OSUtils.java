package com.herokuapp.theinternet;

import java.io.IOException;
import java.util.Locale;

import static com.herokuapp.theinternet.OSUtils.OS.WINDOWS;

/**
 * This class is used to determine OS type and sets the appropriate System property in order to initialize the webdriver
 * for Chrome and Firefox
 */
public class OSUtils {

    public enum OS {
        WINDOWS, LINUX, MAC, OTHER
    }


    public static OS os;

    /**
     * This method sets system property to relevant path bases on OS type
     */
    public static  void setDriverResources() {
        switch (os) {
            case WINDOWS: {

                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                System.setProperty("webdriver.gecko.driver", "//src/main//resources//geckodriver.exe");
                break;
            }
            case LINUX:
                break;
            case MAC:
                System.setProperty("webdriver.chrome.driver", "/Users/krojiktheloved/IdeaProjects/easymode-borbus-tools/src/main/resources/chromedriver");
                System.setProperty("webdriver.gecko.driver", "/Users/krojiktheloved/IdeaProjects/easymode-borbus-tools/src/main/resources/geckodriver");
                break;
            case OTHER:
                System.out.println("Aborting testing . quiting...");
        }


    }

    static {
        try {
            String osName = System.getProperty("os.name");
            if (osName == null) {
                throw new IOException("os.name not found");
            }
            osName = osName.toLowerCase(Locale.ENGLISH);
            if (osName.contains("windows")) {
                os = WINDOWS;

            } else if (osName.startsWith("linux")) {
                os = OS.LINUX;
            } else if (osName.startsWith("mac")) {
                os = OS.MAC;
            } else {
                os = OS.OTHER;
            }
        } catch (Exception ex) {
            os = OS.OTHER;
        }
    }


}

