package com.uol.msse.entity;


public enum Language {
    USA("en_US"),
    UK("en_GB"),
    FR("fr_FR");

    private String locale;

    private Language(String locale) {
        this.locale = locale;
    }

    private String getLocale(){
        return locale;
    }

    public static String getLocale(Language language) {
        for(Language lang: Language.values()) {
            if(language.name().equals(lang.name())) {
                return language.getLocale();
            }
        }
        return null;
    }

}
