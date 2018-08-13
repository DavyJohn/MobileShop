package com.huatec.edu.mobileshop.entity;

import java.util.List;

/**
 * Created by NTVU on 2018/8/7.
 */

public class TQData {

    /**
     * shidu : 94%
     * pm25 : 43.0
     * pm10 : 25.0
     * quality : 良
     * wendu : 23
     * ganmao : 极少数敏感人群应减少户外活动
     * yesterday : {"date":"12日星期日","sunrise":"05:21","high":"高温 30.0℃","low":"低温 24.0℃","sunset":"19:16","aqi":75,"fx":"南风","fl":"<3级","type":"雷阵雨","notice":"带好雨具，别在树下躲雨"}
     * forecast : [{"date":"13日星期一","sunrise":"05:22","high":"高温 31.0℃","low":"低温 24.0℃","sunset":"19:15","aqi":61,"fx":"东北风","fl":"<3级","type":"雷阵雨","notice":"带好雨具，别在树下躲雨"},{"date":"14日星期二","sunrise":"05:23","high":"高温 30.0℃","low":"低温 24.0℃","sunset":"19:14","aqi":58,"fx":"东北风","fl":"<3级","type":"雷阵雨","notice":"带好雨具，别在树下躲雨"},{"date":"15日星期三","sunrise":"05:24","high":"高温 31.0℃","low":"低温 23.0℃","sunset":"19:12","aqi":50,"fx":"东风","fl":"<3级","type":"雷阵雨","notice":"带好雨具，别在树下躲雨"},{"date":"16日星期四","sunrise":"05:25","high":"高温 30.0℃","low":"低温 23.0℃","sunset":"19:11","aqi":66,"fx":"北风","fl":"<3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"17日星期五","sunrise":"05:26","high":"高温 29.0℃","low":"低温 22.0℃","sunset":"19:10","aqi":63,"fx":"东南风","fl":"<3级","type":"雷阵雨","notice":"带好雨具，别在树下躲雨"}]
     */

    private String shidu;
    private double pm25;
    private double pm10;
    private String quality;
    private String wendu;
    private String ganmao;
    private YesterdayBean yesterday;
    private List<ForecastBean> forecast;

    public String getShidu() {
        return shidu;
    }

    public void setShidu(String shidu) {
        this.shidu = shidu;
    }

    public double getPm25() {
        return pm25;
    }

    public void setPm25(double pm25) {
        this.pm25 = pm25;
    }

    public double getPm10() {
        return pm10;
    }

    public void setPm10(double pm10) {
        this.pm10 = pm10;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getWendu() {
        return wendu;
    }

    public void setWendu(String wendu) {
        this.wendu = wendu;
    }

    public String getGanmao() {
        return ganmao;
    }

    public void setGanmao(String ganmao) {
        this.ganmao = ganmao;
    }

    public YesterdayBean getYesterday() {
        return yesterday;
    }

    public void setYesterday(YesterdayBean yesterday) {
        this.yesterday = yesterday;
    }

    public List<ForecastBean> getForecast() {
        return forecast;
    }

    public void setForecast(List<ForecastBean> forecast) {
        this.forecast = forecast;
    }

    public static class YesterdayBean {
        /**
         * date : 12日星期日
         * sunrise : 05:21
         * high : 高温 30.0℃
         * low : 低温 24.0℃
         * sunset : 19:16
         * aqi : 75.0
         * fx : 南风
         * fl : <3级
         * type : 雷阵雨
         * notice : 带好雨具，别在树下躲雨
         */

        private String date;
        private String sunrise;
        private String high;
        private String low;
        private String sunset;
        private double aqi;
        private String fx;
        private String fl;
        private String type;
        private String notice;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getSunrise() {
            return sunrise;
        }

        public void setSunrise(String sunrise) {
            this.sunrise = sunrise;
        }

        public String getHigh() {
            return high;
        }

        public void setHigh(String high) {
            this.high = high;
        }

        public String getLow() {
            return low;
        }

        public void setLow(String low) {
            this.low = low;
        }

        public String getSunset() {
            return sunset;
        }

        public void setSunset(String sunset) {
            this.sunset = sunset;
        }

        public double getAqi() {
            return aqi;
        }

        public void setAqi(double aqi) {
            this.aqi = aqi;
        }

        public String getFx() {
            return fx;
        }

        public void setFx(String fx) {
            this.fx = fx;
        }

        public String getFl() {
            return fl;
        }

        public void setFl(String fl) {
            this.fl = fl;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getNotice() {
            return notice;
        }

        public void setNotice(String notice) {
            this.notice = notice;
        }
    }

    public static class ForecastBean {
        /**
         * date : 13日星期一
         * sunrise : 05:22
         * high : 高温 31.0℃
         * low : 低温 24.0℃
         * sunset : 19:15
         * aqi : 61.0
         * fx : 东北风
         * fl : <3级
         * type : 雷阵雨
         * notice : 带好雨具，别在树下躲雨
         */

        private String date;
        private String sunrise;
        private String high;
        private String low;
        private String sunset;
        private double aqi;
        private String fx;
        private String fl;
        private String type;
        private String notice;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getSunrise() {
            return sunrise;
        }

        public void setSunrise(String sunrise) {
            this.sunrise = sunrise;
        }

        public String getHigh() {
            return high;
        }

        public void setHigh(String high) {
            this.high = high;
        }

        public String getLow() {
            return low;
        }

        public void setLow(String low) {
            this.low = low;
        }

        public String getSunset() {
            return sunset;
        }

        public void setSunset(String sunset) {
            this.sunset = sunset;
        }

        public double getAqi() {
            return aqi;
        }

        public void setAqi(double aqi) {
            this.aqi = aqi;
        }

        public String getFx() {
            return fx;
        }

        public void setFx(String fx) {
            this.fx = fx;
        }

        public String getFl() {
            return fl;
        }

        public void setFl(String fl) {
            this.fl = fl;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getNotice() {
            return notice;
        }

        public void setNotice(String notice) {
            this.notice = notice;
        }
    }

}
