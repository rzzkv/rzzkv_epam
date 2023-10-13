package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:src/test/resources/properties/config.properties"
})
public interface Configuration extends Config {

    @Key("environment")
    String environment();
    @Key("${environment}.browser")
    String browser();
    @Key("${environment}.cloud_url")
    String cloudUrl();
    @Key("${environment}.email_url")
    String emailUrl();

}
