package dev.apposed.apiwrapper.requests.minecraftservices;

import com.google.gson.Gson;
import dev.apposed.apiwrapper.requests.json.inbound.skin.reset.ResetSkin;
import dev.apposed.apiwrapper.util.APIRequest;
import dev.apposed.apiwrapper.util.MojangConstants;
import lombok.SneakyThrows;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

public class ResetSkinRequest {

    private HttpResponse response;
    private String jsonResponse;

    @SneakyThrows
    /**
     * @param - Name of the account to request the status of
     * @param - Bearer token of the account trying to receive the information
     */
    public ResetSkinRequest(String bearerToken){
        this.response = new APIRequest(MojangConstants.ACCOUNT_DATA).addHeader("Authorization", bearerToken).build();

        this.jsonResponse = EntityUtils.toString(response.getEntity(), "UTF-8");
    }

    /**
     * @return - The response as an object in which contains the status
     */
    public ResetSkin getAsObject(){
        return new Gson().fromJson(this.jsonResponse, ResetSkin.class);
    }

    /**
     * @return - The response from the status as a string. Useful for debugging
     */
    public String getAsString(){
        return jsonResponse;
    }
    
}
