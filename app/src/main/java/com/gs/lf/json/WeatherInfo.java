package com.gs.lf.json;

import java.util.List;

/**
 * Created by luofan18 on 2016/8/9.
 */
public class WeatherInfo {

    /**
     * aqi : {"city":{"aqi":"100","co":"1","no2":"82","o3":"60","pm10":"124","pm25":"75","qlty":"良","so2":"21"}}
     * basic : {"city":"广州","cnty":"中国","id":"CN101280101","lat":"23.108000","lon":"113.265000","update":{"loc":"2016-08-09 11:52","utc":"2016-08-09 03:52"}}
     * daily_forecast : [{"astro":{"sr":"06:01","ss":"19:03"},"cond":{"code_d":"302","code_n":"302","txt_d":"雷阵雨","txt_n":"雷阵雨"},"date":"2016-08-09","hum":"56","pcpn":"1.6","pop":"95","pres":"1001","tmp":{"max":"34","min":"25"},"vis":"10","wind":{"deg":"281","dir":"无持续风向","sc":"微风","spd":"9"}},{"astro":{"sr":"06:01","ss":"19:03"},"cond":{"code_d":"302","code_n":"302","txt_d":"雷阵雨","txt_n":"雷阵雨"},"date":"2016-08-10","hum":"79","pcpn":"23.2","pop":"90","pres":"1002","tmp":{"max":"32","min":"25"},"vis":"10","wind":{"deg":"209","dir":"无持续风向","sc":"微风","spd":"9"}},{"astro":{"sr":"06:01","ss":"19:02"},"cond":{"code_d":"302","code_n":"302","txt_d":"雷阵雨","txt_n":"雷阵雨"},"date":"2016-08-11","hum":"54","pcpn":"2.2","pop":"80","pres":"1004","tmp":{"max":"32","min":"26"},"vis":"10","wind":{"deg":"165","dir":"无持续风向","sc":"微风","spd":"4"}},{"astro":{"sr":"06:02","ss":"19:01"},"cond":{"code_d":"302","code_n":"302","txt_d":"雷阵雨","txt_n":"雷阵雨"},"date":"2016-08-12","hum":"47","pcpn":"0.0","pop":"1","pres":"1002","tmp":{"max":"33","min":"26"},"vis":"10","wind":{"deg":"223","dir":"无持续风向","sc":"微风","spd":"3"}},{"astro":{"sr":"06:02","ss":"19:00"},"cond":{"code_d":"302","code_n":"302","txt_d":"雷阵雨","txt_n":"雷阵雨"},"date":"2016-08-13","hum":"50","pcpn":"2.0","pop":"58","pres":"1001","tmp":{"max":"34","min":"26"},"vis":"10","wind":{"deg":"58","dir":"无持续风向","sc":"微风","spd":"10"}},{"astro":{"sr":"06:02","ss":"19:00"},"cond":{"code_d":"302","code_n":"101","txt_d":"雷阵雨","txt_n":"多云"},"date":"2016-08-14","hum":"54","pcpn":"4.8","pop":"52","pres":"1001","tmp":{"max":"35","min":"27"},"vis":"10","wind":{"deg":"81","dir":"无持续风向","sc":"微风","spd":"6"}},{"astro":{"sr":"06:03","ss":"18:59"},"cond":{"code_d":"101","code_n":"305","txt_d":"多云","txt_n":"小雨"},"date":"2016-08-15","hum":"53","pcpn":"0.6","pop":"43","pres":"1001","tmp":{"max":"35","min":"26"},"vis":"10","wind":{"deg":"85","dir":"无持续风向","sc":"微风","spd":"3"}}]
     * hourly_forecast : [{"date":"2016-08-09 13:00","hum":"58","pop":"71","pres":"1002","tmp":"37","wind":{"deg":"283","dir":"西北风","sc":"微风","spd":"7"}},{"date":"2016-08-09 16:00","hum":"63","pop":"28","pres":"1000","tmp":"37","wind":{"deg":"222","dir":"西南风","sc":"微风","spd":"5"}},{"date":"2016-08-09 19:00","hum":"71","pop":"24","pres":"1000","tmp":"33","wind":{"deg":"152","dir":"东南风","sc":"微风","spd":"6"}},{"date":"2016-08-09 22:00","hum":"78","pop":"35","pres":"1001","tmp":"30","wind":{"deg":"141","dir":"东南风","sc":"微风","spd":"9"}}]
     * now : {"cond":{"code":"300","txt":"阵雨"},"fl":"37","hum":"77","pcpn":"0","pres":"1003","tmp":"31","vis":"5","wind":{"deg":"291","dir":"东北风","sc":"3-4","spd":"15"}}
     * status : ok
     * suggestion : {"comf":{"brf":"很不舒适","txt":"白天虽然天气以阴为主，但由于天热，加上湿度较大，您会感到很闷热，很不舒适。"},"cw":{"brf":"不宜","txt":"不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"},"drsg":{"brf":"炎热","txt":"天气炎热，建议着短衫、短裙、短裤、薄型T恤衫等清凉夏季服装。"},"flu":{"brf":"少发","txt":"各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。"},"sport":{"brf":"较不宜","txt":"有较强降水，建议您选择在室内进行健身休闲运动。"},"trav":{"brf":"一般","txt":"天热，有微风，请注意防暑降温。另外，较强降雨给出行带来很多的不便，若坚持旅行建议带上雨具。"},"uv":{"brf":"弱","txt":"紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。"}}
     */

