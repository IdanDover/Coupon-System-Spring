package com.jb.CouponSystemSpring.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrMsg {
    NO_ID_FOUND("LOL😹 no ID found"),
    ID_ALREADY_EXISTS("LOL😹 the id is already inside the DB"),
    NAME_ALREADY_EXISTS("LOL😹 the name already exists in the DB"),
    EMAIL_ALREADY_EXISTS("LOL😹 the email already exists in the DB"),
    CANT_UPDATE_EMAIL("LOL😹 you can't update the email"), NO_CLIENT_SUPPORTED("LOL😹 no such client type"),
    CANT_CREATE_ADMIN("LOL😹 you can't register as admin"),
    EMAIL_OR_PASSWORD_INCORRECT("LOL😹 email or password are incorrect"),
    INCORRECT_EMAIL("LOL😹 email is incorrect"),
    INCORRECT_PASSWORD("LOL😹 password is incorrect"),
    INCORRECT_TOKEN("LOL😹 token is incorrect"),
    DUPLICATE_TITLE("LOL😹 you can't add a coupon with the same title"),
    ID_MISMATCH("LOL😹 the coupon you want to update does not match to the one inside the DB");

    private final String message;
}
