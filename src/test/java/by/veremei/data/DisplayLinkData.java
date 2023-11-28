package by.veremei.data;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DisplayLinkData {
    private final Faker euFaker = new Faker(new Locale("en"));
    public final String repoName = euFaker.lorem().word();
}