    private List<HeWeatherdataserviceBean> HeWeatherdataservice;

    public List<HeWeatherdataserviceBean> getHeWeatherdataservice() {
        return HeWeatherdataservice;
    }

    public void setHeWeatherdataservice(List<HeWeatherdataserviceBean> HeWeatherdataservice) {
        this.HeWeatherdataservice = HeWeatherdataservice;
    }

    public static class HeWeatherdataserviceBean {
        /**
         * city : {"aqi":"100","co":"1","no2":"82","o3":"60","pm10":"124","pm25":"75","qlty":"良","so2":"21"}
         */

        private AqiBean aqi;
        /**
         * city : 广州
         * cnty : 中国
         * id : CN101280101
         * lat : 23.108000
         * lon : 113.265000
         * update : {"loc":"2016-08-09 11:52","utc":"2016-08-09 03:52"}
         */

        private BasicBean basic;
        /**
         * cond : {"code":"300","txt":"阵雨"}
         * fl : 37
         * hum : 77
         * pcpn : 0
         * pres : 1003
         * tmp : 31
         * vis : 5
         * wind : {"deg":"291","dir":"东北风","sc":"3-4","spd":"15"}
         */

        private NowBean now;
        private String status;
        /**
         * comf : {"brf":"很不舒适","txt":"白天虽然天气以阴为主，但由于天热，加上湿度较大，您会感到很闷热，很不舒适。"}
         * cw : {"brf":"不宜","txt":"不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"}
         * drsg : {"brf":"炎热","txt":"天气炎热，建议着短衫、短裙、短裤、薄型T恤衫等清凉夏季服装。"}
         * flu : {"brf":"少发","txt":"各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。"}
         * sport : {"brf":"较不宜","txt":"有较强降水，建议您选择在室内进行健身休闲运动。"}
         * trav : {"brf":"一般","txt":"天热，有微风，请注意防暑降温。另外，较强降雨给出行带来很多的不便，若坚持旅行建议带上雨具。"}
         * uv : {"brf":"弱","txt":"紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。"}
         */

        private SuggestionBean suggestion;
        /**
         * astro : {"sr":"06:01","ss":"19:03"}
         * cond : {"code_d":"302","code_n":"302","txt_d":"雷阵雨","txt_n":"雷阵雨"}
         * date : 2016-08-09
         * hum : 56
         * pcpn : 1.6
         * pop : 95
         * pres : 1001
         * tmp : {"max":"34","min":"25"}
         * vis : 10
         * wind : {"deg":"281","dir":"无持续风向","sc":"微风","spd":"9"}
         */

        private List<DailyForecastBean> daily_forecast;
        /**
         * date : 2016-08-09 13:00
         * hum : 58
         * pop : 71
         * pres : 1002
         * tmp : 37
         * wind : {"deg":"283","dir":"西北风","sc":"微风","spd":"7"}
         */

