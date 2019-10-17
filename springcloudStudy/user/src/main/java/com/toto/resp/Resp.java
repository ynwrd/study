package com.toto.resp;

public class Resp<T> {
    private Integer code;
    private String msg;
    private T result;

    public static Resp OK(){
        Resp resp = new Resp();
        resp.setCode(200);
        resp.setMsg("操作成功");
        return resp;
    }
    public static Resp OK(Object object){
        Resp resp = new Resp();
        resp.setCode(200);
        resp.setMsg("操作成功");
        resp.setResult(object);
        return resp;
    }
    public static Resp error(){
        Resp resp = new Resp();
        resp.setCode(500);
        resp.setMsg("操作失败");
        return resp;
    }
    public static Resp error(String msg){
        Resp resp = new Resp();
        resp.setCode(500);
        resp.setMsg(msg);
        return resp;
    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
