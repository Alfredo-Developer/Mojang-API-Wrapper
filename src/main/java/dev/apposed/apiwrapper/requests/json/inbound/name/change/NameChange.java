package dev.apposed.apiwrapper.requests.json.inbound.name.change;

import dev.apposed.apiwrapper.requests.json.inbound.account.data.Skin;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor @Getter
public class NameChange {

    private String id, name;
    private List<Skin> skins;
    private List<String> capes;

}
