package com.example.constellation.bean;

/**
 * @PackageName: com.example.constellation.bean
 * @ClassName: StarAnalysisBean
 * @Author: winwa
 * @Date: 2023/1/27 10:53
 * @Description:
 **/
public class StarAnalysisItemBean {
    private String propertyName;
    private String propertyContent;
    private int propertyColor;

    public StarAnalysisItemBean(String propertyName, String propertyContent, int propertyColor) {
        this.propertyName = propertyName;
        this.propertyContent = propertyContent;
        this.propertyColor = propertyColor;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyContent() {
        return propertyContent;
    }

    public void setPropertyContent(String propertyContent) {
        this.propertyContent = propertyContent;
    }

    public int getPropertyColor() {
        return propertyColor;
    }

    public void setPropertyColor(int propertyColor) {
        this.propertyColor = propertyColor;
    }
}
