package dev.apposed.apiwrapper.util;

import lombok.Getter;

@Getter
public enum MojangConstants {

    NAME_STATUS("GET", "https://api.minecraftservices.com/minecraft/profile/name/<nameToCheck>/available"),
    NAME_CHANGE_ELIGIBILITY("GET", "https://api.minecraftservices.com/minecraft/profile/namechange"),
    ACCOUNT_DATA("GET", "https://api.minecraftservices.com/minecraft/profile"),
    CHANGE_NAME("PUT", "https://api.minecraftservices.com/minecraft/profile/name"),
    CHANGE_SKIN("POST", "(DISABLED)"),
    RESET_SKIN("DELETE", "https://api.minecraftservices.com/minecraft/profile/skins/active");

    private String method, pathUrl;

    MojangConstants(String method, String pathUrl){
        this.method = method;
        this.pathUrl = pathUrl;
    }
}
