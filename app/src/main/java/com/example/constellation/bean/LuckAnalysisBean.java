package com.example.constellation.bean;

import java.util.List;

/**
 * @PackageName: com.example.constellation.bean
 * @ClassName: LuckAnalysisBean
 * @Author: winwa
 * @Date: 2023/1/29 18:30
 * @Description:
 **/
public class LuckAnalysisBean {

    /**
     * name : 双鱼座
     * year : 2023
     * date : 2023年
     * future :
     * career : ["事业上，双鱼座本年会有奋勇拼搏的精神，木星将强势进入双鱼座的事业宫，这也会让双鱼更好地实现心中的理想，即使在逆境中也能够轻松翻盘，建议双鱼要多吸取他人所长，这样才能够全面发展自己；学业上，双鱼座本年可能会出现计划跟不上变化的情况，所以建议双鱼座要保持平和的心态，不要太过计较分数，只有真正的汲取到课本上的知识，才能够得到思维的拓展。"]
     * love : ["恋爱中的双鱼座，本年会特别愿意跟伴侣分享自己的内心世界，渴望让对方深刻的感知到自己，沉浸在爱情世界里的双鱼座，也能够拥有十分幸福的体验，同时也会为伴侣准备很多浪漫的惊喜，去创造很多美好的回忆；单身的双鱼座，本年有望收获一段轰轰烈烈的爱情，但建议双鱼座不要太过恋爱脑，也要多多的为自己考虑，只有在感情中保持着理智的头脑，才能够成为最大的赢家。"]
     * health : ["双鱼座本年在健康方面要多留意一下睡眠的问题，双鱼座很可能会出现神经衰弱以及失眠多梦的情况，建议双鱼不要把一些琐事太放在心上，只有慢慢的敞开心扉去释放压力，才能够有更好的睡眠状态。"]
     * finance : ["双鱼座本年财富运势还是比较可观的，木星的顺行，能够让双鱼通过自己的实力和创造力获得一定的资源转化，并且好好把握住机会快速变现，但建议双鱼座在消费方面也要有所收敛，这样才能够有更加稳固的资产，生活也会变得更加光明璀璨。双鱼座今年可佩戴一条六方开财斧双鱼宝懿手绳来提升全年财富指数，此幸运手绳由双鱼座的守护神波塞冬Poseidon和双鱼座符号组成，使得双鱼们得到守护神的庇佑，增添理财智慧、巩固财源，银制开财斧寓意守护正财偏财，使得双鱼们在新的一年事业顺遂，六方来财。"]
     * mima : {"info":"计划跟不上变化","text":["由于天王星的逆行，可能会打乱双鱼座的节奏，所以双鱼座本年要懂得韬光养晦，要努力的去沉淀自己，不要总是抱着刻板印象去看待问题，只有发散思维，以灵活的头脑去思考，才能够彻底让生活充满希望，积极的去拥抱光明。建议双鱼座要保持着好学的态度，去学习更多优秀的楷模，这样就能够更加轻松自在的实现目标。双鱼座2023年可佩戴一件数字11海王星吉宏旋运轮项链作为全年的幸运饰物；项链外轮廓由一个呵护形状的图案组成，两边刻有双鱼座今年的幸运罗马数字11；项链内部有一个可转动的幸运轮，寓意时来运转、财气滚滚，幸运轮上刻有双鱼座符号和守护星海王星图案，象征着胜利的信心与勇气，为双鱼们全年运势带来双重守护，使得2023年里自信满满、勇往直前、积极进取。"]}
     * luckyStone : 黄水晶
     * resultcode : 200
     * error_code : 0
     */

    private String name;
    private int year;
    private String date;
    private String future;
    private MimaBean mima;
    private String luckyStone;
    private String resultcode;
    private int error_code;
    private List<String> career;
    private List<String> love;
    private List<String> health;
    private List<String> finance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFuture() {
        return future;
    }

    public void setFuture(String future) {
        this.future = future;
    }

    public MimaBean getMima() {
        return mima;
    }

    public void setMima(MimaBean mima) {
        this.mima = mima;
    }

    public String getLuckyStone() {
        return luckyStone;
    }

    public void setLuckyStone(String luckyStone) {
        this.luckyStone = luckyStone;
    }

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public List<String> getCareer() {
        return career;
    }

    public void setCareer(List<String> career) {
        this.career = career;
    }

    public List<String> getLove() {
        return love;
    }

    public void setLove(List<String> love) {
        this.love = love;
    }

    public List<String> getHealth() {
        return health;
    }

    public void setHealth(List<String> health) {
        this.health = health;
    }

    public List<String> getFinance() {
        return finance;
    }

    public void setFinance(List<String> finance) {
        this.finance = finance;
    }

    public static class MimaBean {
        /**
         * info : 计划跟不上变化
         * text : ["由于天王星的逆行，可能会打乱双鱼座的节奏，所以双鱼座本年要懂得韬光养晦，要努力的去沉淀自己，不要总是抱着刻板印象去看待问题，只有发散思维，以灵活的头脑去思考，才能够彻底让生活充满希望，积极的去拥抱光明。建议双鱼座要保持着好学的态度，去学习更多优秀的楷模，这样就能够更加轻松自在的实现目标。双鱼座2023年可佩戴一件数字11海王星吉宏旋运轮项链作为全年的幸运饰物；项链外轮廓由一个呵护形状的图案组成，两边刻有双鱼座今年的幸运罗马数字11；项链内部有一个可转动的幸运轮，寓意时来运转、财气滚滚，幸运轮上刻有双鱼座符号和守护星海王星图案，象征着胜利的信心与勇气，为双鱼们全年运势带来双重守护，使得2023年里自信满满、勇往直前、积极进取。"]
         */

        private String info;
        private List<String> text;

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public List<String> getText() {
            return text;
        }

        public void setText(List<String> text) {
            this.text = text;
        }
    }
}
