package com.example.coursemanagement.response;


import lombok.Data;

@Data
public class CommonReturnType {
    private String status;
    private Integer data;

    public static CommonReturnType create(Integer result){
        return CommonReturnType.create(result,"success");
    }

    public static CommonReturnType create(Integer result,String status){
        CommonReturnType commonReturnType=new CommonReturnType();
        commonReturnType.setData(result);
        commonReturnType.setStatus(status);
        return commonReturnType;
    }
}
