package cn.grassc;

public class HelloService {
    private String msg;

    public HelloService(String msg) {
        this.msg = msg;
    }

    void doHello() {
        System.out.println(this.msg);
    }
}
