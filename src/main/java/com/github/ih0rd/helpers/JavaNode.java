package com.github.ih0rd.helpers;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.RootNode;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

/**
 * JavaNode class is a Truffle RootNode implementation designed to execute a specified method
 * of a given class with provided arguments in a secure sandbox environment.
 */
public class JavaNode extends RootNode {
    private final Class<?> clazz;
    private final String methodName;
    private final Object[] args;

    /**
     * Constructs a new JavaNode instance.
     *
     * @param clazz      The class containing the method to be executed.
     * @param methodName The name of the method to be executed.
     * @param args       The arguments to be passed to the method during execution.
     */
    public JavaNode(Class<?> clazz, String methodName, Object[] args) {
        super(null);
        this.clazz = clazz;
        this.methodName = methodName;
        this.args = args;
    }

    /**
     * Executes the specified method with the provided arguments.
     *
     * @param frame The current execution frame.
     * @return A map containing the return type and result of the method execution, or an empty Optional if no result.
     */
    @Override
    public Object execute(VirtualFrame frame) {
        try {
            var instance = clazz.getDeclaredConstructor().newInstance();
            var optionalMethod = getMethodFromClass(clazz, methodName);
            if (optionalMethod.isPresent()) {
                var invoke = optionalMethod.get().invoke(instance, args);
                return Map.of("returnType", optionalMethod.get().getReturnType().getCanonicalName(),
                        "result", invoke != null ? invoke : Optional.empty());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    /**
     * Retrieves a method from the specified class by its name.
     *
     * @param clazz      The class containing the method.
     * @param methodName The name of the method to be retrieved.
     * @return An Optional containing the method if found, or an empty Optional otherwise.
     */
    private Optional<Method> getMethodFromClass(Class<?> clazz, String methodName) {
        return Arrays.stream(clazz.getMethods()).filter(method -> method.getName().equals(methodName)).findFirst();
    }
}
