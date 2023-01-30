package com.example.constellation.bean;

/**
 * @PackageName: com.example.constellation.bean
 * @ClassName: PartnerAnalysisBean
 * @Author: winwa
 * @Date: 2023/1/29 8:50
 * @Description:
 **/
public class PartnerAnalysisBean {

    /**
     * reason : success
     * result : {"men":"金牛","women":"金牛","zhishu":"80","bizhong":"50:50","xiangyue":"80","tcdj":"80","jieguo":"相处和谐的一对","lianai":"金牛座男生和金牛座女生相配度相当高，俩人性格相似，有着相同的价值观、世界观，有共同话题。你们感情发展并非一见钟情，而是如同炭火般，越烧越旺。随着时间推移，你们会越发了解对方。你们的感情酝酿过程相比其他星座组合而言要来的久，但却是最温馨的一对。在这么多星座里，没有其他星座比金牛座男生更吸引金牛女的目光，因为你俩有太多相同点，性格也相似，实际、忠实有耐心，对未来憧憬同是行动比动作慢；缺乏积极性，但骨子里却是固执又倔强。你们很少发生矛盾，即使有少许的矛盾也是思维摩擦的火花。","zhuyi":"两只牛儿在一起，就像照镜子一样，看的都是自己，在个性和行为模式上都太像。都久缺开拓冒险精神，所以两个在一起经常会在有效时间内，做不出决定性的事。在语言上，你们欠缺表达能力，你们的语言仿佛只有你们自己才懂；你们过于谨慎，不易表达情感，这样就很容易发生与爱失之交臂、爱恨离别的惨剧。你们性格固执且一条筋，很多事容易各执已见，不懂得退一步为对方着想。在这方面，你们要懂得用你们独特的沟通方式去化险为夷。"}
     * error_code : 0
     */

    private String reason;
    private ResultBean result;
    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean {
        /**
         * men : 金牛
         * women : 金牛
         * zhishu : 80
         * bizhong : 50:50
         * xiangyue : 80
         * tcdj : 80
         * jieguo : 相处和谐的一对
         * lianai : 金牛座男生和金牛座女生相配度相当高，俩人性格相似，有着相同的价值观、世界观，有共同话题。你们感情发展并非一见钟情，而是如同炭火般，越烧越旺。随着时间推移，你们会越发了解对方。你们的感情酝酿过程相比其他星座组合而言要来的久，但却是最温馨的一对。在这么多星座里，没有其他星座比金牛座男生更吸引金牛女的目光，因为你俩有太多相同点，性格也相似，实际、忠实有耐心，对未来憧憬同是行动比动作慢；缺乏积极性，但骨子里却是固执又倔强。你们很少发生矛盾，即使有少许的矛盾也是思维摩擦的火花。
         * zhuyi : 两只牛儿在一起，就像照镜子一样，看的都是自己，在个性和行为模式上都太像。都久缺开拓冒险精神，所以两个在一起经常会在有效时间内，做不出决定性的事。在语言上，你们欠缺表达能力，你们的语言仿佛只有你们自己才懂；你们过于谨慎，不易表达情感，这样就很容易发生与爱失之交臂、爱恨离别的惨剧。你们性格固执且一条筋，很多事容易各执已见，不懂得退一步为对方着想。在这方面，你们要懂得用你们独特的沟通方式去化险为夷。
         */

        private String men;
        private String women;
        private String zhishu;
        private String bizhong;
        private String xiangyue;
        private String tcdj;
        private String jieguo;
        private String lianai;
        private String zhuyi;

        public String getMen() {
            return men;
        }

        public void setMen(String men) {
            this.men = men;
        }

        public String getWomen() {
            return women;
        }

        public void setWomen(String women) {
            this.women = women;
        }

        public String getZhishu() {
            return zhishu;
        }

        public void setZhishu(String zhishu) {
            this.zhishu = zhishu;
        }

        public String getBizhong() {
            return bizhong;
        }

        public void setBizhong(String bizhong) {
            this.bizhong = bizhong;
        }

        public String getXiangyue() {
            return xiangyue;
        }

        public void setXiangyue(String xiangyue) {
            this.xiangyue = xiangyue;
        }

        public String getTcdj() {
            return tcdj;
        }

        public void setTcdj(String tcdj) {
            this.tcdj = tcdj;
        }

        public String getJieguo() {
            return jieguo;
        }

        public void setJieguo(String jieguo) {
            this.jieguo = jieguo;
        }

        public String getLianai() {
            return lianai;
        }

        public void setLianai(String lianai) {
            this.lianai = lianai;
        }

        public String getZhuyi() {
            return zhuyi;
        }

        public void setZhuyi(String zhuyi) {
            this.zhuyi = zhuyi;
        }
    }
}
