package org.example.model;

public class Currency{

    private Integer id;
    private String code;
    private String name;
    private String sign;

    public Currency(){
    }
    public Currency(Integer id,String code,String name,String sign){
        this.id =  id;
        this.code = code;
        this.name = name;
        this.sign = sign;
    }

    public Integer getId(){
        return this.id;
    }
    public void setId(Integer id){
        this.id = id;
    }

    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getSign(){
        return this.sign;
    }
    public void setSign(String sign){
        this.sign = sign;
    }




}
