package com.daveace.greenspaces.util;

public interface Regexp {

    String PASSWORD_REGEXP = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()\\-_=+[{]};:'\",/?]).{7,}$";
    String LETTER_REGEX = "^[\\p{L}]+$";
    String ALPHA_NUM_REGEX = "^[a-zA-Z0-9!@#%^&*()_-]{7,}$";
    String IMAGE_URL_REGEX = "(?:https?:\\/\\/(?:www\\.)?|file:\\/\\/|\\/|\\.\\/|\\.\\.\\/|~\\/)?(?:[a-zA-Z0-9_\\-]+\\/)*[a-zA-Z0-9_\\-]+\\.(?:jpg|jpeg|png|gif|bmp|svg|webp|tiff)\n";
    String POSTCODE_REGEX = "^A-Za-z[0-9][A-Za-z]{2}$";
}
