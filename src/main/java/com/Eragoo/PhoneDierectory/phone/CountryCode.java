package com.Eragoo.PhoneDierectory.phone;

import lombok.Getter;

@Getter
public enum CountryCode {
    UA(380),
    US(1);

    CountryCode(int code) {
        this.code = code;
    }

    int code;
}
