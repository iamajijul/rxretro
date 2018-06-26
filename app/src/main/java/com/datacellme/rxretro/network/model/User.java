package com.datacellme.rxretro.network.model;

import com.google.gson.annotations.SerializedName;

public class User extends BaseResonse {
    @SerializedName("api_key")
    String apiKey;

    public String getApiKey() {
        return apiKey;
    }
}
