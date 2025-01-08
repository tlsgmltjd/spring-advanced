package hello.springadvanced.trace.templatecallback;

public interface TraceCallBack<T> {
    T call();
}
