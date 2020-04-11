package util;


public class LogUtil {
    public static void log(String message) {

        StackTraceElement stack[] = Thread.currentThread().getStackTrace();
        StackTraceElement callTrace = stack[2];
        System.out.println(String.format("%d %s@%d <%s>:[%s] %s",System.currentTimeMillis(), callTrace.getFileName(), callTrace.getLineNumber(), callTrace.getClassName(), callTrace.getMethodName(), message));

    }
}
