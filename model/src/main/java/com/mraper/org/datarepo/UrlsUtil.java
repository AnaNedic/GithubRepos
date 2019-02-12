package com.mraper.org.datarepo;

/**
 * Class for all URLs we need to fetch data from.
 */
public class UrlsUtil {

    /**
     * Github api to fetch current repos about Kotlin.
     */
    public static final String KOTLIN_REPO
            = "https://api.github.com/search/repositories?q=kotlin&since=today/";

    /**
     * Github api base url.
     */
    public static final String BASE_URL
            = "https://api.github.com/";
}
