package me.debugjoker.dto;

//封装json结果
public class ChooseResult<T> {

    private boolean success;

    private T data;

    private String error;

    //正确返回数据
    public ChooseResult(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    //错误返回错误信息
    public ChooseResult(boolean success, String error) {
        this.success = success;
        this.error = error;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
