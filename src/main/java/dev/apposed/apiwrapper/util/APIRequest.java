package dev.apposed.apiwrapper.util;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.HttpClients;

import java.util.HashMap;
import java.util.Map;

@Getter @Setter
public class APIRequest {

    private final HttpClient httpClient = HttpClients.createDefault();

    private final MojangConstants request;

    private String pathAddon = "", jsonPayload;
    private Map<String, String> headers, pathChange;

    public APIRequest(MojangConstants request){
        this.request = request;
        this.headers = new HashMap<>();
        this.pathChange = new HashMap<>();
    }

    public APIRequest(MojangConstants request, String jsonPayload){
        this.request = request;
        this.jsonPayload = jsonPayload;
        this.headers = new HashMap<>();
        this.pathChange = new HashMap<>();
    }

    public APIRequest(MojangConstants request, Map<String, String> headers){
        this.request = request;
        this.headers = headers;
    }

    public APIRequest(MojangConstants request, String jsonPayload, Map<String, String> headers){
        this.request = request;
        this.jsonPayload = jsonPayload;
        this.headers = headers;
        this.pathChange = new HashMap<>();
    }

    @SneakyThrows
    public HttpResponse build(){
        switch(request.getMethod()){
            case "GET":
                String[] url = {request.getPathUrl() + pathAddon};
                this.pathChange.forEach((key, value) -> {
                    url[0] = url[0].replace(key, value);
                });

                HttpGet getRequest = new HttpGet(url[0]);

                this.headers.forEach(getRequest::addHeader);
                getRequest.addHeader("Content-Type", "application/json");
                getRequest.addHeader("User-Agent", "Mozilla Firefox Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:53.0) Gecko/20100101 Firefox/53.0");


                return httpClient.execute(getRequest);
            case "POST":
                HttpPost postRequest = new HttpPost(request.getPathUrl() + pathAddon);

                this.headers.forEach(postRequest::addHeader);
                postRequest.addHeader("Content-Type", "application/json");
                postRequest.addHeader("User-Agent", "Mozilla Firefox Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:53.0) Gecko/20100101 Firefox/53.0");


                return httpClient.execute(postRequest);
            case "PUT":
                HttpPut putRequest = new HttpPut(request.getPathUrl() + pathAddon);

                this.headers.forEach(putRequest::addHeader);
                putRequest.addHeader("Content-Type", "application/json");
                putRequest.addHeader("User-Agent", "Mozilla Firefox Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:53.0) Gecko/20100101 Firefox/53.0");


                return httpClient.execute(putRequest);
            case "DELETE":
                HttpDelete deleteRequest = new HttpDelete(request.getPathUrl() + pathAddon);

                this.headers.forEach(deleteRequest::addHeader);
                deleteRequest.addHeader("Content-Type", "application/json");
                deleteRequest.addHeader("User-Agent", "Mozilla Firefox Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:53.0) Gecko/20100101 Firefox/53.0");


                return httpClient.execute(deleteRequest);
            default:
                return null;
        }
    }

    public APIRequest addToPath(String toAdd){
        this.pathAddon+="/" + toAdd;
        return this;
    }

    public APIRequest addPathChange(String key, String value){
        this.pathChange.put(key, value);
        return this;
    }

    public APIRequest removePathChange(String key){
        this.pathChange.remove(key);
        return this;
    }

    public APIRequest addHeader(String key, String value){
        this.headers.put(key, value);
        return this;
    }

    public APIRequest removeHeader(String key){
        this.headers.remove(key);
        return this;
    }
}
