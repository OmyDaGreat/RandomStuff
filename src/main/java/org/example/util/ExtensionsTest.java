package org.example.util;

import lombok.experimental.ExtensionMethod;
import lombok.extern.log4j.Log4j2;

@Log4j2
@ExtensionMethod({Extensions.class})
public class ExtensionsTest {
    public static void main(String[] args) {
        log.info("help".reverse());
        log.info("i am a person not in pain".toTitleCase());
    }
}
