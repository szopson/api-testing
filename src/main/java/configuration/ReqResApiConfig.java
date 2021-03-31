package configuration;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources("classpath:reqres-api.properties")
public interface ReqResApiConfig extends Config {


    @Key("url")
    String url();

    @Key("registerEndpoint")
    String postRegisterEndpoint();

    @Key("userEndpoint")
    String getUserEndpoint();

}