        private List<HourlyForecastBean> hourly_forecast;

        public AqiBean getAqi() {
            return aqi;
        }

        public void setAqi(AqiBean aqi) {
            this.aqi = aqi;
        }

        public BasicBean getBasic() {
            return basic;
        }

        public void setBasic(BasicBean basic) {
            this.basic = basic;
        }

        public NowBean getNow() {
            return now;
        }

        public void setNow(NowBean now) {
            this.now = now;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public SuggestionBean getSuggestion() {
            return suggestion;
        }

        public void setSuggestion(SuggestionBean suggestion) {
            this.suggestion = suggestion;
        }

        public List<DailyForecastBean> getDaily_forecast() {
            return daily_forecast;
        }

        public void setDaily_forecast(List<DailyForecastBean> daily_forecast) {
            this.daily_forecast = daily_forecast;
        }

        public List<HourlyForecastBean> getHourly_forecast() {
            return hourly_forecast;
        }

        public void setHourly_forecast(List<HourlyForecastBean> hourly_forecast) {
            this.hourly_forecast = hourly_forecast;
        }

        public static class AqiBean {
            /**
             * aqi : 100
             * co : 1
             * no2 : 82
             * o3 : 60
             * pm10 : 124
             * pm25 : 75
             * qlty : 良
             * so2 : 21
             */

            private CityBean city;

            public CityBean getCity() {
                return city;
            }

            public void setCity(CityBean city) {
                this.city = city;
            }

            public static class CityBean {
                private String aqi;
                private String co;
                private String no2;
                private String o3;
                private String pm10;
                private String pm25;
                private String qlty;
                private String so2;

                public String getAqi() {
                    return aqi;
                }

                public void setAqi(String aqi) {
                    this.aqi = aqi;
                }

                public String getCo() {
                    return co;
                }

                public void setCo(String co) {
                    this.co = co;
                }

                public String getNo2() {
                    return no2;
                }

                public void setNo2(String no2) {
                    this.no2 = no2;
                }

                public String getO3() {
                    return o3;
                }

                public void setO3(String o3) {
                    this.o3 = o3;
                }

                public String getPm10() {
                    return pm10;
                }

                public void setPm10(String pm10) {
                    this.pm10 = pm10;
                }

                public String getPm25() {
                    return pm25;
                }

                public void setPm25(String pm25) {
                    this.pm25 = pm25;
                }

                public String getQlty() {
                    return qlty;
                }

                public void setQlty(String qlty) {
                    this.qlty = qlty;
                }

                public String getSo2() {
                    return so2;
                }

                public void setSo2(String so2) {
                    this.so2 = so2;
                }
            }
        }

        public static class BasicBean {
            private String city;
            private String cnty;
            private String id;
            private String lat;
            private String lon;
            /**
             * loc : 2016-08-09 11:52
             * utc : 2016-08-09 03:52
             */

            private UpdateBean update;

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getCnty() {
                return cnty;
            }

            public void setCnty(String cnty) {
                this.cnty = cnty;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getLat() {
                return lat;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public String getLon() {
                return lon;
            }

            public void setLon(String lon) {
                this.lon = lon;
            }

            public UpdateBean getUpdate() {
                return update;
            }

            public void setUpdate(UpdateBean update) {
                this.update = update;
            }

            public static class UpdateBean {
                private String loc;
                private String utc;

                public String getLoc() {
                    return loc;
                }

                public void setLoc(String loc) {
                    this.loc = loc;
                }

                public String getUtc() {
                    return utc;
                }

                public void setUtc(String utc) {
                    this.utc = utc;
                }
            }
        }

        public static class NowBean {
            /**
             * code : 300
             * txt : 阵雨
             */

            private CondBean cond;
            private String fl;
            private String hum;
            private String pcpn;
            private String pres;
            private String tmp;
            private String vis;
            /**
             * deg : 291
             * dir : 东北风
             * sc : 3-4
             * spd : 15
             */

            private WindBean wind;

            public CondBean getCond() {
                return cond;
            }

            public void setCond(CondBean cond) {
                this.cond = cond;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getHum() {
                return hum;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public String getPcpn() {
                return pcpn;
            }

            public void setPcpn(String pcpn) {
                this.pcpn = pcpn;
            }

            public String getPres() {
                return pres;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public String getTmp() {
                return tmp;
            }

            public void setTmp(String tmp) {
                this.tmp = tmp;
            }

            public String getVis() {
                return vis;
            }

            public void setVis(String vis) {
                this.vis = vis;
            }

            public WindBean getWind() {
                return wind;
            }

            public void setWind(WindBean wind) {
                this.wind = wind;
            }

            public static class CondBean {
                private String code;
                private String txt;

                public String getCode() {
                    return code;
                }

                public void setCode(String code) {
                    this.code = code;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public static class WindBean {
                private String deg;
                private String dir;
                private String sc;
                private String spd;

                public String getDeg() {
                    return deg;
                }

                public void setDeg(String deg) {
                    this.deg = deg;
                }

                public String getDir() {
                    return dir;
                }

                public void setDir(String dir) {
                    this.dir = dir;
                }

                public String getSc() {
                    return sc;
                }

                public void setSc(String sc) {
                    this.sc = sc;
                }

                public String getSpd() {
                    return spd;
                }

                public void setSpd(String spd) {
                    this.spd = spd;
                }
            }
        }

        public static class SuggestionBean {
            /**
             * brf : 很不舒适
             * txt : 白天虽然天气以阴为主，但由于天热，加上湿度较大，您会感到很闷热，很不舒适。
             */

            private ComfBean comf;
            /**
             * brf : 不宜
             * txt : 不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。
             */

            private CwBean cw;
            /**
             * brf : 炎热
             * txt : 天气炎热，建议着短衫、短裙、短裤、薄型T恤衫等清凉夏季服装。
             */

            private DrsgBean drsg;
            /**
             * brf : 少发
             * txt : 各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。
             */

            private FluBean flu;
            /**
             * brf : 较不宜
             * txt : 有较强降水，建议您选择在室内进行健身休闲运动。
             */

            private SportBean sport;
            /**
             * brf : 一般
             * txt : 天热，有微风，请注意防暑降温。另外，较强降雨给出行带来很多的不便，若坚持旅行建议带上雨具。
             */

            private TravBean trav;
            /**
             * brf : 弱
             * txt : 紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。
             */

            private UvBean uv;

            public ComfBean getComf() {
                return comf;
            }

            public void setComf(ComfBean comf) {
                this.comf = comf;
            }

            public CwBean getCw() {
                return cw;
            }

            public void setCw(CwBean cw) {
                this.cw = cw;
            }

            public DrsgBean getDrsg() {
                return drsg;
            }

            public void setDrsg(DrsgBean drsg) {
                this.drsg = drsg;
            }

            public FluBean getFlu() {
                return flu;
            }

            public void setFlu(FluBean flu) {
                this.flu = flu;
            }

            public SportBean getSport() {
                return sport;
            }

            public void setSport(SportBean sport) {
                this.sport = sport;
            }

            public TravBean getTrav() {
                return trav;
            }

            public void setTrav(TravBean trav) {
                this.trav = trav;
            }

            public UvBean getUv() {
                return uv;
            }

            public void setUv(UvBean uv) {
                this.uv = uv;
            }

            public static class ComfBean {
                private String brf;
                private String txt;

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public static class CwBean {
                private String brf;
                private String txt;

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public static class DrsgBean {
                private String brf;
                private String txt;

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public static class FluBean {
                private String brf;
                private String txt;

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public static class SportBean {
                private String brf;
                private String txt;

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public static class TravBean {
                private String brf;
                private String txt;

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public static class UvBean {
                private String brf;
                private String txt;

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }
        }

        public static class DailyForecastBean {
            /**
             * sr : 06:01
             * ss : 19:03
             */

            private AstroBean astro;
            /**
             * code_d : 302
             * code_n : 302
             * txt_d : 雷阵雨
             * txt_n : 雷阵雨
             */

            private CondBean cond;
            private String date;
            private String hum;
            private String pcpn;
            private String pop;
            private String pres;
            /**
             * max : 34
             * min : 25
             */

            private TmpBean tmp;
            private String vis;
            /**
             * deg : 281
             * dir : 无持续风向
             * sc : 微风
             * spd : 9
             */

            private WindBean wind;

            public AstroBean getAstro() {
                return astro;
            }

            public void setAstro(AstroBean astro) {
                this.astro = astro;
            }

            public CondBean getCond() {
                return cond;
            }

            public void setCond(CondBean cond) {
                this.cond = cond;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getHum() {
                return hum;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public String getPcpn() {
                return pcpn;
            }

            public void setPcpn(String pcpn) {
                this.pcpn = pcpn;
            }

            public String getPop() {
                return pop;
            }

            public void setPop(String pop) {
                this.pop = pop;
            }

            public String getPres() {
                return pres;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public TmpBean getTmp() {
                return tmp;
            }

            public void setTmp(TmpBean tmp) {
                this.tmp = tmp;
            }

            public String getVis() {
                return vis;
            }

            public void setVis(String vis) {
                this.vis = vis;
            }

            public WindBean getWind() {
                return wind;
            }

            public void setWind(WindBean wind) {
                this.wind = wind;
            }

            public static class AstroBean {
                private String sr;
                private String ss;

                public String getSr() {
                    return sr;
                }

                public void setSr(String sr) {
                    this.sr = sr;
                }

                public String getSs() {
                    return ss;
                }

                public void setSs(String ss) {
                    this.ss = ss;
                }
            }

            public static class CondBean {
                private String code_d;
                private String code_n;
                private String txt_d;
                private String txt_n;

                public String getCode_d() {
                    return code_d;
                }

                public void setCode_d(String code_d) {
                    this.code_d = code_d;
                }

                public String getCode_n() {
                    return code_n;
                }

                public void setCode_n(String code_n) {
                    this.code_n = code_n;
                }

                public String getTxt_d() {
                    return txt_d;
                }

                public void setTxt_d(String txt_d) {
                    this.txt_d = txt_d;
                }

                public String getTxt_n() {
                    return txt_n;
                }

                public void setTxt_n(String txt_n) {
                    this.txt_n = txt_n;
                }
            }

            public static class TmpBean {
                private String max;
                private String min;

                public String getMax() {
                    return max;
                }

                public void setMax(String max) {
                    this.max = max;
                }

                public String getMin() {
                    return min;
                }

                public void setMin(String min) {
                    this.min = min;
                }
            }

            public static class WindBean {
                private String deg;
                private String dir;
                private String sc;
                private String spd;

                public String getDeg() {
                    return deg;
                }

                public void setDeg(String deg) {
                    this.deg = deg;
                }

                public String getDir() {
                    return dir;
                }

                public void setDir(String dir) {
                    this.dir = dir;
                }

                public String getSc() {
                    return sc;
                }

                public void setSc(String sc) {
                    this.sc = sc;
                }

                public String getSpd() {
                    return spd;
                }

                public void setSpd(String spd) {
                    this.spd = spd;
                }
            }
        }

        public static class HourlyForecastBean {
            private String date;
            private String hum;
            private String pop;
            private String pres;
            private String tmp;
            /**
             * deg : 283
             * dir : 西北风
             * sc : 微风
             * spd : 7
             */

            private WindBean wind;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getHum() {
                return hum;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public String getPop() {
                return pop;
            }

            public void setPop(String pop) {
                this.pop = pop;
            }

            public String getPres() {
                return pres;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public String getTmp() {
                return tmp;
            }

            public void setTmp(String tmp) {
                this.tmp = tmp;
            }

            public WindBean getWind() {
                return wind;
            }

            public void setWind(WindBean wind) {
                this.wind = wind;
            }

            public static class WindBean {
                private String deg;
                private String dir;
                private String sc;
                private String spd;

                public String getDeg() {
                    return deg;
                }

                public void setDeg(String deg) {
                    this.deg = deg;
                }

                public String getDir() {
                    return dir;
                }

                public void setDir(String dir) {
                    this.dir = dir;
                }

                public String getSc() {
                    return sc;
                }

                public void setSc(String sc) {
                    this.sc = sc;
                }

                public String getSpd() {
                    return spd;
                }

                public void setSpd(String spd) {
                    this.spd = spd;
                }
            }
        }
    }
}

