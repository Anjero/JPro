package net.anjero.plugins.json;
/* *
 * 
 * @Title :Result.java
 * @Description:
 * @Datetime : 2014-4-10 下午3:54
 * @Copyright :Copyright (c) 2012
 * @Company :Cheshell
 * @author :anjero   
 * @version :1.0
 **/

public class Result {
    private Integer code;
    private String description;
    private Object result;

    public Result() {
        super();
    }

    public Result(Integer code, String description, Object result) {
        this.code = code;
        this.description = description;
        this.result = result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
