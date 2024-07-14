package com.github.ih0rd;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class GraalvmPlaygroundApplication {

    public static void main(String[] args) {
        var runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        var runtimeInfo = getRuntimeInfo(runtimeMXBean);
        System.out.println(runtimeInfo);
    }

    private static String getRuntimeInfo(RuntimeMXBean runtimeMXBean) {
        String separator = "-".repeat(56);
        return """
                
                GraalVM Runtime Info:
                %s
                | %-15s | %-35s |
                | %-15s | %-35s |
                | %-15s | %-35s |
                | %-15s | %-35s |
                | %-15s | %-35s |
                | %-15s | %-35s |
                %s""".formatted(
                separator,
                "Spec name", runtimeMXBean.getSpecName(),
                "Spec version", runtimeMXBean.getSpecVersion(),
                "VM Name", runtimeMXBean.getVmName(),
                "VM Vendor", runtimeMXBean.getVmVendor(),
                "VM Version", runtimeMXBean.getVmVersion(),
                "Uptime", runtimeMXBean.getUptime(),
                separator
        );
    }


}
