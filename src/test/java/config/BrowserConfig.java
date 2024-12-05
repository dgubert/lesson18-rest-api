package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "file:/tmp/secret.properties",
        "classpath:${env}.properties",
        "classpath:local.properties"
})
public interface BrowserConfig extends Config {

    @Key("browser.baseUrl")
    String baseUrl();

    @Key("browser.version")
    String browserVersion();

    @Key("browser.name")
    String browserName();

    @Key("browser.size")
    String browserSize();

    @Key("remoteUrl")
    String remoteUrl();
}