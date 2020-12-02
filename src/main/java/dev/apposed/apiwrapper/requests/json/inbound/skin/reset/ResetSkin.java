package dev.apposed.apiwrapper.requests.json.inbound.skin.reset;

import dev.apposed.apiwrapper.requests.json.inbound.account.data.Skin;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor @Getter
public class ResetSkin {

    private String id, name;
    private List<Skin> skins;
    private List<String> capes;

}