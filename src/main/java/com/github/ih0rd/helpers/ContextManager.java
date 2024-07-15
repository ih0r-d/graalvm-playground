package com.github.ih0rd.helpers;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.HostAccess;

import static com.github.ih0rd.utils.Constants.JAVA_LANG_ID;

/**
 * The {@code ContextManager} class provides a utility method to create a secured
 * GraalVM polyglot {@link Context} with specific configurations.
 * <p>
 * This class is designed to prevent instantiation and only offers a static method
 * to retrieve a configured {@link Context} instance.
 * </p>
 */
public class ContextManager {

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private ContextManager() {
    }

    /**
     * Creates and returns a secured GraalVM polyglot context for Java.
     * <p>
     * The context is configured with various security restrictions to enhance the safety
     * of executing untrusted code. The following restrictions are applied:
     * <ul>
     *   <li>Host access is disabled ({@code HostAccess.NONE}).</li>
     *   <li>File I/O operations are not allowed ({@code allowIO(false)}).</li>
     *   <li>Native access is not allowed ({@code allowNativeAccess(false)}).</li>
     *   <li>Creating new processes is not allowed ({@code allowCreateProcess(false)}).</li>
     *   <li>All access permissions are disabled ({@code allowAllAccess(false)}).</li>
     *   <li>Experimental options are enabled ({@code allowExperimentalOptions(true)}).</li>
     * </ul>
     *
     * @return a {@link Context} instance configured with the specified security restrictions.
     */
    public static Context getSecuredContext() {
        return Context.newBuilder(JAVA_LANG_ID)
                .allowHostAccess(HostAccess.NONE)
                .allowIO(false)
                .allowNativeAccess(false)
                .allowCreateProcess(false)
                .allowAllAccess(false)
                .allowExperimentalOptions(true)
                .option("engine.WarnInterpreterOnly","false")
                .build();
    }

}
