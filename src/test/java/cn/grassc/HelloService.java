package cn.grassc;

public class HelloService implements Hello {
    private String msg;

    public HelloService(String msg) {
        this.msg = msg;
    }

    public void doHello() {
        System.out.println(this.msg);
    }
}
