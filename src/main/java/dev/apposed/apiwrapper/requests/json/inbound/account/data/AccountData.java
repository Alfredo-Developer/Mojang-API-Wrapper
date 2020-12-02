package dev.apposed.apiwrapper.requests.json.inbound.account.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor @Getter
public class AccountData {

    private String id, name;
    private List<Skin> skins;
    private List<String> capes;

}
