package com.example.constellation.bean;

/**
 * @PackageName: com.example.constellation.bean
 * @ClassName: LuckAnalysisItemBean
 * @Author: winwa
 * @Date: 2023/1/29 18:33
 * @Description:
 **/
public class LuckAnalysisItemBean {
    private String title;
    private String content;
    private int colorId;

    public LuckAnalysisItemBean(String title, String content, int colorId) {
        this.title = title;
        this.content = content;
        this.colorId = colorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }
}
