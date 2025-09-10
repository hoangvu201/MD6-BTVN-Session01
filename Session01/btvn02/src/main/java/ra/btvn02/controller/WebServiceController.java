package ra.btvn02.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ra.btvn02.entity.WebService;

import java.util.Arrays;
import java.util.List;

@RestController
public class WebServiceController {

    @GetMapping("/web-services")
    public List<WebService> getWebServices() {
        return Arrays.asList(
                new WebService("SOAP", "SOAP Web Service"),
                new WebService("REST", "RESTful Web Service"),
                new WebService("XML-RPC", "XML Remote Procedure Call"),
                new WebService("JSON-RPC", "JSON Remote Procedure Call"),
                new WebService("GraphQL", "Query Language for APIs"),
                new WebService("gRPC", "Google Remote Procedure Call")
        );
    }
}
